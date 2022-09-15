package com.ccs.realmeet.domain.entity;

import com.ccs.realmeet.domain.model.Employee;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Allocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Room room;

    @Embedded
    private Employee employee;

    @Column(length = 60)
    private String subject;

    private OffsetDateTime startAt;

    private OffsetDateTime endAt;

    @CreationTimestamp
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    private OffsetDateTime updateAt;


}
