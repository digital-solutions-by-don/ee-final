package com.digitalsolutionsbydon.emergencyelectricinc;

import com.digitalsolutionsbydon.emergencyelectricinc.models.*;
import com.digitalsolutionsbydon.emergencyelectricinc.services.*;
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

    @Autowired
    private AddressService addressService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private ProfileService profileService;

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


        Address a1 = new Address("220 Autumn Ridge Dr NW", "Apt 216", "Corydon", "IN", "47112");
        a1 = addressService.save(a1);
        List<ProfileAddress> pa = new ArrayList<>();
        pa.add(new ProfileAddress(new Profile(), a1));
        Phone p1 = new Phone("8122256539");
        Phone p2 = new Phone("8122255602");
        Phone p3 = new Phone("8125961808");
        p1 = phoneService.save(p1);
        p2 = phoneService.save(p2);
        p3 = phoneService.save(p3);
        List<ProfilePhone> pp = new ArrayList<>();
        pp.add(new ProfilePhone(new Profile(), p1));
        pp.add(new ProfilePhone(new Profile(), p2));
        pp.add(new ProfilePhone(new Profile(), p3));
        Email e1 = new Email("dswhitely1@gmail.com");
        e1 = emailService.save(e1);
        List<ProfileEmail> pe = new ArrayList<>();
        pe.add(new ProfileEmail(new Profile(), e1));
        Profile profile = new Profile("Donald", "Scott", "Whitely", "Don", pa, pp, pe);
        profile = profileService.saveProfile(profile);
        List<UserProfiles> userProfile = new ArrayList<>();
        userProfile.add(new UserProfiles(new User(), profile));
        User u4 = new User("donald", "123456", users, userProfile);
        u4 = userService.save(u4);
    }
}
