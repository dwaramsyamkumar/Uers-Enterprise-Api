package com.lbg.ob.eaisp.users.ent.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ob.eaisp.commons.constants.Brand;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "USER_DETAILS")
@Entity
public class UsersDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SEQ_ID", updatable = false, nullable = false, unique = false)
    private Long userSequenceId;

    @Column(name = "PARTY_ID", nullable = false, length = 24)
    private String partyId;

    @Column(name = "TSP_ID", nullable = false, length = 40)
    private String tspId;

    @Column(name = "TSP_USER_ID")
    private String tspUserId;

    @Column(name = "BRAND", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Brand brand;

    @JsonIgnore
    @Column(name = "CREATED_AT", updatable = false, nullable = false)
    @CreatedDate
    private LocalDateTime creationDateTime;

    @JsonIgnore
    @Column(name = "UPDATED_AT", updatable = false, nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedDateTime;


}
