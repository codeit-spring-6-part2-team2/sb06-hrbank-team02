# 2팀

[팀 협업 문서 링크](https://github.com/orgs/codeit-spring-6-part2-team2/discussions)

---

# 팀원 구성

- 김승빈 (https://github.com/mainlib990)

- 김재원 (https://github.com/kimdotcom2)

- 김태현 (https://github.com/kimtaehyun80)

- 서경원 (https://github.com/SeoGyeongWon)

- 이치호 (https://github.com/chiho0270)

---

# 프로젝트 소개

- 프로그래밍 교육 사이트의 Spring 백엔드 시스템 구축
- 프로젝트 기간: 2025.10.20 ~ 2025.10.28

---

# 기술 스택

- Backend: Spring Boot, Spring Data JPA, Spring Validation, Lombok, MapStruct, Swagger, Spring JPA QueryDSL 
- Database: H2DB, Postgres
- 공통 Tool: Git & Github, Discord

---

# 팀원별 구현 기능 상세

### 김승빈

- 직원 관리 기능 구현
  - 직원 정보
  - 직원 등록
  - 직원 정보 수정
  - 직원 정보 삭제
  - 직원 정보 목록 조회
  - 직원 정보 상세 조회

### 김재원

- 직원 정보 수정 이력 기능 구현
  - 수정 이력 및 직원 정보 수정 이력 엔티티 설계
  - 직원 추가 시 신규 직원 정보 로깅 기능 구현
  - 직원 정보 수정 시 로깅 기능 구현
  - 수정 이력 커서 기반 페이지네이션 구현
  - 직원 정보 수정 시 이전 데이터와의 비교 메소드 구현
- 타 모듈과의 상호작용
  - 백업 모듈의 백업 여부 판단을 위한 최근 로깅 일자 조회 API 구현
  - 직원 모듈에서 로깅 호출을 위한 DTO 및 API 설계


### 김태현

- 부서관리 파트 Entity, Dto, Service, Repository 생성
- 부서등록,조회,수정,삭제 로직, 클라이언트 요청에대한 응답처리
- 부서등록 및 수정: 이름,설명,설립일 은 중복불가
- 부서삭제: 소속 직원이 없어야 삭제 가능
- 특정부서의 직원수 표현 로직구현
- 복합잔 정렬조건 처리, 커서기반 페이징 구현(이전 페이지 마지막 요소ID 활용)

### 서경원

- 파일 관리 기능 구현
  - 파일의 메타 정보와 실제 파일을 분리하여 관리
    - 실제 파일이 저장 된 후 DB에 메타 정보 저장
  - 파일 메타정보를 저장하기 위한 엔티티 설계
    - 관리 대상: 직원(Employee) 프로필 이미지, 백업(Backup) 파일 등
  - 커스텀 경로 + Config를 생성해 파일 경로 지정 하여 Bean 등록 및 주입
  - 파일 타입에 따라 분리해 파일 저장 기능 구현
  - 파일 Id에 따른 파일 삭제 및 파일 실제 데이터 반환(다운로드)기능 구현
  - 파일의 엔티티를 DTO를 통해 Metadata 반환 기능 구현


### 이치호

- 데이터 백업 기능 구현
    - 전체 중 Entity, DTO, Service(Interface), Controller 구현
    - 직원 정보 수정 이력에 따른 직원 데이터 백업 생성
        - 완료 시, 백업 파일(.csv) 생성
        - 실패 시, 로그 파일(.log) 생성
    - 직원 정보 페이지네이션 배치 처리
    - 데이터 백업 Spring Scheduler(1시간 마다)

---

# 파일 구조

```markdown
sb06-hrbank-team02
├── build.gradle
├── docs
│   ├── chiho0270.md
│   ├── kimdotcom2.md
│   ├── kimtaehyun80.md
│   ├── mainlib990.md
│   └── SeoGyeongWon.md
├── gradle
│   ├── libs.versions.toml
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradle.properties
├── gradlew
├── gradlew.bat
├── README.md
├── settings.gradle
└── src
├── main
│   ├── java
│   │   └── com
│   │       └── team2
│   │           └── hrbank
│   │               ├── backup
│   │               │   ├── controller
│   │               │   │   └── BackupController.java
│   │               │   ├── domain
│   │               │   │   ├── Backup.java
│   │               │   │   ├── BackupStatus.java
│   │               │   │   └── package-info.java
│   │               │   ├── dto
│   │               │   │   ├── BackupCompleteRequestDto.java
│   │               │   │   ├── BackupCreateRequestDto.java
│   │               │   │   ├── BackupDto.java
│   │               │   │   ├── BackupFailRequestDto.java
│   │               │   │   ├── CursorPageRequestBackupDto.java
│   │               │   │   └── CursorPageResponseBackupDto.java
│   │               │   ├── repository
│   │               │   │   └── BackupRepository.java
│   │               │   └── service
│   │               │       ├── BackupService.java
│   │               │       ├── BasicBackupService.java
│   │               │       └── package-info.java
│   │               ├── changelog
│   │               │   ├── domain
│   │               │   │   ├── ChangeLog.java
│   │               │   │   ├── ChangeLogType.java
│   │               │   │   ├── EmployeeDetailLog.java
│   │               │   │   ├── EmployeeEmail.java
│   │               │   │   ├── EmployeeLogType.java
│   │               │   │   └── IPAddress.java
│   │               │   ├── dto
│   │               │   │   ├── ChangeLogDto.java
│   │               │   │   ├── ChangeLogRequestDto.java
│   │               │   │   ├── CursorPageResponseChangeLogDto.java
│   │               │   │   ├── DiffDto.java
│   │               │   │   └── EmployeeLogDto.java
│   │               │   ├── mapper
│   │               │   │   ├── ChangeLogMapper.java
│   │               │   │   └── EmployeeLogMapper.java
│   │               │   ├── package-info.java
│   │               │   ├── repository
│   │               │   │   ├── ChangeLogRepository.java
│   │               │   │   └── EmployeeDetailLogRepository.java
│   │               │   └── service
│   │               │       ├── BasicChangeLogService.java
│   │               │       └── ChangeLogService.java
│   │               ├── common
│   │               │   └── config
│   │               │       └── QuerydslConfig.java
│   │               ├── department
│   │               │   ├── domain
│   │               │   │   └── Department.java
│   │               │   ├── dto
│   │               │   │   ├── CursorPageResponseDepartmentDto.java
│   │               │   │   ├── DepartmentCreateRequest.java
│   │               │   │   ├── DepartmentDto.java
│   │               │   │   ├── DepartmentMapper.java
│   │               │   │   └── DepartmentUpdateRequest.java
│   │               │   ├── repository
│   │               │   │   ├── DepartmentRepository.java
│   │               │   │   └── DepartmentRepositoryCustom.java
│   │               │   └── service
│   │               │       ├── BasicDepartmentService.java
│   │               │       └── DepartmentService.java
│   │               ├── employee
│   │               │   ├── BasicEmployeeService.java
│   │               │   ├── domain
│   │               │   │   ├── Employee.java
│   │               │   │   ├── EmployeeContext.java
│   │               │   │   ├── EmployeeEmail.java
│   │               │   │   ├── EmployeeNumber.java
│   │               │   │   ├── EmployeeStatus.java
│   │               │   │   └── exception
│   │               │   │       ├── EmployeeException.java
│   │               │   │       ├── EmployeeInvalidEmailException.java
│   │               │   │       ├── EmployeeNameEmptyException.java
│   │               │   │       └── EmployeePositionEmptyException.java
│   │               │   ├── dto
│   │               │   │   ├── BackupEmployeeDto.java
│   │               │   │   ├── BackupEmployeePageRequestDto.java
│   │               │   │   ├── BackupEmployeePageResponseDto.java
│   │               │   │   ├── CursorPageRequestEmployeeDto.java
│   │               │   │   ├── CursorPageResponseEmployeeDto.java
│   │               │   │   ├── DepartmentEmployeeCountDto.java
│   │               │   │   ├── EmployeeCreateRequest.java
│   │               │   │   ├── EmployeeDistributionDto.java
│   │               │   │   ├── EmployeeDto.java
│   │               │   │   ├── EmployeeTrendDto.java
│   │               │   │   ├── EmployeeUpdateRequest.java
│   │               │   │   └── package-info.java
│   │               │   ├── EmployeeController.java
│   │               │   ├── EmployeeControllerAdvice.java
│   │               │   ├── EmployeeMapper.java
│   │               │   ├── EmployeeRepository.java
│   │               │   └── EmployeeService.java
│   │               └── HrbankApplication.java
│   └── resources
│       ├── application-local.yaml
│       ├── application-production.yaml
│       └── application.properties
└── test
    └── java
        └── com
            └── team2
                └── hrbank
```

---

# 구현 홈페이지

- 미완성

# 프로젝트 회고록

- 
