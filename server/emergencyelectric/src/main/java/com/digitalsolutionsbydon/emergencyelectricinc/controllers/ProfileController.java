package com.digitalsolutionsbydon.emergencyelectricinc.controllers;

import com.digitalsolutionsbydon.emergencyelectricinc.models.*;
import com.digitalsolutionsbydon.emergencyelectricinc.services.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController
{
    private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
    @Autowired
    private AddressService addressService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserService userService;

    @PostMapping(value = "/address",
            consumes = {"application/json"},
            produces = {"application/json"})
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> addNewAddress(@Valid
                                           @RequestBody
                                                   Address address, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        Address newAddress = addressService.save(address);
        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
    }

    @PutMapping(value = "/address/{id}",
            consumes = {"application/json"},
            produces = {"application/json"})
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> updateAddress(
            @RequestBody
                    Address address,
            @PathVariable
                    long id, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        Address updateAddress = addressService.update(address, id);
        return new ResponseEntity<>(updateAddress, HttpStatus.OK);
    }

    @DeleteMapping(value = "/address/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> deleteAddress(
            @PathVariable
                    long id, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        addressService.deleteAddressById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/phone",
            consumes = {"application/json"},
            produces = {"application/json"})
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> addNewPhone(@Valid
                                         @RequestBody
                                                 Phone phone, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        Phone newPhone = phoneService.save(phone);
        return new ResponseEntity<>(newPhone, HttpStatus.CREATED);
    }

    @PutMapping(value = "/phone/{id}",
            consumes = {"application/json"},
            produces = {"application/json"})
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> updatePhone(
            @RequestBody
                    Phone phone,
            @PathVariable
                    long id, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        Phone updatePhone = phoneService.update(phone, id);
        return new ResponseEntity<>(updatePhone, HttpStatus.OK);
    }

    @DeleteMapping(value = "/phone/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> deletePhone(
            @PathVariable
                    long id, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        phoneService.deletePhoneById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/email",
            consumes = {"application/json"},
            produces = {"application/json"})
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> addNewAddress(@Valid
                                           @RequestBody
                                                   Email email, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        Email newEmail = emailService.save(email);
        return new ResponseEntity<>(newEmail, HttpStatus.CREATED);
    }

    @PutMapping(value = "/email/{id}",
            consumes = {"application/json"},
            produces = {"application/json"})
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> updateEmail(
            @RequestBody
                    Email email,
            @PathVariable
                    long id, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        Email updateEmail = emailService.update(email, id);
        return new ResponseEntity<>(updateEmail, HttpStatus.OK);
    }

    @DeleteMapping(value = "/email/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> deleteEmail(
            @PathVariable
                    long id, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        emailService.deleteEmailById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping(value = "/profile",
            consumes = {"application/json"},
            produces = {"application/json"})
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<?> addProfile(@Valid
                                        @RequestBody
                                                Profile profile, Authentication authentication, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        User currentUser = userService.findUserByUsername(authentication.getName());
        profileService.saveProfile(profile, currentUser);
        return new ResponseEntity<>(currentUser, HttpStatus.CREATED);
    }
}
