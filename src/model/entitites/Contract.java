package model.entitites;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {

	private Integer number;
	private LocalDate date;
	private Double totalValue;

	List<Installment> list = new ArrayList<>();

	public Contract(Integer number, LocalDate date, Double totalValue) {
		super();
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public List<Installment> getList() {
		return list;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
	
		for (Installment inst : list) {
			sb.append(inst.getDueDate());
			sb.append(String.format("%.2f", inst.getAmount()) + "\n");
		}

		return sb.toString();

	}

}
