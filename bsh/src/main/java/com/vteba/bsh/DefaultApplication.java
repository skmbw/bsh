package com.vteba.bsh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 程序启动引导类
 * 
 * @author iyinlei@126.com
 * @since 2016年5月10日 下午1:04:47
 */
@EnableAutoConfiguration
@SpringBootApplication // 这是一个组合注解，上面有很多其他的注解，简单来讲就是启动spring boot程序
public class DefaultApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

	public static void main(String[] args) {
		SpringApplication.run(DefaultApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DefaultApplication.class);
	}

	// 可以在这里设置，程序的启动端口
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(8081);
	}
}
