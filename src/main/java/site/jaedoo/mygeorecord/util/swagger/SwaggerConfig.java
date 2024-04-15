package site.jaedoo.mygeorecord.util.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI api() {
        Info info = new Info()
                .title("My Geo Record API Documentation")
                .version("0.0.1")
//                .contact(new Contact()
//                        .name(""))
                .license(new License()
                        .name("Apache License Version 2.0")
                        .url("http://www.apache.org/license/LICENSE-2.0"));

        SecurityScheme auth = new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY).in(SecurityScheme.In.COOKIE).name("JSESSIONID");

        SecurityRequirement securityRequirement = new SecurityRequirement().addList("Authorization");

        return new OpenAPI()
                .components(new Components().addSecuritySchemes("Authorization", auth))
                .addSecurityItem(securityRequirement)
                .info(info);
    }
}
