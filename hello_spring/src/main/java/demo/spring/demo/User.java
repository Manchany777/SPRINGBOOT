package demo.spring.demo;

public class User {
    private String id;    
    private String name;           // alt + insert -> getter and setter
    
    //----------------------- 이하 자동생성

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
