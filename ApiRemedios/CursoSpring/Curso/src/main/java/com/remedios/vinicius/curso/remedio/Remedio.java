package com.remedios.vinicius.curso.remedio;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "remedios")
@Table(name = "Remedio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

	public Remedio(DadosCadastroRemedio dados) {
		this.ativo = true;
	//	this.setAtivo(true);
		this.nome=dados.nome();
		this.via=dados.via();
		this.lote = dados.lote();
		this.quantidade= dados.quantidade();
		this.validade = dados.validade();
		this.laboratorio=dados.laboratorio();
	}

	public Remedio() {
    }
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private via via;
	private String lote;
	private int quantidade;
	private LocalDate validade;
	
	@Enumerated(EnumType.STRING)
	private Laboratorio laboratorio;
	
	
	private Boolean ativo;
	
	
	// =============GETTER AND SETTER==========================
	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}


	public via getVia() {
		return via;
	}
	
	public void setVia(via via) {
		this.via = via;
	}
	
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	//==============================================================================
	
	public void atualizarInformaceos(@Valid DadosAtualizarRemedio dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		
		if (dados.via()!= null) {
			this.via = dados.via();
		}
		
		if(dados.laboratorio() != null) {
			this.laboratorio = dados.laboratorio();
		}
		
	}

	public void inativar() {
		this.ativo = false;
	}

	public void reativar() {
		this.ativo = true;
	}
	
}
