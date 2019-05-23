package project.config;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import project.ws.GreetingService;
import project.ws.InfoServiceImpl;

import javax.xml.ws.Endpoint;

@Configuration
@ComponentScan("project.ws")
public class WSConfig {
    @Autowired
    private GreetingService greetingService;

    @Bean
    public ServletRegistrationBean dispatcherServletCXF() {
        return new ServletRegistrationBean(new CXFServlet(), "/services/*");
    }

    @Bean(name= Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new InfoServiceImpl());
        endpoint.publish("/InfoService");
        return endpoint;
    }
    @Bean
    public Endpoint endpointGreeting() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), greetingService);
        endpoint.publish("/greeting");
        return endpoint;
    }

}
