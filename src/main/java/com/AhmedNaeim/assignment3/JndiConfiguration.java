package com.AhmedNaeim.assignment3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

@Configuration
public class JndiConfiguration {

    @Bean
    public Context context() throws NamingException {
        Properties jndiProps = new Properties();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");


        return new InitialContext(jndiProps);
    }

//    @Bean
//    public Hello hello(Context context) throws NamingException {
//        return (Hello) context.lookup(getFullName(Hello.class));
//    }



    private String getFullName(Class<?> classType) {
        String moduleName = "assignent3ejb/";
        String beanName = classType.getSimpleName();
        String viewClassName = classType.getName();
        return moduleName + beanName + "!" + viewClassName;
    }

}
