package ch.yagan.domainModels.tutorial;

import ch.yagan.domainModels.author.Author;
import ch.yagan.domainModels.author.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TutorialMutations implements GraphQLMutationResolver {

    private TutorialRepository tutorialRepository;

    @Autowired
    public TutorialMutations (TutorialRepository tutorialRepository){
        this.tutorialRepository = tutorialRepository;
    }

    public Tutorial createTutorial(String title, String description, String authorId) {
        Tutorial book = new Tutorial();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setDescription(description);

        tutorialRepository.save(book);

        return book;
    }

    public boolean deleteTutorial(String id) {
        tutorialRepository.deleteById(id);
        return true;
    }

    public Tutorial updateTutorial(String id, String title, String description) throws NotFoundException {
        Optional<Tutorial> optTutorial = tutorialRepository.findById(id);

        if (optTutorial.isPresent()) {
            Tutorial tutorial = optTutorial.get();

            if (title != null)
                tutorial.setTitle(title);
            if (description != null)
                tutorial.setDescription(description);

            tutorialRepository.save(tutorial);
            return tutorial;
        }

        throw new NotFoundException("Not found Tutorial to update!");
    }
}
