package com.example.fintectapi.entities;

import com.example.fintectapi.entities.appEnums.Gender;

import javax.persistence.*;

@Entity
@Table(name="next_of_kin_table")
public class NextOfKinDetails {

    @Id
    @SequenceGenerator(name="kin_sequence", allocationSize = 1, sequenceName = "kin_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kin_sequence")
    private long id;

    @Column(columnDefinition = "TEXT", name = "nok_name")
    private String nextOfkin;

    @Column(columnDefinition = "TEXT", name="nok_address")
    private String nextOfKinAddress;

    @Column(columnDefinition = "TEXT", name="nok_phone")
    private String nextOfKinPhone;

    @Enumerated(EnumType.STRING)
    @Column(name="nok_gender")
    private Gender nextOfKinGender;

    @Column(columnDefinition = "TEXT", name="nok_relationship")
    private String nextOfKinRelationship;

    @OneToOne
    @JoinColumn(name = "fk_user_bio", referencedColumnName = "id", nullable = false)
    private UserBiodata user_bio_nok;

    public NextOfKinDetails() {
    }

    public NextOfKinDetails(String nextOfkin, String nextOfKinAddress, String nextOfKinPhone, Gender nextOfKinGender, String nextOfKinRelationship, UserBiodata user_bio_nok) {
        this.nextOfkin = nextOfkin;
        this.nextOfKinAddress = nextOfKinAddress;
        this.nextOfKinPhone = nextOfKinPhone;
        this.nextOfKinGender = nextOfKinGender;
        this.nextOfKinRelationship = nextOfKinRelationship;
        this.user_bio_nok = user_bio_nok;
    }

    public long getId() {
        return id;
    }

    public String getNextOfkin() {
        return nextOfkin;
    }

    public void setNextOfkin(String nextOfkin) {
        this.nextOfkin = nextOfkin;
    }

    public String getNextOfKinAddress() {
        return nextOfKinAddress;
    }

    public void setNextOfKinAddress(String nextOfKinAddress) {
        this.nextOfKinAddress = nextOfKinAddress;
    }

    public String getNextOfKinPhone() {
        return nextOfKinPhone;
    }

    public void setNextOfKinPhone(String nextOfKinPhone) {
        this.nextOfKinPhone = nextOfKinPhone;
    }

    public Gender getNextOfKinGender() {
        return nextOfKinGender;
    }

    public void setNextOfKinGender(Gender nextOfKinGender) {
        this.nextOfKinGender = nextOfKinGender;
    }

    public String getNextOfKinRelationship() {
        return nextOfKinRelationship;
    }

    public void setNextOfKinRelationship(String nextOfKinRelationship) {
        this.nextOfKinRelationship = nextOfKinRelationship;
    }

    public UserBiodata getUser_bio_nok() {
        return user_bio_nok;
    }

    public void setUser_bio_nok(UserBiodata user_bio_nok) {
        this.user_bio_nok = user_bio_nok;
    }

    @Override
    public String toString() {
        return "NextOfKinDetails{" +
                "id=" + id +
                ", nextOfkin='" + nextOfkin + '\'' +
                ", nextOfKinAddress='" + nextOfKinAddress + '\'' +
                ", nextOfKinPhone='" + nextOfKinPhone + '\'' +
                ", nextOfKinGender=" + nextOfKinGender +
                ", nextOfKinRelationship='" + nextOfKinRelationship + '\'' +
                ", user_bio_nok=" + user_bio_nok +
                '}';
    }
}
