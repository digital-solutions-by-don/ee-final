package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.exceptions.ResourceNotFoundException;
import com.digitalsolutionsbydon.emergencyelectricinc.models.Phone;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "phoneService")
public class PhoneServiceImpl implements PhoneService
{
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public Phone save(Phone phone)
    {
        Phone newPhone = new Phone();
        newPhone.setPhoneNumber(phone.getPhoneNumber());
        return phoneRepository.save(newPhone);
    }

    @Override
    public Phone update(Phone phone, long id)
    {
        Phone updatePhone = phoneRepository.findById(id)
                                           .orElseThrow(() -> new ResourceNotFoundException("Phone number not found"));
        if (phone.getPhoneNumber() != null)
        {
            updatePhone.setPhoneNumber(phone.getPhoneNumber());
        }
        return phoneRepository.save(updatePhone);
    }

    @Override
    public void deletePhoneById(long id)
    {
        if (phoneRepository.findById(id)
                           .isPresent())
        {
            phoneRepository.deleteById(id);
        } else
        {
            throw new ResourceNotFoundException("Phone Number Not Found");
        }
    }
}
