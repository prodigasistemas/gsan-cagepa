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

package gcom.gui.relatorio.cadastro.imovel;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import gcom.cadastro.localidade.FiltroGerenciaRegional;
import gcom.cadastro.localidade.FiltroLocalidade;
import gcom.cadastro.localidade.GerenciaRegional;
import gcom.cadastro.localidade.Localidade;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;

/**
 * [UC0XXX] Gerar Relat�rio Grandes Consumidores
 * 
 * @author Anderson Italo
 * @date 16/02/2011
 */
public class ExibirGerarRelatorioGrandesConsumidoresAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta o mapeamento de retorno
		ActionForward retorno = actionMapping.findForward("exibirGerarRelatorioGrandesConsumidores");

		GerarRelatorioGrandesConsumidoresActionForm form = (GerarRelatorioGrandesConsumidoresActionForm) actionForm;
		Fachada fachada = Fachada.getInstancia();

		// Pesquisar Ger�ncias Regionais
		FiltroGerenciaRegional filtroGerenciaRegional = new FiltroGerenciaRegional();
		filtroGerenciaRegional.adicionarParametro(new ParametroSimples(FiltroGerenciaRegional.INDICADOR_USO,
						ConstantesSistema.INDICADOR_USO_ATIVO));
		filtroGerenciaRegional.setCampoOrderBy(FiltroGerenciaRegional.NOME_ABREVIADO);

		Collection colecaoGerenciaRegional = fachada.pesquisar(filtroGerenciaRegional, GerenciaRegional.class.getName());

		httpServletRequest.setAttribute("colecaoGerenciaRegional", colecaoGerenciaRegional);

		if(httpServletRequest.getParameter("limparCampos") != null && httpServletRequest.getParameter("limparCampos").equals("true")){

			form.setCodigoLocalidadeInicial(null);
			form.setNomeLocalidadeInicial(null);
			form.setCodigoLocalidadeFinal(null);
			form.setNomeLocalidadeFinal(null);
			form.setCodigoGerencia(null);
		}else{
			// Flag indicando que o usu�rio fez uma consulta a partir da tecla
			// Enter
			String objetoConsulta = httpServletRequest.getParameter("objetoConsulta");

			// Pesquisar Localidade
			if(objetoConsulta != null && !objetoConsulta.trim().equals("")
							&& (objetoConsulta.trim().equals("1") || objetoConsulta.trim().equals("3"))){

				// Faz a consulta de Localidade
				this.pesquisarLocalidade(form, objetoConsulta);
			}

			this.setaRequest(httpServletRequest, form);
		}

		return retorno;
	}

	/**
	 * Pesquisa Localidade ao teclar Enter.
	 * 
	 * @author Anderson Itallo
	 * @date 25/01/2011
	 */
	private void pesquisarLocalidade(GerarRelatorioGrandesConsumidoresActionForm form, String objetoConsulta){

		Object local = form.getCodigoLocalidadeInicial();

		if(!objetoConsulta.trim().equals("1")){
			local = form.getCodigoLocalidadeFinal();
		}

		FiltroLocalidade filtroLocalidade = new FiltroLocalidade();
		filtroLocalidade.adicionarParametro(new ParametroSimples(FiltroLocalidade.ID, local));
		if(form.getCodigoGerencia() != null && !form.getCodigoGerencia().equals("")){
			filtroLocalidade.adicionarParametro(new ParametroSimples(FiltroLocalidade.ID_GERENCIA, form.getCodigoGerencia()));
		}else{
			throw new ActionServletException("atencao.informe_campo", null, "Gerencia Regional");
		}

		// Recupera Localidade
		Collection colecaoLocalidade = this.getFachada().pesquisar(filtroLocalidade, Localidade.class.getName());

		if(colecaoLocalidade != null && !colecaoLocalidade.isEmpty()){

			Localidade localidade = (Localidade) Util.retonarObjetoDeColecao(colecaoLocalidade);

			if(objetoConsulta.trim().equals("1")){
				form.setCodigoLocalidadeInicial(localidade.getId().toString());
				form.setNomeLocalidadeInicial(localidade.getDescricao());
			}

			form.setCodigoLocalidadeFinal(localidade.getId().toString());
			form.setNomeLocalidadeFinal(localidade.getDescricao());

		}else{
			if(objetoConsulta.trim().equals("1")){
				form.setCodigoLocalidadeInicial(null);
				form.setNomeLocalidadeInicial("Localidade Inicial inexistente");

				form.setCodigoLocalidadeFinal(null);
				form.setNomeLocalidadeFinal(null);
			}else{
				form.setCodigoLocalidadeFinal(null);
				form.setNomeLocalidadeFinal("Localidade Final inexistente");
			}
		}
	}

	/**
	 * Seta o atributo no request indicando localidade n�o encontrada.
	 * 
	 * @author Anderson Italo
	 * @date 25/01/2011
	 */
	private void setaRequest(HttpServletRequest httpServletRequest, GerarRelatorioGrandesConsumidoresActionForm form){

		boolean validouLocalidadeFinal = false;

		if(form.getCodigoLocalidadeInicial() != null && !form.getCodigoLocalidadeInicial().equals("")
						&& form.getNomeLocalidadeInicial() != null && !form.getNomeLocalidadeInicial().equals("")){

			httpServletRequest.setAttribute("localidadeInicialEncontrada", "true");

			if(form.getCodigoLocalidadeFinal() != null && !form.getCodigoLocalidadeFinal().equals("")
							&& form.getNomeLocalidadeFinal() != null && !form.getNomeLocalidadeFinal().equals("")){

				validouLocalidadeFinal = true;
				httpServletRequest.setAttribute("localidadeFinalEncontrada", "true");
			}
		}

		if(form.getCodigoLocalidadeFinal() != null && !form.getCodigoLocalidadeFinal().equals("") && form.getNomeLocalidadeFinal() != null
						&& !form.getNomeLocalidadeFinal().equals("") && !validouLocalidadeFinal){

			httpServletRequest.setAttribute("localidadeFinalEncontrada", "true");
		}
	}

}
