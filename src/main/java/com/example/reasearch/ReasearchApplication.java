package com.example.reasearch;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@SpringBootApplication
public class ReasearchApplication {

	@RequestMapping("/")
	public void transform(String message){
		String ss = "{\"name\":\"Reza\",\"email\":\"new@mail.com\"}";
		Gson gson = new Gson();
		Map<Object,Object> attributes = gson.fromJson(ss,Map.class);
		System.out.println(attributes.get("name").toString());
	}

	public static void main(String[] args) {
		SpringApplication.run(ReasearchApplication.class, args);
	}

}
