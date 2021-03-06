package com.digitalsolutionsbydon.emergencyelectricinc.controllers;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Message;
import com.digitalsolutionsbydon.emergencyelectricinc.services.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController
{
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);
    @Autowired
    private MessageService messageService;

    @PostMapping(value="", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> addMessage(@Valid @RequestBody
                                                Message newMessage, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        Message savedMessage = messageService.saveMessage(newMessage);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    @GetMapping(value="", produces = {"application/json"})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAllMessages(HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        List<Message> allMessages = messageService.findAll();
        return new ResponseEntity<>(allMessages, HttpStatus.OK);
    }

    @GetMapping(value="/{id}", produces={"application/json"})
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getMessageById(@PathVariable long id, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        Message message = messageService.findMessageById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteMessageById(@PathVariable long id, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        messageService.deleteMessageById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
