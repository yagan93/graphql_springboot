package ch.yagan.domainModels.author;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorQueriesImpl implements GraphQLQueryResolver {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorQueriesImpl(AuthorRepository repository, AuthorRepository authorRepository) {
       this.authorRepository = authorRepository;
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

}
