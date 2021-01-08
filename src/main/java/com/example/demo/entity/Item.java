package com.example.demo.entity;

import com.example.demo.common.PurposeTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Lance
 * @date 2021/1/7 17:20
 */
@Data
@Table(name = "item")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "gender", nullable = false, length = 100)
    private Integer gender;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "type")
    private Integer type;

    @Column(name = "purpose")
    private Integer purpose;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "is_deal")
    private Integer deal;

    @Column(name = "handler_id")
    private String handlerId;

    @Column(name = "handler_name")
    private String handlerName;
}
