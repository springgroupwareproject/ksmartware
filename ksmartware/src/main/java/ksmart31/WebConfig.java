package ksmart31;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/dist/**",
                "/img/**",
                "/js/**",
                "/plugins/**",
                "/src/**"
                )
                .addResourceLocations(
                        "classpath:/static/dist/",
                        "classpath:/static/img/",
                        "classpath:/static/js/",
                        "classpath:/static/plugins/",
                        "classpath:/static/src/");
    }

}