package config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import resolver.SimpleCacheResolver;

@Configuration
public class CacheConfig {

    @Bean
    CacheManagerCustomizer<ConcurrentMapCacheManager> customizer() {
        return new ConcurrentCustomizer();
    }

    @Bean
    public CacheResolver cacheResolver() {
        return new SimpleCacheResolver();
    }

    //a class to customize a cache manager
    class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager> {

        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {
            cacheManager.setStoreByValue(true);
            cacheManager.setAllowNullValues(false);
            System.out.println("customizer invoked!!");
        }
    }
}
