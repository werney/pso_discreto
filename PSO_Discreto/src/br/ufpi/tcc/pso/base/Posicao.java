package br.ufpi.tcc.pso.base;

/**
 * 
 * @author Werney Ayala
 *
 */
public class Posicao {
	
	private boolean[] posicao;
	
	/**
	 * Construtor
	 * @param dimensao
	 */
	public Posicao(int dimensao){
		this.posicao = new boolean[dimensao];
		for(int i = 0; i < dimensao; i++){
			if(Math.random() < 0.5)
				this.posicao[i] = true;
			else
				this.posicao[i] = false;
		}
	}
	
	/**
	 * @return Posição
	 */
	public boolean[] getPosicao(){
		return posicao;
	}
	
	/**
	 * @param posicao O valor de posição que será setado
	 */
	public void setPosicao(boolean[] posicao){
		this.posicao = posicao;
	}
	
	/**
	 * @param posicao A posição que será alterado
	 * @param valor O valor que será setado
	 */
	public void setPosicao(int posicao, boolean valor){
			this.posicao[posicao] = valor;
	}
	
}
