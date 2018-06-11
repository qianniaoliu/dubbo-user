package com.iu.sl.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.iu.sl.api.BlogService;
import com.iu.sl.model.Blog;
import com.iu.sl.pojo.SLResponse;
import com.iu.sl.pojo.blog.RedisSLResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/5/31 23:12
 */
@Service
public class BlogServiceImpl implements BlogService {


    private final StringRedisTemplate redisTemplate;

    @Autowired
    public BlogServiceImpl(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public SLResponse findAll() {
        RedisSLResponse<List<Blog>> response = new RedisSLResponse<>();
        HashOperations<String,String,String> hashOperations = redisTemplate.opsForHash();
        ValueOperations<String,String> valueOperations =  redisTemplate.opsForValue();
        String hello = valueOperations.get("nihao");
        Set<String> keys = redisTemplate.keys("blog:*");
        List<Blog> blogs = new ArrayList<>();
        for(String key : keys){
            Blog blog = new Blog();
            blog.setTitle(hashOperations.get(key,"title"));
            blog.setContent(hashOperations.get(key,"content"));
            blogs.add(blog);
        }
        response.setResult(blogs);
        response.setCode("200");
        response.setMsg("请求成功");
        return response;
    }
}
