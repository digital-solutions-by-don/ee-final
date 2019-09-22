package com.digitalsolutionsbydon.emergencyelectricinc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class ProfileAddress extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JoinColumn(name="profileId", referencedColumnName = "id")
    @JsonIgnoreProperties("profileAddress")
    private Profile profile;

    @Id
    @ManyToOne
    @JoinColumn(name="addressId", referencedColumnName = "id")
    @JsonIgnoreProperties("profileAddress")
    private Address address;

    public ProfileAddress()
    {
    }

    public ProfileAddress(Profile profile, Address address)
    {
        this.profile = profile;
        this.address = address;
    }

    public Profile getProfile()
    {
        return profile;
    }

    public void setProfile(Profile profile)
    {
        this.profile = profile;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof ProfileAddress))
        {
            return false;
        }
        ProfileAddress that = (ProfileAddress) o;
        return getProfile().equals(that.getProfile()) && getAddress().equals(that.getAddress());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getProfile(), getAddress());
    }
}
