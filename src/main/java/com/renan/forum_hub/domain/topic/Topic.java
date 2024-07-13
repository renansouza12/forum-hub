package com.renan.forum_hub.domain.topic;

import java.time.LocalDateTime;

import com.renan.forum_hub.dto.TopicDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.*;

@Entity
@Table(name = "topic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Topic {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String title;
    @Column(nullable = false) private String message;
    @Column(name = "createAt" ,nullable = false)private LocalDateTime create_at;
    @Column(nullable = false)    private String state;
    @Column(nullable = false) private String author;
    @Column(nullable = false) private String course;

    
    public Topic(@Valid TopicDTO topic) {
        this.title = topic.title();
        this.message = topic.message();
        this.author = topic.author();
        this.course = topic.course();
        
    }
}   
