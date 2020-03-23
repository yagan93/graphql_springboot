package ch.yagan.domainModels.tutorial.mapper;

import ch.yagan.core.CoreMapper;
import ch.yagan.domainModels.tutorial.Tutorial;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TutorialMapper extends CoreMapper<Tutorial, TutorialInput> {

}
