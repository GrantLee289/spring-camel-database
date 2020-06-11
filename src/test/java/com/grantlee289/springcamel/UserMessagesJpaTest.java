package com.grantlee289.springcamel;

import com.grantlee289.springcamel.config.PersistenceUserConfiguration;
import com.grantlee289.springcamel.dao.UserMessageRepository;
import com.grantlee289.springcamel.models.UserMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceUserConfiguration.class})
@EnableTransactionManagement
public class UserMessagesJpaTest {

    @Autowired
    private UserMessageRepository userMessageRepository;

    @Test
    @Transactional("userTransactionManager")
    public void createUser() {
        UserMessage userMessage = new UserMessage();

        userMessage.setId(UUID.randomUUID().toString());
        userMessage.setName("Test Name 2");
        userMessage.setMessage("Test Message 2");
        userMessage = userMessageRepository.save(userMessage);

        final Optional<UserMessage> results = Optional.of(userMessageRepository.findByName(userMessage.getName()));
        assertTrue(results.isPresent());
    }
}
