package entities;

public class PessoaJuridica extends Pessoa{
	private Integer numero_de_funcionarios;

	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, Double renda_anual, Integer numero_de_funcionarios) {
		super(nome, renda_anual);
		this.numero_de_funcionarios = numero_de_funcionarios;
	}

	public Integer getNumero_de_funcionarios() {
		return numero_de_funcionarios;
	}

	public void setNumero_de_funcionarios(Integer numero_de_funcionarios) {
		this.numero_de_funcionarios = numero_de_funcionarios;
	}
	
	@Override
	public double imposto() {
		if (numero_de_funcionarios <= 10) {
			return (getRenda_anual() * 0.16);
		}else {
			return (getRenda_anual() * 0.14);
		}
	}
}
