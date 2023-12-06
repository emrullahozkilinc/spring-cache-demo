package com.emr.springcachedemo;

import com.emr.springcachedemo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SpringCacheDemoApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(SpringCacheDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        RedisStandaloneConfiguration redisSC = new RedisStandaloneConfiguration();
        redisSC.setPassword("cache-demo");
        redisSC.setPort(8640);

        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(redisSC);
        connectionFactory.afterPropertiesSet();

        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultSerializer(StringRedisSerializer.UTF_8);
        template.afterPropertiesSet();

        template.opsForValue().set("foo", "bar");

        log.info("Value at foo:" + template.opsForValue().get("foo"));

        connectionFactory.destroy();

    }
}
