package com.ccs.realmeet.domain.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Builder
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Column(length = 20)
    private String name;
    @Column(length = 30)
    private String email;

}
