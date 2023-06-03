package com.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.ecommerce.restController.*;
public class App extends Application<Configuration> {
    
 
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }
 
    @Override
    public void run(Configuration c, Environment e) throws Exception {
        
        e.jersey().register(new ProductRestController());
    }
 
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}