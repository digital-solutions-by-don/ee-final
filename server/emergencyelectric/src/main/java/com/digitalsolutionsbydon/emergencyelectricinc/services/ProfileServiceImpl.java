package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.exceptions.ResourceNotFoundException;
import com.digitalsolutionsbydon.emergencyelectricinc.models.Profile;
import com.digitalsolutionsbydon.emergencyelectricinc.models.ProfileAddress;
import com.digitalsolutionsbydon.emergencyelectricinc.models.ProfileEmail;
import com.digitalsolutionsbydon.emergencyelectricinc.models.ProfilePhone;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.AddressRepository;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.EmailRepository;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.PhoneRepository;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "profileService")
public class ProfileServiceImpl implements ProfileService
{
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Transactional
    @Modifying
    @Override
    public Profile saveProfile(Profile profile)
    {

        Profile newProfile = new Profile();
        newProfile.setFirstName(profile.getFirstName());
        newProfile.setMiddleName(profile.getMiddleName());
        newProfile.setLastName(profile.getLastName());
        newProfile.setPreferredName(profile.getPreferredName());
        List<ProfileAddress> newAddress = new ArrayList<>();
        for (ProfileAddress pa : profile.getProfileAddresses())
        {
            newAddress.add(new ProfileAddress(newProfile, pa.getAddress()));
        }
        newProfile.setProfileAddresses(newAddress);
        List<ProfilePhone> newPhone = new ArrayList<>();
        for (ProfilePhone pp : profile.getProfilePhones())
        {
            newPhone.add(new ProfilePhone(newProfile, pp.getPhone()));
        }
        newProfile.setProfilePhones(newPhone);
        List<ProfileEmail> newEmail = new ArrayList<>();
        for (ProfileEmail pe : profile.getProfileEmails())
        {
            newEmail.add(new ProfileEmail(newProfile, pe.getEmail()));
        }
        newProfile.setProfileEmails(newEmail);
        return profileRepository.save(newProfile);
    }

    @Transactional
    @Modifying
    @Override
    public Profile updateProfileById(Profile profile, long id)
    {
        Profile updateProfile = profileRepository.findById(id)
                                                 .orElseThrow(() -> new ResourceNotFoundException("The profile cannot be found"));
        if (profile.getFirstName() != null)
        {
            updateProfile.setFirstName(profile.getFirstName());
        }
        if (profile.getMiddleName() != null)
        {
            updateProfile.setMiddleName(profile.getMiddleName());
        }
        if (profile.getLastName() != null)
        {
            updateProfile.setLastName(profile.getLastName());
        }
        if (profile.getPreferredName() != null)
        {
            updateProfile.setPreferredName(profile.getPreferredName());
        }
        if (profile.getProfileAddresses()
                   .size() > 0)
        {
            addressRepository.deleteProfileAddressByProfileId(updateProfile.getId());
            for (ProfileAddress pa : profile.getProfileAddresses())
            {
                addressRepository.insertIntoProfileAddress(updateProfile.getId(), pa.getAddress()
                                                                                    .getId());
            }
            updateProfile.setProfileAddresses(profile.getProfileAddresses());
        }
        if (profile.getProfilePhones()
                   .size() > 0)
        {
            phoneRepository.deleteProfilePhoneByProfileId(updateProfile.getId());
            for (ProfilePhone pp : profile.getProfilePhones())
            {
                phoneRepository.insertIntoProfilePhone(updateProfile.getId(), pp.getPhone()
                                                                                .getId());
            }
            updateProfile.setProfilePhones(profile.getProfilePhones());
        }
        if (profile.getProfileEmails()
                   .size() > 0)
        {
            emailRepository.deleteProfileEmailByProfileId(updateProfile.getId());
            for (ProfileEmail pe : profile.getProfileEmails())
            {
                emailRepository.insertIntoProfileEmail(updateProfile.getId(), pe.getEmail()
                                                                                .getId());
            }
            updateProfile.setProfileEmails(profile.getProfileEmails());
        }
        return profileRepository.save(updateProfile);
    }

}
