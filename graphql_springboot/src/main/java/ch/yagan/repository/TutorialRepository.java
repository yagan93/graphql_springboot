package ch.yagan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.yagan.model.Tutorial;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

}
