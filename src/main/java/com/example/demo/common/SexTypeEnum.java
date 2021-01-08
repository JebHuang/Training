package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Lance
 * @date 2021/1/7 17:47
 */
@Getter
@AllArgsConstructor
public enum SexTypeEnum {
    MISS(2, "MISS"),
    SIR(1, "SIR");

    private Integer code;
    private String desc;

    public static String getDesc(Integer code) {
        for (SexTypeEnum type : SexTypeEnum.values()) {
            if (type.getCode().equals(code)) {
                return type.getDesc();
            }
        }
        return null;
    }
}
