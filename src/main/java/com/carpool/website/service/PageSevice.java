package com.carpool.website.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by qi on 2016/12/1.
 */
public class PageSevice {
    private static final int pageSize = 2;
    private int currentPage=0;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Pageable buidPage(Sort.Direction direction, String sortParam)
    {
        Sort sort = new Sort(direction, sortParam);
        Pageable pageable = new PageRequest(currentPage, pageSize, sort);
        return  pageable;
    }
}
