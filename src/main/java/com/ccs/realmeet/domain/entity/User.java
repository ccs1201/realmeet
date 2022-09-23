package com.ccs.realmeet.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @Id
    @Column(nullable = false)
    private String api_key;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean active;
}
