package com.digitalsolutionsbydon.emergencyelectricinc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Email extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    @OneToMany(mappedBy = "email")
    @JsonIgnoreProperties("email")
    private List<ProfileEmail> profileEmails = new ArrayList<>();

    public Email()
    {
    }

    public Email(String email)
    {
        this.email = email;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<ProfileEmail> getProfileEmails()
    {
        return profileEmails;
    }

    public void setProfileEmails(List<ProfileEmail> profileEmails)
    {
        this.profileEmails = profileEmails;
    }
}
