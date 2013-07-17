package br.ufpi.tcc.pso.base;

/**
 * 
 * @author Werney Ayala
 *
 */
public class Possibilidade {

	private double probabilidade;
	private boolean valor;
	
	public Possibilidade(){}
	
	public Possibilidade(double probabilidade, boolean valor){
		this.probabilidade = probabilidade;
		this.valor = valor;
	}
	
	/**
	 * @return probabilidade
	 */
	public double getProbabilidade() {
		return probabilidade;
	}
	/**
	 * @param probabilidade O valor de probabilidade que será setado
	 */
	public void setProbabilidade(double probabilidade) {
		this.probabilidade = probabilidade;
	}
	/**
	 * @return valor
	 */
	public boolean getValor() {
		return valor;
	}
	/**
	 * @param valor O valor que será setado
	 */
	public void setValor(boolean valor) {
		this.valor = valor;
	}
	
	/**
	 * Compare two possibilities
	 * @param possibilidade Possibilidade que será comparada
	 * @return true se for igual
	 */
	public boolean equals(Possibilidade possibilidade){
		return valor == possibilidade.getValor();
	}

}
