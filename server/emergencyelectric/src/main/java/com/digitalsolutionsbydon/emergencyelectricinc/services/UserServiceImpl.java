package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.exceptions.BadRequestException;
import com.digitalsolutionsbydon.emergencyelectricinc.exceptions.ResourceNotFoundException;
import com.digitalsolutionsbydon.emergencyelectricinc.models.User;
import com.digitalsolutionsbydon.emergencyelectricinc.models.UserProfiles;
import com.digitalsolutionsbydon.emergencyelectricinc.models.UserRoles;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.RoleRepository;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userRepository.findByUsername(username);
        if (user == null)
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthority());
    }

    @Override
    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();
        userRepository.findAll()
                      .iterator()
                      .forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findUserById(long id) throws ResourceNotFoundException
    {
        return userRepository.findById(id)
                             .orElseThrow(() -> new ResourceNotFoundException("User with id:" + id + " was not found."));
    }

    @Override
    public User findUserByUsername(String username) throws ResourceNotFoundException
    {
        User currentUser = userRepository.findByUsername(username);
        if(currentUser!=null) {
            return currentUser;
        } else {
            throw new ResourceNotFoundException("The " + username + " is not in the system");
        }
    }

    @Transactional
    @Modifying
    @Override
    public User save(User user)
    {
        User foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null) {
            throw new BadRequestException(user.getUsername()+" is already taken.");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches("",user.getPassword())) {
            throw new BadRequestException("Password cannot be blank");
        }
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPasswordNoEncrypt(user.getPassword());
        List<UserRoles> newRoles = new ArrayList<>();
        for (UserRoles ur: user.getUserRoles())
        {
            newRoles.add(new UserRoles(newUser, ur.getRole()));
        }
        newUser.setUserRoles(newRoles);
        List<UserProfiles> newProfile = new ArrayList<>();
        for(UserProfiles up: user.getUserProfiles())
        {
            newProfile.add(new UserProfiles(newUser, up.getProfile()));
        }
        newUser.setUserProfiles(newProfile);
        return userRepository.save(newUser);
    }

    @Transactional
    @Modifying
    @Override
    public User update(User user, long id)
    {
        User updateUser = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User with id:" + id + " was not found."));
        if (user.getUsername()!=null && !user.getUsername()
                                             .equals(updateUser.getUsername()))  {
            if (userRepository.findByUsername(user.getUsername())!=null)
            {
                throw new BadRequestException(user.getUsername()+" is already taken.");
            }
            updateUser.setUsername(user.getUsername());
        }
        if (user.getPassword()!=null) {
            updateUser.setPasswordNoEncrypt(user.getPassword());
        }
        if (user.getUserRoles().size() > 0) {
            roleRepository.deleteUserRolesByUserId(updateUser.getId());
            for (UserRoles ur: user.getUserRoles())
            {
                roleRepository.insertIntoUserRoles(updateUser.getId(), ur.getRole().getId());
            }
            updateUser.setUserRoles(user.getUserRoles());
        }
        return userRepository.save(updateUser);
    }

    @Transactional
    @Modifying
    @Override
    public void delete(long id)
    {
        if (userRepository.findById(id).isPresent())
        {
            userRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("User with id:" + id + " was not found.");
        }
    }
}
