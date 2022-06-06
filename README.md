# Spring Cloud MSA START
Spring Cloud를 활용한 MSA 환경 구축 실습

## 1. Service Discovery
- 어떤 서버(서비스)로 보낼지 판단하는 역할
- Spring Cloud Netflix Eureka 사용
- Load Balancer 역할까지 가능

```shell
mvn spring-boot:run -Dspring-boot.run.jvmArguments='-Dserver.port=9003'

java -jar -Dserver.port=9004 ./target/user-service-0.0.1-SNAPSHOT.jar
```

- server.port = 0 으로 설정 시, 랜덤 포트로 설정된다.

## 2. API Gateway Service
- 클라이언트에서 접속하는 단일 지점
  - 클라이언트는 어느 서비스로 가야할지 모르게 해야 한다.
- 클라이언트는 게이트웨이로만 접속
- 기능
  - 인증 및 권한 부여
  - 서비스 검색 통합
  - 응답 캐싱
  - 정책, 회로 차단기 및 QoS 다시 시도
  - 속도 제한
  - 로깅, 추적, 상관 관계
  - 헤더, 쿼리 문자열 및 청구 변환
  - IP 허용 목록에 추가

### Netflix Ribbon
- Spring Cloud에서의 MSA간 통신
  - RestTemplate
  - Feign Client
- Ribbon: **Client side** Load Balancer
  - 서비스 이름으로 호출
  - health check
  - 비동기 처리가 부족 -> 최근에는 잘 사용하지 않음
  - 게이트웨이의 기능을 클라이언트 사이드에서 사용할 수 있음.
  - Spring Boot 2.4에서 Maintenance 상태 (해당 기능에 대해 더이상 업데이트가 없음)

### Netflix Zuul
- API Gateway 역할
- Spring Boot 2.4에서 Maintenance 상태
  - <https://spring.io/blog/2018/12/12/spring-cloud-greenwich-rc1-available-now> 참고


## 참고자료
- [인프런 - Spring Cloud로 개발하는 마이크로서비스 애플리케이션(MSA) by Dowon Lee](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4#)