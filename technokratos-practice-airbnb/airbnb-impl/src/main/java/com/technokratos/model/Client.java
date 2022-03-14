package com.technokratos.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString
public class Client {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    String email;
    String password;
    Boolean verified;

    @Column(name = "first_name")
    String firstName;
    @Column(name = "birth_date")
    Date birthDate;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "registration_date")
    Date registrationDate;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @ToString.Exclude
    List<Booking> bookings;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Apartment> apartments;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
