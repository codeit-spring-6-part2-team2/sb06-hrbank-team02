## 초급 프로젝트 개인 보고서(이치호)
> 개인 담당 부분을 서술하였음을 알립니다.
### 개요  
제목: HR Bank  
부제: Batch로 데이터를 관리하는 Open EMS  
기간: 2025.10.20(월) ~ 2025.10.28(화)  
저장소: https://github.com/codeit-spring-6-part2-team2/sb06-hrbank-team02
담당 기능: 데이터 백업 관리

---
### 수행
#### `데이터 백업 관리` 요구사항 분석 및 정의
> 요구사항을 다음과 같이 세부적으로 정의하고 구조화
  - 데이터 백업
    > **Step1. 백업 필요 여부 판단**  
      i. `ChangeLogService` 직원 정보 수정 이력 조회 - `생성시간` 조회  
      ii. 완료 백업 이력 조회 - `시작시간` 조회  
      iii. 시작시간 이후 생성시간이 존재하면 백업 필요, 없으면 `건너뜀`상태로 이력 등록)

    > **Step2. 백업 데이터 생성**
      i. 상태(`진행중`) 이력 등록   
      ii. 이전 판단 시점과 현재 시점의 변경 이력 생성시간 비교 (다를 경우 `실패` 처리)
      iii. `EmployeeService`를 통해 직원 정보 페이지네이션 조회 (배치 처리)   
      iv. 조회한 데이터를 CSV 파일로 변환   
      v. 다음 페이지가 있으면 반복

    > **Step3. 백업 상태(`완료`) 이력 수정**  
      i. 생성된 백업 파일을 파일 관리로 저장 요청 - `파일 식별자` 반환
  - 배치에 의한 데이터 백업
    > 해석 필요 부분 없음 - 요구사항 이행
  - 데이터 백업 이력 목록 조회
    > 해석 필요 부분 없음 - 요구사항 이행
#### 모듈 간 의존성 협의
> 요구사항에서 `파일 관리`는 `직원 정보`와 `데이터 백업`에서 외부 참조 중 때문에 다음 의견 도출
  - a안. 확장성을 위한, 공용 모듈로 전환 후, FK를 파일 관리 필드에 나두기  
  - b안. 요구사항을 위한, 그대로 파일 관리 요구사항에 따르기  
    - 요구사항을 우선하여 b안 채택 - 데이터 백업에서는 `fileId`만 저장
#### 구현
#### 1. Domain Layer
```
com.team2.hrbank.backup.domain
├── Backup.java              # 백업 엔티티 (JPA Entity)
│   ├── 필드: id, worker, startedAt, endedAt, status, fileId
│   ├── create()             - 백업 생성 팩토리 메서드
│   ├── withCompleted()      - 완료 상태 변경
│   ├── withFailed()         - 실패 상태 변경
│   └── withSkipped()        - 건너뜀 상태 변경
└── BackupStatus.java        # 백업 상태 Enum
    └── IN_PROGRESS, COMPLETED, FAILED, SKIPPED
```

#### 2. DTO Layer
```
com.team2.hrbank.backup.dto
├── BackupDto                         # 백업 응답 DTO
├── CursorPageRequestBackupDto        # 페이지네이션 요청
├── CursorPageResponseBackupDto       # 페이지네이션 응답
├── BackupCompleteRequestDto          # 백업 완료 요청
├── BackupFailRequestDto              # 백업 실패 요청
└── BackupCreateRequestDto            # 백업 생성 요청
```
#### 3. Controller Layer  
> Swagger 문서화를 포함한 REST API 엔드포인트 구현
- `POST /api/backups` - 백업 생성
- `GET /api/backups` - 백업 목록 조회 (필터링/정렬 지원)
- `GET /api/backups/latest` - 최근 백업 조회
- `PUT /api/backups/{id}/complete` - 백업 완료
- `PUT /api/backups/{id}/fail` - 백업 실패
#### 4. Service Interface
- `BackupService` 인터페이스 정의
  - 백업 생성, 조회, 상태 변경 메서드 명세
#### 5. 연계 모듈
- `ChangeLogService.getRecentLogDate()` - 최근 변경 이력 조회 메서드 존재 확인
- `EmployeeService`에 백업용 조회 메서드 시그니처 추가
  - `BackupEmployeeDto`, `BackupEmployeePageRequestDto/ResponseDto` 정의
---
### 결과
#### 구현 완료
  - 백업 도메인 모델 및 상태 관리 (Backup, BackupStatus)
  - 모든 DTO 정의 (6개)
  - REST API Controller 및 Swagger 문서화
  - Service 인터페이스 정의
  - 변경 이력 연계 확인 및 백업용 직원 DTO 정의
#### 향후 구현 필요 사항
  - Repository Layer (Querydsl 기반 동적 쿼리)
  - Service 비즈니스 로직 구현
  - CSV 파일 생성 및 저장 로직
  - Spring Scheduler 배치 작업
  - 백업 필요 여부 판단 로직
  - 에러 발생 시 로그 파일 생성 
#### 기술 스택
  - Spring Boot 3.5.6, JPA/Hibernate  
  - Querydsl (동적 쿼리 설계)  
  - OpenCSV (CSV 처리 예정)  
  - Swagger/OpenAPI 3.0  
---
### 소감
부상으로 시간 투자를 못한 것으로 데이터 백업 모듈을 완성하지 않은 것과 적극적으로 의견 표출을 하지 않은 점에서 아쉬움이 큽니다.

필요한 기능에 대한 요구사항을 해석하고 서로 맞추는 점이 매력적이었다.
협업으로 진행하니 생각지 않은 부분까지 세세하게 알아갈 수 있었다.  
(요구사항에 불합리한 부분을 찾아가거나 의존성에 대한 부분을 조사하는 등)

