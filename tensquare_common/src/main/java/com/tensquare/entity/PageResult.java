package com.tensquare.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private Long total;
    private List<T> rows;

    public PageResult(Long  total, int rows)  {
        super();
        this.total  =  total;
        this.rows  =  rows;
    }

}
