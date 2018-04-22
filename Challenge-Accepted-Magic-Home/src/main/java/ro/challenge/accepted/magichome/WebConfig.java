package ro.challenge.accepted.magichome;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**", "/resources/**",
                "/image/**",
                "/css/**",
                "/js/**"
                ,"/html/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/java/resources/",
                        "classpath:/static/image/",
                        "classpath:/static/css/",
                        "classpath:/static/html/",
                        "classpath:/static/js/");

    }
}
