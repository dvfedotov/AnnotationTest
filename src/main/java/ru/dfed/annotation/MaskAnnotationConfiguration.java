package ru.dfed.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaskAnnotationConfiguration {

    @Bean
    public MaskAnnotationBeanPostProcessor maskAnnotationBeanPostProcessor() {
        return new MaskAnnotationBeanPostProcessor();
    }
}
