package ch.yagan.domainModels.tutorial;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialQueries implements GraphQLQueryResolver {

    private TutorialRepository tutorialRepository;

    @Autowired
    public TutorialQueries (TutorialRepository tutorialRepository){
        this.tutorialRepository = tutorialRepository;
    }

    public Iterable<Tutorial> findAllTutorials() {
        return tutorialRepository.findAll();
    }

    public long countTutorials() {
        return tutorialRepository.count();
    }
}
