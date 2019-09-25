package com.digitalsolutionsbydon.emergencyelectricinc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ProfileEmail extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name="profileId", referencedColumnName = "id")
    @JsonIgnoreProperties("profileEmails")
    private Profile profile;

    @Id
    @ManyToOne
    @JoinColumn(name="emailId", referencedColumnName = "id")
    @JsonIgnoreProperties("profileEmails")
    private Email email;

    public ProfileEmail()
    {
    }

    public ProfileEmail(Profile profile, Email email)
    {
        this.profile = profile;
        this.email = email;
    }

    public Profile getProfile()
    {
        return profile;
    }

    public void setProfile(Profile profile)
    {
        this.profile = profile;
    }

    public Email getEmail()
    {
        return email;
    }

    public void setEmail(Email email)
    {
        this.email = email;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof ProfileEmail))
        {
            return false;
        }
        ProfileEmail that = (ProfileEmail) o;
        return getProfile().equals(that.getProfile()) && getEmail().equals(that.getEmail());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getProfile(), getEmail());
    }
}
