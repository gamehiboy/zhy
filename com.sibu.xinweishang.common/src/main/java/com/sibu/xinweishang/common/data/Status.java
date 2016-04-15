package com.sibu.xinweishang.common.data;

/**
* @ClassName: Status
* @Description: 接口调用响应码
* @author zhy
* @date 2016年3月11日 上午10:41:04
* 版本：V2.0
*/ 
public interface Status {

    final int SUCCESS = 0;//成功

    final int NotLogin = 1; //错误，未登录

    final int OtherError = 2;//错误，其他错误
}
