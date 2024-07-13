package com.renan.forum_hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.renan.forum_hub.domain.topic.Topic;
import com.renan.forum_hub.dto.TopicDTO;
import com.renan.forum_hub.repository.TopicRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    TopicRepository repository;

    @PostMapping
    public ResponseEntity<TopicDTO> registerTopic(@RequestBody @Valid TopicDTO topic){
        Topic newTopic = new Topic(topic);
        this.repository.save(newTopic);

        return ResponseEntity.ok().build();
    }
}
