package ch.yagan.core;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoreJpaRepository<T extends CoreEntity> extends JpaRepository<T, String> {
}

