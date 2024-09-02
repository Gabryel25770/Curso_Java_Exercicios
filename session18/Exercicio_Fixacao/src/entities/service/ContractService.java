package entities.service;

import java.util.Calendar;
import java.util.Date;

import entities.domain.Contract;
import entities.domain.Installement;

public class ContractService {	
	private OnlinePaymentService paymenteService;
	
	public ContractService(OnlinePaymentService paymenteService) {
		this.paymenteService = paymenteService;
	}
	
	
	public void processContract(Contract contract, int months) {
		for(int i = 1; i <= months; i++) {
			double value = paymenteService.interest((contract.getTotalValue()/months), i);
			value = paymenteService.paymentFee(value);
			Calendar cal = Calendar.getInstance();
			cal.setTime(contract.getDate());
			cal.add(Calendar.MONTH, i);
			Date newDate = cal.getTime();
			
			Installement installment = new Installement(newDate, value);
			contract.addList(installment);		
		}
	}
}
