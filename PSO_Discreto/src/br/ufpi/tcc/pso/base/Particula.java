package br.ufpi.tcc.pso.base;

import java.util.HashMap;
import java.util.List;

import br.ufpi.tcc.pso.util.MathPSO;

/**
 * 
 * @author Werney Ayala
 *
 */
public class Particula {
	
	private int dimensao;
	private Posicao pBest;
	private Posicao posicao;
	private Velocidade velocidade;
	private double fitness;
	
	/**
	 * Contrutor
	 * @param dimensao Dimensão
	 */
	public Particula(int dimensao){
		this.posicao = new Posicao(dimensao);
		this.velocidade = new Velocidade();
		this.pBest = this.posicao;
	}
	
	/**
	 * Função de avaliação
	 */
	// TODO definir uma função de avaliação
	public void avaliar(){
		this.fitness = ;
		double bestFit = ;
		// TODO Apenas para minimização =/
		if(fitness < bestFit)
			this.pBest = this.posicao;
	}
	
	/**
	 * Atualiza a posição da particula
	 * @param w Inercia
	 * @param c1 Constante cognitiva
	 * @param c2 Constante social
	 * @param gBest Melhor solução
	 */
	public void atualizar(double w, double c1, double c2, Posicao gBest){ 
				
		HashMap<Integer, List<Possibilidade>> wXvel = MathPSO.mul(w, velocidade.getVelocidade()); 
		HashMap<Integer, List<Possibilidade>> c1Xr1XpBest_p = MathPSO.mul(c1 * Math.random(), MathPSO.sub(pBest, posicao)); 
		HashMap<Integer, List<Possibilidade>> c2Xr2XgBest_p = MathPSO.mul(c2 * Math.random(), MathPSO.sub(gBest, posicao));
		
		HashMap<Integer, List<Possibilidade>> novaVelocidade = MathPSO.sum(dimensao, c1Xr1XpBest_p, c2Xr2XgBest_p);
		novaVelocidade = MathPSO.sum(dimensao, wXvel, novaVelocidade);
		
		posicao = MathPSO.sum(posicao, novaVelocidade);
	}

	/**
	 * @return Melhor posicao da particula
	 */
	public Posicao getpBest() {
		return pBest;
	}

	/**
	 * @param pBest A melhor posicao da particula que será setada
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
	 * @param posicao A posicao que será setada
	 */
	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	/**
	 * @return velocidade
	 */
	public Velocidade getVelocidade() {
		return velocidade;
	}

	/**
	 * @param velocidade A velocidade que será setada
	 */
	public void setVelocidade(Velocidade velocidade) {
		this.velocidade = velocidade;
	}

	/**
	 * @return fitness
	 */
	public double getFitness() {
		return fitness;
	}

	/**
	 * @param fitness O valor de fitness que será setado
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

}
