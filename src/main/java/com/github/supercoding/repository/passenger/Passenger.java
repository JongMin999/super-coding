package com.github.supercoding.repository.passenger;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "passengerId")
@Builder
@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @Column(name = "passenger_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passengerId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "passport_num", length = 50)
    private String passportNum;
}