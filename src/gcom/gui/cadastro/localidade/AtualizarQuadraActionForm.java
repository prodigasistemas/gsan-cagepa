/*
 * Copyright (C) 2007-2007 the GSAN � Sistema Integrado de Gest�o de Servi�os de Saneamento
 *
 * This file is part of GSAN, an integrated service management system for Sanitation
 *
 * GSAN is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License.
 *
 * GSAN is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place � Suite 330, Boston, MA 02111-1307, USA
 */

/*
 * GSAN � Sistema Integrado de Gest�o de Servi�os de Saneamento
 * Copyright (C) <2007> 
 * Adriano Britto Siqueira
 * Alexandre Santos Cabral
 * Ana Carolina Alves Breda
 * Ana Maria Andrade Cavalcante
 * Aryed Lins de Ara�jo
 * Bruno Leonardo Rodrigues Barros
 * Carlos Elmano Rodrigues Ferreira
 * Cl�udio de Andrade Lira
 * Denys Guimar�es Guenes Tavares
 * Eduardo Breckenfeld da Rosa Borges
 * Fab�ola Gomes de Ara�jo
 * Fl�vio Leonardo Cavalcanti Cordeiro
 * Francisco do Nascimento J�nior
 * Homero Sampaio Cavalcanti
 * Ivan S�rgio da Silva J�nior
 * Jos� Edmar de Siqueira
 * Jos� Thiago Ten�rio Lopes
 * K�ssia Regina Silvestre de Albuquerque
 * Leonardo Luiz Vieira da Silva
 * M�rcio Roberto Batista da Silva
 * Maria de F�tima Sampaio Leite
 * Micaela Maria Coelho de Ara�jo
 * Nelson Mendon�a de Carvalho
 * Newton Morais e Silva
 * Pedro Alexandre Santos da Silva Filho
 * Rafael Corr�a Lima e Silva
 * Rafael Francisco Pinto
 * Rafael Koury Monteiro
 * Rafael Palermo de Ara�jo
 * Raphael Veras Rossiter
 * Roberto Sobreira Barbalho
 * Rodrigo Avellar Silveira
 * Rosana Carvalho Barbosa
 * S�vio Luiz de Andrade Cavalcante
 * Tai Mu Shih
 * Thiago Augusto Souza do Nascimento
 * Tiago Moreno Rodrigues
 * Vivianne Barbosa Sousa
 * 
 * GSANPCG
 * Virg�nia Melo
 *
 * Este programa � software livre; voc� pode redistribu�-lo e/ou
 * modific�-lo sob os termos de Licen�a P�blica Geral GNU, conforme
 * publicada pela Free Software Foundation; vers�o 2 da
 * Licen�a.
 * Este programa � distribu�do na expectativa de ser �til, mas SEM
 * QUALQUER GARANTIA; sem mesmo a garantia impl�cita de
 * COMERCIALIZA��O ou de ADEQUA��O A QUALQUER PROP�SITO EM
 * PARTICULAR. Consulte a Licen�a P�blica Geral GNU para obter mais
 * detalhes.
 * Voc� deve ter recebido uma c�pia da Licen�a P�blica Geral GNU
 * junto com este programa; se n�o, escreva para Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307, USA.
 */

package gcom.gui.cadastro.localidade;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class AtualizarQuadraActionForm
				extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String baciaID;

	private String subSistemaEsgotoID;

	private String distritoOperacionalID;

	private String indicadorRedeAguaAux;

	private String indicadorRedeEsgotoAux;

	private String localidadeID;

	private String localidadeNome;

	private String perfilQuadra;

	private String quadraNM;

	private String quadraID;

	private String rotaID;

	private String rotaDescricao;

	private String setorCensitarioDescricao;

	private String setorCensitarioID;

	private String setorComercialCD;

	private String setorComercialID;

	private String setorComercialNome;

	private String sistemaEsgotoID;

	private String zeisID;

	private String indicadorUso;

	private String areaTipoID;

	private String bairroID;

	private String bairroNome;

	private String sistemaAbastecimentoID;

	private String idRotaAnterior;

	private String quantidadeImoveisRotaIgualAnterior;

	private String quantidadeImoveisRotaDiferenteAnterior;

	private String quantidadeImoveisDistritoOperacionalIgualAnterior;

	private String quantidadeImoveisDistritoOperacionalDiferenteAnterior;

	private String distritoOperacionalIDAnterior;

	private String indicadorSubstituirRota;

	private String indicadorSubstituirDistritoOperacional;

	public String getSistemaAbastecimentoID(){

		return sistemaAbastecimentoID;
	}

	public void setSistemaAbastecimentoID(String sistemaAbastecimentoID){

		this.sistemaAbastecimentoID = sistemaAbastecimentoID;
	}

	public String getZonaAbastecimentoID(){

		return zonaAbastecimentoID;
	}

	public void setZonaAbastecimentoID(String zonaAbastecimentoID){

		this.zonaAbastecimentoID = zonaAbastecimentoID;
	}

	private String zonaAbastecimentoID;

	public String getAreaTipoID(){

		return areaTipoID;
	}

	public void setAreaTipoID(String areaTipoID){

		this.areaTipoID = areaTipoID;
	}

	public String getBaciaID(){

		return baciaID;
	}

	public void setBaciaID(String baciaID){

		this.baciaID = baciaID;
	}

	public String getDistritoOperacionalID(){

		return distritoOperacionalID;
	}

	public void setDistritoOperacionalID(String distritoOperacionalID){

		this.distritoOperacionalID = distritoOperacionalID;
	}

	public String getIndicadorRedeAguaAux(){

		return indicadorRedeAguaAux;
	}

	public void setIndicadorRedeAguaAux(String indicadorRedeAguaAux){

		this.indicadorRedeAguaAux = indicadorRedeAguaAux;
	}

	public String getIndicadorRedeEsgotoAux(){

		return indicadorRedeEsgotoAux;
	}

	public void setIndicadorRedeEsgotoAux(String indicadorRedeEsgotoAux){

		this.indicadorRedeEsgotoAux = indicadorRedeEsgotoAux;
	}

	public String getLocalidadeID(){

		return localidadeID;
	}

	public void setLocalidadeID(String localidadeID){

		this.localidadeID = localidadeID;
	}

	public String getLocalidadeNome(){

		return localidadeNome;
	}

	public void setLocalidadeNome(String localidadeNome){

		this.localidadeNome = localidadeNome;
	}

	public String getPerfilQuadra(){

		return perfilQuadra;
	}

	public void setPerfilQuadra(String perfilQuadra){

		this.perfilQuadra = perfilQuadra;
	}

	public String getQuadraNM(){

		return quadraNM;
	}

	public void setQuadraNM(String quadraNM){

		this.quadraNM = quadraNM;
	}

	public String getRotaID(){

		return rotaID;
	}

	public void setRotaID(String rotaID){

		this.rotaID = rotaID;
	}

	public String getRotaDescricao(){

		return rotaDescricao;
	}

	public void setRotaDescricao(String rotaDescricao){

		this.rotaDescricao = rotaDescricao;
	}

	public String getSetorCensitarioDescricao(){

		return setorCensitarioDescricao;
	}

	public void setSetorCensitarioDescricao(String setorCensitarioDescricao){

		this.setorCensitarioDescricao = setorCensitarioDescricao;
	}

	public String getSetorCensitarioID(){

		return setorCensitarioID;
	}

	public void setSetorCensitarioID(String setorCensitarioID){

		this.setorCensitarioID = setorCensitarioID;
	}

	public String getSetorComercialCD(){

		return setorComercialCD;
	}

	public void setSetorComercialCD(String setorComercialCD){

		this.setorComercialCD = setorComercialCD;
	}

	public String getSetorComercialID(){

		return setorComercialID;
	}

	public void setSetorComercialID(String setorComercialID){

		this.setorComercialID = setorComercialID;
	}

	public String getSetorComercialNome(){

		return setorComercialNome;
	}

	public void setSetorComercialNome(String setorComercialNome){

		this.setorComercialNome = setorComercialNome;
	}

	public String getSistemaEsgotoID(){

		return sistemaEsgotoID;
	}

	public void setSistemaEsgotoID(String sistemaEsgotoID){

		this.sistemaEsgotoID = sistemaEsgotoID;
	}

	public String getZeisID(){

		return zeisID;
	}

	public void setZeisID(String zeisID){

		this.zeisID = zeisID;
	}

	public String getIndicadorUso(){

		return indicadorUso;
	}

	public void setIndicadorUso(String indicadorUso){

		this.indicadorUso = indicadorUso;
	}

	public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest httpServletRequest){

		/** @todo: finish this method, this is just the skeleton. */
		return null;
	}

	public void reset(ActionMapping actionMapping, HttpServletRequest httpServletRequest){

	}

	public String getQuadraID(){

		return quadraID;
	}

	public void setQuadraID(String quadraID){

		this.quadraID = quadraID;
	}

	public String getBairroID(){

		return bairroID;
	}

	public void setBairroID(String bairroID){

		this.bairroID = bairroID;
	}

	public String getBairroNome(){

		return bairroNome;
	}

	public void setBairroNome(String bairroNome){

		this.bairroNome = bairroNome;
	}

	public void setSubSistemaEsgotoID(String subSistemaEsgotoID){

		this.subSistemaEsgotoID = subSistemaEsgotoID;
	}

	public String getSubSistemaEsgotoID(){

		return subSistemaEsgotoID;
	}

	public String getIdRotaAnterior(){

		return idRotaAnterior;
	}

	public void setIdRotaAnterior(String idRotaAnterior){

		this.idRotaAnterior = idRotaAnterior;
	}

	public String getQuantidadeImoveisRotaIgualAnterior(){

		return quantidadeImoveisRotaIgualAnterior;
	}

	public void setQuantidadeImoveisRotaIgualAnterior(String quantidadeImoveisRotaIgualAnterior){

		this.quantidadeImoveisRotaIgualAnterior = quantidadeImoveisRotaIgualAnterior;
	}

	public String getQuantidadeImoveisRotaDiferenteAnterior(){

		return quantidadeImoveisRotaDiferenteAnterior;
	}

	public void setQuantidadeImoveisRotaDiferenteAnterior(String quantidadeImoveisRotaDiferenteAnterior){

		this.quantidadeImoveisRotaDiferenteAnterior = quantidadeImoveisRotaDiferenteAnterior;
	}

	public String getIndicadorSubstituirRota(){

		return indicadorSubstituirRota;
	}

	public void setIndicadorSubstituirRota(String indicadorSubstituirRota){

		this.indicadorSubstituirRota = indicadorSubstituirRota;
	}

	public String getDistritoOperacionalIDAnterior(){

		return distritoOperacionalIDAnterior;
	}

	public void setDistritoOperacionalIDAnterior(String distritoOperacionalIDAnterior){

		this.distritoOperacionalIDAnterior = distritoOperacionalIDAnterior;
	}

	public String getQuantidadeImoveisDistritoOperacionalIgualAnterior(){

		return quantidadeImoveisDistritoOperacionalIgualAnterior;
	}

	public void setQuantidadeImoveisDistritoOperacionalIgualAnterior(String quantidadeImoveisDistritoOperacionalIgualAnterior){

		this.quantidadeImoveisDistritoOperacionalIgualAnterior = quantidadeImoveisDistritoOperacionalIgualAnterior;
	}

	public String getQuantidadeImoveisDistritoOperacionalDiferenteAnterior(){

		return quantidadeImoveisDistritoOperacionalDiferenteAnterior;
	}

	public void setQuantidadeImoveisDistritoOperacionalDiferenteAnterior(String quantidadeImoveisDistritoOperacionalDiferenteAnterior){

		this.quantidadeImoveisDistritoOperacionalDiferenteAnterior = quantidadeImoveisDistritoOperacionalDiferenteAnterior;
	}

	public String getIndicadorSubstituirDistritoOperacional(){

		return indicadorSubstituirDistritoOperacional;
	}

	public void setIndicadorSubstituirDistritoOperacional(String indicadorSubstituirDistritoOperacional){

		this.indicadorSubstituirDistritoOperacional = indicadorSubstituirDistritoOperacional;
	}

}