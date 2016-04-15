package com.sibu.xinweishang.common.data;

import java.io.Serializable;

/**
* @ClassName: Response
* @Description: 接口调用响应体
* @author zhy
* @date 2016年3月11日 上午10:42:25
* 版本：V2.0
*/ 
public class Response implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int code;//响应码

    private String msg;//消息

    private Object data;//响应数据

    public Response() {
    }

    public Response(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
