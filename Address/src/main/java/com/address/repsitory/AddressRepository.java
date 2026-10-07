package com.address.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.address.model.entity.Address;

public interface AddressRepository extends JpaRepository<Address , Long>{

}
