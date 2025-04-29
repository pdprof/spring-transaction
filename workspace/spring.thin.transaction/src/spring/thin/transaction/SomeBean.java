package spring.thin.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SomeBean {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public String sayHello()
	{
		SqlRowSet srs = jdbcTemplate.queryForRowSet("select id,name from employee");
		String id="";
		String name="";
		while(srs.next()) {
			id = srs.getString("id");
			name = srs.getString("name");
			System.out.println(id + "," + name);
		}
		return "Hello, " + id + ", " + name;
	}

}
