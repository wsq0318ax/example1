package com.wlxy.example1.common.swagger;
 
import java.util.ArrayList;
import java.util.List;

import com.wlxy.example1.common.HttpCode;
import com.wlxy.example1.config.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
 
/**
 * Created by wu on 2018/7/12.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Autowired
	SystemConfig systemConfig;
 
    @Bean
    public Docket docket(){
    	ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();  
    	ticketPar.name("Authorization").description("用户token")  //Authorization 请求头 判断用户是否合法
    	.modelRef(new ModelRef("string")).parameterType("header") 
    	.required(false).build(); //header中的ticket参数非必填，传空也可以
    	pars.add(ticketPar.build()); 
    	
    	List<ResponseMessage> responseMessageList = new ArrayList<>();
    	for (HttpCode httpCode : HttpCode.values()) {
    		responseMessageList.add(new ResponseMessageBuilder().code(httpCode.getCode()).message(httpCode.getMsg()).build());
		}

    	
        return new Docket(DocumentationType.SWAGGER_2)
        		.globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
        		.apiInfo(apiInfo()).select()
//                   当前包路径
                   .apis(RequestHandlerSelectors.basePackage("com.wlxy.example1")) //com.wlxy.example1 扫描文件的位置
//                   .apis(RequestHandlerSelectors.basePackage("com.example.demo.common"))  // 将loginController 移到common中
                    .paths(PathSelectors.any()).build().globalOperationParameters(pars);
        
 
    }
    
    
//构建api文档的详细信息函数
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //页面标题
                    .title(systemConfig.getSwaggerTitle())
                //创建人
                    .contact(new Contact(systemConfig.getSwaggerContactName(),
                    		systemConfig.getSwaggerContactWebUrl(),
                    		systemConfig.getSwaggerContactEmail()))
                 //版本号
                    .version(systemConfig.getSwaggerVersion())
                //描述
                    .description(systemConfig.getSwaggerDescription())
                    .termsOfServiceUrl(systemConfig.getSwaggerTermsOfServiceUrl())
                    .build();
    }
}
