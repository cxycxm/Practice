package com.bwhome.common.core.web.domain;

import com.bwhome.common.core.enums.HttpStatusEnum;

import java.util.HashMap;

public class AjaxResult extends HashMap<String, Object> {

    public static final String MSG_TAG = "msg";
    public static final String CODE_TAG = "code";
    public static final String RESULT_TAG = "result";

    public static void main(String[] args) {
        int i = 1;
        System.out.println(i --);
    }

    public AjaxResult() {
    }

    public  AjaxResult(int code, String msg, Object object){
        super.put(MSG_TAG, msg);
        super.put(CODE_TAG, code);
        super.put(RESULT_TAG, object);
    }

    public static AjaxResult success(Object o){
        return new AjaxResult(HttpStatusEnum.SUCCESS.getCode(), "操作成功", o);
    }

    public static AjaxResult success(){
        return new AjaxResult(HttpStatusEnum.SUCCESS.getCode(), "操作成功", null);
    }

    public static AjaxResult error(Object o){
        return new AjaxResult(HttpStatusEnum.ERROR.getCode(), "操作失败", o);
    }

    public static AjaxResult error(){
        return new AjaxResult(HttpStatusEnum.ERROR.getCode(), "操作失败", null);
    }




}
