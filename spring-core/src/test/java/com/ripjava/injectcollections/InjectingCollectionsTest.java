package com.ripjava.injectcollections;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InjectingCollectionsTest {

    @Test
    public void test_Autowired_List() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CollectionConfig.class);
        ListBean collectionsBean = context.getBean(
                ListBean.class);
        collectionsBean.printNameList();
    }

    @Test
    public void test_Constructor_Set() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CollectionConfig.class);
        SetBean collectionsBean = context.getBean(
                SetBean.class);
        collectionsBean.printNameSet();
    }

    @Test
    public void test_Setter_Map() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CollectionConfig.class);
        MapBean collectionsBean = context.getBean(
                MapBean.class);
        collectionsBean.printNameMap();
    }

    @Test
    public void test_BeanList() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CollectionConfig.class);
        BeanListBean collectionsBean = context.getBean(
                BeanListBean.class);
        collectionsBean.printBeanList();
    }
    @Test
    public void test_EmptyList() {
        ApplicationContext context = new AnnotationConfigApplicationContext(CollectionConfig.class);
        BeanListBean collectionsBean = context.getBean(
                BeanListBean.class);
        collectionsBean.printNameListWithDefaults();
    }

}
