package co.ufps.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "co.ufps.edu.controller" })								 
public class WebConfig extends WebMvcConfigurerAdapter {

	   @Bean	   
	   public InternalResourceViewResolver resolver() {
		   // 2. Registra los jsp
		   System.out.println("Cargar clasee");
	      InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	      resolver.setViewClass(JstlView.class);
	      resolver.setPrefix("/WEB-INF/views/");
	      resolver.setSuffix(".jsp");
	      return resolver;
	   }
	   
	   @Override	  
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
		   // 3. Registrar los Recursos (Css,JS,font,entre otros)
		   registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	   }
}
