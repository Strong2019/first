/*
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.intern.utils;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * spring util, it is easy to get bean in non-spring environment
 *
 * @author KSC
 */
@Component
public final class SpringUtils implements BeanFactoryPostProcessor {
    /**
     * spring context
     */
    private static ConfigurableListableBeanFactory beanFactory;

    /**
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        SpringUtils.beanFactory = beanFactory;
    }
//
//    /**
//     * get bean
//     * @param name name
//     * @return Object return an instance by name
//     * @throws BeansException
//     *
//     */
//    @SuppressWarnings("unchecked")
//    public static <T> T getBean(String name) throws BeansException
//    {
//        return (T) beanFactory.getBean(name);
//    }

    /**
     * get an obj which type is requiredType
     *
     * @param clz Class
     * @return an obj
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> clz) throws BeansException {
        T result = (T) beanFactory.getBean(clz);
        return result;
    }

//    /**
//     * if BeanFactory contains a corresponding bean definition, then return true
//     *
//     * @param name name
//     * @return boolean
//     */
//    public static boolean containsBean(String name)
//    {
//        return beanFactory.containsBean(name);
//    }
//
//    /**
//     * Determine whether the bean definition registered with a given name is a singleton or a prototype,
//     * if not found, then thow a NoSuchBeanDefinitionException
//     *
//     * @param name name
//     * @return boolean
//     * @throws NoSuchBeanDefinitionException
//     *
//     */
//    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException
//    {
//        return beanFactory.isSingleton(name);
//    }
//
//    /**
//     * @param name name
//     * @return Class The type of the registered object
//     * @throws NoSuchBeanDefinitionException
//     *
//     */
//    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException
//    {
//        return beanFactory.getType(name);
//    }
//
//    /**
//     * If the given bean name has aliases in the bean definition, these aliases are returned
//     *
//     * @param name name
//     * @return aliases
//     * @throws NoSuchBeanDefinitionException
//     *
//     */
//    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException
//    {
//        return beanFactory.getAliases(name);
//    }
//
//    /**
//     * get aop proxy obj
//     *
//     * @param invoker invoker
//     * @return proxy obj
//     */
//    @SuppressWarnings("unchecked")
//    public static <T> T getAopProxy(T invoker)
//    {
//        return (T) AopContext.currentProxy();
//    }
}
