package com.ripjava.spring.properties.reloading;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.io.File;
import java.util.Properties;

@Configuration
public class ReloadablePropertySourceConfig {
    private ConfigurableEnvironment env;

    public ReloadablePropertySourceConfig(@Autowired ConfigurableEnvironment env) {
        this.env = env;
    }


    @Bean
    @ConditionalOnProperty(name = "spring.config.location", matchIfMissing = false)
    public PropertiesConfiguration propertiesConfiguration(
            @Value("${spring.config.location}") String path,
            @Value("${spring.properties.refreshDelay}") long refreshDelay) throws Exception {
        String filePath = path.substring("file:".length());
        PropertiesConfiguration configuration = new PropertiesConfiguration(new File(filePath).getCanonicalPath());
        FileChangedReloadingStrategy fileChangedReloadingStrategy = new FileChangedReloadingStrategy();
        fileChangedReloadingStrategy.setRefreshDelay(refreshDelay);
        configuration.setReloadingStrategy(fileChangedReloadingStrategy);
        return configuration;
    }

    @Bean
    @ConditionalOnBean(PropertiesConfiguration.class)
    @Primary
    public Properties properties(PropertiesConfiguration propertiesConfiguration) throws Exception {
        ReloadableProperties properties = new ReloadableProperties(propertiesConfiguration);
        return properties;
    }

    @Bean
    @ConditionalOnProperty(name = "spring.config.location", matchIfMissing = false)
    public ReloadablePropertySource reloadablePropertySource(PropertiesConfiguration properties) {
        ReloadablePropertySource ret = new ReloadablePropertySource("dynamic", properties);
        MutablePropertySources sources = env.getPropertySources();
        sources.addFirst(ret);
        return ret;
    }
}
