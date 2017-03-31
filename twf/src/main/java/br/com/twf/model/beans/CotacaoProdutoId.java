package br.com.twf.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CotacaoProdutoId implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
    private long fornecedor;
	private long produto;
 
    public CotacaoProdutoId() {}
                  
    public CotacaoProdutoId(long fornecedor, long produto) {
		this.fornecedor = fornecedor;
		this.produto = produto;
	}

    public long getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(int fornecedor) {
		this.fornecedor = fornecedor;
	}

	public long getProduto() {
		return produto;
	}

	public void setProduto(int produto) {
		this.produto = produto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (fornecedor ^ (fornecedor >>> 32));
		result = prime * result + (int) (produto ^ (produto >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CotacaoProdutoId other = (CotacaoProdutoId) obj;
		if (fornecedor != other.fornecedor)
			return false;
		if (produto != other.produto)
			return false;
		return true;
	}
	
	
	
//	@Override
//    public int hashCode() {
//        return (int)fornecedor + (int)produto;
//    }
//	
//	@Override
//	public boolean equals(Object obj) {
//	  if(obj instanceof CotacaoProdutoId){
//	      	CotacaoProdutoId cotacaoProdutoId = (CotacaoProdutoId) obj;
//	        return cotacaoProdutoId.fornecedor == fornecedor && cotacaoProdutoId.produto == produto;
//	  }
//	  return false;
//	}
//	
		
}
