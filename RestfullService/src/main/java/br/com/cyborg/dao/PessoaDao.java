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
import br.com.cyborg.entity.Pessoas;
import br.com.cyborg.enums.PessoaType;

@Stateless(name = "pessoaDao")
@TransactionAttribute(TransactionAttributeType.SUPPORTS)
@Transactional
public class PessoaDao implements Serializable {
		
	private static final long serialVersionUID = -7554544054833587985L;
	
	@Inject
	private AplicationBean aplicationBean;
	
	public Pessoas getAll(){
		
		return new Pessoas(aplicationBean.getPessoas());
	}
	
	public Pessoa getPessoa(Long id){
		
		for (Pessoa pessoa : aplicationBean.getPessoas()) {
			if(id==pessoa.getId()){
				return pessoa;
			}
		}
		
		return null;
	}
	
	public Pessoas getPessoaTypes(PessoaType pessoaType){
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		for (Pessoa pessoa : aplicationBean.getPessoas()) {
			if(pessoaType==pessoa.getTipo()){
				pessoas.add(pessoa);
			}
		}
		
		return new Pessoas(pessoas);
	}
	
	public void addPessoa(Pessoa pessoa){
		aplicationBean.getPessoas().add(pessoa);
	}
	
	public Boolean addPessoas(List<Pessoa> pessoas){
	int pessoasOldSize = aplicationBean.getPessoas().size();
	int pessoasNewSize = pessoas.size();
	
		for (Pessoa pessoa : pessoas) {
			addPessoa(pessoa);
		}
		
	return 	aplicationBean.getPessoas().size()==(pessoasOldSize+pessoasNewSize);
	}
	
	public Boolean delPessoa(Pessoa pessoaDel){
		
		for (Pessoa pessoa : aplicationBean.getPessoas()) {
			if(pessoaDel.getId()==pessoa.getId()){
				return aplicationBean.getPessoas().remove(pessoa);
			}
		}
		
		return Boolean.FALSE;
	}
	
	public List<Long> delPessoas(List<Pessoa> pessoas){
		
		List<Long> ids = new ArrayList<Long>();
		
		for (Pessoa pessoa : pessoas) {
			if(!delPessoa(pessoa)){
				ids.add(pessoa.getId());
			}
		}
	
	return ids;	
	}
	
}
