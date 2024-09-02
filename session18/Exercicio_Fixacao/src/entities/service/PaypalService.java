package entities.service;

public class PaypalService implements OnlinePaymentService{

	@Override
	public Double paymentFee(double amount) {
		return amount * 1.02;
	}

	@Override
	public Double interest(double amount, int months) {
		double perc = 0.01*months;
		return amount * (1+perc);
	}

	
}
