package edu.miu.cs.cs544.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.miu.cs.cs544.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
