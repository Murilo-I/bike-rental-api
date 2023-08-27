package br.gov.sp.cptm.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String nome;
    private String email;
    private String rg;
    @OneToOne
    @JoinColumn(name = "addressId")
    private Address address;
    private LocalDateTime createdAt;
}
