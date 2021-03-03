package com.example.fintectapi.entities;

import com.example.fintectapi.entities.appEnums.AccountCurrency;
import com.example.fintectapi.entities.appEnums.AccountStatus;
import com.example.fintectapi.entities.appEnums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="account_details_table")
public class AccountDetails {

    @Id
    @SequenceGenerator(sequenceName = "accountDetails_sequence", name = "account_sequence",
                      allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_sequence")
    private long id;

    @Column(name = "account_name", columnDefinition = "TEXT", nullable = false)
    private String accountName;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", columnDefinition = "TEXT", nullable = false)
    private AccountType accountType;

    @Column(name = "account_number", columnDefinition = "TEXT", nullable = false)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status", nullable = false)
    private AccountStatus accountStatus;

    @Enumerated(EnumType.STRING)
    @Column(name="account_currency",  nullable = false)
    private AccountCurrency accountCurrency;

    @ManyToOne
    @JoinColumn(name = "fk_bio_id", nullable = false, referencedColumnName = "id")
    public UserBiodata user_biodate;

    public AccountDetails(String accountName, AccountType accountType, String accountNumber, AccountStatus accountStatus, AccountCurrency accountCurrency, UserBiodata user_biodate) {
        this.accountName = accountName;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.accountCurrency = accountCurrency;
        this.user_biodate = user_biodate;
    }

    public AccountDetails() {
    }

    public long getId() {
        return id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public AccountCurrency getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(AccountCurrency accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public UserBiodata getUser_biodate() {
        return user_biodate;
    }

    public void setUser_biodate(UserBiodata user_biodate) {
        this.user_biodate = user_biodate;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "id=" + id +
                ", accountName='" + accountName + '\'' +
                ", accountType=" + accountType +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountStatus=" + accountStatus +
                ", accountCurrency=" + accountCurrency +
                ", user_biodate=" + user_biodate +
                '}';
    }
}
