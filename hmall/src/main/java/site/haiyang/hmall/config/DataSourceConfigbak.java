//package site.haiyang.hmall.config;
//
//import javax.sql.DataSource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//@Configuration
//@MapperScan(basePackages = "site.haiyang.*.mapper", sqlSessionTemplateRef  = "SqlSessionTemplate")
//public class DataSourceConfig {
//
//    @Bean(name = "dataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
////    @Primary
//    public DataSource testDataSource() {
//        //在builder里注入DataSourceproperties中的相关数据库属性
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean(name = "SqlSessionFactoryBean")
//    @Primary
//    public SqlSessionFactoryBean testSqlSessionFactoryBean(@Qualifier("dataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:site/haiyang/*/mapping/*.xml"));
//        return bean;
//    }
//
//    @Bean(name = "SqlSessionFactory")
//    @Primary
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:site/haiyang/*/mapping/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "TransactionManager")
//    @Primary
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "SqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}