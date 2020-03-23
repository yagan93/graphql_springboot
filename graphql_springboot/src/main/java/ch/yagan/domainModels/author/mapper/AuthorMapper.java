package ch.yagan.domainModels.author.mapper;

import ch.yagan.core.CoreMapper;
import ch.yagan.domainModels.author.Author;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper extends CoreMapper<Author, AuthorInput> {
}
