package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.entitites.Contract;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		System.out.println("Entre com os dados do contrato: ");
		System.out.print("Numero: ");
		Integer number= sc.nextInt();
		System.out.println("Data: ");
		LocalDate date =LocalDate.parse(sc.next(), fmt);
		System.out.print("Valor do contrato: ");
		Double totalValue = sc.nextDouble();
		System.out.print("Numero de parcelas: ");
		Integer installments = sc.nextInt();
		
		Contract contract = new Contract(number, date, totalValue);
		ContractService service = new ContractService(new PaypalService());
		service.processContract(contract, installments);
		
		System.out.println(contract.toString());

		
		
		
		
		sc.close();

	}

}
