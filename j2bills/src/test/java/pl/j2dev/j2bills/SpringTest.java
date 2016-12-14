package pl.j2dev.j2bills;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import pl.j2dev.j2bills.config.RootConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class}, loader=AnnotationConfigContextLoader.class)
public class SpringTest {

	@Autowired
	ApplicationContext context;
	
	@Autowired
	JdbcOperations jdbc;
	
	@Test
	public void application_context_not_null() {
		Assert.assertNotNull(context);
	}
	
	@Test
	public void jdbc_not_null() {
		Assert.assertNotNull(jdbc);
	}
	
}
