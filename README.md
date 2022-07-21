# simple-springboot-app

A simple Spring Boot app, used for demo on K8S.

We can use this app to test rate limiter api:
- Resilient4J: [https://github.com/resilience4j/resilience4j](https://github.com/resilience4j/resilience4j)
- Bucket4J: [https://bucket4j.com/](https://bucket4j.com/), [https://github.com/MarcGiffing/bucket4j-spring-boot-starter](https://github.com/MarcGiffing/bucket4j-spring-boot-starter)

App endpoints:
- `/api/bucket4j`: IP base, 1 request per minute
- `/api/accounts`: Use `resilience4j`, 1 request per minute

Actuator (port 8081) endpoints:
- `/actuator`
- `/actuator/bucket4j`
- `/actuator/caches`
- `/actuator/health`
- `/actuator/metrics`