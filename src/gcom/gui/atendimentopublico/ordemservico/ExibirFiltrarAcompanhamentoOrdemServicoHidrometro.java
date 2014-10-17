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
 * Ivan S�rgio Virginio da Silva J�nior
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

package gcom.gui.atendimentopublico.ordemservico;

import java.util.Collection;

import gcom.cadastro.empresa.Empresa;
import gcom.cadastro.empresa.FiltroEmpresa;
import gcom.cadastro.localidade.FiltroLocalidade;
import gcom.cadastro.localidade.Localidade;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * [UC0732] Filtro para Relatorio Acompanhamento Ordem de Servico Hidrometro
 * 
 * @author Ivan S�rgio
 * @date 04/12/2007
 */
public class ExibirFiltrarAcompanhamentoOrdemServicoHidrometro
				extends GcomAction {

	private String localidadeID = null;

	private Collection colecaoPesquisa = null;

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta o mapeamento de retorno
		ActionForward retorno = actionMapping.findForward("exibirFiltrarAcompanhamentoOrdemServicoHidrometro");

		Fachada fachada = Fachada.getInstancia();

		HttpSession sessao = httpServletRequest.getSession(false);

		// Form
		GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm gerarRelatorioAcompanhamento = (GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm) actionForm;

		// Limpa os Campos
		if(httpServletRequest.getParameter("menu") != null){
			gerarRelatorioAcompanhamento.setTipoOrdem(GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm.TIPO_ORDEM_INSTALACAO);
			gerarRelatorioAcompanhamento
							.setSituacaoOrdemServico(GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm.SITUACAO_ORDEM_SERVICO_ENCERRADAS);
		}

		// Seta o valor inicial para Tipo da Ordem
		if(gerarRelatorioAcompanhamento.getTipoOrdem() == null){
			httpServletRequest
							.setAttribute("tipoOrdem", GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm.TIPO_ORDEM_INSTALACAO);
			gerarRelatorioAcompanhamento.setTipoOrdem(GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm.TIPO_ORDEM_INSTALACAO);
			gerarRelatorioAcompanhamento.setFirma("");
			gerarRelatorioAcompanhamento.setNomeFirma("");
			gerarRelatorioAcompanhamento.setLocalidade("");
			gerarRelatorioAcompanhamento.setNomeLocalidade("");
			gerarRelatorioAcompanhamento
							.settipoRelatorioAcompanhamento(GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm.TIPO_RELATORIO_ANALITICO
											.toString());
		}

		// Seta o valor inicial para Situacao da Ordem
		if(gerarRelatorioAcompanhamento.getSituacaoOrdemServico() == null){
			httpServletRequest.setAttribute("situacaoOrdemServico",
							GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm.SITUACAO_ORDEM_SERVICO_ENCERRADAS);
			gerarRelatorioAcompanhamento
							.setSituacaoOrdemServico(GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm.SITUACAO_ORDEM_SERVICO_ENCERRADAS);
		}

		// Pesquisa Firma
		if(sessao.getAttribute("colecaoFirma") == null){
			pesquisarFirma(gerarRelatorioAcompanhamento, fachada, sessao, httpServletRequest);
		}

		String objetoConsulta = (String) httpServletRequest.getParameter("objetoConsulta");

		if(objetoConsulta != null && !objetoConsulta.trim().equalsIgnoreCase("")){
			switch(Integer.parseInt(objetoConsulta)){
				// Localidade
				case 1:
					pesquisarLocalidade(gerarRelatorioAcompanhamento, fachada, httpServletRequest);
					break;
			}
		}

		// Seta o valor inicial do Tipo de Relatorio
		if(gerarRelatorioAcompanhamento.gettipoRelatorioAcompanhamento() == null){
			httpServletRequest.setAttribute("tipoRelatorio",
							GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm.TIPO_RELATORIO_ANALITICO.toString());
			gerarRelatorioAcompanhamento
							.settipoRelatorioAcompanhamento(GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm.TIPO_RELATORIO_ANALITICO
											.toString());
		}

		return retorno;
	}

	/**
	 * Pesquisa as Firmas
	 * 
	 * @param gerarRelatorioAcompanhamento
	 * @param fachada
	 * @param sessao
	 * @param httpServletRequest
	 */
	private void pesquisarFirma(GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm gerarRelatorioAcompanhamento, Fachada fachada,
					HttpSession sessao, HttpServletRequest httpServletRequest){

		FiltroEmpresa filtroEmpresa = new FiltroEmpresa();
		filtroEmpresa.adicionarParametro(new ParametroSimples(FiltroEmpresa.INDICADORUSO, ConstantesSistema.INDICADOR_USO_ATIVO));

		filtroEmpresa.setCampoOrderBy(FiltroEmpresa.DESCRICAO);

		Collection<Empresa> colecaoFirma = fachada.pesquisar(filtroEmpresa, Empresa.class.getName());

		// [FS0001 - Verificar Existencia de dados]
		if((colecaoFirma == null) || (colecaoFirma.size() == 0)){
			throw new ActionServletException("atencao.entidade_sem_dados_para_selecao", null, Empresa.class.getName());
		}else{
			sessao.setAttribute("colecaoFirma", colecaoFirma);
		}
	}

	/**
	 * Pesquisa a Firma
	 * 
	 * @param gerarRelatorioAcompanhamento
	 * @param fachada
	 * @param httpServletRequest
	 */
	private void pesquisarLocalidade(GerarRelatorioAcompanhamentoOrdemServicoHidrometroActionForm gerarRelatorioAcompanhamento,
					Fachada fachada, HttpServletRequest httpServletRequest){

		FiltroLocalidade filtroLocalidade = new FiltroLocalidade();

		// Recebe o valor do campo localidadeOrigemID do formul�rio.
		localidadeID = (String) gerarRelatorioAcompanhamento.getLocalidade();

		filtroLocalidade.adicionarParametro(new ParametroSimples(FiltroLocalidade.ID, localidadeID));

		filtroLocalidade.adicionarParametro(new ParametroSimples(FiltroLocalidade.INDICADORUSO, ConstantesSistema.INDICADOR_USO_ATIVO));

		// Retorna localidade
		colecaoPesquisa = fachada.pesquisar(filtroLocalidade, Localidade.class.getName());

		if(colecaoPesquisa == null || colecaoPesquisa.isEmpty()){
			// Localidade nao encontrada
			// Limpa os campos localidadeOrigemID e nomeLocalidadeOrigem do
			// formul�rio
			gerarRelatorioAcompanhamento.setLocalidade("");
			gerarRelatorioAcompanhamento.setNomeLocalidade("Localidade inexistente");
			httpServletRequest.setAttribute("corLocalidadeOrigem", "exception");
			httpServletRequest.setAttribute("nomeCampo", "localidade");

		}else{
			Localidade objetoLocalidade = (Localidade) Util.retonarObjetoDeColecao(colecaoPesquisa);
			gerarRelatorioAcompanhamento.setLocalidade(String.valueOf(objetoLocalidade.getId()));
			gerarRelatorioAcompanhamento.setNomeLocalidade(objetoLocalidade.getDescricao());
		}
	}
}