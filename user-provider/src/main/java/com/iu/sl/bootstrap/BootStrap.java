package com.iu.sl.bootstrap;

import com.iu.sl.config.DubboProviderConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: ShenLong
 * @CreateDate: 2018/4/19 15:40
 */
public class BootStrap {
    public static void main(String[] args) {
        /*Main.main(args);*/


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DubboProviderConfig.class);
        context.refresh();
    }
}
