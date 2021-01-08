package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lance
 * @date 2021/1/8 11:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /**
     * 0:操作正常
     * 1:发生了意外
     */
    private Integer code;
    private String desc;
    private T data;

    public static final Integer SUCCESS_CODE = 0;
    public static final String SUCCESS_DESC = "success";

    public Result(T data) {
        this.code = SUCCESS_CODE;
        this.desc = SUCCESS_DESC;
        this.data = data;
    }

    public Result(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
