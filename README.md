# 🚀 Service Platform Backend

본 프로젝트는 [여기에 서비스의 핵심 목적 한 줄 작성]을 위한 백엔드 API 서버입니다.

## 🛠 Tech Stack
* **Language:** Java 21 (Amazon Corretto)
* **Framework:** Spring Boot 4.0.5 -> https://start.spring.io/
* **Build Tool:** Gradle
* **Database:** MariaDB 11.4.10 (LTS) -> https://mariadb.org/download/
* **Database Tools:** DBeaver 26.0.1 -> https://dbeaver.io/download/
* **Config:** YAML (`application.yml`)
* **Packaging:** Jar

## 💡 기술 스택 선정 사유
* **Java 21 & Corretto:** 최신 LTS 버전의 가상 스레드(Virtual Threads)를 통한 동시성 성능 최적화 및 향후 AWS 인프라 환경과의 완벽한 호환성을 고려함.
* **YAML:** 계층적 구조를 통해 가독성을 높이고 환경 프로필(Profile) 관리를 용이하게 함.
* **MariaDB LTS:** 실 서비스 운영에 필수적인 장기 지원 및 검증된 안정성 확보.

## ⚙️ 로컬 환경 실행 방법 (Getting Started)

### 1. Database Setup
본 프로젝트는 MariaDB를 사용합니다. 로컬 환경에 MariaDB 11.4.x 버전을 설치하고 아래 정보를 설정해 주세요.
* **Database Name:** `service_platform`
* **Port:** `3306`

### 2. 환경 변수 설정 (`application.yml`)
`src/main/resources/application.yml` 파일을 생성하고 아래 본인의 로컬 DB 정보를 기입합니다.
> ⚠️ **주의:** 비밀번호가 포함된 `application.yml` 파일은 절대 Git에 Push하지 마세요.

```yaml
spring:
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    url: jdbc:mariadb://localhost:3306/service_platform
    username: root
    password: [본인의 DB 비밀번호]
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 3. Build & Run (터미널 명령어로 서버 실행)
IDE(인텔리제이) 없이 터미널 명령어만으로 서버를 실행하는 방법입니다.

```bash
# 1. 프로젝트 원격 저장소에서 다운로드 (Clone)
git clone [https://github.com/juchan1122/service_platform.git](https://github.com/juchan1122/service_platform.git)

# 2. 프로젝트 폴더로 이동
cd service_platform

# 3. 스프링 부트 서버 실행
./gradlew bootRun
```

## 📌 Troubleshooting (이슈 해결 기록)

**[2026.04.06] MariaDB 드라이버 로드 에러**
* **Issue:** 서버 초기 실행 시 `Cannot load driver class: org.mariadb.jdbc.Driver` 에러 발생과 함께 서버 강제 종료.
* **Solution:** `build.gradle` 파일의 dependencies 블록에 `runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'` 의존성 코드를 추가한 후, **Gradle Refresh(새로고침)**를 수행하여 라이브러리를 정상적으로 다운로드하여 해결.
