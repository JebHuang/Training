package com.example.demo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author Lance
 * @date 2021/1/8 11:10
 */
@Data
public class ItemVO {
    private Long id;
    private String name;
    private String sex;
    private String email;
    private String phone;


    private String type;
    private String content;
    private Date createDate;
    private Date updateDate;
    private String deal;

    private Long handlerId;
}
