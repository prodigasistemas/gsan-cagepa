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

package gcom.gui.atendimentopublico.ligacaoesgoto;

import gcom.atendimentopublico.ordemservico.OrdemServico;
import gcom.cadastro.cliente.Cliente;
import gcom.cadastro.cliente.ClienteImovel;
import gcom.cadastro.cliente.ClienteRelacaoTipo;
import gcom.cadastro.cliente.FiltroClienteImovel;
import gcom.cadastro.imovel.Categoria;
import gcom.cadastro.imovel.Imovel;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.util.filtro.ParametroNulo;
import gcom.util.filtro.ParametroSimples;

import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action respons�vel pela pre-exibi��o da pagina de atualizar volume m�nimo de
 * liga��o de esgoto.
 * 
 * @author Leonardo Regis
 * @date 22/09/2006
 */
public class ExibirAtualizarVolumeMinimoLigacaoEsgotoAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Set no mapeamento de retorno
		ActionForward retorno = actionMapping.findForward("atualizarVolumeMinimoLigacaoEsgotoActionExibir");
		HttpSession sessao = httpServletRequest.getSession(false);
		AtualizarVolumeMinimoLigacaoEsgotoActionForm form = (AtualizarVolumeMinimoLigacaoEsgotoActionForm) actionForm;
		Fachada fachada = Fachada.getInstancia();
		Boolean veioEncerrarOS = null;
		if(httpServletRequest.getAttribute("veioEncerrarOS") != null){
			veioEncerrarOS = Boolean.TRUE;
		}else{
			if(form.getVeioEncerrarOS() != null && !form.getVeioEncerrarOS().equals("")){
				if(form.getVeioEncerrarOS().toLowerCase().equals("true")){
					veioEncerrarOS = Boolean.TRUE;
				}else{
					veioEncerrarOS = Boolean.FALSE;
				}
			}else{
				veioEncerrarOS = Boolean.FALSE;
			}
		}
		form.setVeioEncerrarOS("" + veioEncerrarOS);

		// Variavel responsav�l pelo preenchimento do imovel no formul�rio
		String idOrdemServico = null;

		if(form.getIdOrdemServico() != null){
			idOrdemServico = form.getIdOrdemServico();
		}else{
			idOrdemServico = (String) httpServletRequest.getAttribute("veioEncerrarOS");

			sessao.setAttribute("caminhoRetornoIntegracaoComercial", httpServletRequest.getAttribute("caminhoRetornoIntegracaoComercial"));
		}

		if(httpServletRequest.getAttribute("semMenu") != null){
			sessao.setAttribute("semMenu", "SIM");
		}else{
			sessao.removeAttribute("semMenu");
		}
		if(idOrdemServico != null && !idOrdemServico.equals("")){
			OrdemServico ordemServico = fachada.recuperaOSPorId(new Integer(idOrdemServico));
			if(ordemServico != null && !ordemServico.equals("")){
				// Valida��es
				fachada.validarExibirAtualizarVolumeMinimoLigacaoEsgoto(ordemServico, veioEncerrarOS);
				form.setIdOrdemServico(idOrdemServico);
				// Preenchar dados da ordem de servico
				form.setNomeOrdemServico(ordemServico.getServicoTipo().getDescricao());
				// Preencher dados do imovel
				this.preencherDadosImovel(form, ordemServico);
				// Preencher dados do Cliente
				this.pesquisarCliente(form, ordemServico);
				sessao.setAttribute("osEncontrada", "true");
			}else{
				sessao.removeAttribute("osEncontrada");
				form.setNomeOrdemServico("Ordem de Servi�o inexistente");
			}
		}else{
			httpServletRequest.setAttribute("nomeCampo", "idOrdemServico");
			form.setDataConcorrencia(new Date());
		}
		return retorno;
	}

	/**
	 * Preencher dados do im�vel
	 * 
	 * @author Leonardo Regis
	 * @date 22/09/2006
	 */
	private void preencherDadosImovel(AtualizarVolumeMinimoLigacaoEsgotoActionForm form, OrdemServico ordemServico){

		Fachada fachada = Fachada.getInstancia();
		Imovel imovel = ordemServico.getRegistroAtendimento().getImovel();
		// Matricula Im�vel
		form.setMatriculaImovel(imovel.getId().toString());
		// Inscri��o Im�vel
		String inscricaoImovel = fachada.pesquisarInscricaoImovel(imovel.getId(), true);
		form.setInscricaoImovel(inscricaoImovel);
		// Situa��o da Liga��o de Agua
		String situacaoLigacaoAgua = imovel.getLigacaoAguaSituacao().getDescricao();
		form.setSituacaoLigacaoAgua(situacaoLigacaoAgua);
		// Situa��o da Liga��o de Esgoto
		String situacaoLigacaoEsgoto = imovel.getLigacaoEsgotoSituacao().getDescricao();
		form.setSituacaoLigacaoEsgoto(situacaoLigacaoEsgoto);
		// Categoria do Imovel
		Categoria categoria = fachada.obterDescricoesCategoriaImovel(imovel);
		form.setCategoriaImovel(categoria.getDescricao());
		// Quatidade de Economias
		int qtdeconomias = fachada.obterQuantidadeEconomias(imovel);
		form.setQtdeEconomia(qtdeconomias + "");
		// Volume M�nimo
		if(imovel.getLigacaoEsgoto().getConsumoMinimo() != null && !imovel.getLigacaoEsgoto().getConsumoMinimo().equals("")){
			form.setConsumoMinimoFixado(imovel.getLigacaoEsgoto().getConsumoMinimo() + "");
		}else{
			form.setConsumoMinimoFixado("");
		}
		// Valor Obtido
		String valorObtido = fachada.obterConsumoMinimoLigacao(imovel, null) + "";
		form.setValorObtido(valorObtido);
		// Consumo Tarifa
		form.setConsumoTarifaId(imovel.getConsumoTarifa().getId() + "");
	}

	/**
	 * Pesquisa Cliente
	 * 
	 * @author Leonardo Regis
	 * @date 22/09/2006
	 */
	private void pesquisarCliente(AtualizarVolumeMinimoLigacaoEsgotoActionForm form, OrdemServico ordemServico){

		// Filtro para carregar o Cliente
		FiltroClienteImovel filtroClienteImovel = new FiltroClienteImovel();
		filtroClienteImovel.adicionarParametro(new ParametroSimples(FiltroClienteImovel.IMOVEL_ID, ordemServico.getRegistroAtendimento()
						.getImovel().getId()));
		filtroClienteImovel.adicionarParametro(new ParametroSimples(FiltroClienteImovel.CLIENTE_RELACAO_TIPO, ClienteRelacaoTipo.USUARIO));
		filtroClienteImovel.adicionarParametro(new ParametroNulo(FiltroClienteImovel.DATA_FIM_RELACAO));
		filtroClienteImovel.adicionarCaminhoParaCarregamentoEntidade("cliente");

		Collection colecaoClienteImovel = Fachada.getInstancia().pesquisar(filtroClienteImovel, ClienteImovel.class.getName());
		if(colecaoClienteImovel != null && !colecaoClienteImovel.isEmpty()){

			ClienteImovel clienteImovel = (ClienteImovel) colecaoClienteImovel.iterator().next();
			Cliente cliente = clienteImovel.getCliente();

			String documento = "";
			if(cliente.getCpf() != null && !cliente.getCpf().equals("")){
				documento = cliente.getCpfFormatado();
			}else{
				documento = cliente.getCnpjFormatado();
			}
			// Cliente Nome/CPF-CNPJ
			form.setClienteUsuario(cliente.getNome());
			form.setCpfCnpjCliente(documento);
		}else{
			throw new ActionServletException("atencao.naocadastrado", null, "Cliente");
		}

	}
}