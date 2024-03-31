package com.example.jpabackend.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

//@Configuration
//@Profile("prod")
public class HttpsConfiguration {
//    @Bean
//    public ServletWebServerFactory servletContainer(){
//        return tomcat;
//    }
    private Connector redidectConnector(){
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("https");
        connector.setPort(80);
        connector.setSecure(false);
        connector.setRedirectPort(443);
        return connector;
    }
}
