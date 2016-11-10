package pl.j2dev.j2bills.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages="pl.j2dev.j2bills", 
	excludeFilters={
			@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
	})
public class RootConfig {

	@Bean
	public DataSource dataSource() {
		System.out.println("Zwracam data source");
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl("jdbc:mysql://localhost:3306/j2bills");
		dataSource.setUsername("j2dev");
		dataSource.setPassword("j2dev123");
		
		return dataSource;
	}
	
	// returns jdbcTemplate, do not need to do jdbc thing (a lot less code to write)
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		System.out.println("Zwracam jdbcTemplate");
		return new JdbcTemplate(dataSource);
	}
	
	// using orm
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
		
		sfb.setDataSource(dataSource);
		sfb.setPackagesToScan( new String[] { "pl.j2dev.j2bills" } );
		
		Properties properties = new Properties();
		properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
		properties.setProperty("show_sql", "true");
		sfb.setHibernateProperties(properties);
		
		return sfb;
		
	}
	
}
