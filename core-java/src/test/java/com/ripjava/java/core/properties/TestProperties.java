package com.ripjava.java.core.properties;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestProperties {

    @Test
    public  void test_loadProperties() throws IOException {
        String rootPath = "src/test/resources/";
        String appConfigPath = rootPath + "app.properties";
        String catalogConfigPath = rootPath + "catalog";

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        Properties catalogProps = new Properties();
        catalogProps.load(new FileInputStream(catalogConfigPath));


        String appVersion = appProps.getProperty("version");
        assertEquals("1.0", appVersion);

        assertEquals("files", catalogProps.getProperty("c1"));
    }

    @Test
    public  void test_loadXML() throws IOException {
        String rootPath = "src/test/resources/";
        String iconConfigPath = rootPath + "icons.xml";
        Properties iconProps = new Properties();
        iconProps.loadFromXML(new FileInputStream(iconConfigPath));

        assertEquals("icon1.jpg", iconProps.getProperty("fileIcon"));
    }
    @Test
    public  void test_getProperty() throws IOException {
        String rootPath = "src/test/resources/";
        String appConfigPath = rootPath + "app.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
        String appVersion = appProps.getProperty("version");
        String appName = appProps.getProperty("name", "defaultName");
        String appGroup = appProps.getProperty("group", "defaultGroup");
        String appDownloadAddr = appProps.getProperty("downloadAddr");

        assertEquals("1.0", appVersion);
        assertEquals("TestApp", appName);
        assertEquals("defaultGroup", appGroup);
        assertNull(appDownloadAddr);
    }
    @Test
    public  void test_setProperty() throws IOException {
        String rootPath = "src/test/resources/";
        String appConfigPath = rootPath + "app.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));

        appProps.setProperty("name", "NewAppName");
        appProps.setProperty("downloadAddr", "xxxx");

        String newAppName = appProps.getProperty("name");
        assertEquals("NewAppName", newAppName);

        String newAppDownloadAddr = appProps.getProperty("downloadAddr");
        assertEquals("xxxx", newAppDownloadAddr);

        appProps.put("version", 2);
        String version = appProps.getProperty("version");
        assertNull(version);

    }
    @Test
    public  void test_remove() throws IOException {
        String rootPath = "src/test/resources/";
        String appConfigPath = rootPath + "app.properties";
        Properties appProps = new Properties();
        appProps.load(new FileInputStream(appConfigPath));
        String versionBeforeRemoval = appProps.getProperty("version");
        assertEquals("1.0", versionBeforeRemoval);

        appProps.remove("version");
        String versionAfterRemoval = appProps.getProperty("version");
        assertNull(versionAfterRemoval);
    }

    @Test
    public  void test_storeProperties() throws IOException {
        String rootPath = "src/test/resources/";
        String newAppConfigPropertiesFile = rootPath + "newApp.properties";
        Properties appProps = new Properties();
        appProps.setProperty("name", "NewAppName");
        appProps.setProperty("download", "downloadUrl");
        appProps.store(new FileWriter(newAppConfigPropertiesFile), "store to properties file");

        Properties newAppProps = new Properties();
        newAppProps.load(new FileInputStream(newAppConfigPropertiesFile));
        String newAppName = newAppProps.getProperty("name");
        assertEquals("NewAppName", newAppName);

        String newAppDownload = newAppProps.getProperty("download");
        assertEquals("downloadUrl", newAppDownload);

    }

    @Test
    public  void test_storeXML() throws IOException {
        String rootPath = "src/test/resources/";
        String newAppConfigXmlFile = rootPath + "newApp.xml";

        Properties appProps = new Properties();
        appProps.setProperty("name", "NewAppName");
        appProps.setProperty("download", "downloadUrl");
        appProps.storeToXML(new FileOutputStream(newAppConfigXmlFile), "store to xml file");

        Properties newAppProps = new Properties();
        newAppProps.loadFromXML(new FileInputStream(newAppConfigXmlFile));
        String newAppName = newAppProps.getProperty("name");
        assertEquals("NewAppName", newAppName);

        String newAppDownload = newAppProps.getProperty("download");
        assertEquals("downloadUrl", newAppDownload);
    }

    @Test
    public  void test_otherMethod() throws IOException {
        String rootPath = "src/test/resources/";
        String newAppConfigPropertiesFile = rootPath + "newApp.properties";

        Properties appProps = new Properties();
        appProps.load(new FileInputStream(newAppConfigPropertiesFile));

        appProps.list(System.out);

        Enumeration<Object> valueEnumeration = appProps.elements();
        while (valueEnumeration.hasMoreElements()) {
            System.out.println(valueEnumeration.nextElement());
        }

        Enumeration<Object> keyEnumeration = appProps.keys();
        while (keyEnumeration.hasMoreElements()) {
            System.out.println(keyEnumeration.nextElement());
        }

        int size = appProps.size();
        assertEquals(2, size);

    }

    @Test
    public  void test_defaultPropertiesObject() throws IOException {
        String rootPath = "src/test/resources/";
        String defaultConfigPath = rootPath + "default.properties";
        Properties defaultProps = new Properties();
        defaultProps.load(new FileInputStream(defaultConfigPath));

        String appConfigPath = rootPath + "app.properties";
        // 设置默认的属性列表
        Properties appProps = new Properties(defaultProps);
        appProps.load(new FileInputStream(appConfigPath));

        String appVersion = appProps.getProperty("version");
        assertEquals("1.0", appVersion);
        String appName = appProps.getProperty("name");
        assertEquals("TestApp", appName);
        String defaultSite = appProps.getProperty("site");
        assertEquals("www.google.com", defaultSite);
    }


}
