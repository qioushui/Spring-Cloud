package com.didispace;

import com.didispace.filter.AccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy   //支持 Zuul  组件 的注解（对外 统一的入口，服务的前门  路由功能 ，过滤） http://localhost:5555/api-a/hello?accessToken=token
@SpringCloudApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

	@Bean //过滤 功能
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}

}
