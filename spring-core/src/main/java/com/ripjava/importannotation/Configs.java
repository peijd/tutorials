package com.ripjava.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
class BirdConfig {

    @Bean
    Bird bird() {
        return new Bird();
    }
}

@Configuration
class CatConfig {

    @Bean
    Cat cat() {
        return new Cat();
    }
}

@Configuration
class DogConfig {

    @Bean
    Dog dog() {
        return new Dog();
    }
}

@Configuration
@Import(Elephant.class)
class ElephantConfig{

}

@Component(value = "elephant")
class  Elephant{

}