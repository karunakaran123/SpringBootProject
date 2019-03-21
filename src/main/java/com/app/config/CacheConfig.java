package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;



@Configuration
public class CacheConfig {

	@Bean
	public Config cacheConfig1()
	{
		return new Config().setInstanceName("MyHazelCast Instance")
				.addMapConfig(new MapConfig().setName("EmpCache")
						.setMaxSizeConfig(new MaxSizeConfig(100, MaxSizePolicy.FREE_HEAP_SIZE))
						.setEvictionPolicy(EvictionPolicy.LRU)
						.setTimeToLiveSeconds(2000));
	}
}
