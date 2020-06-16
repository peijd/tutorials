package com.ripjava.injectcollections;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Configuration
@ComponentScan(basePackageClasses = {CollectionConfig.class})
public class CollectionConfig {

    @Bean
    public List<String> nameList() {
        return Arrays.asList("Li", "Sun", "Huan");
    }
    
    @Bean
    public Set<String> nameSet(){
        return new HashSet<>(Arrays.asList("Qi", "Ai", "Yi"));
    }

    @Bean
    public Map<Integer, String> nameMap(){
        Map<Integer, String>  nameMap = new HashMap<>();
        nameMap.put(1, "Ji");
        nameMap.put(2, "Hong");
        nameMap.put(3, "Heng");
        return nameMap;
    }

    @Bean
    @Order(1)
    @Qualifier("CollectionsBean")
    public RipjavaBean getElement() {
        return new RipjavaBean("JD");
    }

    @Bean
    @Order(3)
    public RipjavaBean getAnotherElement() {
        return new RipjavaBean("PK");
    }

    @Bean
    @Order(2)
    @Qualifier("CollectionsBean")
    public RipjavaBean getOneMoreElement() {
        return new RipjavaBean("PJ");
    }
}
