package br.ufpi.tcc.pso.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Werney Ayala
 *
 */
public class Velocidade {
	
	private HashMap<Integer, List<Possibilidade>> velocidade;
	
	public Velocidade(){
		this.velocidade = new HashMap<>();
	}

	/**
	 * @return velocidade
	 */
	public HashMap<Integer, List<Possibilidade>> getVelocidade() {
		return velocidade;
	}

	/**
	 * @param velocidade A velocidade que será setada
	 */
	public void setVelocidade(HashMap<Integer, List<Possibilidade>> velocidade) {
		this.velocidade = velocidade;
	}
	
	/**
	 * A lista de possibilidades da dimensão
	 * @param dim
	 * @return
	 */
	public List<Possibilidade> getVelocidadeDim(int dim){
		return velocidade.get(dim);
	}
	
	/**
	 * Altera uma lista de possibilidades de uma dimensão
	 * @param dim
	 * @param possibilidades
	 */
	public void setVelocidadeDim(int dim, List<Possibilidade> possibilidades){
		velocidade.put(dim, possibilidades);
	}
	
	/**
	 * Adiciona uma possibilidade em uma dimensão
	 * @param dim
	 * @param possibilidade
	 */
	public void addVelocidadeDim(int dim, Possibilidade possibilidade) {
		if(velocidade.get(dim) == null)
			velocidade.put(dim, new ArrayList<Possibilidade>());
		velocidade.get(dim).add(possibilidade);
	}
}
