package ch.yagan.domainModels.tutorial;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TutorialQueries implements GraphQLQueryResolver {

    private TutorialService tutorialService;

    public TutorialQueries(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    public Iterable<Tutorial> findAllTutorials() {
        return tutorialService.findAll();
    }

    public Tutorial findTutorialById(String id) {
        return tutorialService.findById(id);
    }
}
