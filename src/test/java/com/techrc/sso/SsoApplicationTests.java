package com.techrc.sso;

import com.techrc.sso.model.RedisModel;
import com.techrc.sso.service.redis.RedisServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsoApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Test
	public void contextLoads() {

		stringRedisTemplate.opsForValue().set("abc", "hahahaha11");
		String value=stringRedisTemplate.opsForValue().get("abc");
		System.out.println(value);



	}

}
