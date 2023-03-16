package com.example.demo.repository.custom;

import com.example.demo.dto.TutorialCustomDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepository {

    Page<TutorialCustomDTO> testCustomPaging(@Param("titleLike") String titleLike, Pageable pageable);
}
