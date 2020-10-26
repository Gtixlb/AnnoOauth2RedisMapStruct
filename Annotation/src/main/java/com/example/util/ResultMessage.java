package com.example.util;

public enum  ResultMessage {
    /** 成功 */
    SUCCESS(200, "Success"),
    /** 请求错误 */
    BAD_REQUEST(400, "Bad request"),
    /** 未经授权 */
    UNAUTHORIZED(401, "Unauthorized"),
    /** 目标不存在 */
    NOT_FOUND(404, "Not found"),
    /** 服务内部错误 */
    SERVER_ERROR(500, "Server Error");


    private int code;
    private String message;

    ResultMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}