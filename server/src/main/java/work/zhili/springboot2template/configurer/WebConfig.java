package work.zhili.springboot2template.configurer;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import work.zhili.springboot2template.core.filter.SampleFilter;

import javax.servlet.DispatcherType;

/**
 * Title : work.zhili.springboot2template.configurer <br>
 * Description :
 *   add filters
 *
 * @author chile
 * @version 1.0
 * @date 2018-4-17 13:43:19
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        registration.setFilter(new SampleFilter());
        registration.addUrlPatterns("/lawyer/*", "/ajypfx/*", "/recognition/*", "/typesetting/*", "/loginStatusValidate");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("loginStatusCheckFilter");
        registration.setOrder(1);
        return registration;
    }

}
