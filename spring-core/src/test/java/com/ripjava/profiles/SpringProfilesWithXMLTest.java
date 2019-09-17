package com.ripjava.profiles;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SpringProfilesWithXMLTest {
    private ClassPathXmlApplicationContext classPathXmlApplicationContext;

    @Test
    public void testSpringProfilesForDevEnvironment() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:springProfiles-config.xml");
        final ConfigurableEnvironment configurableEnvironment = classPathXmlApplicationContext.getEnvironment();
        configurableEnvironment.setActiveProfiles("dev");
        classPathXmlApplicationContext.refresh();
        final DatasourceConfig datasourceConfig = classPathXmlApplicationContext.getBean("devDatasourceConfig", DatasourceConfig.class);

        assertTrue(datasourceConfig instanceof DevDatasourceConfig);
    }

    @Test
    public void testSpringProfilesForProdEnvironment() {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:springProfiles-config.xml");
        final ConfigurableEnvironment configurableEnvironment = classPathXmlApplicationContext.getEnvironment();
        configurableEnvironment.setActiveProfiles("production");
        classPathXmlApplicationContext.refresh();
        final DatasourceConfig datasourceConfig = classPathXmlApplicationContext.getBean("productionDatasourceConfig", DatasourceConfig.class);

        assertTrue(datasourceConfig instanceof ProductionDatasourceConfig);
    }
}
