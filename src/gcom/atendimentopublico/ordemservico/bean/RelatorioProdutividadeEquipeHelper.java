/**
 * 
 */

package gcom.atendimentopublico.ordemservico.bean;

import java.io.Serializable;

/**
 * @author Bruno Ferreira dos Santos
 */
public class RelatorioProdutividadeEquipeHelper
				implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer tempoMedio;

	private Integer qtd;

	private Integer idUnidade;

	private String descricaoUnidade;

	private Integer idEquipe;

	private String descricaoEquipe;

	private Integer idServicoTipo;

	private String descricaoServicoTipo;

	private Integer tempoPadrao;

	/**
	 * 
	 */
	public RelatorioProdutividadeEquipeHelper() {

		// TODO Auto-generated constructor stub
	}

	public Integer getIdServicoTipo(){

		return idServicoTipo;
	}

	public void setIdServicoTipo(Integer idServicoTipo){

		this.idServicoTipo = idServicoTipo;
	}

	public String getDescricaoServicoTipo(){

		return descricaoServicoTipo;
	}

	public void setDescricaoServicoTipo(String descricaoServicoTipo){

		this.descricaoServicoTipo = descricaoServicoTipo;
	}

	public Integer getTempoMedio(){

		return tempoMedio;
	}

	public void setTempoMedio(Integer tempoMedio){

		this.tempoMedio = tempoMedio;
	}

	public Integer getQtd(){

		return qtd;
	}

	public void setQtd(Integer qtd){

		this.qtd = qtd;
	}

	public Integer getIdUnidade(){

		return idUnidade;
	}

	public void setIdUnidade(Integer idUnidade){

		this.idUnidade = idUnidade;
	}

	public String getDescricaoUnidade(){

		return descricaoUnidade;
	}

	public void setDescricaoUnidade(String descricaoUnidade){

		this.descricaoUnidade = descricaoUnidade;
	}

	public Integer getIdEquipe(){

		return idEquipe;
	}

	public void setIdEquipe(Integer idEquipe){

		this.idEquipe = idEquipe;
	}

	public String getDescricaoEquipe(){

		return descricaoEquipe;
	}

	public void setDescricaoEquipe(String descricaoEquipe){

		this.descricaoEquipe = descricaoEquipe;
	}

	public Integer getTempoPadrao(){

		return tempoPadrao;
	}

	public void setTempoPadrao(Integer tempoPadrao){

		this.tempoPadrao = tempoPadrao;
	}

	public boolean equals(Object arg0){

		boolean retorno = false;

		if(arg0 instanceof RelatorioProdutividadeEquipeHelper){
			RelatorioProdutividadeEquipeHelper help = (RelatorioProdutividadeEquipeHelper) arg0;
			if(this.getIdUnidade() != null && null != help.getIdUnidade()){
				retorno = this.getIdUnidade().equals(help.getIdUnidade());
			}else if(this.getIdUnidade() == null && null == help.getIdUnidade()){
				retorno = true;
			}else{
				retorno = false;
			}

			if(retorno){
				if(this.getIdEquipe() != null && null != help.getIdEquipe()){
					retorno = this.getIdEquipe().equals(help.getIdEquipe());
				}else if(this.getIdEquipe() == null && null == help.getIdEquipe()){
					retorno = true;
				}else{
					retorno = false;
				}
			}

			if(retorno){
				if(this.getIdServicoTipo() != null && null != help.getIdServicoTipo()){
					retorno = this.getIdServicoTipo().equals(help.getIdServicoTipo());
				}else if(this.getIdServicoTipo() == null && null == help.getIdServicoTipo()){
					retorno = true;
				}else{
					retorno = false;
				}
			}
		}

		return retorno;
	}

}
