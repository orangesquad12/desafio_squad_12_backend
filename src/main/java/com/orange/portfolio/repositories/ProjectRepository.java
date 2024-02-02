package com.orange.portfolio.repositories;

import com.orange.portfolio.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository <Project, Long> {

    List<Project> findProjectByTags(String tag);

    void delete(Project project);

    @Query(value = "select client_id from tb_project p where p.client_id =?1",
            nativeQuery = true)
    List<Project> findAllByClientId(Long userId);
}
