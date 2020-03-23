package ch.yagan.domainModels.author;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Component
public class AuthorQueries implements GraphQLQueryResolver {

    private AuthorService authorService;

    @Autowired
    public AuthorQueries(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<Author> findAllAuthors() {
        return authorService.findAll();
    }

    public Author findAuthorById(String id) {
        return authorService.findById(id);
    }

}
