package com.digitalsolutionsbydon.emergencyelectricinc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ProfilePhone extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name="profileId", referencedColumnName = "id")
    @JsonIgnoreProperties("profilePhones")
    private Profile profile;

    @Id
    @ManyToOne
    @JoinColumn(name="phoneId", referencedColumnName = "id")
    @JsonIgnoreProperties("profilePhones")
    private Phone phone;

    public ProfilePhone()
    {
    }

    public ProfilePhone(Profile profile, Phone phone)
    {
        this.profile = profile;
        this.phone = phone;
    }

    public Profile getProfile()
    {
        return profile;
    }

    public void setProfile(Profile profile)
    {
        this.profile = profile;
    }

    public Phone getPhone()
    {
        return phone;
    }

    public void setPhone(Phone phone)
    {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof ProfilePhone))
        {
            return false;
        }
        ProfilePhone that = (ProfilePhone) o;
        return getProfile().equals(that.getProfile()) && getPhone().equals(that.getPhone());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getProfile(), getPhone());
    }
}
