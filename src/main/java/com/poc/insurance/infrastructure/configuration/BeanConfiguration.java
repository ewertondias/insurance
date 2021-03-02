package com.poc.insurance.infrastructure.configuration;

import com.poc.insurance.InsuranceApplication;
import com.poc.insurance.domain.sinistro.repository.SinistroRepository;
import com.poc.insurance.domain.sinistro.service.SinistroService;
import com.poc.insurance.domain.sinistro.service.SinistroServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = InsuranceApplication.class)
public class BeanConfiguration {

    @Bean
    SinistroService sinistroService(SinistroRepository sinistroRepository) {
        return new SinistroServiceImpl(sinistroRepository);
    }

}
