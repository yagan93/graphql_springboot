package ch.yagan.domainModels.tutorial;

import ch.yagan.domainModels.tutorial.mapper.TutorialMapper;
import ch.yagan.domainModels.tutorial.mapper.TutorialInput;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TutorialMutations implements GraphQLMutationResolver {

    private TutorialService tutorialService;
    private TutorialMapper tutorialMapper;

    @Autowired
    public TutorialMutations(TutorialService tutorialService, TutorialMapper tutorialMapper) {
        this.tutorialService = tutorialService;
        this.tutorialMapper = tutorialMapper;
    }

    public Tutorial createTutorial(TutorialInput tutorial) {
        return tutorialService.create(tutorialMapper.fromInput(tutorial));
    }

    public Tutorial updateTutorialById(String id, TutorialInput tutorial) {
        return tutorialService.updateById(id, tutorialMapper.fromInput(tutorial));
    }

    public Boolean deleteTutorialById(String id) {
        tutorialService.deleteById(id);
        return true;
    }
}
