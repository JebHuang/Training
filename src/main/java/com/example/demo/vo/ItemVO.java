package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm", timezone = "Asia/Shanghai")
    private Date createDate;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm", timezone = "Asia/Shanghai")
    private Date updateDate;
    private String deal;
    private String purpose;

    private Long handlerId;
    private String handlerName;
    private String result;
}
