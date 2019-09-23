package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Profile;
import com.digitalsolutionsbydon.emergencyelectricinc.models.ProfileAddress;
import com.digitalsolutionsbydon.emergencyelectricinc.models.ProfileEmail;
import com.digitalsolutionsbydon.emergencyelectricinc.models.ProfilePhone;
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

    @Override
    public List<Profile> getProfilesByUserId(long id)
    {
        return null;
    }

    @Override
    public Profile getProfileByProfileId(long id)
    {
        return null;
    }

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

    @Override
    public Profile updateProfileById(Profile profile, long id)
    {
        return null;
    }

    @Override
    public void deleteProfileById(long id)
    {

    }
}
