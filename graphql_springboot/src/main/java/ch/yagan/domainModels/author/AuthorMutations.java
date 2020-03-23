package ch.yagan.domainModels.author;

import ch.yagan.domainModels.author.mapper.AuthorInput;
import ch.yagan.domainModels.author.mapper.AuthorMapper;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutations implements GraphQLMutationResolver {

    private AuthorService authorService;
    private AuthorMapper authorMapper;

    @Autowired
    public AuthorMutations(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    public Author createAuthor(AuthorInput author) {
        return authorService.create(authorMapper.fromInput(author));
    }

    public Author updateAuthorById(String id, AuthorInput author) {
        return authorService.updateById(id, authorMapper.fromInput(author));
    }

    public Boolean deleteAuthorById(String id) {
        authorService.deleteById(id);
        return true;
    }
}
