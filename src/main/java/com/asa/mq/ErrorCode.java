package com.asa.mq;

import java.io.Serializable;

/**
 * Created by liangtieqi on 2018/11/29.
 */
public interface ErrorCode extends Serializable {

    /**
     * 错误码
     *
     * @return
     */
    String getCode();

    /**
     * 错误信息
     *
     * @return
     */
    String getMsg();
}
