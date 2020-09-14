package com.antra.easy_notes.repository;

import com.antra.easy_notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //this tells Spring to bootstrap the repository during component scan.
public interface NoteRepository extends JpaRepository<Note, Long> {
    /*
    You don’t need to implement these methods, hence you don't need to implement this interface.
    They are already implemented by Spring Data JPA’s SimpleJpaRepository.
    This implementation is plugged in by Spring automatically at runtime.
    */
}
