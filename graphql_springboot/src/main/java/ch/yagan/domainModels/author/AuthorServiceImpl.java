package ch.yagan.domainModels.author;

import ch.yagan.core.CoreServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends CoreServiceImpl<Author> implements AuthorService {

    @Autowired
    public AuthorServiceImpl(AuthorRepository repository, Logger logger) {
        super(repository, logger);
    }
}
