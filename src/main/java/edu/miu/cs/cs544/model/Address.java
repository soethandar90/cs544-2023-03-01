package edu.miu.cs.cs544.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "[AdventureWorksLT2019].[SalesLT].[Address]")
public class Address {
	
	@Id
	@Column(name = "[AddressID]")
	private Integer id;
	
	@Column(name = "[AddressLine1]")
	private String address1;

	@Column(name = "[AddressLine2]")
	private String address2;

	@Column(name = "[City]")
	private String city;

	@Column(name = "[StateProvince]")
	private String stateProvince;

	@Column(name = "[CountryRegion]")
	private String countryRegion;

	@Column(name = "[PostalCode]")
	private String postalCode;

	@Column(name = "[rowguid]", unique = true)
	private String rowGUID;

	@Column(name = "[ModifiedDate]")
	private LocalDate modifiedDate;

}
