package com.irving.springbootelasticsearch.service;

import com.irving.springbootelasticsearch.dao.UserSearchRepository;

import javax.annotation.Resource;

/**
 * @program: springboot-elasticsearch
 * @description:
 * @author: Irving
 * @create: 2020-01-09
 **/
public class BaseService {

    /**
     * The User search repository.
     */
    @Resource
    protected UserSearchRepository userSearchRepository;

}
