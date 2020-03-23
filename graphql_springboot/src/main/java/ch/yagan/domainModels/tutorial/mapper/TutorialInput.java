package ch.yagan.domainModels.tutorial.mapper;

import ch.yagan.domainModels.author.mapper.AuthorInput;

public class TutorialInput {

    private String title;
    private String description;
    private AuthorInput author;

    public String getTitle() {
        return title;
    }

    public TutorialInput setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TutorialInput setDescription(String description) {
        this.description = description;
        return this;
    }

    public AuthorInput getAuthor() {
        return author;
    }

    public TutorialInput setAuthor(AuthorInput author) {
        this.author = author;
        return this;
    }
}
