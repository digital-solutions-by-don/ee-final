package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Profile;

import java.util.List;

public interface ProfileService
{
    List<Profile> getProfilesByUserId(long id);
    Profile getProfileByProfileId(long id);
    Profile saveProfile(Profile profile);
    Profile updateProfileById(Profile profile, long id);
    void deleteProfileById(long id);
}
