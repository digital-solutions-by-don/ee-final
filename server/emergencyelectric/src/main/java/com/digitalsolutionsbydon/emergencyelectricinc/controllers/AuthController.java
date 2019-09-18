package com.digitalsolutionsbydon.emergencyelectricinc.controllers;

import com.digitalsolutionsbydon.emergencyelectricinc.models.User;
import com.digitalsolutionsbydon.emergencyelectricinc.models.UserRoles;
import com.digitalsolutionsbydon.emergencyelectricinc.services.RoleService;
import com.digitalsolutionsbydon.emergencyelectricinc.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController
{
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @PostMapping(value = "/register",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> registerUser(@Valid
                                          @RequestBody
                                                  User newUser, HttpServletRequest request)
    {
        logger.info(request.getMethod() + " " + request.getRequestURI() + " accessed");
        List<UserRoles> newRoles = new ArrayList<>();
        newRoles.add(new UserRoles(new User(), roleService.findRoleByName("user")));
        newUser.setUserRoles(newRoles);
        User savedUser = userService.save(newUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
}
