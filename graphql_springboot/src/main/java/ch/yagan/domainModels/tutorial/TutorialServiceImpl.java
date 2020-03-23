package ch.yagan.domainModels.tutorial;

import ch.yagan.core.CoreJpaRepository;
import ch.yagan.core.CoreServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialServiceImpl extends CoreServiceImpl<Tutorial> implements TutorialService {

    @Autowired
    public TutorialServiceImpl(TutorialRepository repository, Logger logger) {
        super(repository, logger);
    }
}
