package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.models.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();

    User findUserById(long id);

    User findUserByUsername(String username);

    User save(User user);

    User update(User user, long id);

    void delete(long id);
}
