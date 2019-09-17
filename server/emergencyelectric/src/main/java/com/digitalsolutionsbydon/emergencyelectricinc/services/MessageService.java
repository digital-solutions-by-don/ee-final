package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Message;

import java.util.List;

public interface MessageService
{
    List<Message> findAll();

    Message findMessageById(long id);

    Message saveMessage(Message message);

    void deleteMessageById(long id);
}
