package com.grantlee289.springcamel.processors;

import com.grantlee289.springcamel.dao.UserMessageRepository;
import com.grantlee289.springcamel.models.UserMessage;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProcessToDb implements Processor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessToDb.class);

    private UserMessageRepository userMessageRepository;

    public ProcessToDb(UserMessageRepository userMessageRepository) {
        this.userMessageRepository = userMessageRepository;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        LOGGER.info("Start Push to DB");

        Message message = exchange.getIn().getBody(Message.class);

        UserMessage userMessage = new UserMessage();
        userMessage.setId(1234567);
        userMessage.setName("Test Name 3");
        userMessage.setMessage("Test Message 3");
        userMessage = userMessageRepository.save(userMessage);


        LOGGER.info("Push to DB complete");
    }
}
