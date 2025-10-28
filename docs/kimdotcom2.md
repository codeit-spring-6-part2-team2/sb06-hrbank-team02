# 직원 정보 수정 이력 모듈

## 요구사항

이 모듈은 직원 정보의 수정 이력이라는 책임을 가진다.
모듈의 요구사항은 다음과 같다.

1. 직원 정보 기록 
직원의 이름, 직책, 부서, 연락처 등 정보가 추가/수정될 때마다 수정이 되었음을 기록한다.

2. 직원 정보 기록
수정 이후의 직원 정보를 저장한다.
따라서 직원 모듈과 유사한 내용의 형태로 기록한다.

3. 직원 정보 수정 이력 기록
기존 직원의 정보가 수정될 때마다 수정 이전의 정보와 수정 이후의 정보를 모두 기록한다.

4. 직원 정보 수정 기록을 커서 기반 페이징을 통해 조회한다.

5. 직원 정보 수정 기록의 개수를 조회한다.

6. 직원 정보 수정 기록에 연관된 직원 정보 기록을 조회한다.

여기서 도출할 수 있는 상세한 요구사항은 다음과 같다.

1. 새로운 직원이 추가되면 수정이 발생했다는 사실과 직원의 정보를 기록한다.

2. 기존 직원의 정보가 수정되면 수정 이전의 정보와 수정 이후의 정보를 모두 기록하여 둘을 비교하는 API를 제공한다.

3. 기존 직원이 삭제되면 삭제 이전 직원 정보를 기록한다.

4. 위 사항을 직원 모듈에서 호출할 수 있는 API를 인터페이스로 제공한다.

5. 가장 마지막으로 수정된 기록의 타임스태프를 백업 모듈에서 호출할 수 있는 API를 인터페이스로 제공한다.

## 엔티티 설계

### ChangeLog

| 필드명            | 타입            | 제약조건            | 설명                        |
|----------------|---------------| ------------------- |---------------------------|
| id             | Long          | PK, Not Null       | 수정 이력 고유 식별자              |
| type           | ChangeLogType | Not Null       | CREATED, UPDATED, DELETED |
| employeeNumber | String        | Not Null       | 수정된 직원의 고유 식별자            |
| memo           | String        | Nullable           | 메모 사항                     |
| IPAddress      | String        | Not Null       | 수정을 발생시킨 IP 주소            |
| at             | LocalDateTime | Not Null       | 수정이 발생한 시점                |

### EmployeeDetailLog

| 필드명        | 타입              | 제약조건         | 설명                 |
|------------|-----------------|--------------|--------------------|
| id         | Long            | PK, Not Null | 직원 정보 수정 이력 고유 식별자 |
| type       | EmployeeLogType | Not Null     | AFTER, BEFORE      |
| changeLog  | ChangeLog       | FK, Not Null | 수정 이력              |
| hireDate   | LocalDate       | Not Null     | 입사 일자              |
| name       | String          | Not Null     | 직원 이름              |
| position   | String          | Not Null     | 직책                 |
| department | String          | Not Null     | 부서                 |
| email      | String          | Not Null     | 연락처                |
| status     | String          | Not Null     | 직원 상태              |

### 엔티티 관계

- ChangeLog 1 : N EmployeeDetailLog
- EmployeeDetailLog는 ChangeLog에 종속적이다.
- ChangeLog는 EmployeeDetailLog에 종속적이지 않다.
- ChangeLog.ipAddress는 ChangeLog의 서브 도메인에 속한다.
- EmployeeDetailLog.EmployeeEmail는 Employee의 서브 도메인에 속한다. (조건: 모듈에서 검증 가능한가?)

## API 명세

```java
    getChangeLogs(PaginatedLogRequest request);

    getDiffByChangeLogId(Long id);

    getTotalCount(LocalDateTime fromDate, LocalDateTime toDate);
    
    getRecentLogDate();

    addEmployeeInsertLog(CreateLogRequest request);

    addEmployeeUpdateLog(CreateLogRequest request);

    addEmployeeDeleteLog(CreateDeleteLogRequest request);
```

## 고민했던 사례

### 발생한 문제

엔티티의 필드 중 검증이 가능한 필드의 validation 로직을 어디에 둘 것인지 고민했다.

평소 코드 스타일은 Spring Validation을 사용하여 Controller 단에서 input 값의 검증을 수행하는 것이다.

하지만 직원 정보 수정 이력 모듈의 메소드 호출은 다른 모듈에서 발생하기 때문에 Controller 단에서 검증을 수행할 수 없다.

또한, Spring Validation을 사용하면 코드가 프레임워크에 종속적이게 된다.

직접 검증 로직을 작성할 수 없을까?

### 대안

1. Service 단에서 직접 검증 로직을 작성한다.

장점
- 프레임워크에 종속적이지 않다.
단점
- Service 단이 비대해질 수 있다.
- 중복 코드가 발생할 수 있다.
- Service 단이 여러 책임을 가지게 될 수 있다.

2. 별도의 Validator 클래스를 작성하여 검증 로직을 분리한다.

장점
- 검증 로직이 분리되어 코드가 깔끔해진다.
- 재사용성이 높아진다.
단점
- Validator 클래스를 별도로 관리해야 한다.
- 검증 로직의 응집도가 분산될 수 있다.

3. 엔티티 내부에 검증 메소드를 작성한다.

장점
- 엔티티와 검증 로직이 함께 있어 응집도가 높아진다
- 재사용성이 높아진다.
단점
- 필드가 늘어날 따마다 검증 메소드가 늘어나 엔티티가 비대해질 수 있다.
- 엔티티가 여러 책임을 가지게 될 수 있다.

### 해결 방법

세 번째 대안을 선택하여 엔티티 내부에 검증 메소드를 작성했다.
검증 가능한 필드를 서브 도메인으로 분리하고, 불변 VO로 구현하여 생성 시점에 검증이 이루어지도록 했다.

예를 들어, ChangeLog의 IPAddress 필드를 IPAddress라는 서브 도메인으로 분리하고, 
IPAddress 클래스 내부에 유효한 IP 주소인지 검증하는 로직을 작성했다.
이를 통해 엔티티와 검증 로직이 함께 있어 응집도가 높아졌고, 코드가 간결해지며 재사용성도 확보할 수 있었다.

### 배운 점과 개선 사항

도메인을 설계할 때 루트 도메인과 VO를 구분하는 것은 DDD(Domain-Driven Design)에서 떠올린 아이디어이다.
이러한 방식은 도메인의 응집도를 높이면서도 관심사를 분리하여 유지보수성을 향상시킨다.

하지만 그만큼 작성할 코드가 많아지고 복잡도가 증가할 수 있다.

또한, 이번 DDD의 활용은 그저 검증 로직의 분리라는 측면에서만 접근했기 때문에, 본격적으로 도메인 모델링에 반영을 한 것이 아니다.

앞으로 도메인 주도 설계를 더 깊이 공부하고, 실제 프로젝트에 적용해보면서 어떤 장점이 있는지, 어떤 단점이 있는지 
또 그것을 어떻게 극복할 수 있는지 깊이 있게 고민을 하고 싶다.

## 프로젝트를 진행하면서 느낀 좋았던 점과 아쉬웠던 점

### 좋았던 점

1. 협업을 위한 컨벤션 준수

프로젝트 초반에 코드 스타일, 커밋 메시지 규칙, 브랜치 전략 등 협업을 위한 컨벤션을 미리 정하고 이를 준수하려 노력했다.
이를 통해 팀원 간의 의사소통이 원활해지고, 코드 리뷰 과정에서 불필요한 논쟁을 줄일 수 있었다.

또한 협업에 필요한 Git 사용법을 익힐 수 있었다.

2. 코드 리뷰

팀원 간의 코드 리뷰를 통해 서로의 코드를 검토하고 피드백을 주고받았다.
이를 통해 코드 품질을 향상시키고, 서로의 코딩 스타일과 문제 해결 방식을 이해할 수 있었다.

자신의 코드 스타일과 작성 습관을 돌아볼 수 있는 좋은 기회가 되었다.

### 아쉬웠던 점

1. 타인의 코드 리뷰

코드 리뷰를 하는 입장에서 타인의 코드를 자신의 코드만큼 깊이 있게 분석하고 피드백을 주는 데 어려움이 있었다.
자신이 작성한 코드보다 조심스럽게 접근하게 되다보니, 피드백을 줘야 할 부분인지 고민하는 경우가 많았다.

2. 일정 관리

프로젝트 일정 관리에 있어 예상보다 시간이 더 소요되는 경우가 많았다.
특히 도메인 엔티티 모델링과 API를 위한 DTO 설계에 많은 시간이 소요되었다.

요구사항 추가 또는 변경에 의한 코드 수정에 대해 어떻게 대응할 것인가? 에 대한 고민의 필요성을 느꼈다.








