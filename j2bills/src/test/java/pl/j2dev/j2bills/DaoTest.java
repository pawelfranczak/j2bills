package pl.j2dev.j2bills;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.util.Assert;

import pl.j2dev.j2bills.config.RootConfig;
import pl.j2dev.j2bills.dao.impl.AccountDaoImpl;
import pl.j2dev.j2bills.dao.impl.CurrencyDaoImpl;
import pl.j2dev.j2bills.dao.impl.JournalDaoImpl;
import pl.j2dev.j2bills.dao.impl.PersonDaoImpl;
import pl.j2dev.j2bills.dao.impl.UsersDaoImpl;
import pl.j2dev.j2bills.pojo.Account;
import pl.j2dev.j2bills.pojo.Currency;
import pl.j2dev.j2bills.pojo.Journal;
import pl.j2dev.j2bills.pojo.Person;
import pl.j2dev.j2bills.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class}, loader=AnnotationConfigContextLoader.class)
public class DaoTest {

	@Autowired
	ApplicationContext context;
	
	@Autowired
	UsersDaoImpl userDao;
	
	@Autowired
	JournalDaoImpl journalDao;
	
	@Autowired
	AccountDaoImpl accountDao;
	
	@Autowired
	PersonDaoImpl personDao;
	
	@Autowired
	CurrencyDaoImpl currencyDao;
	
	@Test
	public void database_returns_user() {
		Users data = userDao.getOjectById("gzem");
		Assert.notNull(data);
	}
	
	@Test
	public void database_returns_account() {
		Account data = accountDao.getOjectById(2);
		Assert.notNull(data);
	}
	
	@Test
	public void database_returns_journal() {
		Journal data = journalDao.getOjectById(1);
		Assert.notNull(data);
	}
	
	@Test
	public void database_returns_person() {
		Person data = personDao.getOjectById(1);
		Assert.notNull(data);
	}
	
	@Test
	public void database_returns_currency() {
		Currency data = currencyDao.getOjectById(3);
		Assert.notNull(data);
	}
	
	@Test
	public void database_can_add_journal() {
		
		Users user = userDao.getOjectById("gzem");
		Account account = accountDao.getOjectById(2);
		Person person = personDao.getOjectById(1);
		Currency currency = currencyDao.getOjectById(3);
		
		// mocking method returns username because it works only in spring context
		JournalDaoImpl journalDaoSpy = spy(journalDao);
		when(journalDaoSpy.username()).thenReturn("gzem");
		
		Journal j = new Journal();
		j.setAccount(account);
		j.setCurrency(currency);
		j.setPerson(person);
		j.setUsers(user);
		j.setDescription("JUnit");
		j.setValue(new BigDecimal("18"));
		int save = journalDaoSpy.save(j);
		
		Assert.state(save > 0);
		
	}

}
