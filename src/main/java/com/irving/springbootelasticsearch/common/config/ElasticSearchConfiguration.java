package com.irving.springbootelasticsearch.common.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 邵少
 * @date 2019年5月26日
 */
@Configuration
public class ElasticSearchConfiguration {

	@Resource
	ElasticSearchConfig config;

	@Bean
	public TransportClient esClient() throws UnknownHostException{
		Settings settings = Settings.builder()
				.put("cluster.name", config.getClusterName())
				.build();

		TransportAddress master = new TransportAddress(
				InetAddress.getByName(config.getClusterNodes()), config.getPort()
				);

		TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(master);
		return client;
	}
}
