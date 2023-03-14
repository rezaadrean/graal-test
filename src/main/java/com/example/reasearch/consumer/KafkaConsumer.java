package com.example.reasearch.consumer;

import com.example.reasearch.model.Student;
import com.example.reasearch.repo.StudentRepo;
import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class KafkaConsumer {

    @Autowired
    private StudentRepo studentRepo;

    @KafkaListener(topics = "topic-student", groupId = "group-id")
    public void consume(String message){
        System.out.println("message = "+ message);
        Map map = transform(message);
        add(map);
    }

    public Map transform(String message){
//        String ss = "{\"name\":\"Reza\",\"email\":\"new@mail.com\"}";
        Gson gson = new Gson();
        Map<Object,Object> attributes = gson.fromJson(message,Map.class);
        return attributes;
    }

    public void add(@RequestBody Map param) {
        Student s = new Student();
        s.setName(param.get("name").toString());
        s.setEmail(param.get("email").toString());
        System.out.println(s);
        studentRepo.save(s);
    }
}
