package com.iu.sl;

import static org.junit.Assert.assertTrue;

import com.iu.sl.api.BlogService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    @Ignore
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void dubbo(){
        System.out.println(Math.abs("mailGroup".hashCode())%50);
        System.out.println(Math.abs("DemoGroup1".hashCode())%50);
    }
}
