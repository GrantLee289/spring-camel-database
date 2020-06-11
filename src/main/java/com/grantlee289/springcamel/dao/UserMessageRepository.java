package com.grantlee289.springcamel.dao;

import com.grantlee289.springcamel.models.UserMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMessageRepository extends JpaRepository <UserMessage, Integer> {
    UserMessage findByName(String name);
}
