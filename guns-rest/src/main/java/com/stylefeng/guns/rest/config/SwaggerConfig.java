package com.stylefeng.guns.rest.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.config.properties.RestProperties;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 *
 * @author fanyj
 * @date 2018年1月30日22:08:43
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = RestProperties.REST_PREFIX, name = "swagger-open", havingValue = "true")
public class SwaggerConfig{

    @Autowired
    private JwtProperties jwtProperties;

    @Bean
    public Docket createRestApi() {

    	//添加全局head参数,将jwt的token放在head里
    	ParameterBuilder tokenPar = new ParameterBuilder();
    	List<Parameter> pars = new ArrayList<Parameter>();
    	tokenPar.name(jwtProperties.getHeader()).description("jwt token令牌").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
    	pars.add(tokenPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
        		.globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))                         //这里采用包含注解的方式来确定要显示的接口
                //.apis(RequestHandlerSelectors.basePackage("com.stylefeng.guns.modular.system.controller"))    //这里采用包扫描的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {

    	Contact fanyj=new Contact("fanyj",null,"yanjunfan12@fudan.edu.cn");

        return new ApiInfoBuilder()
                .title("Guns REST Doc")
                .description("Guns REST Api文档")
                .termsOfServiceUrl("")
                .contact(fanyj)
                .version("0.1")
                .build();
    }

}
