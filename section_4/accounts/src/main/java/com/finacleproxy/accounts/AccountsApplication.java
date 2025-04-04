package com.finacleproxy.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
/*@ComponentScans({@ComponentScan("com.finacleproxy.accounts.controller")})
@EnableJpaRepositories("com.finacleproxy.accounts.respository")
@EntityScan("com.finacleproxy.accounts.entity")*/
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts Microservices REST API Documentation",
                description = """
                        EazyBytes Accounts Microservice REST API Documentation
                        
                        Contact:
                        - [LinkedIn](https://www.linkedin.com/in/omkar-oak-87a3a71a4)
                        - [GitHub](https://github.com/omuu8)""",
                version = "v1",
                contact = @Contact(
                        name = "Omkar Oak",
                        email = "omkaroak0697@gmail.com",
                        url = "https://www.linkedin.com/in/omkar-oak-87a3a71a4"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://github.com/omuu8"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "EazyBytes Accounts microservice REST API Documentation",
                url = "https://wwww.eazybytes.com/swagger-ui.html"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
