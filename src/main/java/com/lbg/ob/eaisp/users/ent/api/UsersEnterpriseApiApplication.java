package com.lbg.ob.eaisp.users.ent.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties
public class UsersEnterpriseApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersEnterpriseApiApplication.class, args);
    }


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .registerModule(new JavaTimeModule());
    }

    /*
        @Bean
        public ObjectMapper getObjectMapper() {
            return new ObjectMapper()
                    .enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION)
                    .registerModule(new JavaTimeModule());
        }
    */
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
