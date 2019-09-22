package com.digitalsolutionsbydon.emergencyelectricinc.repositories;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Email;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface EmailRepository extends CrudRepository<Email, Long>
{
    @Transactional
    @Modifying
    @Query(value = "delete from ProfileEmail where (PROFILE_ID = :profileId)")
    void deleteProfileEmailByProfileId(long profileId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO ProfileEmail(PROFILE_ID, EMAIL_ID) VALUES(:profileId, :emailId)", nativeQuery = true)
    void insertIntoProfileEmail(long profileId, long emailId);
}
