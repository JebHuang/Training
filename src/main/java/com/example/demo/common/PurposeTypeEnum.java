package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Lance
 * @date 2021/1/7 17:54
 */
@Getter
@AllArgsConstructor
public enum PurposeTypeEnum {
    DEPOSIT(1, "Deposit"),
    CREDIT_CARD(2, "Credit Card"),
    PERSONAL_LOAN(3, "Personal Loan"),
    MORTGAGE(4, "Mortgage"),
    INVESTMENT(5, "Investment"),
    INSURANCE(6, "Insurance"),
    OTHER(7, "Other");

    private Integer code;
    private String desc;

    public static String getDesc(Integer code) {
        for (PurposeTypeEnum type : PurposeTypeEnum.values()) {
            if (type.getCode().equals(code)) {
                return type.getDesc();
            }
        }
        return null;
    }
}
