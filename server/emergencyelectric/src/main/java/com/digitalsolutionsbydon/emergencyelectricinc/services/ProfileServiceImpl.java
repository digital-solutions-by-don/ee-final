package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Profile;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.RoleRepository;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "profileService")
public class ProfileServiceImpl implements ProfileService
{
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public Profile saveProfile(Profile profile)
    {
        return null;
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
