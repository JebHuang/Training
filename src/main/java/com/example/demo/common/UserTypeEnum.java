package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Lance
 * @date 2021/1/7 17:47
 */
@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    ADMIN(2, "经理"),
    NORMAL(1, "用户");

    private Integer code;
    private String desc;

    public static String getDesc(Integer code) {
        for (UserTypeEnum type : UserTypeEnum.values()) {
            if (type.getCode().equals(code)) {
                return type.getDesc();
            }
        }
        return null;
    }
}
