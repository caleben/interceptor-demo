package com.foryoutruck.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lilimin
 * @Date: 2019/8/24 10:21
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse {

    private int code;
    private String desc;
    private List<Object> data;

    public enum GlobalStatus {

        SUCCESS(0, "成功"),
        FAILED(1, "失败"),
        ERROR(2, "错误");

        private final int code;
        private final String desc;

        private GlobalStatus(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    public ServerResponse(GlobalStatus status, String desc) {
        this.code = status.code;
        this.desc = desc;
    }

    public ServerResponse(GlobalStatus status) {
        this.code = status.code;
        this.desc = status.desc;
    }

    public void addObject(Object da) {
        if (this.data == null)
            this.data = new ArrayList<Object>();
        this.data.add(da);
    }

    public <T>void setData(List<T> data) {
        this.data = (List)data;
    }
}
