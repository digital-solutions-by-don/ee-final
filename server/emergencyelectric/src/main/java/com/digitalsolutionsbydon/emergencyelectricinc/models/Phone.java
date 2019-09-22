package com.digitalsolutionsbydon.emergencyelectricinc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Phone extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String phoneNumber;

    @OneToMany(mappedBy = "phone")
    @JsonIgnoreProperties("phone")
    private List<ProfilePhone> profilePhones = new ArrayList<>();

    public Phone(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public List<ProfilePhone> getProfilePhones()
    {
        return profilePhones;
    }

    public void setProfilePhones(List<ProfilePhone> profilePhones)
    {
        this.profilePhones = profilePhones;
    }
}
