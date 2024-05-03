package br.com.joshua.basiccache.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
@EnableCaching
public class CaffeineConfig {

    @Bean
    public CaffeineCacheManager cacheManager() {
        Caffeine<Object, Object> caffeineBuilder = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.HOURS)
                .initialCapacity(100)
                .maximumSize(1000);

        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        caffeineCacheManager.setCaffeine(caffeineBuilder);
        return caffeineCacheManager;
    }
}
