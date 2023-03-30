H2 메모리모드로 서버를 뜨우면서 Table를 보려면
H2ServiceConfig 주석을 풀면된다.
  - @Configuration 해제
  - @Bean 해제

주석한이유는 테스트가 제대로 안돌아서이다.

템플릿 엔진으로 만든것은 따로 해야할 필요가 있을 것 같다. 이만 여기서 중단하도록 하겠다.  
API 문서를 위한 것은 따로 만들도록 하자.

템플릿 엔진과 API를 같이 쓰는 것은 어울리지 않는것 같다. 
  - get방식으로 조회하는 것까지는 괜찮을 것 같다. 하지만... post방식은 따로 만들도록 하자.


---
## 사용 방법

1. Form으로 템플릿 엔진 처리 : CUD 처리
2. url호출로 템플릿 엔진 처리 : 화면 호출
3. get방식 api호출로 : 데이터 조회

--- 
## 진행
1. 스프링 부트 : 3.0.4
2. spring JPA
   - H2 
3. spring Security 
4. springdoc-openapi : swagger를 wrapping한 라이브러리 

## 접속
1. http://localhost:8080
2. http://localhost:8080/swagger-ui/index.html

---

API와 시큐리티 그리고 api문서는 따로 프로젝트를 만든다.