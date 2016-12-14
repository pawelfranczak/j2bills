package pl.j2dev.j2bills.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.j2dev.j2bills.config.converters.StringToAccount;
import pl.j2dev.j2bills.config.converters.StringToCurrency;
import pl.j2dev.j2bills.config.converters.StringToPerson;

@Configuration
@EnableWebMvc
@ComponentScan("pl.j2dev.j2bills")
public class ServletConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(false);
		return resolver;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer config) {
		config.enable();
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToCurrency());
		registry.addConverter(new StringToPerson());
		registry.addConverter(new StringToAccount());
	}

}
