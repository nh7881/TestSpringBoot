package com.testspringboot.config.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//WebMvcTest 를 위한 JpaAuditinog 분리
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
