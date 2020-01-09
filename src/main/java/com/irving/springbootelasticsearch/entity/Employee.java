package com.irving.springbootelasticsearch.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author irving
 * @date 2020/01/09
 */
@Data
@Document(indexName = "springboot-elasticsearch1",type = "employee")
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age = 0;
    private String about;
}
