package com.example.demo.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Lance
 * @date 2021/1/7 17:20
 */
@Data
@Table(name = "item")
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "type")
    private Integer type;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "is_deal")
    private Integer deal;

    @OneToOne
    @JoinColumn(name = "handler_id", referencedColumnName = "id")
    private User handler;
}
