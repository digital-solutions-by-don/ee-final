package com.digitalsolutionsbydon.emergencyelectricinc.repositories;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Profile;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProfileRepository extends CrudRepository<Profile, Long>
{
    @Transactional
    @Modifying
    @Query(value = "delete from UserProfiles where (userID = :userId)")
    void deleteUserProfilesByUserId(long userId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO UserProfiles(userId, profileId) VALUES(:userId, :profileId)", nativeQuery = true)
    void insertIntoUserRoles(long userId, long profileId);
}
