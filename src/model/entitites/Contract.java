package model.entitites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

	private Integer number;
	private Date date;

	List<Installment> list = new ArrayList<>();

	public Contract(Integer number, Date date) {
		super();
		this.number = number;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double totalValue() {
		return null;
	}

}
