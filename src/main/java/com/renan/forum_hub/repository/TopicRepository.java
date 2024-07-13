package com.renan.forum_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renan.forum_hub.domain.topic.Topic;

public interface TopicRepository  extends JpaRepository<Topic,Long>{}
