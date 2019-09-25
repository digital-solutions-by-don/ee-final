package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.exceptions.ResourceNotFoundException;
import com.digitalsolutionsbydon.emergencyelectricinc.models.Message;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "messageService")
public class MessageServiceImpl implements MessageService
{
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> findAll()
    {
        List<Message> list = new ArrayList<>();
        messageRepository.findAll()
                         .iterator()
                         .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Message findMessageById(long id) throws ResourceNotFoundException
    {
        return messageRepository.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("The message with id:" + id + " cannot be found"));
    }

    @Override
    public Message saveMessage(Message message)
    {
        Message newMessage = new Message();
        newMessage.setFirstName(message.getFirstName());
        newMessage.setLastName(message.getLastName());
        newMessage.setContact(message.getContact());
        newMessage.setSubject(message.getSubject());
        newMessage.setMessage(message.getMessage());
        return messageRepository.save(newMessage);
    }

    @Override
    public void deleteMessageById(long id)
    {
        if (messageRepository.findById(id)
                             .isPresent())
        {
            messageRepository.deleteById(id);
        } else
        {
            throw new ResourceNotFoundException("The message with id:" + id + " cannot be found");
        }
    }
}
