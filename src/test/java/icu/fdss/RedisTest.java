package icu.fdss;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testSet(){
       // 在Redis中存储一个键值对    StringRedisTemplate
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("username", "zhangsan");
        stringStringValueOperations.set("id", "1",15, TimeUnit.SECONDS);
    }

    @Test
    public void testGet(){
        // 从Redis中获取一个键值对
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        String username = stringStringValueOperations.get("username");
        System.out.println(username);
    }

}
