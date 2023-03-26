package com.example.demo.repository.custom;

import com.example.demo.dto.TutorialCustomDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class CustomRepositoryImpl implements CustomRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<TutorialCustomDTO> testCustomPaging(String titleLike, Pageable pageable) {
        Query query = entityManager.createNativeQuery("Select * from tutorial where title like :key", "TutorialValueMapping");
        query.setParameter("key", "%" + titleLike + "%");
        int pageNumber = pageable.getPageNumber();
        int pageSize = pageable.getPageSize();
        query.setFirstResult((pageNumber) * pageSize);
        query.setMaxResults(pageSize);
        List<TutorialCustomDTO> list = query.getResultList();

        Query queryTotal = entityManager.createNativeQuery
                ("Select count(*) from tutorial where title like :key");
        queryTotal.setParameter("key", "%" + titleLike + "%");
        int countResult = Integer.parseInt(String.valueOf(queryTotal.getSingleResult()));
        return new PageImpl<>(list, pageable, countResult);
    }
}
