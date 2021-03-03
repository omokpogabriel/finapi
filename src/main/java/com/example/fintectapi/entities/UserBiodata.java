package com.example.fintectapi.entities;

import com.example.fintectapi.entities.appEnums.Gender;
import com.example.fintectapi.entities.appEnums.MaritalStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "user_biodata_table")
public class UserBiodata {
    @Id
    @SequenceGenerator(name = "biodata_sequence", sequenceName = "biodata_sequence", allocationSize = 1)
    @GeneratedValue(generator = "biodata_sequence", strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String firstname;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String lastname;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "TEXT")
    private Gender gender;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "TEXT")
    private MaritalStatus maritalStatus;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String nationality;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String religion;
    @Column(nullable = false, columnDefinition = "TEXT", unique = true)
    private String phone;
    @Column(nullable = false, columnDefinition = "TEXT", unique = true)
    private String email;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String employer;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "biodata")
    private BankUser bankUser;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user_biodate")
        private Set<AccountDetails> accountDetails;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "user_bio_nok")
    private NextOfKinDetails nextOfKinDetails;

    public UserBiodata(String firstname, String lastname, Gender gender, LocalDate dob, String address, MaritalStatus maritalStatus, String nationality, String religion, String phone, String email, String employer, BankUser bankUser, Set<AccountDetails> accountDetails, NextOfKinDetails nextOfKinDetails) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.religion = religion;
        this.phone = phone;
        this.email = email;
        this.employer = employer;
        this.bankUser = bankUser;
        this.accountDetails = accountDetails;
        this.nextOfKinDetails = nextOfKinDetails;
    }

    public UserBiodata() {
    }
    public UserBiodata(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public BankUser getBankUser() {
        return bankUser;
    }

    public void setBankUser(BankUser bankUser) {
        this.bankUser = bankUser;
    }

    public Set<AccountDetails> getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(Set<AccountDetails> accountDetails) {
        this.accountDetails = accountDetails;
    }

    public NextOfKinDetails getNextOfKinDetails() {
        return nextOfKinDetails;
    }

    public void setNextOfKinDetails(NextOfKinDetails nextOfKinDetails) {
        this.nextOfKinDetails = nextOfKinDetails;
    }

    @Override
    public String toString() {
        return "UserBiodata{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", maritalStatus=" + maritalStatus +
                ", nationality='" + nationality + '\'' +
                ", religion='" + religion + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", employer='" + employer + '\'' +
                ", bankUser=" + bankUser +
                ", accountDetails=" + accountDetails +
                ", nextOfKinDetails=" + nextOfKinDetails +
                '}';
    }
}
