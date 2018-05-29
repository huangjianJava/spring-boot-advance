package com.huangj.advance;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author huangj
 * @Description:  一些简单的测试
 * @date 2018/5/29
 */
public class SimpleTest {

    private static final Logger logger = LoggerFactory.getLogger(SimpleTest.class);

    @Test
    public void testLog(){
        logger.error("error log 测试");
    }

}

























