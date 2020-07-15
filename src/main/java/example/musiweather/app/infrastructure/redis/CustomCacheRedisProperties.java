package example.musiweather.app.infrastructure.redis;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "spring.cache.redis")
@Getter
@Setter
@ToString
public class CustomCacheRedisProperties {

    private Map<String, Long> timeToLiveCacheMap = new HashMap<>();

}
