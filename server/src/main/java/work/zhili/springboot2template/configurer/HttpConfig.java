package work.zhili.springboot2template.configurer;

import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Title : work.zhili.springboot2template.configurer <br>
 * Description :
 *   http message converter
 *
 * @author chile
 * @version 1.0
 * @date 2018/5/24 14:53
 */
// @Configuration
public class HttpConfig {
    @Bean
    public HttpMessageConverters customConverters() {
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        JsonbHttpMessageConverter jsonbHttpMessageConverter = new JsonbHttpMessageConverter();
        messageConverters.add(jsonbHttpMessageConverter);
        return new HttpMessageConverters(true, messageConverters);
    }
}
