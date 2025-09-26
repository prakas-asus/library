// package com.example.library.config;

// import io.swagger.v3.oas.models.info.Contact;
// import io.swagger.v3.oas.models.info.Info;
// import io.swagger.v3.oas.models.security.SecurityRequirement;
// import io.swagger.v3.oas.models.OpenAPI;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class SwaggerConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {
//         return new OpenAPI()
//             .info(new Info()
//                 .title("My REST API")
//                 .description("Some custom description of API.")
//                 .version("v1.0.0")
//                 .contact(new Contact()
//                     .name("Prakosa Dwi Prasetya")
//                     .url("https://gitlab.com/prakosadwiprasetya/rest-api/-/tree/development?ref_type=heads")
//                     .email("prakosadwiprasetya@gmail.com")
//                 )
//             )
//             .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
//             .components(new io.swagger.v3.oas.models.Components()
//                 .addSecuritySchemes("basicAuth",
//                     new io.swagger.v3.oas.models.security.SecurityScheme()
//                         .type(io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP)
//                         .scheme("basic")
//                 )
//             );
//     }

// }