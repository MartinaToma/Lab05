package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	List<String> elencoAnagrammi;
	AnagrammaDAO dao=new AnagrammaDAO();
	
	
	public List<String> calcola(String parola) {
		String parziale="";
		elencoAnagrammi=new LinkedList<String>();
		calcola(parola,0,parziale,elencoAnagrammi);
		
		return this.elencoAnagrammi;		
	}

	
	private void calcola(String parola,int livello, String parziale,List<String> elencoAnagrammi) {
		//passo la parola di cui fare l'anagramma, il livello per capire a che punto sono
		//il parziale per costruire l'anagramma e l'elenco degli anagrammi fatti per evitare di fare dei doppioni
		
		if(livello==parola.length()) {
			//vuol dire che ho permutato tutte le lettere della parola e ho ottenuto l'anagramma
			
			if(!elencoAnagrammi.contains(parziale)) {
				//vuol dire che l'anagramma che ho ottenuto non è un doppione
				//e quindi ho aggiunto all'elenco degli anagrammi
				// MA ATTENZIONEAGGIUNGO IL CLONE
				String clone= new String(parziale);
				elencoAnagrammi.add(clone);
			}
			//ho terminato quel livello,sono apposto, esco
			return;
			
		}
		
		//se non ho permutato tutte le lettere devo continuare a costruire l'anagramma
		for(int i=0;i<parola.length();i++) {
			//aggiungo all'anagramma che sto costruendo le lettere della parola di partenza,
			//controllando di non aggiungere più volte la stessa lettera, ammesse solo le doppie
			// e quindi devo contarle
			char c=parola.charAt(i);
			if(conta(c,parola)>conta(c,parziale)) {
				//non l'ho ancora aggiunta e quindi l'aggiungo
				parziale+=c;
				//ora passo al livello successivo
				this.calcola(parola, livello+1, parziale, elencoAnagrammi);
				//devo fare il BACKTRACKING
				
				parziale=parziale.substring(0, parziale.length()-1);
				
			}			
		}
		
		
	}
	
	
	public int conta(char c , String s) {
		int tot=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==c)
				tot++;
		}
		return tot;
	}
	
	
	public boolean isCorrect(String a) {
		boolean flag=false;
		flag=dao.dimmiSeCorretta(a);
		
		return flag;
	}

}
