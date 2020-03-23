package ch.yagan.domainModels.tutorial;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.yagan.domainModels.tutorial.Tutorial;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, String> {

}
