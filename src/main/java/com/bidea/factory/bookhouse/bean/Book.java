package com.bidea.factory.bookhouse.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="book")
public class Book {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String lastname;
    private BigDecimal age;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="start_date")
    private LocalDate startDate;
    @Column(name="end_date")
    private LocalDate endDate;
    @Column(name="house_id")
    private String houseId;
    @Column(name="discount_code")
    private String discountCode;
}
