package entities;

public class PessoaFisica extends Pessoa{
	private Double gastos_com_saude;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Double renda_anual, Double gastos_com_saude) {
		super(nome, renda_anual);
		this.gastos_com_saude = gastos_com_saude;
	}

	public Double getGastos_com_saude() {
		return gastos_com_saude;
	}

	public void setGastos_com_saude(Double gastos_com_saude) {
		this.gastos_com_saude = gastos_com_saude;
	}
	
	@Override
	public double imposto() {
		if (getRenda_anual() < 20000) {
			return (getRenda_anual() * 0.15) - (getGastos_com_saude() > 0 ? getGastos_com_saude()/2 : 0);
		}else {
			return (getRenda_anual() * 0.25) - (getGastos_com_saude() > 0 ? getGastos_com_saude()/2 : 0);
		}
	}

}
