package com.digitalsolutionsbydon.emergencyelectricinc.repositories;

import com.digitalsolutionsbydon.emergencyelectricinc.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
