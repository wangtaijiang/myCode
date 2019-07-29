package com.example.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication:表明此类为springBoot的启动类
 *		@Target({ElementType.TYPE})
 * 		@Retention(RetentionPolicy.RUNTIME)
 * 		@Documented
 * 		@Inherited
 * 		@SpringBootConfiguration  ：表明这是一个springBoot的配置类，属于springBoot定义的注解，@Configuration是spring的注解
 * 		@EnableAutoConfiguration  ：开启自动配置功能，将主配置类（@SpringBootApplication标注的类）的所在包以及下面的所有子包包含的所有组件扫描到spring容器
 * 		@ComponentScan(
 *   		  excludeFilters = {@Filter(
 *    		 type = FilterType.CUSTOM,
 *   		  classes = {TypeExcludeFilter.class}
 * 		), @Filter(
 *  		   type = FilterType.CUSTOM,
 *  		   classes = {AutoConfigurationExcludeFilter.class}
 * 		)}
 * 		)
 * 		public @interface SpringBootApplication {
 */
@SpringBootApplication
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

}
