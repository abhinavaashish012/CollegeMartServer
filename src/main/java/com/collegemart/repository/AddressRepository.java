package com.collegemart.repository;

import com.collegemart.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    public Long getPincodeByAddressId(Long addressId);

    public String getCityByAddressId(Long addressId);

    public String getStreetByAddressId(Long addressId);
}
