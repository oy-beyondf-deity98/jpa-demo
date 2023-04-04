# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.0.4/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.0.4/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.0.4/reference/htmlsingle/#web)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boo

---

오류 페이지를 위한 것을 작성하자.

1. 사용자의 입력 오류 확인
2. 시스템의 입력 오류 확인
3. 로직 오류 확인
4. 서버가 정상인가 확인


1XX는 Information responses로 그냥 하면된다.

2XX는 성공적인 처리
- 200 성공
- 201 created 되었지만 리턴은 없음
    - 추가/수정/삭제 할때 보내는 내용같다.
- 204 요청에 대해서 보내줄 내용이 없음
- 205 초기화 할 것
  3XX는 다른곳으로 이동되었음을
- 301 리다이렉트, 해당소스는 다른곳으로 이동되었음을 나타낸다.
- 306
  4XX는 사용자 오류
- 400 서버가 요청을 이해할수 없음
- 401 인증 되지 않는 사용자
- 403 접근 금지된 리소스 요청
- 404 찾을수 없음, 리소스가 없습니다.
- 408 시간 초과, 요청이 오래된 연결
  5XX는 서버 오류이다.
- 500 서버오류
- 502 잘못된 요청, 내부적으로 잘못
- 503 서버가 서비스 중지된 상태
- 504 타임아웃

위 메서드를 모두 명시할 필요가 있을까? 싶다..
그냥은 모두 200이고, 추가적으로 할것만 넣으면 될것 같다.

200 성공
201로 추가/수정/삭제 된것은 표시한다.
- 다른곳으로 이동한 것도 표시한다.
- 201, 204, 205는 비슷한 의미로 보인다.. 201로 통일하자

400 으로 validation 체크를 해서 해당 값이 충족되지 않으면 오류나도록 한다.
404는 데이터가 없는 것을 조회했을때 처리한다.
- 근데 404는 오류로 내보내는 것은 이상하다... 200으로 하고 특정한 메세지를 내보내는 것이 좋지 않는가?
  401, 403는 같게 처리한다.

500 으로 오류를 내보낸다.

502는 내부적인 오류,
503은 서비스 중지된 상태

408과 504는 타임아웃

---

포탈쪽은 이미 처리가 되도록 되어 있는 것 같다. API만들때 위의값을 사용하도록 하자.

302는 이미 서버가 처리하네?


포탈은 400부터를 다르게 보여주면 될것 같다.

---

설정외에도 queryDSL을 도입하면서 소스 코드가 몇가지 변하네요.

1. queryDslConfig를 넣어야 합니다.
2. 그리고 queryDslConfig에서 만든 빈에 있는 facotry를 import해주어야 합니다.
3. 마지막으로 queryDSL에 대한 조회 쿼리를 익혀야 합니다.
   4. 러닝 커브 한단계 상승...


### queryDSL 문법
queryFactory로 시작해주어야 합니다.
그리고 fetchOne()이나 fetch()로 끝납니다.
  - fetchOne()은 한건이 리턴 됩니다.
    - JpaObject로 리턴하므로 Optional.ofNullable로 감싸주어야 합니다.
  - fetch()는 List로 리턴합니다.
  

```java
//설정파일 추가
@Configuration
public class QuerydslConfig {
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
```


```java
class queryDsl도입전{
    final CommonCodeRepository commonCodeRepository;
    
    public Optional<CommonCode> read(CommonCode code) {
        return commonCodeRepository.findById(code.getCode());
      }    
}



```


```java
class queryDsl도입후{
    final CommonCodeRepository commonCodeRepository;
  
    final JPAQueryFactory queryFactory;    // 추가
    public Optional<CommonCode> read(CommonCode code) {
        QCommonCode findCode = QCommonCode.commonCode;//추가


        //기본적으로 Optional로 리턴이 안되므로 해주어야 한다.
        return Optional.ofNullable(queryFactory.select(findCode).where(findCode.eq(code)).fetchOne()); 
        
      }    
}
```

