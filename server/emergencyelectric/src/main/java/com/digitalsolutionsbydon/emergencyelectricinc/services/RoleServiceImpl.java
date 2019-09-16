package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.exceptions.BadRequestException;
import com.digitalsolutionsbydon.emergencyelectricinc.exceptions.ResourceNotFoundException;
import com.digitalsolutionsbydon.emergencyelectricinc.models.Role;
import com.digitalsolutionsbydon.emergencyelectricinc.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService
{
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findRoleByName(String name)
    {
        Role foundRole = roleRepository.findByName(name);
        if (foundRole != null)
        {
            return foundRole;
        } else
        {
            throw new ResourceNotFoundException("The Role:" + name + " was not found.");
        }
    }

    @Override
    public Role save(Role role)
    {
        if (roleRepository.findByName(role.getName()) != null)
        {
            throw new BadRequestException("The role:" + role.getName() + " is already defined in the system.");
        }
        return roleRepository.save(role);
    }
}
