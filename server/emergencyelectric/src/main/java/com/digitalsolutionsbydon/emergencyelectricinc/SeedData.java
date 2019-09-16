package com.digitalsolutionsbydon.emergencyelectricinc;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Role;
import com.digitalsolutionsbydon.emergencyelectricinc.models.User;
import com.digitalsolutionsbydon.emergencyelectricinc.models.UserRoles;
import com.digitalsolutionsbydon.emergencyelectricinc.services.RoleService;
import com.digitalsolutionsbydon.emergencyelectricinc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public void run(String... args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("employee");
        Role r3 = new Role("user");
        r1 = roleService.save(r1);
        r2 = roleService.save(r2);
        r3 = roleService.save(r3);

        List<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));
        admins.add(new UserRoles(new User(), r3));
        List<UserRoles> employees = new ArrayList<>();
        employees.add(new UserRoles(new User(), r2));
        employees.add(new UserRoles(new User(), r3));
        List<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r3));

        User u1 = new User("admin", "password", admins);
        User u2 = new User("employee", "password", employees);
        User u3 = new User("user", "password", users);
        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
    }
}
