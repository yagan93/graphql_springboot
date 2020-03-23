# graphql_springboot

Introduction to GraphQL with SpringBoot and Maven

## authors.graphqls
```
type Author {
	id: String!
	name: String!
	age: Int
}

input AuthorInput {
	id: String
	name: String!
	age: Int
}

# Root
type Query {
	findAllAuthors: [Author]!
	findAuthorById(id: String!): Author
}

# Root
type Mutation {
	createAuthor(author: AuthorInput!): Author!
	updateAuthorById(id: String!, author: AuthorInput!): Author
	deleteAuthorById(id: String!): Boolean
}
```

## Queries

### AuthorQueries.java
```
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
```

### Queries using Postman

#### findAllAuthors
![findAllAuthors](img/findAllAuthors.png)

#### findAuthorById
![findAuthorById](img/findAuthorById.png)

## Mutations

### AuthorMutations.java
```
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
```

### Mutations using Postman

#### createAuthor
![createAuthor](img/createAuthor.png)

#### updateAuthorById
![updateAuthorById](img/updateAuthorById.png)

#### deleteAuthorById
![deleteAuthorById](img/deleteAuthorById.png)
