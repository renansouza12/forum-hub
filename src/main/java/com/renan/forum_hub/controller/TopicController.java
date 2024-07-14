package com.renan.forum_hub.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.renan.forum_hub.domain.topic.Topic;
import com.renan.forum_hub.dto.TopicDTO;
import com.renan.forum_hub.dto.TopicUpadateDTO;
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

    @GetMapping
    public ResponseEntity<Page<TopicDTO>> getAllTopics(Pageable pagination){
    var page =  this.repository.findAll(pagination).map(TopicDTO::new);
    return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDetailTopic(@PathVariable Long id){
        var topic = this.repository.getReferenceById(id);
        return ResponseEntity.ok(new TopicDTO(topic));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id ,@RequestBody @Valid TopicUpadateDTO data){
        Optional<Topic> topic = this.repository.findById(id);

        if(topic.isPresent()){
            Topic rawTopic = topic.get();
            rawTopic.setTitle(data.title());
            rawTopic.setMessage(data.message());
            rawTopic.setCreate_at(data.create_at());
            rawTopic.setAuthor(data.author());
            rawTopic.setCourse(data.course());
            rawTopic.setState(data.state());

            this.repository.save(rawTopic);

            return ResponseEntity.ok(rawTopic);
        }

        return topic.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id){
        Optional<Topic> topic = this.repository.findById(id);

        if(topic.isPresent()){
            this.repository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        
        return ResponseEntity.notFound().build();
    }
}   
