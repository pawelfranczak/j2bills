package pl.j2dev.j2bills.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages="pl.j2dev.j2bills", 
	excludeFilters={
			@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
	})
public class RootConfig {

	@Bean
	public DataSource dataSource() {
		System.out.println("Creating bean dataSource");
		
		Properties prop = new Properties();
		InputStream input = null;

		String sqlUrl = "";
		String sqlUser = "";
		String sqlPassword = "";
		
		try {

			input = new FileInputStream("j2bills.properties");
			prop.load(input);
			sqlUrl = prop.getProperty("mysql.url");
			sqlUser = prop.getProperty("mysql.username");
			sqlPassword = prop.getProperty("mysql.password");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
		dataSource.setUrl(sqlUrl);
		dataSource.setUsername(sqlUser);
		dataSource.setPassword(sqlPassword);
		return dataSource;
	}
	
	// returns jdbcTemplate, do not need to do jdbc thing (a lot less code to write)
	@Bean
	public JdbcOperations jdbcTemplate(DataSource dataSource) {
		System.out.println("Creating bean jdbcOperations");
		return new JdbcTemplate(dataSource);
	}
	
}
