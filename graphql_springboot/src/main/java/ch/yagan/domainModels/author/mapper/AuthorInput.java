package ch.yagan.domainModels.author.mapper;

public class AuthorInput {

    private String id;
    private String name;
    private Integer age;

    public String getId() {
        return id;
    }

    public AuthorInput setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AuthorInput setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public AuthorInput setAge(Integer age) {
        this.age = age;
        return this;
    }
}
