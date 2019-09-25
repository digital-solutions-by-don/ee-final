package com.digitalsolutionsbydon.emergencyelectricinc.services;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Role;

public interface RoleService
{
    Role findRoleByName(String name);

    Role save(Role role);
}
