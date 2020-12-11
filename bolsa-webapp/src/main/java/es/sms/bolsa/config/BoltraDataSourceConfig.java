package es.sms.bolsa.config;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@Configuration
@EnableJpaRepositories(
    entityManagerFactoryRef = "boltraDbEntityManagerFactory", transactionManagerRef = "boltraDbTransactionManager", basePackages = "es.sms.bolsa.repository")
@EnableTransactionManagement
public class BoltraDataSourceConfig {
	
	
    @Bean(name = "boltraDbDataSource")
    @ConfigurationProperties("es.sms.datasource.boltra")
	@Profile("dev")
    public DataSource boltraDbDataSource() {
        return DataSourceBuilder.create().build();
    }
	@Bean(name = "boltraDbDataSource")
	@Profile("!dev")
	public DataSource accesoDatasourceJndi() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		return dataSourceLookup.getDataSource("java:/jdbc/BoltraDS");
	}
    @Bean(name = "boltraDbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean boltraDbEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("boltraDbDataSource") DataSource dataSource
    ) {
        return builder
            .dataSource(dataSource)
            .packages(new String[] { "es.sms.bolsa.model.entity" })
            .persistenceUnit("boltraDb")
            .build();
    }
    @Bean(name = "boltraDbTransactionManager")
    public PlatformTransactionManager boltraDbTransactionManager(
    		@Qualifier("boltraDbEntityManagerFactory") EntityManagerFactory  boltraDbEntityManagerFactory
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(boltraDbEntityManagerFactory);
        return transactionManager;
    }
}