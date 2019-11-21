package edu.baylor.ecs.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@RibbonClient(name = "demo-server", configuration = RibbonConfiguration.class)
public class DemoClientApplication {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping()
    public String sendRequest() {
        return this.restTemplate.getForObject("http://demo-server", String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoClientApplication.class, args);
    }

}
