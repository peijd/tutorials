package com.ripjava.importannotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({BirdConfig.class, CatConfig.class, DogConfig.class})
public class AnimalConfig {
}