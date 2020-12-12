package com.cenfotec.examen3Graphql.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode
@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "last", nullable = false)
	private String last;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "cardNumber", nullable = false)
	private String cardNumber;	
	
	@Column(name = "monthNumber", nullable = false)
	private String monthNumber;
	
	@Column(name = "yearNumber", nullable = false)
	private String yearNumber;

	
}
