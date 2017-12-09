package br.com.cyborg.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.cyborg.bean.AplicationBean;
import br.com.cyborg.entity.Pessoa;
import br.com.cyborg.enums.PessoaType;

@Stateless(name = "pessoaDao")
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
@Transactional
public class PessoaDao implements Serializable {
		
	private static final long serialVersionUID = -7554544054833587985L;
	
	@Inject
	private AplicationBean aplicationBean;
	
	public List<Pessoa> getAll(){
		
		return aplicationBean.getPessoas();
	}
	
	public List<Pessoa> getPessoaTypes(PessoaType pessoaType){
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		for (Pessoa pessoa : aplicationBean.getPessoas()) {
			if(pessoaType==pessoa.getTipo()){
				pessoas.add(pessoa);
			}
		}
		
		return pessoas;
	}
	
	public void addPessoa(Pessoa pessoa){
		aplicationBean.getPessoas().add(pessoa);
	}
	
	public Boolean delPessoa(Pessoa pessoaDel){
		
		for (Pessoa pessoa : aplicationBean.getPessoas()) {
			if(pessoaDel.getId()==pessoa.getId()){
				return aplicationBean.getPessoas().remove(pessoa);
			}
		}
		
		return Boolean.FALSE;
	}
	
}
