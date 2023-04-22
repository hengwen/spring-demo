package cn.jtoss.springbootapiversion.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author jason
 */
@Configuration
public class CustomWebMvcConfiguration extends WebMvcConfigurationSupport {
    @Override
    public RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
        return new ApiVersionHandlerMapping();
    }
}
