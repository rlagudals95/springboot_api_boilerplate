package com.example.demo.config;
 
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.context.ApplicationContext; 

import javax.sql.DataSource;
 
@Configuration
public class MybatisConfig {
 
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource , ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        /* 맵퍼 xml 파일 경로 설정 */
        Resource[] resources = new PathMatchingResourcePatternResolver()
        		
                .getResources("classpath:com/gglee/sample/mapper/*Mapper.xml"); // 쿼리문 작성 파일위치  &xml 파일명 포멧형식
        sqlSessionFactoryBean.setMapperLocations(resources);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/sql/*.xml"));
        /* alias 설정 com.package..entity.Board -> resultType"Board" */
        sqlSessionFactoryBean.setTypeAliasesPackage("com.gglee.sample.*.entity");
 
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
 
        org.apache.ibatis.session.Configuration configuration = sqlSessionFactory.getConfiguration();
        /* 실제DB컬럼명 스네이크 표기법 = 카멜케이스 표기법 맵핑 */
        configuration.setMapUnderscoreToCamelCase(true);
 
        return sqlSessionFactory;
    }
}