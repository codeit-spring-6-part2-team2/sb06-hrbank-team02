본 문서는 HR Bank 프로젝트에서 **팀장 및 기술 리더**로서 제가 수행한 역할과 기여를 중심으로 작성되었습니다.

### **1. 개발 문화 형성: 기록 중심의 투명한 소통과 협업**

**"팀의 개발 문화에서 가장 중요하게 여긴 가치는 '서로의 생각을 동기화하고, 모든 결정과 과정에 대한 명확한 이해를 공유하는 팀을 만드는 것이었습니다."**

이를 위해, 구두나 휘발성 메신저가 아닌 **GitHub Discussions를 팀의 공식 소통 채널로 정착**시켰습니다.

#### **1.1. 협업 능력 강화 및 상호 존중**
*   글로 작성하는 행위 자체가 인지 능력을 요구하기 때문에, 디스커션을 통해 생각을 정리하고 공유하는 과정은 더 정확하고 심도 깊은 소통을 가능하게 했습니다.
*   이러한 활동은 팀원 간의 **상호 존중**을 바탕으로 한 건설적인 피드백 루프를 만들었으며, **협업 능력**을 강화하는 핵심적인 역할을 했습니다.

#### **1.2. 개발 프로세스의 투명성 및 효율성**
*   **GitHub PR 코드 리뷰 방법 및 베스트 프랙티스 학습 논의(#34)**는 팀의 개발 프로세스를 정립하는 데 중요한 역할을 했습니다.
*   이 논의를 통해 우리는 GitHub의 코드 리뷰 기능을 효과적으로 활용하는 방법, 여러 피드백을 한 번에 모아 전달하는 코드 리뷰 에티켓, 그리고 불필요한 리뷰 요청을 방지하기 위한 Draft PR 활용법 등을 학습하고 팀의 공식적인 워크플로우로 정립했습니다.
*   GitHub Discussions를 통해 모든 팀원이 프로세스 정립에 참여하고 의견을 **나눌 수 있었기에**, **투명성과 공동의 책임감**을 바탕으로 한 개발 문화를 효과적으로 형성할 수 있었습니다.

#### **1.3. 프로젝트 소유 의식 및 지식 창출**
*   모든 논의와 결정 사항이 기록으로 남아, 과거의 정보는 새로운 지식 형태로 창출하는 데 효과적이었습니다.
*   이러한 활동은 **자기 참조 효과**를 불러일으켜 도메인에 대한 이해도를 단순 암기가 아닌 진정한 이해로 탈바꿈시켰습니다.
*   결과적으로, 모든 논의가 기록으로 남아 모든 프로세스에 대한 명확한 근거를 제공하게 되었고, 이는 **팀의 집단 지성을 성장시키고 지속적인 개선을 가능하게 하는 기반**이 되었습니다.

#### **1.4. GitHub 중심의 개발 프로세스 정립**

**"우리 팀은 소규모 인원이었고, 프로젝트 상황상 GitHub을 통한 프로젝트 관리가 가장 효과적일 것이라고 판단했습니다. 특히 GitHub Flow 전략이 팀의 민첩한 개발에 적합하다고 보았습니다."**

**1) GitHub Issues를 통한 체계적인 이슈 트래킹:**
모든 개발 작업은 **GitHub Issues를 통해 체계적으로 관리**했습니다. 버그(`[BUG]`), 신규 기능(`[FEAT]`), 리팩토링(`[REFACTOR]`), 유지보수(`[CHORE]`) 등 이슈의 성격을 명확히 구분하고, 각 이슈에 대한 진행 상황을 투명하게 추적했습니다.

**2) Pull Request(PR) 기반의 협업 및 코드 품질 관리:**
코드 변경 사항은 **Pull Request(PR)를 통해서만 반영**되도록 의도했습니다. 이는 단순히 코드를 병합하는 절차를 넘어, 다음과 같은 핵심적인 이점을 제공했습니다.

*   **집단 지성을 통한 오류 감소:** 한 사람의 실수가 아닌 여러 팀원의 집단 지성을 활용하여 잠재적인 오류를 최대한 줄이고 코드 품질을 향상시켰습니다.
*   **함께 성장하는 문화:** PR 리뷰 과정에서 서로의 코드를 학습하고 피드백을 주고받으며 팀원 모두가 기술적으로 성장할 수 있는 기회를 마련했습니다.
*   **명확한 절차 확립:** PR을 통한 코드 변경은 팀 내에서 합의된 절차(코드 리뷰 등)를 거치도록 하여, 개발 과정의 투명성과 안정성을 확보했습니다.

이러한 GitHub 중심의 개발 프로세스 정립을 통해, 우리는 **예측 가능하고 효율적인 개발 절차**를 확립할 수 있었으며, 이는 프로젝트의 성공적인 진행을 위한 견고한 기반이 되었습니다.

---

### **2. 아키텍처 설계: 독립적 모듈 구조와 API 디자인의 성찰**

**"프로젝트가 커질수록 스파게티처럼 얽히는 코드는 유지보수를 어렵게 만듭니다. 저는 이를 방지하기 위해 '레고 블록'처럼 각 모듈을 독립적으로 설계하는 것을 아키텍처의 핵심 목표로 삼았습니다."**

**1) 모듈화된 백엔드 설계**

-   **기능별 패키지(Package-by-Feature) 전략으로 모듈을 고립:**
    `employee`, `department`와 같이 기능 중심으로 패키지를 구성하여, 한 기능의 변경이 다른 기능에 미치는 영향을 원천적으로 차단하고자 했습니다.

-   **DTO를 활용한 서비스 계층의 일관된 인터페이스 정의:**
    모든 서비스는 반드시 DTO(Data Transfer Object)를 통해 데이터를 입출력하도록 설계했습니다. 이를 통해 서비스 계층이 내부 구현(JPA 엔티티 등)에 직접 의존하지 않는, 느슨하게 결합된 구조를 구현했습니다.

**2) 예상치 못한 난관과 깊은 성찰**

하지만 이 설계는 **'프론트엔드 코드를 수정할 수 없다'** 는 현실적인 제약과 만나 예상치 못한 난관에 부딪혔습니다. 당시에는 백엔드 아키텍처와 API 디자인 간의 불일치가 문제라고 생각했지만, 다시금 깊이 성찰해보니 **API 자체가 이미 높은 결합도를 가진 디자인**이었다는 것을 깨달았습니다.

`Employee` API가 `Department`의 이름처럼 다른 모듈의 정보를 포함해야 하는 상황은, API가 이미 여러 도메인의 책임을 한 번에 떠안고 있음을 의미했습니다. 이러한 API의 본질적인 결합도를 제대로 분석하지 못한 채 백엔드 모듈의 경계만 명확히 하려다 보니, 결국 복잡성이 가중되고 개발 효율이 떨어져 프로젝트를 미완성하게 되는 아쉬운 결과를 맞이하게 되었습니다.

**3) 얻게 된 귀중한 교훈**

이 경험은 저에게 **'좋은 API 디자인이란 무엇인가'** 에 대해 깊이 성찰하는 계기가 되었습니다. 기술적으로 아무리 '낮은 결합도'를 추구해도, **API 자체가 여러 도메인의 경계를 넘나들며 데이터를 조합하도록 설계되었다면, 그것은 결국 시스템 전체에 보이지 않는 결합을 만들어낸다**는 것을 깨달았습니다. 진정한 '책임 분리'는 코드 레벨에서 끝나는 것이 아니라, 시스템의 가장 바깥 경계인 API 레벨에서도 지켜져야 한다는 귀중한 교훈을 얻었습니다. API가 각 모듈의 경계를 명확히 반영하고, 자신의 책임에만 집중할 때 비로소 전체 시스템이 예측 가능하고 확장 가능해진다는 것을 배우게 된 성장의 기회였습니다.

---

### **3. 도메인 모델 디자인: Memento Pattern을 통한 상태 캡슐화 및 비즈니스 로직의 명확성**

**"Employee 모듈을 디자인할 때, 객체의 내부 상태를 직접적으로 외부에 노출시키는 것은 좋지 못한 디자인이라는 철학을 가지고 접근했습니다."**

객체의 내부 상태가 외부 로직에 의해 직접 변경될 경우, 데이터 무결성이 깨지거나 예상치 못한 부작용이 발생할 위험이 커집니다. 이를 방지하고 `Employee` 객체의 **캡슐화(Encapsulation)**를 강화하기 위해 **Memento Design Pattern**을 적극적으로 활용했습니다.

구체적으로, `Employee` 객체 자체는 자신의 내부 상태를 온전히 캡슐화하고, `EmployeeContext`라는 별도의 객체를 **Memento(메멘토)**로 활용하여 `Employee` 객체의 특정 시점 상태를 저장하고 로드하는 방식으로 클래스를 디자인했습니다.

이러한 디자인은 다음과 같은 이점을 제공했습니다.

*   **데이터 무결성 보장:** `Employee` 객체의 내부 상태는 오직 `Employee` 객체 내부의 로직에 의해서만 변경될 수 있도록 강제하여 데이터의 일관성과 무결성을 보장했습니다.
*   **느슨한 결합:** `Employee` 객체의 상태를 관리하는 외부 객체(예: 서비스 레이어)는 `EmployeeContext`라는 Memento 객체만을 다루므로, `Employee` 객체의 복잡한 내부 구현에 대해 알 필요가 없어졌습니다. 이는 모듈 간의 결합도를 낮추는 데 기여했습니다.
*   **유연한 상태 관리:** 필요에 따라 `Employee` 객체의 과거 상태를 쉽게 복원하거나, 특정 시점의 스냅샷을 저장하는 등 유연한 상태 관리 메커니즘을 제공할 수 있는 기반을 마련했습니다.

**2) 함수형 프로그래밍 기법을 활용한 비즈니스 로직의 명확성:**

Service Layer를 설계할 때, 중요한 비즈니스 로직이 복잡한 추상화 뒤에 숨겨져 가독성을 해치지 않도록 특별히 주의했습니다. 이를 위해 **함수형 프로그래밍의 람다(Lambda) 표현식**을 적극적으로 활용했습니다.

람다를 통해 비즈니스 로직의 핵심적인 부분을 명시적으로 전달하고 실행함으로써, 코드의 흐름을 따라가기 쉽게 만들고, 어떤 로직이 언제 실행되는지 명확하게 드러나도록 했습니다. 이는 개발자가 Service Layer의 코드를 읽을 때, 불필요한 계층을 파고들 필요 없이 **핵심 비즈니스 규칙을 한눈에 파악**할 수 있게 하여 코드의 이해도와 유지보수성을 크게 향상시켰습니다.

**예시:** `addEmployee` 메서드에서 프로필 이미지 저장 로직(`fileService::save`)과 변경 로그 저장 로직(`changeLogService::addEmployeeInsertLog`)을 람다 형태로 전달하여, 핵심 비즈니스 로직의 흐름을 명확하게 유지하면서도 유연성을 확보했습니다.

```java
    @Override @Transactional
    public EmployeeDto addEmployee(EmployeeCreateRequest request, MultipartFile multipartFile, String ipAddress) {
        EmployeeContext employeeContext = employeeMapper.toEntityContext(request);

        // 비지니스 로직
        Employee employee = repository.save(Employee.from(employeeContext));
        // - departmentName을 반환해야하는 상황으로 간접 강한 결합 발생
        String departmentName = departmentService.getDepartmentName(employee.getDepartmentId());
        Long profileImageId = saveProfileIfPresent(multipartFile, fileService::save);

        // 직원 정보 수정 이벤트 수행
        EmployeeLogDto.CreateLogRequest changeLogRequest =
                createChangeLogRequest(employee, departmentName, request.memo(), ipAddress);
        saveChangeLog(changeLogRequest, changeLogService::addEmployeeInsertLog);
        
        return employeeMapper.toDto(employee, departmentName, profileImageId);
    }

    @Nullable
    private static Long saveProfileIfPresent(MultipartFile multipartFile, Function<MultipartFile, Long> saver) {
        if (!multipartFile.isEmpty()) {
            return saver.apply(multipartFile);
        }
        return null;
    }

    // 직원 정보 수정 이벤트 생성 (CREATE)
    private EmployeeLogDto.CreateLogRequest createChangeLogRequest(
            Employee employee,
            String departmentName,
            String memo,
            String ipAddress
    ) {
        return employeeMapper.toChangeLogRequest(employee.save(), departmentName, memo, ipAddress);
    }
    
    private static <T> void saveChangeLog(T request, Consumer<T> saver) {
        saver.accept(request);
    }
```
