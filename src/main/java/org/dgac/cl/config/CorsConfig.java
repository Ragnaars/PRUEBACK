// package org.dgac.cl.config;  

// import org.springframework.context.annotation.Configuration;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
// // Anotación de configuración de Spring Boot, indica que esta clase proporciona métodos de configuración como un bean
// public class CorsConfig implements WebMvcConfigurer { 
//     // Implementa la interfaz WebMvcConfigurer para configurar CORS en Spring Boot,
//     // esta interfaz proporciona métodos de devolución de llamada que se pueden anular para personalizar la configuración de CORS

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**")  // Permite todas las rutas
//                 .allowedOrigins("http://localhost:8100")  // Orígenes permitidos
//                 .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos HTTP permitidos
//                 .allowedHeaders("*")  // Permite todos los encabezados
//                 .allowCredentials(true)  // Permite el envío de cookies y credenciales
//                 .maxAge(3600);  // Tiempo máximo en caché de la respuesta (en segundos)
//     }
// }
