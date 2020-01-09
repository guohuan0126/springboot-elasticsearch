package com.irving.springbootelasticsearch.dao;

import com.irving.springbootelasticsearch.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import java.util.List;
/**
 * @author irving
 */
@Component
public interface UserSearchRepository extends ElasticsearchRepository<User, Integer> {

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    List<User> findByName(String name);

    /**
     * 使用 Page<User> users = userSearchRepository.findByName("测试",  PageRequest.of(0, 10)); //分页是从0开始的
     *
     * @param name     the name
     * @param pageable the pageable
     * @return the page
     */
    Page<User> findByName(String name, Pageable pageable);

    /**
     * Find product by id user.
     *
     * @param name the name
     * @return the user
     */
    User findProductById(String name);
}
