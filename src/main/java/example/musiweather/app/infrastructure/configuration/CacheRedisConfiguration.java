package example.musiweather.app.infrastructure.configuration;

import example.musiweather.app.infrastructure.redis.CustomCacheRedisProperties;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Cache redis configuration.
 */
@Configuration
@EnableConfigurationProperties(CustomCacheRedisProperties.class)
public class CacheRedisConfiguration {

    /**
     * Redis cache manager builder customizer redis cache manager builder customizer.
     *
     * @param customCacheRedisProperties the custom cache redis properties
     * @return the redis cache manager builder customizer
     */
    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer(CustomCacheRedisProperties customCacheRedisProperties) {
        return (builder) -> {
            Map<String, RedisCacheConfiguration> configurationMap = new HashMap<>();
            Map<String, Long> cacheMapProps = customCacheRedisProperties.getTimeToLiveCacheMap();
            cacheMapProps.keySet().stream().forEach(key ->
                    configurationMap.put(key, RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(cacheMapProps.get(key)))));
            builder.withInitialCacheConfigurations(configurationMap);
        };
    }
}
