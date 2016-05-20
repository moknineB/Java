package webapp_JDF;


import java.util.Date;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.sql.DataSource;

@Named
@RequestScoped
public class DateActuel {

	@Resource(name = "JEE_09")
	private static DataSource dataSource;

	Date date = new Date();

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}