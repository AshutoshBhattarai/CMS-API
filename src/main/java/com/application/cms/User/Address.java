package com.application.cms.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity
//@Table(name = "address")
public class Address {

//    @Id
//    @GeneratedValue
    Long address_id;
    String zipCode;
    String city;
    String state;




}
