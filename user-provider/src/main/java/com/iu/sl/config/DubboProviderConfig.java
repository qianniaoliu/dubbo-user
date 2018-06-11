package com.iu.sl.config;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/5/23 14:52
 */
@Configuration
@EnableDubboConfig
@PropertySource("dubbo.properties")
@DubboComponentScan("com.iu.sl.provider")
public class DubboProviderConfig {

   /* @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-user-provider");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("192.168.2.129:2181");
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20881);
        protocolConfig.setHost("192.168.2.100");
        return protocolConfig;
    }*/
}
