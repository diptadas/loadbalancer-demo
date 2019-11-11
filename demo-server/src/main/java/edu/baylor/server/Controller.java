package edu.baylor.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Value("${server.port}")
    private String port;

    @GetMapping
    private String serve() {
        return "Response from port " + port + "\n";
    }
}
