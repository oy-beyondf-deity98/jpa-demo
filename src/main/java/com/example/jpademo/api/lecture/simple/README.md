아래와 같이 매핑테이블이 저절로 생긴다.

lecture가 아래와 같이 되어 있으면 매핑테이블이 저절로 생긴다.

SIMPLE_LECTURE
SIMPLE_LECTURE_STUDENT_LIST
SIMPLE_STUDENT

```java
@Entity @Getter @Setter
public class SimpleLecture {
    @Id @GeneratedValue
    Long seq;

    String name;

    @OneToMany
    List<SimpleStudent> studentList;

    @Override
    public String toString() {
        return "SimpleLecture{" + "seq=" + seq + ", name='" + name + '\'' + '}';
    }
}

```

아래와 같이 속성을 주어야지 매핑테이블이 생기지 않고 쓸수 있다.

```java
@Entity @Getter @Setter
public class SimpleLecture {
    @Id @GeneratedValue
    Long seq;

    String name;

    @OneToMany(mappedBy = "lecture")
    List<SimpleStudent> studentList;

    @Override
    public String toString() {
        return "SimpleLecture{" + "seq=" + seq + ", name='" + name + '\'' + '}';
    }
}
```

테이블 있다는 가정하에서는 이게 맞는것 같다.