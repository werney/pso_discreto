package br.ufpi.tcc.pso.base;

import java.util.HashMap;
import java.util.List;

import br.ufpi.tcc.pso.util.MathPSO;

public class Particula {
	
	private int dimensao;
	private Posicao pBest;
	private Posicao posicao;
	private Velocidade velocidade;
	private double fitness;
	
	public Particula(int dimensao){
		this.posicao = new Posicao(dimensao);
		this.velocidade = new Velocidade(dimensao);
		this.pBest = this.posicao;
	}
	
	// TODO definir uma função de avaliação
	public void avaliar(){
		this.fitness = ;
		double bestFit = ;
		// TODO Apenas para minimização =/
		if(fitness < bestFit)
			this.pBest = this.posicao;
	}
	
	public void atualizar(double w, double c1, double c2, Posicao gBest){ 
				
		HashMap<Integer, List<Possibilidade>> wXvel = MathPSO.mul(w, velocidade.getVelocidade()); 
		HashMap<Integer, List<Possibilidade>> c1Xr1XpBest_p = MathPSO.mul(c1 * Math.random(), MathPSO.sub(pBest, posicao)); 
		HashMap<Integer, List<Possibilidade>> c2Xr2XgBest_p = MathPSO.mul(c2 * Math.random(), MathPSO.sub(gBest, posicao));
		
		HashMap<Integer, List<Possibilidade>> novaVelocidade = MathPSO.sum(dimensao, c1Xr1XpBest_p, c2Xr2XgBest_p);
		novaVelocidade = MathPSO.sum(dimensao, wXvel, novaVelocidade);
		
		posicao = MathPSO.sum(posicao, novaVelocidade);
	}

	/**
	 * @return the pBest
	 */
	public Posicao getpBest() {
		return pBest;
	}

	/**
	 * @param pBest the pBest to set
	 */
	public void setpBest(Posicao pBest) {
		this.pBest = pBest;
	}

	/**
	 * @return the posicao
	 */
	public Posicao getPosicao() {
		return posicao;
	}

	/**
	 * @param posicao the posicao to set
	 */
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	/**
	 * @return the velocidade
	 */
	public Velocidade getVelocidade() {
		return velocidade;
	}

	/**
	 * @param velocidade the velocidade to set
	 */
	public void setVelocidade(Velocidade velocidade) {
		this.velocidade = velocidade;
	}

	/**
	 * @return the fitness
	 */
	public double getFitness() {
		return fitness;
	}

	/**
	 * @param fitness the fitness to set
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

}
