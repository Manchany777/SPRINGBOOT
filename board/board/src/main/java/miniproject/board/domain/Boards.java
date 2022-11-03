package miniproject.board.domain;

import javax.persistence.*;

@Entity
@Table(name = "boards")// 테이블 이름을 소문자로 해서 워크벤치와 통일
public class Boards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // id 자동생성 어노테이션
    private Integer id;
    @Column(name = "title")    // Column 중복시 생략 가능
    private String title;
    private String content;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
