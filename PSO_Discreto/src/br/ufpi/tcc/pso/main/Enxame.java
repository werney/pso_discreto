package br.ufpi.tcc.pso.main;

import br.ufpi.tcc.pso.base.Particula;
import br.ufpi.tcc.pso.base.Posicao;
import br.ufpi.tcc.pso.base.Velocidade;

public class Enxame {
	
	private double melhorFitness;
	private Posicao gBest;
	private Particula[] enxame;
	
	private int dimParticula;
	private int numParticulas;
	private int numAvaliacoes;
	
	private double w;
	private double c1;
	private double c2;
	private double r1;
	private double r2;
	
	public Enxame(){}
	
	public Enxame(int dimParticula, int numParticulas, int numAvaliacoes, 
			double w, double c1, double c2){
		this.dimParticula = dimParticula;
		this.numAvaliacoes = numAvaliacoes;
		this.numParticulas = numParticulas;
		this.c1 = c1;
		this.c2 = c2;
		this.w = w;
		this.r1 = Math.random(); // TODO REVER
		this.r2 = Math.random(); // TODO REVER
	}
	
	private void init(){
		
		this.melhorFitness = Double.MAX_VALUE; // TODO Apenas para minimização
		
		Velocidade velocidade = new Velocidade();
		enxame = new Particula[numParticulas];
		for(int i = 0; i < enxame.length; i++){
			enxame[i] = new Particula(dimParticula);
			enxame[i].setVelocidade(velocidade);
		}
		
	}
	
	public void executar(){
		
		init();
		
		for(int i = 0; i < numAvaliacoes; i++){
			
			for(int j = 0; j < numParticulas; j++){
				enxame[j].avaliar();
				/* TODO Apenas para minimização */
				if(enxame[j].getFitness() > melhorFitness){
					melhorFitness = enxame[j].getFitness();
					gBest = enxame[j].getPosicao();
				}
				enxame[j].atualizar(w, c1, c2, gBest);
			}
			
		}
		
	}
	
	/**
	 * @return the melhorFitness
	 */
	public double getMelhorFitness() {
		return melhorFitness;
	}
	
	/**
	 * @param melhorFitness the melhorFitness to set
	 */
	public void setMelhorFitness(double melhorFitness) {
		this.melhorFitness = melhorFitness;
	}
	
	/**
	 * @return the melhorPosicao
	 */
	public Posicao getMelhorPosicao() {
		return gBest;
	}
	
	/**
	 * @param melhorPosicao the melhorPosicao to set
	 */
	public void setMelhorPosicao(Posicao melhorPosicao) {
		this.gBest = melhorPosicao;
	}
	
	/**
	 * @return the enxame
	 */
	public Particula[] getEnxame() {
		return enxame;
	}
	
	/**
	 * @param enxame the enxame to set
	 */
	public void setEnxame(Particula[] enxame) {
		this.enxame = enxame;
	}
	
	/**
	 * @return the numParticula
	 */
	public int getNumParticulas() {
		return numParticulas;
	}
	
	/**
	 * @param numParticula the numParticula to set
	 */
	public void setNumParticulas(int numParticula) {
		this.numParticulas = numParticula;
	}
	
	/**
	 * @return the numAvaliacoes
	 */
	public int getNumAvaliacoes() {
		return numAvaliacoes;
	}
	
	/**
	 * @param numAvaliacoes the numAvaliacoes to set
	 */
	public void setNumAvaliacoes(int numAvaliacoes) {
		this.numAvaliacoes = numAvaliacoes;
	}
	
	/**
	 * @return the inertia
	 */
	public double getW() {
		return w;
	}
	
	/**
	 * @param inertia the inertia to set
	 */
	public void setW(double inertia) {
		this.w = inertia;
	}
	
	/**
	 * @return the c1
	 */
	public double getC1() {
		return c1;
	}
	
	/**
	 * @param c1 the c1 to set
	 */
	public void setC1(double c1) {
		this.c1 = c1;
	}
	
	/**
	 * @return the c2
	 */
	public double getC2() {
		return c2;
	}
	
	/**
	 * @param c2 the c2 to set
	 */
	public void setC2(double c2) {
		this.c2 = c2;
	}
	
	/**
	 * @return the r1
	 */
	public double getR1() {
		return r1;
	}

	/**
	 * @param r1 the r1 to set
	 */
	public void setR1(double r1) {
		this.r1 = r1;
	}

	/**
	 * @return the r2
	 */
	public double getR2() {
		return r2;
	}

	/**
	 * @param r2 the r2 to set
	 */
	public void setR2(double r2) {
		this.r2 = r2;
	}

	/**
	 * @return the dimParticula
	 */
	public int getDimParticula() {
		return dimParticula;
	}

	/**
	 * @param dimParticula the dimParticula to set
	 */
	public void setDimParticula(int dimParticula) {
		this.dimParticula = dimParticula;
	}
	
}
