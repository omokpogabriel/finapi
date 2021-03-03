package com.example.fintectapi.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="account_access_table")
 public class BankUser {
    @Id
    @SequenceGenerator(name = "user_sequence", allocationSize = 1, sequenceName = "user_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private long id;

    @Column(columnDefinition = "TEXT", name = "username", nullable = false, unique = true)
    private String username;

    @Column(nullable = false, columnDefinition = "TEXT", name = "password")
    private String password;

    @Column
    private LocalDateTime created_at;


    @OneToOne
    @JoinColumn(name = "fk_bio_id", referencedColumnName = "id")
    private UserBiodata biodata;


    public BankUser(String username, String password, LocalDateTime created_at, UserBiodata biodata) {
        this.username = username;
        this.password = password;
        this.created_at = created_at;
        this.biodata = biodata;
    }

    public BankUser() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = LocalDateTime.now();
    }

    public UserBiodata getBiodata() {
        return biodata;
    }

    public void setBiodata(UserBiodata biodata) {
        this.biodata = biodata;
    }

    @Override
    public String toString() {
        return "BankUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                ", biodata=" + biodata +
                '}';
    }
}
