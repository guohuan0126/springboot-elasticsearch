package com.irving.springbootelasticsearch.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @program: pakbos
 * @description: email config
 * @author: Irving
 * @create: 2019-10-29
 **/
@Data
@Configuration
@ConfigurationProperties(value = "spring.data.elasticsearch")
public class ElasticSearchConfig {

    private String clusterName;

    private String clusterNodes;

    private int port;
}
