package com.vivekkumar.projects.airBnbApp.entity;

import com.vivekkumar.projects.airBnbApp.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String transactionId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.LAZY)
    private Booking booking;
}
