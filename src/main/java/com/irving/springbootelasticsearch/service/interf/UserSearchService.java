package com.irving.springbootelasticsearch.service.interf;

import com.irving.springbootelasticsearch.entity.User;

import java.util.List;

/**
 * @program: springboot-elasticsearch
 * @description:
 * @author: Irving
 * @create: 2020-01-09
 **/
public interface UserSearchService {

    List<User> getUserAll();

    List<User> getUserLimit(int pageNum, int size);

    List<User> getUserByName(String name, int pageNum, int size);

    List<User> getUserByName(String name);

    Boolean insertUser(User user);

    Boolean updateUser(User user);

    Boolean dropUser(Integer id);
}
