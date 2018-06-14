package br.com.resteasy.app.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.resteasy.app.formatter.CEPFormat;
import br.com.resteasy.app.formatter.CNPJFormat;
import br.com.resteasy.app.formatter.PhoneFormat;
import br.com.resteasy.app.interfaces.IDto;

@Document(collection="companies")
public class Company extends BaseEntity implements IDto {

	private static final long serialVersionUID = 1381082489932184470L;
	
	@NotNull
	@Size(min=3, max=200)
	private String fantasia;
	@NotNull
	@Size(min=3, max=200)
	private String razaoSocial;
	
	@NotNull
	@CNPJFormat
	private Long cnpj;

	@PhoneFormat
	private Integer telefone;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	
	@CEPFormat
	private Integer cep;
	private String pais;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	private Date dataAbertura;

//	@Transient
//	private String strCnpj;

	public Company() {
		
	}
	
	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public Long getCnpj() {
		return cnpj;
	}

	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

//	public String getStrCnpj() {
//		if (cnpj != null) {
//			strCnpj = String.valueOf(cnpj);
//		}
//		return strCnpj;
//	}
//
//	public void setStrCnpj(String strCnpj) {
//		this.strCnpj = strCnpj;
//		
//		if (strCnpj!= null && !strCnpj.equals("")) {
//            String s = strCnpj.replaceAll("\\.", "").replaceAll("\\-", "").replaceAll("/", "");
//			setCnpj( Long.parseLong( s ) );
//            
//		}
//
//	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}



}
