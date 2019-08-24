package com.foryoutruck.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lilimin
 * @Date: 2019/8/24 10:21
 */
public class ServerResponse {

    private Status status;
    private List<Object> data;

    public enum GlobalStatus {

        SUCCESS(0, "操作成功"),
        FAILED(1, "操作失败"),
        ERROR(2, "服务器出现错误");

        public int code;
        public String desc;

        private GlobalStatus(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }
    }

    public class Status {
        private GlobalStatus status;
        private String desc;

        public Status(GlobalStatus status) {
            this.status = status;
            this.desc = status.desc;
        }

        public Status(GlobalStatus status, String desc) {
            this.status = status;
            this.desc = desc;
        }
    }

    public ServerResponse(GlobalStatus status, String msg) {
        this.status = new Status(status, msg);
    }

    public ServerResponse(GlobalStatus status) {
        this.status = new Status(status);
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
