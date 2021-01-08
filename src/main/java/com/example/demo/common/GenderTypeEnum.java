package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Lance
 * @date 2021/1/7 17:47
 */
@Getter
@AllArgsConstructor
public enum GenderTypeEnum {
    MISS(0, "Female"),
    SIR(1, "Male");

    private Integer code;
    private String desc;

    public static String getDesc(Integer code) {
        for (GenderTypeEnum type : GenderTypeEnum.values()) {
            if (type.getCode().equals(code)) {
                return type.getDesc();
            }
        }
        return null;
    }
}
