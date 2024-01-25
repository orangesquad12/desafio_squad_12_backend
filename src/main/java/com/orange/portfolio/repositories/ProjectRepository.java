package com.orange.portfolio.repositories;

import com.orange.portfolio.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long> {

    Project findProjectByTag(String tag);

    void delete(Project project);

    @Query(value = "select user_id from project p where p.user_id =?1",
            nativeQuery = true)
    List<Project> findAllByUserId(Long userId);
}
