package spring.thin.transaction;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.ibm.db2.jcc.DB2SimpleDataSource;


@Configuration
@ImportResource("classpath:hello.xml")
public class Hello {
	
	@Autowired
	private SomeBean someBean;
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	}
	
	@Bean 
	public DataSource dataSource() 
	{	
		
		DB2SimpleDataSource dataSource = new DB2SimpleDataSource();
		dataSource.setDriverType(4);
		dataSource.setServerName("localhost");
		dataSource.setPortNumber(50000);
		dataSource.setDatabaseName("PDPROF");
		dataSource.setUser("db2inst1");
		dataSource.setPassword("passw0rd");
		return dataSource;
	}
	
	@Bean 
	public PlatformTransactionManager transactionManager()
	{
		return new DataSourceTransactionManager(dataSource());
	}
	
	public void run(String[] args)
	{
		System.out.println(someBean.sayHello());
	}
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(Hello.class);
		ctx.scan("spring.thin.transaction");
		ctx.refresh();
		Hello hello = ctx.getBean(Hello.class);
		hello.run(args);
	}

}
