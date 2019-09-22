package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.exceptions.ResourceNotFoundException;
import com.digitalsolutionsbydon.emergencyelectricinc.models.Email;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "emailService")
public class EmailServiceImpl implements EmailService
{
    @Autowired
    private EmailRepository emailRepository;

    @Override
    public Email save(Email email)
    {
        Email newEmail = new Email();
        newEmail.setEmail(email.getEmail());
        return emailRepository.save(newEmail);
    }

    @Override
    public Email update(Email email, long id)
    {
        Email updateEmail = emailRepository.findById(id)
                                           .orElseThrow(() -> new ResourceNotFoundException("Email not Found"));
        if (email.getEmail() != null)
        {
            updateEmail.setEmail(email.getEmail());
        }
        return emailRepository.save(updateEmail);
    }

    @Override
    public void deleteEmailById(long id)
    {
        if (emailRepository.findById(id)
                           .isPresent())
        {
            deleteEmailById(id);
        } else
        {
            throw new ResourceNotFoundException("Email not found");
        }
    }
}
