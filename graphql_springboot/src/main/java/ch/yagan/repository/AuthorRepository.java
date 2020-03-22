package ch.yagan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.yagan.model.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}