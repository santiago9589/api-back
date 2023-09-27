package back.port.port;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Config implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Este comodín permite todas las rutas
                .allowedOrigins("*") // Este comodín permite todos los orígenes
                .allowedMethods("*") // Este comodín permite todos los métodos HTTP (GET, POST, PUT, DELETE, etc.)
                .allowedHeaders("*"); // Este comodín permite todos los encabezados
    }
}





