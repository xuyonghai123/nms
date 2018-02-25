package com.xuyh.nms;

import com.xuyh.nms.modules.sys.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NmsApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test() throws Exception{
		stringRedisTemplate.opsForValue().set("aaaa","11111");
		System.out.println("redis:"+stringRedisTemplate.opsForValue().get("aaaa"));
		Assert.assertEquals("11111",stringRedisTemplate.opsForValue().get("aaaa"));
	}

	@Test
	public void redisUser() throws Exception{
		User user = new User();
		user.setId(1);
		user.setId(1);
		user.setPassword("qwert");
		user.setName("ashdisad");
		redisTemplate.opsForValue().set(user.getName(),user);

		Assert.assertEquals("qwert", redisTemplate.opsForValue().get("ashdisad").getPassword());
		System.out.println("redis:"+redisTemplate.opsForValue().get("ashdisad").getPassword());
	}
}
