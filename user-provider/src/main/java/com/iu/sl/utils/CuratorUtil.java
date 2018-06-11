package com.iu.sl.utils;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/6/10 11:28
 */
@Component
public class CuratorUtil {

    @Value("${athena.zookeeper}")
    public String CONNECT_STR;

    public CuratorFramework getInstance(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000,10);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(CONNECT_STR)
                .sessionTimeoutMs(5000).retryPolicy(retryPolicy).build();
        client.start();
        return client;
    }
}
