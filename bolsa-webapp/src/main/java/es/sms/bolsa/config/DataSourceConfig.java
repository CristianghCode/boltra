package es.sms.bolsa.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

@Configuration
public class DataSourceConfig {

	@Bean(name = "accesoDataSource")
	@Primary
	@ConfigurationProperties(prefix = "es.sms.datasource.acceso")
	@Profile("dev")
	public DataSource accesoDatasource() {
		return DataSourceBuilder.create()
				.build();
	}

	@Bean(name = "accesoDataSource")
	@Primary
	@Profile("!dev")
	public DataSource accesoDatasourceJndi() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		return dataSourceLookup.getDataSource("java:/jdbc/AccesoDS");
	}

	@Bean("accesoTransactionManager")
	@Primary
	public DataSourceTransactionManager accesoTransactionmanager() {
		return new DataSourceTransactionManager(accesoDatasource());
	}
}