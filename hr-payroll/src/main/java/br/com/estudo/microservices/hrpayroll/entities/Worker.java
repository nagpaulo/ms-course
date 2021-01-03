package br.com.estudo.microservices.hrpayroll.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Worker implements Serializable {

	private static final long serialVersionUID = -3111999352639457886L;
	
	private Long id;
	private String name;
	private Double dailyIncome;

}
