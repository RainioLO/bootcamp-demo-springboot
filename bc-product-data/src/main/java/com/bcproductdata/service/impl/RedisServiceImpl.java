package com.bcproductdata.service.impl;

import java.time.Duration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import com.bcproductdata.exception.BusinessRuntimeException;
import com.bcproductdata.infra.Syscode;
import com.bcproductdata.service.RedisService;



@Service
public class RedisServiceImpl implements RedisService {

  private final RedisTemplate<String, String> redisTemplate;

  // @Autowired
  public RedisServiceImpl(RedisTemplate<String, String> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  @Override
  public String setValue(String key, String value) {
    redisTemplate.opsForValue().set(key, value);
    redisTemplate.expire(key, Duration.ofHours(24));
    return redisTemplate.opsForValue().get(key);
  }

  @Override
  public String getValue(String key) {
    String value = redisTemplate.opsForValue().get(key);
    if (value == null) {
      throw new BusinessRuntimeException(Syscode.ERROR);
    }
    return value;
  }


}
