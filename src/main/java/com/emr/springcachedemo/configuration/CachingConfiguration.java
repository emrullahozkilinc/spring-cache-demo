//package com.emr.springcachedemo.configuration;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//
//import java.lang.reflect.Method;
//
//@Configuration
//@EnableCaching //ConcurrentMapCacheManager'ı aktive eder ve ayrıca bunun için bir bean açmamıza gerek kalmaz.
//public class CachingConfiguration extends CachingConfigurerSupport {
//
//    private static final String KEY_SEPERATOR = "#";
//
//    @Bean
//    @Override
//    public KeyGenerator keyGenerator() {
//        return (target, method, params) -> {
//
//            StringBuilder sb = new StringBuilder();
//            sb.append(target.getClass().getSimpleName());
//            sb.append(KEY_SEPERATOR);
//            sb.append(method.getName());
//            sb.append(KEY_SEPERATOR);
//            for(Object param : params){
//                sb.append(param.toString());
//                sb.append(KEY_SEPERATOR);
//            }
//
//            String str = sb.toString();
//
//            return str.substring(0, str.length() - 1);
//        };
//    }
//
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager manager = new RedisCacheManager(redisTemplate);
//        manager.setExpires(7200);
//        return manager;
//    }
//
//    @Bean
//    public StringRedisTemplate redisTemplate(RedisConnectionFactory factory) {
//        final StringRedisTemplate template = new StringRedisTemplate(factory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//
//        return template;
//    }
//
//}
