package com.example.demo.common;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {
    /**
     * 0:操作正常
     * 1:发生了意外
     */
    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;
}
