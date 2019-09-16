package com.digitalsolutionsbydon.emergencyelectricinc.repositories;

import com.digitalsolutionsbydon.emergencyelectricinc.models.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RoleRepository extends CrudRepository<Role, Long>
{
    @Transactional
    @Modifying
    @Query(value = "delete from UserRoles where (userID = :userId)")
    void deleteUserRolesByUserId(long userId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO UserRoles(userId, roleId) VALUES(:userId, :roleId)", nativeQuery = true)
    void insertIntoUserRoles(long userId, long roleId);

    Role findByName(String name);
}
