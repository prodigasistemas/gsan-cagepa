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

package gcom.gui.faturamento.consumotarifa;

import gcom.cadastro.imovel.Categoria;
import gcom.cadastro.imovel.FiltroCategoria;
import gcom.fachada.Fachada;
import gcom.gui.GcomAction;
import gcom.util.ConstantesSistema;
import gcom.util.filtro.ParametroSimples;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ExibirInserirCategoriaConsumoTarifaAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta o mapeamento de retorno
		ActionForward retorno = actionMapping.findForward("inserirCategoriaConsumoTarifa");

		// Form
		// InserirConsumoTarifaActionForm form = (InserirConsumoTarifaActionForm) actionForm;

		Fachada fachada = Fachada.getInstancia();

		// Mudar isso quando tiver esquema de seguran�a
		HttpSession sessao = httpServletRequest.getSession(false);

		String inTarifaEsgotoPropria = null;

		if(httpServletRequest.getParameter("indicadorTarifaEsgotoPropria") != null){
			inTarifaEsgotoPropria = httpServletRequest.getParameter("indicadorTarifaEsgotoPropria");
		}else{
			inTarifaEsgotoPropria = (String) sessao.getAttribute("indicadorTarifaEsgotoPropria");
		}

		if(inTarifaEsgotoPropria != null && inTarifaEsgotoPropria.equals(ConstantesSistema.SIM.toString())){
			sessao.setAttribute("indicadorTarifaEsgotoPropria", ConstantesSistema.SIM.toString());
		}else{
			sessao.removeAttribute("indicadorTarifaEsgotoPropria");
		}

		// ----------------FILTRO CATEGORIAS DE ESTABELECIMENTO - PROPULAR
		// DROPDOWN ------

		if(httpServletRequest.getParameter("parametroVigencia") != null){
			String vigencia = (String) httpServletRequest.getParameter("parametroVigencia");
			sessao.setAttribute("vigencia", vigencia);
		}
		if(httpServletRequest.getParameter("parametroDescricao") != null){
			String descricao = (String) httpServletRequest.getParameter("parametroDescricao");
			sessao.setAttribute("descricao", descricao);
		}
		if(httpServletRequest.getParameter("parametroSelect") != null){
			String select = (String) httpServletRequest.getParameter("parametroSelect");
			sessao.setAttribute("select", select);
		}

		FiltroCategoria filtroCategoria = new FiltroCategoria();

		if((httpServletRequest.getParameter("limpa") != null) && (httpServletRequest.getParameter("limpa").equals("1"))){
			sessao.removeAttribute("InserirCategoriaConsumoTarifaActionForm");
			sessao.removeAttribute("valorMinimo");
			sessao.removeAttribute("colecaoFaixa");
			sessao.removeAttribute("consumoMinimo");
			sessao.setAttribute("categoriaSelected", ConstantesSistema.NUMERO_NAO_INFORMADO);
		}

		InserirCategoriaConsumoTarifaActionForm inserirCategoriaConsumoTarifaActionForm = new InserirCategoriaConsumoTarifaActionForm();

		if((sessao.getAttribute("valorMinimo") != null) && (!sessao.getAttribute("valorMinimo").equals(""))){
			inserirCategoriaConsumoTarifaActionForm.setValorTarifaMinima((String) sessao.getAttribute("valorMinimo").toString());
		}

		if((sessao.getAttribute("consumoMinimo") != null) && (!sessao.getAttribute("consumoMinimo").equals(""))){
			inserirCategoriaConsumoTarifaActionForm.setConsumoMinimo((String) sessao.getAttribute("consumoMinimo"));
		}

		if((sessao.getAttribute("valorMinimoEsgoto") != null) && (!sessao.getAttribute("valorMinimoEsgoto").equals(""))){
			inserirCategoriaConsumoTarifaActionForm.setValorTarifaMinimaEsgoto((String) sessao.getAttribute("valorMinimoEsgoto"));
		}

		filtroCategoria.adicionarParametro(new ParametroSimples(FiltroCategoria.INDICADOR_USO, ConstantesSistema.INDICADOR_USO_ATIVO));
		filtroCategoria.setCampoOrderBy(FiltroCategoria.DESCRICAO);

		sessao.setAttribute("InserirCategoriaConsumoTarifaActionForm", inserirCategoriaConsumoTarifaActionForm);
		Collection colecaoCategoria = fachada.pesquisar(filtroCategoria, Categoria.class.getName());

		sessao.setAttribute("colecaoCategoria", colecaoCategoria);

		return retorno;
	}

}