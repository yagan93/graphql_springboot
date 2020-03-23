package ch.yagan.domainModels.tutorial;

import ch.yagan.domainModels.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.yagan.domainModels.author.Author;
import com.coxautodev.graphql.tools.GraphQLResolver;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {

	private AuthorRepository authorRepository;

	@Autowired
	public TutorialResolver (AuthorRepository authorRepository){
		this.authorRepository = authorRepository;
	}

	public Author getAuthor(Tutorial tutorial) {
		return authorRepository.findById(tutorial.getAuthor().getId()).orElseThrow(null);
	}
}
