package com.eoi.Facturacion.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "invoice")
public class Invoice {
    @Column (name = "id_invoice")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column (name = "date")
    private LocalDate date;

    private String codigoFactura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer")  //Foreign key que une con la entidad que se va a relacionar
    private Customer invoiceToCustomer;
}
