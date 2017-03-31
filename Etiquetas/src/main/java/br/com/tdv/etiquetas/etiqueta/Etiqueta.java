package br.com.tdv.etiquetas.etiqueta;

/**
 * @author Felipe Santaniello
 * @data 14/01/2016
 * 
 */
public class Etiqueta {
	private String codigoBarra;
	private String descricaoCodigoBarra;
	private String cnpj;
	private String armazem;
	private String embalagem;
	private String po;
	private String peso;
	private String remetente;
	private String usuario;
	private String notaFiscal;

	public Etiqueta() {
	}

	public Etiqueta(String codigoBarra, String descricaoCodigoBarra, String cnpj, String armazem, String embalagem,
			String po, String peso, String remetente, String usuario, String notaFiscal) {
		this.codigoBarra = codigoBarra;
		this.descricaoCodigoBarra = descricaoCodigoBarra;
		this.cnpj = cnpj;
		this.armazem = armazem;
		this.embalagem = embalagem;
		this.po = po;
		this.peso = peso;
		this.remetente = remetente;
		this.usuario = usuario;
		this.notaFiscal = notaFiscal;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getDescricaoCodigoBarra() {
		return descricaoCodigoBarra;
	}

	public void setDescricaoCodigoBarra(String descricaoCodigoBarra) {
		this.descricaoCodigoBarra = descricaoCodigoBarra;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getArmazem() {
		return armazem;
	}

	public void setArmazem(String armazem) {
		this.armazem = armazem;
	}

	public String getEmbalagem() {
		return embalagem;
	}

	public void setEmbalagem(String embalagem) {
		this.embalagem = embalagem;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	@Override
	public String toString() {
		return "Etiqueta [codigoBarra=" + codigoBarra + ", descricaoCodigoBarra=" + descricaoCodigoBarra + ", cnpj="
				+ cnpj + ", armazem=" + armazem + ", embalagem=" + embalagem + ", po=" + po + ", peso=" + peso
				+ ", remetente=" + remetente + ", usuario=" + usuario + ", notaFiscal=" + notaFiscal + "]";
	}

}
