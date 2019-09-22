package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Address;

public interface AddressService
{
    Address save(Address address);

    Address update(Address address, long id);

    void deleteAddressById(long id);
}
