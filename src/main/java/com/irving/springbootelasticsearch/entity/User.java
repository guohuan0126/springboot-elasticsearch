package com.irving.springbootelasticsearch.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author irving
 */
@Data
@Document(indexName = "springboot-elasticsearch2", type = "user")
public class User {

    private Integer id;
    private String name;
    private String date;

}
