# 🚀 Service Platform Backend

본 프로젝트는 [여기에 서비스의 핵심 목적 한 줄 작성]을 위한 백엔드 API 서버입니다.

## 🛠 Tech Stack
* **Language:** Java 21 (Amazon Corretto)
* **Framework:** Spring Boot 4.0.5
* **Build Tool:** Gradle
* **Database:** MariaDB 11.4.10 (LTS)
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


3. Build & Run  
터미널 명령어로만 서버 실행하는 방법  
Bash  
$ git clone   [https://github.com/juchan1122/service_platform.git$(https://github.com/juchan1122/service_platform.git$)  
cd service_platform
$ ./gradlew bootRun  
서버가 정상적으로 실행되면 http://localhost:8080/test 로 접속하여 "스프링 부트 서버가 정상적으로 연결되었습니다!" 문구를 확인합니다.

📌 Troubleshooting (이슈 해결 기록)  
26.04.26  
Issue: 초기 실행 시 Cannot load driver class: org.mariadb.jdbc.Driver 에러 발생  
Solution: build.gradle에 runtimeOnly 'org.mariadb.jdbc:mariadb-java-client' 의존성 추가 후 Gradle Refresh 수행하여 해결.
