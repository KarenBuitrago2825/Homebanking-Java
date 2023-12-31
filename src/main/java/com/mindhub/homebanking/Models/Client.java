package com.mindhub.homebanking.Models;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
   @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String firstName;
    private String lastName;
    private String email;


    @OneToMany( mappedBy = "client",fetch = FetchType.EAGER)
    private Set<Account> accounts = new HashSet<>();

    public long getId() {
        return id;
    }

    public Client() {
    }

    public Client(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return firstName + " " +lastName + " "+ email;
    }

    public Set<Account> getAccount() {
        return accounts;
    }

    public void setAccount(Set<Account> account) {
        this.accounts = account;
    }

    public void addAccounts(Account account){
        account.setClient(this);
        accounts.add(account);
    }
}
