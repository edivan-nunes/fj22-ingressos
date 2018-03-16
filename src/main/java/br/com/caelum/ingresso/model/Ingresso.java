package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.model.descontos.Desconto;

@Entity
public class Ingresso {
	@Id
	@GeneratedValue
	private	Integer	id;
	
	@ManyToOne
	private	Sessao	sessao;
	
	@ManyToOne
	private Lugar lugar;
	
	private	BigDecimal	preco;
	private TipoDeIngresso tipoDeIngresso;
	/**
	*	@deprecated	hibernate	only
	*/
	public	Ingresso(){
	}
	
	public	Ingresso(Sessao	sessao,	Desconto	tipoDeDesconto)	{
					this.sessao	=	sessao;
					this.preco	=	tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());
	}
	public	Sessao	getSessao()	{
					return	sessao;
	}
	public void setSessao(Sessao sessao){
		this.sessao = sessao;
	}
	
	public	BigDecimal	getPreco()	{
					return	preco;
	}
	public void setPreco(BigDecimal preco){
		this.preco=preco;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}

}
