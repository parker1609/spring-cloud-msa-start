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