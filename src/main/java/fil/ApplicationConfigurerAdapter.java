package fil;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ApplicationConfigurerAdapter extends WebMvcConfigurerAdapter {

    /*
     * Configuration de base
     */
    @Override
    public void configureDefaultServletHandling( final DefaultServletHandlerConfigurer configurer ) {
        configurer.enable();
    }

    /*
     * Bean permettant d'acceder aux differentes JSP dans le dossier "WEB-INF/jsp"
     * Le suffix permet d'eviter d'ecrire ".jsp" a chaque fois dans les controlleurs.
     * Un simple "index" correspond donc à "/WEB-INF/jsp/index.jsp"
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        final InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix( "WEB-INF/jsp/" );
        resolver.setSuffix( ".jsp" );
        return resolver;
    }

    @Override
    public void addResourceHandlers( final ResourceHandlerRegistry registry ) {
        registry.addResourceHandler( "/**" ).addResourceLocations( "classpath:/public/" );
    }

}
