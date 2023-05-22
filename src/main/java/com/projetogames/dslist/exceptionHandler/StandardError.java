package com.projetogames.dslist.exceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StandardError {

    private Integer status;
    private OffsetDateTime instant;
    private String title;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OffsetDateTime getInstant() {
        return instant;
    }

    public void setInstant(OffsetDateTime instant) {
        this.instant = instant;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFields(List<Fields> fields) {
        this.fields = fields;
    }

    public List<Fields> getFields() {
        return fields;
    }

    List<Fields> fields;
    public static class Fields {

        public Fields(String name, String msg) {
            this.name = name;
            this.msg = msg;
        }

        private String name;
        private String msg;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}