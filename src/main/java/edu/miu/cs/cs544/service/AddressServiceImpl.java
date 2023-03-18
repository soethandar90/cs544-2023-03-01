package edu.miu.cs.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.model.Address;
import edu.miu.cs.cs544.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository repository;

	@Override
	public List<Address> findAll() {
		return repository.findAll();
	}

}
