package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Email;

public interface EmailService
{
    Email save(Email email);

    Email update(Email email, long id);

    void deleteEmailById(long id);
}
