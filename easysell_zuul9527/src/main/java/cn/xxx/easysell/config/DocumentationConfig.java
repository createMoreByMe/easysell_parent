package cn.xxx.easysell.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    public List<SwaggerResource> get() {
        List resources = new ArrayList();
       //aigou网关前缀,employee网关路径   ；swagger的路径 ，以后增加了接口就在这配置就ok
        //网关地址http://localhost:9527/easysell/user/user/login 直接录入地址/easysell/user
        resources.add(swaggerResource("用户系统", "/easysell/user/v2/api-docs", "2.0"));
        resources.add(swaggerResource("商品系统", "/aigou/product/v2/api-docs", "2.0"));
        resources.add(swaggerResource("基础系统", "/aigou/common/v2/api-docs", "2.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
