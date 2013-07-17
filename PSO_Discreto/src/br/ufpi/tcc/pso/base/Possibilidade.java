package br.ufpi.tcc.pso.base;

public class Possibilidade {

	private double probabilidade;
	private boolean valor;
	
	public Possibilidade(){}
	
	public Possibilidade(double probabilidade, boolean valor){
		this.probabilidade = probabilidade;
		this.valor = valor;
	}
	
	/**
	 * @return the probabilidade
	 */
	public double getProbabilidade() {
		return probabilidade;
	}
	/**
	 * @param probabilidade the probabilidade to set
	 */
	public void setProbabilidade(double probabilidade) {
		this.probabilidade = probabilidade;
	}
	/**
	 * @return the valor
	 */
	public boolean getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(boolean valor) {
		this.valor = valor;
	}
	
	public boolean equals(Possibilidade possibilidade){
		return valor == possibilidade.getValor();
	}

}
