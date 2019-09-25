package com.digitalsolutionsbydon.emergencyelectricinc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class UserProfiles extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @JsonIgnoreProperties("userProfiles")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name="profileId", referencedColumnName = "id")
    @JsonIgnoreProperties("userProfiles")
    private Profile profile;

    public UserProfiles()
    {
    }

    public UserProfiles(User user, Profile profile)
    {
        this.user = user;
        this.profile = profile;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Profile getProfile()
    {
        return profile;
    }

    public void setProfile(Profile profile)
    {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof UserProfiles))
        {
            return false;
        }
        UserProfiles that = (UserProfiles) o;
        return getUser().equals(that.getUser()) && getProfile().equals(that.getProfile());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUser(), getProfile());
    }
}
