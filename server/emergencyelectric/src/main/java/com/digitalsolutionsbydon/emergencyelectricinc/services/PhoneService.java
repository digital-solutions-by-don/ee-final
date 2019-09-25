package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Phone;

public interface PhoneService
{
    Phone save(Phone phone);

    Phone update(Phone phone, long id);

    void deletePhoneById(long id);
}
