package com.escoger.tv.repo.impl;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.QueryLogger;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.escoger.tv.beans.AllTvBean;
import com.escoger.tv.repo.config.AllTvRepo;
import com.escoger.tv.services.TVService;
import com.escoger.tv.services.TVServiceImpl;

@Repository
public class CassandraUtil implements AllTvRepo {
	private static final Logger logger = LoggerFactory.getLogger(CassandraUtil.class);

	@Autowired
	Cluster cluster;

	private final CassandraOperations cassandraTemplate;

	public CassandraUtil(CassandraOperations cassandraTemplate) {
		this.cassandraTemplate = cassandraTemplate;
	}

	@Bean
	public TVService TVService(AllTvRepo tvRepository) {
		return new TVServiceImpl(tvRepository);
	}

	@Bean
	public QueryLogger queryLogger(Cluster cluster) {
		QueryLogger queryLogger = QueryLogger.builder().build();
		cluster.register(queryLogger);
		return queryLogger;
	}

	@Override
	public List<AllTvBean> getAllTv() {
		List<AllTvBean> allMobileList = this.cassandraTemplate.select(QueryBuilder.select().from("tv"), AllTvBean.class);
		return allMobileList;
	}

	@Override
	public Collection<? extends Object> getAllTvBasedOnBrand(String brand, Class clazz) {
		
		List<Object> tvList = this.cassandraTemplate.select(QueryBuilder.select().from(brand+"tv"), clazz);
		return tvList;
	}

}
