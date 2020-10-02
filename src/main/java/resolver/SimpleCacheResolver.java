package resolver;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.AbstractCacheResolver;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SimpleCacheResolver extends AbstractCacheResolver {

    public SimpleCacheResolver() {
        super();
    }

    public SimpleCacheResolver(CacheManager cacheManager) {
        super(cacheManager);
    }

    @Override
    public void setCacheManager(CacheManager cacheManager) {
        super.setCacheManager(cacheManager);
    }

    @Override
    public CacheManager getCacheManager() {
        return super.getCacheManager();
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
    }

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        Collection<String> cacheNames = getCacheNames(context);

        if (cacheNames == null) {
            return Collections.EMPTY_LIST;
        }
        Collection<Cache> result = new ArrayList<>(cacheNames.size());
        for (String cacheName : cacheNames) {
            Cache cache = getCacheManager().getCache(cacheName);
            if (cache == null) {
                throw new IllegalArgumentException("cannot find cache named " + cacheName);
            }
            result.add(cache);
        }
        return result;
    }

    @Override
    protected Collection<String> getCacheNames(CacheOperationInvocationContext<?> cacheOperationInvocationContext) {
        return this.getCacheManager().getCacheNames();
    }
}
