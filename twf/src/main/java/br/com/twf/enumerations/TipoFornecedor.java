package br.com.twf.enumerations;

public enum TipoFornecedor {
	Loja_Fisica,
	Site;	
	
	public String getDescricao() {
	    switch(this) {
	      	case Loja_Fisica: return "Loja Física";
	   		case Site: return "Site";
	   		default :  return "";
	    }
	}
	
}
