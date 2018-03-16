package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sessao {
	@Id
	@GeneratedValue
	private	Integer	id;
	private	LocalTime	horario;
	@ManyToOne
	private	Sala	sala;
	@ManyToOne
	private	Filme	filme;
	
	@OneToMany(mappedBy	=	"sessao",	fetch	=	FetchType.EAGER)
	private	Set<Ingresso>	ingressos	=	new	HashSet<>();
	
	private	BigDecimal	preco;
	/**
	*	@deprecated	hibernate	only
	*/
	public	Sessao()	{
	}
	public	Sessao(LocalTime	horario,	Filme	filme,	Sala	sala)	{
					this.setHorario(horario);
					this.filme	=	filme;
					this.sala	=	sala;
					this.preco	=	sala.getPreco().add(filme.getPreco());
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public Filme getFilme() {
		// TODO Auto-generated method stub
		return this.filme;
	}
	public Sala getSala() {
		// TODO Auto-generated method stub
		return this.sala;
	}
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		this.id = id;
	}
	
	public Integer getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public	Map<String,	List<Lugar>>	getMapaDeLugares(){
		return	sala.getMapaDeLugares();
	}
	
	public	boolean	isDisponivel(Lugar	lugarSelecionado)	{
		return	ingressos.stream().map(Ingresso::getLugar).noneMatch(lugar	->	lugar.equals(lugarSelecionado));
}
	
}
	