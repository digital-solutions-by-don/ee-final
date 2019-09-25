package com.digitalsolutionsbydon.emergencyelectricinc.controllers;

import com.digitalsolutionsbydon.emergencyelectricinc.models.User;
import com.digitalsolutionsbydon.emergencyelectricinc.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/users")
public class UsersController
{
    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value="/user", produces = {"application/json"})
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getCurrentUser(HttpServletRequest request, Authentication authentication)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        User currentUser = userService.findUserByUsername(authentication.getName());
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

}
