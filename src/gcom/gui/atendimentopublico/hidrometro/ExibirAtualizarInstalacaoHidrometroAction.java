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

package gcom.gui.atendimentopublico.hidrometro;

import gcom.atendimentopublico.ordemservico.OrdemServico;
import gcom.cadastro.cliente.Cliente;
import gcom.cadastro.cliente.ClienteImovel;
import gcom.cadastro.cliente.ClienteRelacaoTipo;
import gcom.cadastro.cliente.FiltroClienteImovel;
import gcom.cadastro.funcionario.FiltroFuncionario;
import gcom.cadastro.funcionario.Funcionario;
import gcom.cadastro.imovel.Imovel;
import gcom.fachada.Fachada;
import gcom.gui.GcomAction;
import gcom.micromedicao.hidrometro.*;
import gcom.micromedicao.medicao.MedicaoTipo;
import gcom.util.ConstantesSistema;
import gcom.util.FachadaException;
import gcom.util.Util;
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
 * <<Descri��o da Classe>>
 * 
 * @author lms
 * @date 17/07/2006
 */
public class ExibirAtualizarInstalacaoHidrometroAction
				extends GcomAction {

	/**
	 * Este caso de uso permite efetuar a atualiza��o dos atributos da instala��o do hidr�metro
	 * [UC0368] Atualizar Instala��o de Hidr�metro
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		ActionForward retorno = actionMapping.findForward("atualizarInstalacaoHidrometro");
		AtualizarInstalacaoHidrometroActionForm form = (AtualizarInstalacaoHidrometroActionForm) actionForm;
		Fachada fachada = Fachada.getInstancia();

		boolean pesquisouFuncionario = false;

		// Pesquisar Funcionario ENTER
		if((form.getIdFuncionario() != null && !form.getIdFuncionario().equals(""))
						&& (form.getDescricaoFuncionario() == null || form.getDescricaoFuncionario().equals(""))){

			FiltroFuncionario filtroFuncionario = new FiltroFuncionario();

			filtroFuncionario.adicionarParametro(new ParametroSimples(FiltroFuncionario.ID, form.getIdFuncionario()));

			Collection colecaoFuncionario = getFachada().pesquisar(filtroFuncionario, Funcionario.class.getName());

			if(colecaoFuncionario == null || colecaoFuncionario.isEmpty()){

				form.setIdFuncionario("");
				form.setDescricaoFuncionario("FUNCION�RIO INEXISTENTE");

				httpServletRequest.setAttribute("corFuncionario", "exception");
				httpServletRequest.setAttribute("nomeCampo", "idFuncionario");

			}else{

				Funcionario funcionario = (Funcionario) Util.retonarObjetoDeColecao(colecaoFuncionario);

				form.setIdFuncionario(funcionario.getId().toString());
				form.setDescricaoFuncionario(funcionario.getNome());

				httpServletRequest.setAttribute("nomeCampo", "botaoAdicionar");

			}
			pesquisouFuncionario = true;
		}

		// Pesquisar Funcion�rio POPUP
		String pesquisarFuncionario = httpServletRequest.getParameter("pesquisarFuncionario");

		if(pesquisarFuncionario != null && !pesquisarFuncionario.equalsIgnoreCase("")){
			retorno = actionMapping.findForward("pesquisarFuncionario");
		}

		Boolean veioEncerrarOS = null;
		if(httpServletRequest.getAttribute("veioEncerrarOS") != null
						|| (form.getVeioEncerrarOS() != null && form.getVeioEncerrarOS().equals(Boolean.TRUE.toString()))){
			veioEncerrarOS = Boolean.TRUE;
		}else{
			veioEncerrarOS = Boolean.FALSE;
		}

		HttpSession sessao = httpServletRequest.getSession(false);
		if(form.getReset().equals("true")){
			form.reset();
		}else if(form.getReset().equals("hidrometro")){
			form.resetHidrometro();
		}
		// Constr�i filtro para pesquisa dos locais de instala��o
		FiltroHidrometroLocalInstalacao filtroHidrometroLocalInstalacao = new FiltroHidrometroLocalInstalacao();
		filtroHidrometroLocalInstalacao.setCampoOrderBy(FiltroHidrometroLocalInstalacao.DESCRICAO);
		filtroHidrometroLocalInstalacao.adicionarParametro(new ParametroSimples(FiltroHidrometroLocalInstalacao.INDICADOR_USO,
						ConstantesSistema.INDICADOR_USO_ATIVO));

		sessao.setAttribute("colecaoLocalInstalacao", fachada.pesquisar(filtroHidrometroLocalInstalacao, HidrometroLocalInstalacao.class
						.getName()));

		// Constr�i o filtro para pesquisa das prote��es
		FiltroHidrometroProtecao filtroHidrometroProtecao = new FiltroHidrometroProtecao();
		filtroHidrometroProtecao.setCampoOrderBy(FiltroHidrometroProtecao.DESCRICAO);
		filtroHidrometroProtecao.adicionarParametro(new ParametroSimples(FiltroHidrometroProtecao.INDICADOR_USO,
						ConstantesSistema.INDICADOR_USO_ATIVO));

		sessao.setAttribute("colecaoProtecao", fachada.pesquisar(filtroHidrometroProtecao, HidrometroProtecao.class.getName()));

		Integer idOrdemServico = null;
		if(httpServletRequest.getParameter("idOrdemServico") != null){
			idOrdemServico = Util.converterStringParaInteger(httpServletRequest.getParameter("idOrdemServico"));
		}else if(form.getIdOrdemServico() != null){
			idOrdemServico = Util.converterStringParaInteger(form.getIdOrdemServico());
		}else{
			idOrdemServico = Util.converterStringParaInteger((String) httpServletRequest.getAttribute("veioEncerrarOS"));
			// form.setDataCorte((String) httpServletRequest.getAttribute("dataEncerramento"));
			sessao.setAttribute("caminhoRetornoIntegracaoComercial", httpServletRequest.getAttribute("caminhoRetornoIntegracaoComercial"));
		}

		if(Util.validarNumeroMaiorQueZERO(idOrdemServico)){

			OrdemServico ordemServico = fachada.recuperaOSPorId(idOrdemServico);
			if(ordemServico != null){
				sessao.setAttribute("ordemServicoEncontrada", "true");
				// Realiza a pesquisa do im�vel
				fachada.validarExibirAtualizarInstalacaoHidrometro(ordemServico, veioEncerrarOS);

				form.setVeioEncerrarOS("" + veioEncerrarOS);

				Imovel imovel = ordemServico.getRegistroAtendimento().getImovel();

				// Constr�i o filtro para pesquisa do cliente do im�vel
				FiltroClienteImovel filtroClienteImovel = new FiltroClienteImovel();
				filtroClienteImovel.adicionarCaminhoParaCarregamentoEntidade("cliente");
				filtroClienteImovel.adicionarParametro(new ParametroSimples(FiltroClienteImovel.IMOVEL_ID, imovel.getId()));
				filtroClienteImovel.adicionarParametro(new ParametroSimples(FiltroClienteImovel.CLIENTE_RELACAO_TIPO,
								ClienteRelacaoTipo.USUARIO));
				filtroClienteImovel.adicionarParametro(new ParametroNulo(FiltroClienteImovel.DATA_FIM_RELACAO));

				// Realiza a pesquisa do cliente usu�rio
				ClienteImovel clienteImovel = (ClienteImovel) fachada.pesquisar(filtroClienteImovel, ClienteImovel.class.getName())
								.iterator().next();
				Cliente cliente = clienteImovel.getCliente();
				String cpfCnpjCliente = "";
				if(cliente.getCpf() != null && !cliente.getCpf().equals("")){
					cpfCnpjCliente = cliente.getCpfFormatado();
				}else{
					cpfCnpjCliente = cliente.getCnpjFormatado();
				}

				// Seta os campos obrigat�rios do form
				form.setIdOrdemServico(idOrdemServico.toString());
				form.setNomeOrdemServico(ordemServico.getServicoTipo().getDescricao());
				form.setMatriculaImovel(imovel.getId().toString());
				String inscricaoFormatada = fachada.pesquisarInscricaoImovel(imovel.getId(), true);
				form.setInscricaoImovel(inscricaoFormatada);
				form.setSituacaoLigacaoEsgoto(imovel.getLigacaoEsgotoSituacao().getDescricao());
				form.setClienteUsuario(cliente.getNome());
				if("00.000.000/0000-00".equals(cpfCnpjCliente)){
					form.setCpfCnpjCliente("");
				}else{
					form.setCpfCnpjCliente(cpfCnpjCliente);
				}

				HidrometroInstalacaoHistorico hidrometroInstalacaoHistorico = null;

				// Verifica se o tipo de medi��o foi informado
				if(Util.validarStringNumerica(form.getMedicaoTipo())){

					Integer medicaoTipo = Integer.parseInt(form.getMedicaoTipo());

					try{
						fachada.validarExistenciaHidrometro(imovel, medicaoTipo);
					}catch(FachadaException fe){
						form.setMedicaoTipo(null);
						fe.setUrlBotaoVoltar("/gsan/exibirAtualizarInstalacaoHidrometroAction.do");
						throw fe;
					}

					if(MedicaoTipo.LIGACAO_AGUA.equals(medicaoTipo)){
						hidrometroInstalacaoHistorico = imovel.getLigacaoAgua().getHidrometroInstalacaoHistorico();
					}else if(MedicaoTipo.POCO.equals(medicaoTipo)){
						hidrometroInstalacaoHistorico = imovel.getHidrometroInstalacaoHistorico();
					}

					// Seta os campos obrigat�rios do form
					form.setDataInstalacao(Util.formatarData(hidrometroInstalacaoHistorico.getDataInstalacao()));
					form.setHidrometro(hidrometroInstalacaoHistorico.getHidrometro().getNumero());
					if(hidrometroInstalacaoHistorico.getHidrometroLocalInstalacao() != null) form
									.setLocalInstalacao(hidrometroInstalacaoHistorico.getHidrometroLocalInstalacao().getId().toString());
					form.setProtecao(hidrometroInstalacaoHistorico.getHidrometroProtecao().getId().toString());
					if(hidrometroInstalacaoHistorico.getIndicadorExistenciaCavalete() != null) form
									.setIndicadorExistenciaCavalete(hidrometroInstalacaoHistorico.getIndicadorExistenciaCavalete()
													.toString());
					if(hidrometroInstalacaoHistorico.getNumeroLeituraInstalacao() != null) form
									.setLeituraInstalacao(hidrometroInstalacaoHistorico.getNumeroLeituraInstalacao().toString());

					// Seta os campos opcionais do form
					form.setNumeroSelo(Util.converterObjetoParaString(hidrometroInstalacaoHistorico.getNumeroSelo()));
					form.setLeituraCorte(Util.converterObjetoParaString(hidrometroInstalacaoHistorico.getNumeroLeituraCorte()));
					form.setLeituraSupressao(Util.converterObjetoParaString(hidrometroInstalacaoHistorico.getNumeroLeituraSupressao()));
					form.setLeituraRetirada(Util.converterObjetoParaString(hidrometroInstalacaoHistorico.getNumeroLeituraRetirada()));

					if(!pesquisouFuncionario){
						form.setIdFuncionario((hidrometroInstalacaoHistorico.getFuncionarioInstalacaoHidrometro() != null ? hidrometroInstalacaoHistorico
										.getFuncionarioInstalacaoHidrometro().getId().toString()
										: ""));

						if(hidrometroInstalacaoHistorico.getFuncionarioInstalacaoHidrometro() != null){
							FiltroFuncionario filtroFuncionario = new FiltroFuncionario();

							filtroFuncionario.adicionarParametro(new ParametroSimples(FiltroFuncionario.ID, form.getIdFuncionario()));

							Collection colecaoFuncionario = getFachada().pesquisar(filtroFuncionario, Funcionario.class.getName());

							Funcionario funcionario = (Funcionario) Util.retonarObjetoDeColecao(colecaoFuncionario);
							form.setDescricaoFuncionario(funcionario.getNome());
						}

					}

					httpServletRequest.setAttribute("hidrometroInstalacaoHistorico", hidrometroInstalacaoHistorico);

				}
			}else{
				sessao.removeAttribute("ordemServicoEncontrada");
				form.setIdOrdemServico("");
				form.setNomeOrdemServico("Ordem de Servi�o Inexistente");
			}
		}else{
			form.setDataCorrente(new Date());
			httpServletRequest.setAttribute("nomeCampo", "idOrdemServico");
		}

		return retorno;
	}

}