package com.digitalsolutionsbydon.emergencyelectricinc.services;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAuditing implements AuditorAware<String>
{
    @Override
    public Optional<String> getCurrentAuditor()
    {
        String uName;
        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();

        if (authentication != null)
        {
            uName = authentication.getName();
        } else
        {
            uName = "SYSTEM";
        }
        return Optional.of(uName);
    }
}
