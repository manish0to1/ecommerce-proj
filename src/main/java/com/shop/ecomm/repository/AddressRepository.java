package com.shop.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.ecomm.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
