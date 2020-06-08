package com.shellgui.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
    private KafkaTemplate<String, MyModel> kafkaTemplate;
    @Autowired
    public KafkaController(KafkaTemplate<String, MyModel> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void post(@RequestBody MyModel myModel){
        kafkaTemplate.send("myTopic", myModel);
    }
}
