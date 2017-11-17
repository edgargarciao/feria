package co.ufps.edu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	   @Override
	   protected Class<?>[] getRootConfigClasses() {
	      return new Class[] {RootConfig.class};
	   }

	   @Override
	   protected Class<?>[] getServletConfigClasses() {
		   // 1. Enciende la configuracion
	      return new Class[] { WebConfig.class };
	   }

	   @Override
	   protected String[] getServletMappings() {
	      return new String[] { "/" };
	   }
}
