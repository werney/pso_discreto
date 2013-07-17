package br.ufpi.tcc.pso.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Velocidade {
	
	private HashMap<Integer, List<Possibilidade>> velocidade;
	
	public Velocidade(){
		this.velocidade = new HashMap<>();
	}

	/**
	 * @return the velocidade
	 */
	public HashMap<Integer, List<Possibilidade>> getVelocidade() {
		return velocidade;
	}

	/**
	 * @param velocidade the velocidade to set
	 */
	public void setVelocidade(HashMap<Integer, List<Possibilidade>> velocidade) {
		this.velocidade = velocidade;
	}
	
	public List<Possibilidade> getVelocidadeDim(int dim){
		return velocidade.get(dim);
	}
	
	public void setVelocidadeDim(int dim, List<Possibilidade> possibilidades){
		velocidade.put(dim, possibilidades);
	}
	
	public void addVelocidadeDim(int dim, Possibilidade possibilidade) {
		if(velocidade.get(dim) == null)
			velocidade.put(dim, new ArrayList<Possibilidade>());
		velocidade.get(dim).add(possibilidade);
	}
}
