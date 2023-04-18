package com.eoi.Facturacion.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String apellido;

    private Integer edad;

    private LocalDate fechaNacimiento;

    @JsonManagedReference
    @OneToMany(mappedBy = "invoiceToCustomer", fetch = FetchType.EAGER, cascade = CascadeType.ALL) //Para llamar al objeto Customer invoiceToCustomer de la entidad Invoice
    private List<Invoice> invoiceList;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Contract> contracts;

}
