package com.digitalsolutionsbydon.emergencyelectricinc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String firstName;

    private String middleName;

    @Column(nullable = false)
    private String lastName;

    private String preferredName;

    @OneToMany(mappedBy = "profile")
    @JsonIgnoreProperties("profile")
    private List<UserProfiles> userProfiles = new ArrayList<>();

    @OneToMany(mappedBy="profile", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("profile")
    private List<ProfileAddress> profileAddresses = new ArrayList<>();

    @OneToMany(mappedBy="profile", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("profile")
    private List<ProfilePhone> profilePhones = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("profile")
    private List<ProfileEmail> profileEmails = new ArrayList<>();

    public Profile()
    {
    }

    public Profile(String firstName, String middleName, String lastName, String preferredName, List<ProfileAddress> profileAddresses, List<ProfilePhone> profilePhones, List<ProfileEmail> profileEmails)
    {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.preferredName = preferredName;
        for (ProfileAddress pa: profileAddresses)
        {
            pa.setProfile(this);
        }
        this.profileAddresses = profileAddresses;
        for (ProfilePhone pp: profilePhones)
        {
            pp.setProfile(this);
        }
        this.profilePhones = profilePhones;
        for (ProfileEmail pe: profileEmails)
        {
            pe.setProfile(this);
        }
        this.profileEmails = profileEmails;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getMiddleName()
    {
        return middleName;
    }

    public void setMiddleName(String middleName)
    {
        this.middleName = middleName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPreferredName()
    {
        return preferredName;
    }

    public void setPreferredName(String preferredName)
    {
        this.preferredName = preferredName;
    }

    public List<UserProfiles> getUserProfiles()
    {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfiles> userProfiles)
    {
        this.userProfiles = userProfiles;
    }

    public List<ProfileAddress> getProfileAddresses()
    {
        return profileAddresses;
    }

    public void setProfileAddresses(List<ProfileAddress> profileAddresses)
    {
        this.profileAddresses = profileAddresses;
    }

    public List<ProfilePhone> getProfilePhones()
    {
        return profilePhones;
    }

    public void setProfilePhones(List<ProfilePhone> profilePhones)
    {
        this.profilePhones = profilePhones;
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
