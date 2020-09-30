package com.hjf.config;

import com.hjf.controller.HelloController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author Jiang锋时刻
 * @create 2020-09-30 14:49
 */
@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {

    @Bean
    public Docket docketA(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("分组A");
    }
    @Bean
    public Docket docketB(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("分组B");
    }
    @Bean
    public Docket docketC(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("分组C");
    }



    // 配置Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment env){
        // 获取项目的环境
        // 设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");

        boolean flag = env.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("Jiang锋时刻")
            .apiInfo(apiInfo())
            .enable(flag)  //是否开启swagger
            .select()
            /**
             * RequestHandlerSelectors: 配置要扫描接口的方式
             *  basePackage: 扫描指定包下的方法
             *  any: 扫描全部
             *  none: 都不扫描
             *  withClassAnnotation: 扫描类上的注解, 参数是一个注解的反射对象
             *  withMethodAnnotation: 扫描方法上的注解
             *
             */
            .apis(RequestHandlerSelectors.basePackage("com.hjf.controller"))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
            // 只扫描hello下的
            .paths(PathSelectors.ant("/hello/**"))
            .build()
            ;
    }

    // 配置Swagger信息: apiInfo
    private ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("jiang锋时刻", "http://www.jiangfengtime.top", "jiangfengtime@gmail.com");
        return new ApiInfo(
                "Api 文档",
                "描述信息",
                "1.5",
                "http://www.jiangfengtime.top",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
