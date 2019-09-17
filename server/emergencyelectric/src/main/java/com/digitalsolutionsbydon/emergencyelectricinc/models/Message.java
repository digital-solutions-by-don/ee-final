package com.digitalsolutionsbydon.emergencyelectricinc.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Message extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @NotNull
    private String firstName;

    @Column(nullable=false)
    @NotNull
    private String lastName;

    @Column(nullable=false)
    @NotNull
    private String contact;

    @Column(nullable=false)
    @NotNull
    private String subject;

    @Column(nullable=false)
    @NotNull
    private String message;

    public Message()
    {
    }

    public Message(@NotNull String firstName, @NotNull String lastName, @NotNull String contact, @NotNull String subject, @NotNull String message)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.subject = subject;
        this.message = message;
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

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
