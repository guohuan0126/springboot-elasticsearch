package com.irving.springbootelasticsearch.service.impl;

import com.alibaba.fastjson.JSON;
import com.irving.springbootelasticsearch.entity.User;
import com.irving.springbootelasticsearch.service.BaseService;
import com.irving.springbootelasticsearch.service.interf.UserSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author irving
 */
@Service
@Slf4j
public class UserSearchServiceImpl extends BaseService implements UserSearchService{

    @Override
    public List<User> getUserAll() {
        List<User> userList = new ArrayList<>();
        Iterable<User> userIterable = userSearchRepository.findAll();
        userIterable.forEach(userList::add);
        return userList;
    }

    @Override
    public List<User> getUserLimit(int pageNum, int size) {
        Page<User> userPage = userSearchRepository.findAll(PageRequest.of(pageNum, size));
        return userPage.getContent();
    }

    @Override
    public List<User> getUserByName(String name, int pageNum, int size) {
        Page<User> userPage = userSearchRepository.findByName(name, PageRequest.of(pageNum, size));
        return userPage.getContent();
    }

    @Override
    public List<User> getUserByName(String name) {
        return userSearchRepository.findByName(name);
    }

    @Override
    public Boolean insertUser(User user) {
        try {
            userSearchRepository.save(user);
        } catch (Exception e) {
            log.warn("添加失败!param:{}", JSON.toJSONString(user), e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateUser(User user) {
        try {
            userSearchRepository.save(user);
        } catch (Exception e) {
            log.warn("修改失败!param:{}", JSON.toJSONString(user), e);
            return false;
        }
        return true;
    }

    @Override
    public Boolean dropUser(Integer id) {
        try {
            userSearchRepository.deleteById(id);
        } catch (Exception e) {
            log.warn("删除失败!param:{}", id, e);
            return false;
        }
        return true;
    }
}
