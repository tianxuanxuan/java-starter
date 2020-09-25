package com.xgit.starter.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxuanxuan
 * On 2020-09-25 10:00
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig() {
        List<Parameter> pars = new ArrayList<Parameter>();
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")//分组名
                .apiInfo(webApiInfo())//在线文档的信息，传入ApiInfo对象，就是下面内个方法返回的对象
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))//路径中包含admin时不显示信息
                .paths(Predicates.not(PathSelectors.regex("/error/.*")))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("spring-all-study 接口 API 文档")
                .description("spring boot 全家桶测试项目")
                .termsOfServiceUrl("http://xcmg-xgxx.xyz")
                .version("1.0")
                .contact(new Contact("tianxuanxuan","http://xcmg-xgxx.xyz",
                        "xx_tian189@163.com"))
                .build();
    }
}
