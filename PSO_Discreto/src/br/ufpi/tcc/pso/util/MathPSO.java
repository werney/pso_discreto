package br.ufpi.tcc.pso.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.ufpi.tcc.pso.base.Posicao;
import br.ufpi.tcc.pso.base.Possibilidade;

/**
 * 
 * @author Werney Ayala
 *
 */
public class MathPSO {
	
	/**
	 * Operação de subtração entre duas posições
	 * @param posicao1 Posição
	 * @param posicao2 Posição
	 * @return
	 */
	public static HashMap<Integer, List<Possibilidade>> sub(Posicao posicao1, Posicao posicao2){
		HashMap<Integer, List<Possibilidade>> possibilidades = new HashMap<>();
		for(int i = 0; i<posicao1.getPosicao().length; i++){
			if(posicao1.getPosicao()[i] != posicao2.getPosicao()[2]){
				if(possibilidades.get(i) == null)
					possibilidades.put(i, new ArrayList<Possibilidade>());
				possibilidades.get(i).add(new Possibilidade(1.0,posicao1.getPosicao()[i]));
			}
		}
		return possibilidades;
	}
	
	/**
	 * Operação de multiplicação entre um coeficiente e uma lista de possibilidades
	 * @param coeficiente Coeficiente
	 * @param possibilidades Lista de possibilidades
	 * @return
	 */
	public static HashMap<Integer, List<Possibilidade>> mul(double coeficiente, HashMap<Integer, List<Possibilidade>> possibilidades){
		for(int temp : possibilidades.keySet()){
			for(Possibilidade possibilidade : possibilidades.get(temp)){
				double probabilidade = coeficiente * possibilidade.getProbabilidade();
				if(probabilidade > 1.0)
					possibilidade.setProbabilidade(1.0);
				else
					possibilidade.setProbabilidade(probabilidade);
			}
		}
		return possibilidades;
	}
	
	/**
	 * Operação de soma entre duas listas de possibilidades
	 * @param size Dimensão da particula 
	 * @param possibilidades1 Lista de possibilidades
	 * @param possibilidades2 Lista de possibilidades
	 * @return
	 */
	public static HashMap<Integer, List<Possibilidade>> sum(int size, HashMap<Integer, List<Possibilidade>> possibilidades1, HashMap<Integer, List<Possibilidade>> possibilidades2){
		HashMap<Integer, List<Possibilidade>> retorno = new HashMap<>();
		for(int i = 0; i < size; i++){
			List<Possibilidade> listPossibilidadesDim1 = possibilidades1.get(i);
			List<Possibilidade> listPossibilidadesDim2 = possibilidades1.get(i);
			
			if((listPossibilidadesDim1 == null)&&(listPossibilidadesDim2 == null)){
				continue;
			} else if((listPossibilidadesDim1 != null)&&(listPossibilidadesDim2 != null)){
				retorno.put(i, listPossibilidadesDim1);
				for(Possibilidade pos : listPossibilidadesDim2)
					addPossibilidade(retorno.get(i), pos);
			} else {
				if(listPossibilidadesDim1 == null)
					retorno.put(i, listPossibilidadesDim2);
				else
					retorno.put(i, listPossibilidadesDim1);
			}
		}
		return retorno;
	}
	
	/**
	 * Operação de soma entre uma posição e uma lista de possibilidades
	 * @param posicao Posição
	 * @param possibilidades Lista de possibilidades
	 * @return
	 */
	public static Posicao sum(Posicao posicao, HashMap<Integer, List<Possibilidade>> possibilidades){
		for(int temp : possibilidades.keySet()){
			for(Possibilidade possibilidade : possibilidades.get(temp)){
				if(Math.random() < possibilidade.getProbabilidade())
					posicao.setPosicao(temp, possibilidade.getValor());
			}
		}
		return posicao;
	}
	
	/**
	 * Adiciona uma possibilidade à uma lista de possibilidades
	 * Caso exista uma possibilidade com o mesmo valor, o maior valor é o que fica
	 * @param possibilidades Lista de possibilidades
	 * @param possibilidade Possibilidade
	 * @return
	 */
	private static List<Possibilidade> addPossibilidade(List<Possibilidade> possibilidades, Possibilidade possibilidade){
		boolean inseriu = false;
		
		for(Possibilidade temp : possibilidades){
			if(temp.equals(possibilidade)){
				temp = new Possibilidade(Math.max(temp.getProbabilidade(), possibilidade.getProbabilidade()), temp.getValor());
				inseriu = true;
			}
		}
		
		if(!inseriu)
			possibilidades.add(possibilidade);
		
		return possibilidades;
	}

}
