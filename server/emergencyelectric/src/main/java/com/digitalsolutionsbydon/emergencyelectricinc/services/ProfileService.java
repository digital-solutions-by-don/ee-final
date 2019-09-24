package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Profile;

import java.util.List;

public interface ProfileService
{
    Profile saveProfile(Profile profile);
    Profile updateProfileById(Profile profile, long id);
}
