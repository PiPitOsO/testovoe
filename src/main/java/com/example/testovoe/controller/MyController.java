package com.example.testovoe.controller;

import com.example.testovoe.service.MyService;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping
public class MyController {
    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @GetMapping
    public void newConnection(@RequestParam(required = false) String client1, String client2){
        service.newwConnection(client1, client2);
    }

    @GetMapping("/connection")
    public void connection(HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        final var data = service.get();
        final var gson = new Gson();
        response.getWriter().print(gson.toJson(data));
    }
    @GetMapping("/connection/max")
    public void connectionMax(HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        var data = service.getMax();
        final var gson = new Gson();
        response.getWriter().print(gson.toJson(data.get(0)));
    }
    @GetMapping("/connection/min")
    public void connectionMin(HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        final var data = service.getMin();
        final var gson = new Gson();
        response.getWriter().print(gson.toJson(data.get(data.size()-1)));
    }
    @GetMapping("/connection/avg")
    public void connectionAvg(HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        final var data = service.getAvg();
        final var gson = new Gson();
        response.getWriter().print(gson.toJson(data.get(data.size()/2)));
    }
}
