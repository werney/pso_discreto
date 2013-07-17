package br.ufpi.tcc.pso.base;

public class Posicao {
	
	private boolean[] posicao;
	
	public Posicao(int dimensao){
		this.posicao = new boolean[dimensao];
		for(int i = 0; i < dimensao; i++){
			if(Math.random() < 0.5)
				this.posicao[i] = true;
			else
				this.posicao[i] = false;
		}
	}
	
	public boolean[] getPosicao(){
		return posicao;
	}
	
	public void setPosicao(boolean[] posicao){
		this.posicao = posicao;
	}
	
	public void setPosicao(int posicao, boolean valor){
			this.posicao[posicao] = valor;
	}
	
}
