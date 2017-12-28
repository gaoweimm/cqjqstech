package com.hgpm.cqkzcyw.util;

import java.util.Locale;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.LocaleResolver;

@Component
public final class SpringBean implements DisposableBean,
		ApplicationContextAware, ServletContextAware {

	private static ApplicationContext ac;

	private static ServletContext servletContext;

	public void setApplicationContext(ApplicationContext applicationContext) {
		ac = applicationContext;
	}

	public void destroy() {
		ac = null;
	}

	public static ApplicationContext getApplicationContext() {
		return ac;
	}

	public static ServletContext getServletContext() {
		return servletContext;
	}

	public static <T> T getBean(String name, Class<T> type) {
		Assert.hasText(name);
		Assert.notNull(type);
		return ac.getBean(name, type);
	}

	public static String getMessage(String code, Object... args) {
		LocaleResolver localeResolver = getBean(
				"localeResolver", LocaleResolver.class);
		Locale locale = localeResolver.resolveLocale(null);
		return ac.getMessage(code, args, locale);
	}

	/**
	 * ��ȡ����
	 * 
	 * @param name
	 * @return Object һ������������ע���bean��ʵ��
	 * @throws org.springframework.beans.BeansException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		Assert.hasText(name);
		return (T) ac.getBean(name);
	}

	/**
	 * ��ȡ����ΪrequiredType�Ķ���
	 * 
	 * @param clz
	 * @return
	 * @throws org.springframework.beans.BeansException
	 */
	public static <T> T getBean(Class<T> clz) throws BeansException {
		T result = (T) ac.getBean(clz);
		return result;
	}

	/**
	 * ���BeanFactory����һ������������ƥ���bean���壬�򷵻�true
	 * 
	 * @param name
	 * @return boolean
	 */
	public static boolean containsBean(String name) {
		return ac.containsBean(name);
	}

	/**
	 * �ж��Ը�������ע���bean������һ��singleton����һ��prototype��
	 * ��������������Ӧ��bean����û�б��ҵ��������׳�һ���쳣��NoSuchBeanDefinitionException��
	 * 
	 * @param name
	 * @return boolean
	 * @throws org.springframework.beans.factory.NoSuchBeanDefinitionException
	 */
	public static boolean isSingleton(String name)
			throws NoSuchBeanDefinitionException {
		return ac.isSingleton(name);
	}

	/**
	 * @param name
	 * @return Class ע����������
	 * @throws org.springframework.beans.factory.NoSuchBeanDefinitionException
	 */
	public static Class<?> getType(String name)
			throws NoSuchBeanDefinitionException {
		return ac.getType(name);
	}

	/**
	 * ���������bean������bean�������б������򷵻���Щ����
	 * 
	 * @param name
	 * @return
	 * @throws org.springframework.beans.factory.NoSuchBeanDefinitionException
	 */
	public static String[] getAliases(String name)
			throws NoSuchBeanDefinitionException {
		return ac.getAliases(name);
	}

	
	public void setServletContext(ServletContext arg0) {
		servletContext = arg0;
	}
}
