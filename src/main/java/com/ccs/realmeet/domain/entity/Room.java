package com.ccs.realmeet.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

import static java.util.Objects.isNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private int seats;
    private Boolean active;
    @CreationTimestamp
    private OffsetDateTime createTimeStamp;
    @UpdateTimestamp
    private OffsetDateTime lastUpdate;

    @PrePersist
    public void prePersist() {
        if (isNull(active)) {
            this.active = true;
        }
    }
}
