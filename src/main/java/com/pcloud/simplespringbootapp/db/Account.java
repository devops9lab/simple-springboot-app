package com.pcloud.simplespringbootapp.db;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    @Getter
    @Setter
    private String name;

    @Column(name = "email_address")
    @Getter
    @Setter
    private String emailAddress;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<AccountSetting> accountSettings = new ArrayList<>();
}