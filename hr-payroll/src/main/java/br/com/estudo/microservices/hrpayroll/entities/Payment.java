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
public class Payment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private String name;
	private Double dailyIncome;
	private Integer days;
	
	public double getTotal() {
		return dailyIncome * days;
	}
}
