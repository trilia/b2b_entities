/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trillia.common;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 *
 * @author raghosh
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/application-test-context.xml")
@Transactional
@SpringApplicationConfiguration
@Configurable
public abstract class BaseSpringAwareTest extends BaseTest {
    
    @Autowired
    private ApplicationContext __ctx;

    /**
     * @return the __ctx
     */
    protected ApplicationContext getCtx() {
        return __ctx;
    }

}
