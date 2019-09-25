package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Profile;
import com.digitalsolutionsbydon.emergencyelectricinc.models.User;

public interface ProfileService
{
    Profile saveProfile(Profile profile, User user);

    Profile updateProfileById(Profile profile, long id);
}
