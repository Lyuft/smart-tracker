package org.smart_tracker.backend.repo;

import org.smart_tracker.backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUser_Id(Long id);

    Optional<Task> findByIdAndUser_Id(Long id, Long userId);

}