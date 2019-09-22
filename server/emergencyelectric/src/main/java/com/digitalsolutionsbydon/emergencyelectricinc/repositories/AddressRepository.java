package com.digitalsolutionsbydon.emergencyelectricinc.repositories;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepository extends CrudRepository<Address, Long>
{
    @Transactional
    @Modifying
    @Query(value = "delete from ProfileAddress where (PROFILE_ID = :profileId)")
    void deleteProfileAddressByProfileId(long profileId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO ProfileAddress(PROFILE_ID, ADDRESS_ID) VALUES(:profileId, :addressId)", nativeQuery = true)
    void insertIntoProfileAddress(long profileId, long addressId);
}
