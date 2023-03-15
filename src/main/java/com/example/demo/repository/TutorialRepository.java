package com.example.demo.repository;

import com.example.demo.entity.Tutorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

    List<Tutorial> findByTitleContainingIgnoreCase(String keyword);

    Page<Tutorial> findAllByTitleContainingIgnoreCase(String keyword, Pageable pageable);

    @Query("UPDATE Tutorial t SET t.published = :published WHERE t.id = :id")
    @Modifying
    void updatePublishedStatus(Integer id, boolean published);

    @Query(value = "Select t.* from tutorial t where id = 1", nativeQuery = true)
    Object[] testMapperObjectToEntity();
}
