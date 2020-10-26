package com.example.enums;

public enum GenderEnum {
    MAN(1, "男"),
    WOMAN(0, "女");

    private Integer code;

    private String sex;

    GenderEnum(Integer code, String sex) {
        this.code = code;
        this.sex = sex;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
