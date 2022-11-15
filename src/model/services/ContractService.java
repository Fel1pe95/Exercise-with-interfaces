package model.services;

import java.time.LocalDate;

import model.entitites.Contract;
import model.entitites.Installment;

public class ContractService {

	
	
	private OnlinePaymentService paymentService;

	public ContractService(OnlinePaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}

	public OnlinePaymentService getPaymentService() {
		return paymentService;
	}

	public void setPaymentService(OnlinePaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void processContract(Contract contract, Integer months) {
		
		Double amount = contract.getTotalValue()/months;
		
		for(int i = 1; i <= months; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			Double insta = amount + paymentService.interest(amount, i);
			Double finalAmount = insta + paymentService.paymentFee(insta);
			
			Installment installment = new Installment(dueDate, finalAmount);
			contract.getList().add(installment);
			
		}
		
		
	}
	
}
