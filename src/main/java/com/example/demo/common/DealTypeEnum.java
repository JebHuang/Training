package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Lance
 * @date 2021/1/7 17:47
 */
@Getter
@AllArgsConstructor
public enum DealTypeEnum {
    PROCESSED(1, "Accomplish"),
    UNPROCESSED(0, "In Process"),;

    private Integer code;
    private String desc;

    public static String getDesc(Integer code) {
        for (DealTypeEnum type : DealTypeEnum.values()) {
            if (type.getCode().equals(code)) {
                return type.getDesc();
            }
        }
        return null;
    }
}
