package com.example.demo.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PageUtil {

    public static int getCurrentPage(int page) {
        return page <= 0 ? 1 : page;
    }

    public static int getCurrentPageSize(int pageSize) {
        return pageSize <= 0 ? 5 : pageSize;
    }

    public static List<Integer> getPageNumbers(int totalPages) {
        return IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
    }
}
