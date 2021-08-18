package com.bwhome.common.core.enums;

public enum HttpStatusEnum {
    SUCCESS(200),
    ERROR(500);

    private int code;

    HttpStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
