package com.chainsys.bloodbankapp.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConnectionTemplate {
	// to enter into sql details (to find source)
	public static DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("system");
		dataSource.setPassword("oracle");
		return dataSource;
	}
	// connection establish
	public static JdbcTemplate getJdbcTemplate() {
		DriverManagerDataSource dataSource = ConnectionTemplate.getDataSource();

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
}
