package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.exceptions.ResourceNotFoundException;
import com.digitalsolutionsbydon.emergencyelectricinc.models.Address;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "addressService")
public class AddressServiceImpl implements AddressService
{
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    @Modifying
    @Override
    public Address save(Address address)
    {
        Address newAddress = new Address();
        newAddress.setAddress(address.getAddress());
        newAddress.setAddress2(address.getAddress2());
        newAddress.setCity(address.getCity());
        newAddress.setState(address.getState());
        newAddress.setZipCode(address.getZipCode());
        return addressRepository.save(newAddress);
    }

    @Transactional
    @Modifying
    @Override
    public Address update(Address address, long id)
    {
        Address updateAddress = addressRepository.findById(id)
                                                 .orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        if (address.getAddress() != null)
        {
            updateAddress.setAddress(address.getAddress());
        }
        if (address.getAddress2() != null)
        {
            updateAddress.setAddress2(address.getAddress2());
        }
        if (address.getCity() != null)
        {
            updateAddress.setCity(address.getCity());
        }
        if (address.getState() != null)
        {
            updateAddress.setState(address.getState());
        }
        if (address.getZipCode() != null)
        {
            updateAddress.setZipCode(address.getZipCode());
        }
        return addressRepository.save(updateAddress);
    }

    @Transactional
    @Modifying
    @Override
    public void deleteAddressById(long id)
    {
        if (addressRepository.findById(id)
                             .isPresent())
        {
            addressRepository.deleteById(id);
        } else
        {
            throw new ResourceNotFoundException("Address not found");
        }
    }
}
