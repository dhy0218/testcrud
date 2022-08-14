package com.example.demo.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 配置了swagger的Docket的bean实例,用Docket对象接管了他原来的默认配置ApiInfo
     * @return
     */

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    /**
     * 配置swagger信息apiInfo() 里面要传入一个 apiInfo
     */

    private ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact("dhy", "https://www.baidu.com/", "814329760@qq.com");

        return new ApiInfo(
                "swagger 学习日记",
                "清幽现云山，虚静出内功",
                "1.0",
                "https://www.baidu.com/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }


}

