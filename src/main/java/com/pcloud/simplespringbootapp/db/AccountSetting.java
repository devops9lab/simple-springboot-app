package com.pcloud.simplespringbootapp.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account_settings")
public class AccountSetting {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Column(name = "name", nullable = false)
    @Getter
    @Setter
    private String settingName;

    @Column(name = "value", nullable = false)
    @Getter
    @Setter
    private String settingValue;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @Getter
    @Setter
    private Account account;
}