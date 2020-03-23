package ch.yagan.domainModels.author;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutations implements GraphQLMutationResolver {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorMutations (AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(String name, Integer age) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);

        authorRepository.save(author);

        return author;
    }

}
