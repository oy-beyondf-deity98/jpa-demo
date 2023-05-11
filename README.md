

## 화면에 나오는 것
1. 공통코드 관리
2. 사용자 관리
   1. 권한
   2. 사용자
3. 수강 신청
    - 저번에 내가 설계한대로 해야하나? 음.. 설계서가 어디있더라? 프리폼에 있었던것 같다.


## 사용 방법

1. Form으로 템플릿 엔진 처리 : CUD 처리
2. url호출로 템플릿 엔진 처리 : 화면 호출
3. get방식 api호출로 : 데이터 조회

--- 
## 진행
1. 스프링 부트 : 3.0.4
2. spring JPA
   - H2
   - queryDSL
3. spring Security 
4. springdoc-openapi : swagger를 wrapping한 라이브러리
   - controller와 dto에 덕지덕지 붙이는것을 실어해서 swagger 애노테이션은 하나도 안넣었다.
   - 그것을 붙일 정도의 규모가 되면 rest doc로 가자. 아니 rest doc와 swagger를 합친게 있으니 그걸 찾아서 적용해보도록 하자.
5. 실행할때 2개의 유저가 추가 된다. admin과 user이다. 그냥 테스트용으로 남겨놨다고 하자.

6. api와 같이 쓸때 api문서화하는것은 실패하였다. 스프링3.0이어서... 문서까지하려면 2.X버전으로 진행하라

## 접속
1. http://localhost:8080
2. http://localhost:8080/swagger-ui/index.html
  - "/lecture/listLecture"에서 아래의 값을 넣으면 값이 조회 된다.
```json
{
  "name": "",
  "studentSeq": "1"
}
```

스프링부트 3.0이상, 인텔리J의 버전, gradle의 버전문제 콜라보로 아래의 설정법을 한번에 맞추누라 고생좀 했다. 
  - queryDSL
  - openapi
  - jpa

시큐리티문제도 엉켜있는줄알고 많이 해멨다. 시큐리티가 엉켜 있으면 참 힘들다.

---

API와 시큐리티 그리고 api문서는 따로 프로젝트를 만든다.
  - 이곳의 코드가 정리가 잘되어 있다. https://github.com/kgu-capstone/study-with-me-be
  - 템플릿 엔진으로 만든것은 따로 해야할 필요가 있을 것 같다. 이만 여기서 중단하도록 하겠다.  
    - API 문서를 위한 것은 따로 만들도록 하자.
  - 템플릿 엔진과 API를 같이 쓰는 것은 어울리지 않는것 같다.
    - get방식으로 조회하는 것까지는 괜찮을 것 같다. 하지만... post방식은 따로 만들도록 하자.

---
# H2 메모리모드에 대한 추가사항

## H2를 메모리모드로 서버띄우면서 유틸프로그램으로 보는방법

H2 메모리모드로 서버를 뜨우면서 Table를 보려면
H2ServiceConfig 주석을 풀면된다.
- @Configuration 해제
- @Bean 해제

주석한이유는 테스트가 제대로 안돌아서이다.


