package com.irving.springbootelasticsearch.common.http;

/**
 * @author tangxuezhi
 * @date 2019-04-09
 */
public interface ResponseCode {

    /**
     * get response code
     * @return code
     */
    Integer getCode();

    /**
     * get response message
     * @return message
     */
    String getMsg();
}
