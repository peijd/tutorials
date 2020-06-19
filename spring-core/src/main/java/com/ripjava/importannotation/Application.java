package com.ripjava.importannotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AnimalScanConfiguration.class)
public class Application {
}
