package com.example.demo.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class PageUtil {

    public int getCurrentPage(int page) {
        return page <= 0 ? 1 : page;
    }

    public int getCurrentPageSize(int pageSize) {
        return pageSize <= 0 ? 5 : pageSize;
    }

    public List<Integer> getPageNumbers(int totalPages) {
        return IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
    }

    public static <E> Page<E> returnPagedList(Pageable pageable, List<E> listOfEntities) {
        List<E> listToReturn = listOfEntities;
        if (pageable.isPaged()) {
            int pageSize = pageable.getPageSize();
            int currentPage = pageable.getPageNumber();
            int startItem = currentPage * pageSize;
            if (listOfEntities.size() < startItem) {
                listToReturn = Collections.emptyList();
            } else {
                int toIndex = Math.min(startItem + pageSize, listOfEntities.size());
                listToReturn = listOfEntities.subList(startItem, toIndex);
            }
        }
        return new PageImpl<>(listToReturn, pageable, listOfEntities.size());
    }
}
