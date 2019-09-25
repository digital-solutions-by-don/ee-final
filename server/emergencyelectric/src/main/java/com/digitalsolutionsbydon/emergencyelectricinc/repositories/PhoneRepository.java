package com.digitalsolutionsbydon.emergencyelectricinc.repositories;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Phone;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface PhoneRepository extends CrudRepository<Phone, Long>
{
    @Transactional
    @Modifying
    @Query(value = "delete from ProfilePhone where (PROFILE_ID = :profileId)")
    void deleteProfilePhoneByProfileId(long profileId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO ProfilePhone(PROFILE_ID, PHONE_ID) VALUES(:profileId, :phoneId)", nativeQuery = true)
    void insertIntoProfilePhone(long profileId, long phoneId);
}
