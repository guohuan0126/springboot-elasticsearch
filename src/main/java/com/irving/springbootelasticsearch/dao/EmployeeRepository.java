package com.irving.springbootelasticsearch.dao;

import com.irving.springbootelasticsearch.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: springboot-elasticsearch
 * @description:
 * @author: Irving
 * @create: 2020-01-09
 **/
@Component
public interface EmployeeRepository extends ElasticsearchCrudRepository<Employee, String> {

    /**
     * 查询雇员信息
     * @param id
     * @return
     */
    Employee queryEmployeeById(String id);

    /**
     *
     * @param firstName
     * @return
     */
    List<Employee> queryEmployeeByFirstName(String firstName);

    /**
     *
     * @param name
     * @param pageable
     * @return
     */
    Page<Employee> queryEmployeeByFirstName(String name, Pageable pageable);


}
