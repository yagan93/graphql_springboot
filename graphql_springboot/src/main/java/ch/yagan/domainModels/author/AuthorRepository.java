package ch.yagan.domainModels.author;

import ch.yagan.core.CoreJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import ch.yagan.domainModels.author.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CoreJpaRepository<Author> {

}