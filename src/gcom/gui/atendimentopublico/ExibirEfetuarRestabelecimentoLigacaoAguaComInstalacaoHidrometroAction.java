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

package gcom.gui.atendimentopublico;

import gcom.atendimentopublico.ordemservico.FiltroServicoNaoCobrancaMotivo;
import gcom.atendimentopublico.ordemservico.OrdemServico;
import gcom.atendimentopublico.ordemservico.ServicoNaoCobrancaMotivo;
import gcom.atendimentopublico.ordemservico.ServicoTipo;
import gcom.cadastro.cliente.Cliente;
import gcom.cadastro.cliente.ClienteImovel;
import gcom.cadastro.cliente.ClienteRelacaoTipo;
import gcom.cadastro.cliente.FiltroClienteImovel;
import gcom.cadastro.funcionario.FiltroFuncionario;
import gcom.cadastro.funcionario.Funcionario;
import gcom.cadastro.imovel.Imovel;
import gcom.cadastro.sistemaparametro.SistemaParametro;
import gcom.fachada.Fachada;
import gcom.faturamento.debito.FiltroDebitoTipo;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.micromedicao.hidrometro.*;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.util.ConstantesSistema;
import gcom.util.ControladorException;
import gcom.util.Util;
import gcom.util.filtro.ParametroNulo;
import gcom.util.filtro.ParametroSimples;
import gcom.util.parametrizacao.cadastro.ParametroCadastro;

import java.math.BigDecimal;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action respons�vel pela pre-exibi��o da pagina de inserir bairro
 * 
 * @author Leandro Cavalcanti
 * @created 20 de Junho de 2006
 */
public class ExibirEfetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Mudar isso quando tiver esquema de seguran�a
		HttpSession sessao = httpServletRequest.getSession(false);

		Usuario usuarioLogado = (Usuario) sessao.getAttribute("usuarioLogado");

		Fachada fachada = Fachada.getInstancia();

		if(sessao.getAttribute("colecaoPercentualCobranca") == null){

			sessao.setAttribute("colecaoPercentualCobranca", fachada.obterPercentuaisCobranca());
		}

		// -----------------------------------------------------------
		// Verificar permiss�o especial
		boolean temPermissaoMotivoNaoCobranca = fachada.verificarPermissaoInformarMotivoNaoCobranca(usuarioLogado);
		// -----------------------------------------------------------

		// Set no mapeamento de retorno
		ActionForward retorno = actionMapping.findForward("efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometro");

		EfetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm = (EfetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm) actionForm;

		// Pesquisar Funcionario ENTER
		if((efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.getIdFuncionario() != null && !efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm
						.getIdFuncionario().equals(""))
						&& (efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.getDescricaoFuncionario() == null || efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm
										.getDescricaoFuncionario().equals(""))){

			FiltroFuncionario filtroFuncionario = new FiltroFuncionario();

			filtroFuncionario.adicionarParametro(new ParametroSimples(FiltroFuncionario.ID,
							efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.getIdFuncionario()));

			Collection colecaoFuncionario = getFachada().pesquisar(filtroFuncionario, Funcionario.class.getName());

			if(colecaoFuncionario == null || colecaoFuncionario.isEmpty()){

				efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setIdFuncionario("");
				efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setDescricaoFuncionario("FUNCION�RIO INEXISTENTE");

				httpServletRequest.setAttribute("corFuncionario", "exception");
				httpServletRequest.setAttribute("nomeCampo", "idFuncionario");

			}else{

				Funcionario funcionario = (Funcionario) Util.retonarObjetoDeColecao(colecaoFuncionario);

				efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setIdFuncionario(funcionario.getId().toString());
				efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setDescricaoFuncionario(funcionario.getNome());

				httpServletRequest.setAttribute("nomeCampo", "botaoAdicionar");

			}
		}

		// Pesquisar Funcion�rio POPUP
		String pesquisarFuncionario = httpServletRequest.getParameter("pesquisarFuncionario");

		if(pesquisarFuncionario != null && !pesquisarFuncionario.equalsIgnoreCase("")){
			retorno = actionMapping.findForward("pesquisarFuncionario");
		}

		if(httpServletRequest.getParameter("desfazer") != null){
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setSituacaoCavalete(null);
		}

		Boolean veioEncerrarOS = null;

		if(httpServletRequest.getAttribute("veioEncerrarOS") != null
						|| (efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.getVeioEncerrarOS() != null && efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm
										.getVeioEncerrarOS().equals("true"))){

			veioEncerrarOS = Boolean.TRUE;
		}else{
			if(efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.getVeioEncerrarOS() != null
							&& !efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.getVeioEncerrarOS().equals("")){
				if(efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.getVeioEncerrarOS().toLowerCase().equals("true")){
					veioEncerrarOS = Boolean.TRUE;
				}else{
					veioEncerrarOS = Boolean.FALSE;
				}
			}else{
				veioEncerrarOS = Boolean.FALSE;
			}
		}

		efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setVeioEncerrarOS("" + veioEncerrarOS);

		this.consultaSelectObrigatorio(sessao);

		// Variavel responsav�l pelo preenchimento do imovel no formul�rio
		String idOrdemServico = null;

		if(httpServletRequest.getAttribute("veioEncerrarOS") != null){
			idOrdemServico = (String) httpServletRequest.getAttribute("veioEncerrarOS");

			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setDataRestabelecimento((String) httpServletRequest
							.getAttribute("dataEncerramento"));

			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setDataInstalacao((String) httpServletRequest
							.getAttribute("dataEncerramento"));

			sessao.setAttribute("caminhoRetornoIntegracaoComercial", httpServletRequest.getAttribute("caminhoRetornoIntegracaoComercial"));

		}else if(efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.getIdOrdemServico() != null){
			idOrdemServico = efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.getIdOrdemServico();
		}

		if(httpServletRequest.getAttribute("semMenu") != null){
			sessao.setAttribute("semMenu", "SIM");
		}else{
			sessao.removeAttribute("semMenu");
		}
		OrdemServico ordemServico = null;
		String matriculaImovel = null;

		// [FS0001] Validar Ordem de Servi�o.
		if(idOrdemServico != null && !idOrdemServico.trim().equals("")){

			ordemServico = fachada.recuperaOSPorId(new Integer(idOrdemServico));

			BigDecimal valorDebito = new BigDecimal(0.00);

			if(ordemServico != null){

				fachada.validarRestabelecimentoLigacaoAguaComInstalacaoHidrometroExibir(ordemServico, veioEncerrarOS);

				sessao.setAttribute("ordemServico", ordemServico);

				efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setIdOrdemServico(idOrdemServico);
				efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setNomeOrdemServico(ordemServico.getServicoTipo()
								.getDescricao());

				Imovel imovel = null;

				if(ordemServico.getImovel() != null){
					imovel = ordemServico.getImovel();
				}else if(ordemServico.getRegistroAtendimento() != null){
					if(ordemServico.getRegistroAtendimento().getImovel() != null){
						imovel = ordemServico.getRegistroAtendimento().getImovel();
					}else{
						throw new ActionServletException("atencao.ordem.servico.nao.vinculada.imovel");
					}
				}else{
					throw new ActionServletException("atencao.ordem.servico.nao.vinculada.registro.etendimento");
				}

				if(imovel == null){
					throw new ActionServletException("atencao.ordem.servico.nao.vinculada.imovel");
				}else if(imovel.getIndicadorExclusao() == null || imovel.getIndicadorExclusao().intValue() == Short.valueOf("1").intValue()){
					throw new ActionServletException("atencao.imovel.associado.ordem.servico.nao.esta.ativo", null, imovel.getId()
									.toString());
				}

				sessao.setAttribute("imovel", imovel);

				ServicoTipo servicoTipo = ordemServico.getServicoTipo();

				if(servicoTipo != null && servicoTipo.getDebitoTipo() != null){

					if(sessao.getAttribute("colecaoPercentualCobranca") == null){

						sessao.setAttribute("colecaoPercentualCobranca", fachada.obterPercentuaisCobranca());
					}

					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setIdTipoDebito(servicoTipo.getDebitoTipo().getId()
									.toString());

					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setDescricaoTipoDebito(servicoTipo.getDebitoTipo()
									.getDescricao());

					// [FS0013] - Altera��o de Valor
					this.permitirAlteracaoValor(ordemServico.getServicoTipo(),
									efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm);

					// Colocado por Raphael Rossiter em 04/05/2007 (Analista:
					// Rosana Carvalho)
					if(!Util.verificarNaoVazio(httpServletRequest.getParameter("objetoConsulta"))){
						// Colocado por Raphael Rossiter em 04/05/2007 (Analista: Rosana Carvalho)
						valorDebito = this.calcularValores(httpServletRequest, ordemServico,
										efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm);

						efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setQtdeMaxParcelas(fachada
										.obterQuantidadeParcelasMaxima().toString());

						// -----------------------------------------------------------
						// Verificar permiss�o especial

						if(temPermissaoMotivoNaoCobranca){
							httpServletRequest.setAttribute("permissaoMotivoNaoCobranca", temPermissaoMotivoNaoCobranca);
						}else{
							efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setPercentualCobranca("100");
							efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setQuantidadeParcelas("1");
							efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setValorParcelas(Util.formataBigDecimal(
											valorDebito, 2, true));
						}
						// -----------------------------------------------------------
					}

					if(ordemServico.getServicoNaoCobrancaMotivo() != null){
						efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setMotivoNaoCobranca(ordemServico
										.getServicoNaoCobrancaMotivo().getId().toString());
					}

					if(ordemServico.getPercentualCobranca() != null){
						efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setPercentualCobranca(ordemServico
										.getPercentualCobranca().toString());
					}
				}

				if(ordemServico.getDataExecucao() != null){
					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setDataRestabelecimento(Util
									.formatarData(ordemServico.getDataExecucao()));
					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setDataInstalacao(Util.formatarData(ordemServico
									.getDataExecucao()));
				}

				sessao.setAttribute("imovel", imovel);

				matriculaImovel = imovel.getId().toString();
				efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setMatriculaImovel("" + matriculaImovel);

				/*-------------- In�cio dados do Im�vel---------------*/

				sessao.setAttribute("imovel", ordemServico.getRegistroAtendimento().getImovel());

				if(imovel != null){

					// Matricula Im�vel
					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setMatriculaImovel(imovel.getId().toString());

					// Inscri��o Im�vel
					String inscricaoImovel = fachada.pesquisarInscricaoImovel(imovel.getId(), true);
					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setInscricaoImovel(inscricaoImovel);

					// Situa��o da Liga��o de Agua
					String situacaoLigacaoAgua = imovel.getLigacaoAguaSituacao().getDescricao();
					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setSituacaoLigacaoAgua(situacaoLigacaoAgua);

					// Situa��o da Liga��o de Esgoto
					String situacaoLigacaoEsgoto = imovel.getLigacaoEsgotoSituacao().getDescricao();
					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setSituacaoLigacaoEsgoto(situacaoLigacaoEsgoto);

					this
									.pesquisarCliente(efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm, new Integer(
													matriculaImovel));
				}

				if(temPermissaoMotivoNaoCobranca){
					httpServletRequest.setAttribute("permissaoMotivoNaoCobranca", temPermissaoMotivoNaoCobranca);
					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setMotivoNaoCobranca("-1");
				}

				boolean temPermissaoPercentualCobrancaExcedente = fachada
								.verificarPermissaoInformarPercentualCobrancaExcedente(usuarioLogado);
				boolean temPermissaoQuantidadeParcelasExcedente = fachada
								.verificarPermissaoInformarQuantidadeParcelasExcedentes(usuarioLogado);

				if(temPermissaoPercentualCobrancaExcedente){

					httpServletRequest.setAttribute("permissaoPercentualCobrancaExcedente", temPermissaoPercentualCobrancaExcedente);
					httpServletRequest.setAttribute("colecaoPercentualCobranca", fachada.obterPercentuaisCobranca());

				}else{

					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setPercentualCobranca("100");
				}

				if(!temPermissaoQuantidadeParcelasExcedente){

					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setQuantidadeParcelas("1");
				}else{

					httpServletRequest.setAttribute("temPermissaoQuantidadeParcelasExcedente", temPermissaoQuantidadeParcelasExcedente);
				}
				if(!temPermissaoPercentualCobrancaExcedente && !temPermissaoQuantidadeParcelasExcedente){
					efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setValorParcelas(Util.formataBigDecimal(
									valorDebito, 2, true));
				}

			}else{
				efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setNomeOrdemServico("Ordem de Servi�o inexistente");
				efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setIdOrdemServico("");
				httpServletRequest.setAttribute("OrdemServioInexistente", true);
			}
		}else{

			httpServletRequest.setAttribute("nomeCampo", "idOrdemServico");

			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setIdOrdemServico("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setMatriculaImovel("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setInscricaoImovel("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setClienteUsuario("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setCpfCnpjCliente("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setSituacaoLigacaoAgua("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setSituacaoLigacaoEsgoto("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setDataRestabelecimento("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setIdTipoDebito("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setDescricaoTipoDebito("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setQuantidadeParcelas("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setValorParcelas("");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setPercentualCobranca("-1");
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setMotivoNaoCobranca("-1");

		}

		// Pesquisa o hidr�metro novo
		String numeroHidrometro = (String) httpServletRequest.getParameter("numeroHidrometro");

		// Verificar se o n�mero do hidr�metro n�o est� cadastrado

		if(numeroHidrometro != null && !numeroHidrometro.trim().equals("")){

			// Pesquisa o hidr�metro
			Hidrometro hidrometro = fachada.pesquisarHidrometroPeloNumero(numeroHidrometro);

			if(hidrometro == null){
				efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setNumeroHidrometro("");
				throw new ActionServletException("atencao.hidrometro_inexistente");
			}

			if(hidrometro.getHidrometroSituacao().getId().intValue() != HidrometroSituacao.DISPONIVEL){

				ActionServletException ex = new ActionServletException(
								"atencao.situacao_ligacao_agua_invalida_restabelecimento_situacao_hidromentro", hidrometro
												.getHidrometroSituacao().getDescricao());
				ex.setUrlBotaoVoltar("/gsan/exibirEfetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroAction.do");
				throw ex;

			}else{
				efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setNumeroHidrometro(hidrometro.getNumero());
			}

		}

		// Par�metro que indica obrigatoriedade do campo Funcion�rio
		String indicadorObrigatoriedadeFuncionario = null;
		try{
			indicadorObrigatoriedadeFuncionario = ParametroCadastro.P_INDICADOR_OBRIGATORIEDADE_FUNCIONARIO.executar();
		}catch(ControladorException e){
			e.printStackTrace();
		}
		httpServletRequest.setAttribute("indicadorObrigatoriedadeFuncionario", indicadorObrigatoriedadeFuncionario);

		return retorno;
	}

	/*
	 * [FS0013 - Altera��o de Valor]
	 * autor: Raphael Rossiter
	 * data: 19/04/2007
	 */
	private void permitirAlteracaoValor(ServicoTipo servicoTipo, EfetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm form){

		if(servicoTipo.getIndicadorPermiteAlterarValor() == ConstantesSistema.INDICADOR_USO_ATIVO.shortValue()){

			form.setAlteracaoValor("OK");
		}else{
			form.setAlteracaoValor("");
		}
	}

	/*
	 * Calcular valor da presta��o com juros
	 * return: Retorna o valor total do d�bito
	 * autor: Isilva
	 * data: 28/12/2010
	 */
	private BigDecimal calcularValores(HttpServletRequest httpServletRequest, OrdemServico ordemServico,
					EfetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm form){

		String calculaValores = httpServletRequest.getParameter("calculaValores");

		BigDecimal valorDebito = new BigDecimal(0);
		SistemaParametro sistemaParametro = this.getFachada().pesquisarParametrosDoSistema();
		Integer qtdeParcelas = null;

		if(calculaValores != null && calculaValores.equals("S")){

			// [UC] - Calcular Presta��o
			BigDecimal taxaJurosFinanciamento = null;
			qtdeParcelas = new Integer(form.getQuantidadeParcelas());

			if(ordemServico.getServicoTipo().getIndicadorCobrarJuros() == ConstantesSistema.SIM.shortValue() && qtdeParcelas.intValue() > 1){

				taxaJurosFinanciamento = sistemaParametro.getPercentualTaxaJurosFinanciamento();
			}else{
				taxaJurosFinanciamento = new BigDecimal(0);
				qtdeParcelas = 1;
			}

			BigDecimal valorPrestacao = null;
			if(taxaJurosFinanciamento != null){

				// valorDebito = new BigDecimal(form.getValorDebito().replace(",","."));
				valorDebito = Util.formatarMoedaRealparaBigDecimal(form.getValorDebito());

				String percentualCobranca = form.getPercentualCobranca();

				if(percentualCobranca == null || percentualCobranca.equalsIgnoreCase("")
								|| percentualCobranca.equalsIgnoreCase("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){
					throw new ActionServletException("atencao.informe_campo", null, "Percentual de Cobran�a");
				}

				valorDebito = valorDebito.multiply(Util.converterEmPercentagem(percentualCobranca, 1));

				valorPrestacao = this.getFachada().calcularPrestacao(taxaJurosFinanciamento, qtdeParcelas, valorDebito,
								new BigDecimal("0.00"));

				valorPrestacao.setScale(2, BigDecimal.ROUND_HALF_UP);
			}

			if(valorPrestacao != null){
				String valorPrestacaoComVirgula = Util.formataBigDecimal(valorPrestacao, 2, true);
				form.setValorParcelas(valorPrestacaoComVirgula);
			}else{
				form.setValorParcelas("0,00");
			}

		}else{

			HttpSession sessao = httpServletRequest.getSession(false);
			Imovel imovel = (Imovel) sessao.getAttribute("imovel");

			valorDebito = Fachada.getInstancia().obterValorDebito(ordemServico.getServicoTipo().getId(), imovel.getId(), new Short("3"));

			if(valorDebito != null){
				form.setValorDebito(Util.formataBigDecimal(valorDebito, 2, true));
			}else{
				form.setValorDebito("0");
			}
		}

		return valorDebito;
	}

	/**
	 * Pesquisa Cliente
	 * 
	 * @author Rafael Corr�a
	 * @date 27/11/2006
	 */
	private void pesquisarCliente(
					EfetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm,
					Integer matriculaImovel){

		// Filtro para carregar o Cliente
		FiltroClienteImovel filtroClienteImovel = new FiltroClienteImovel();

		filtroClienteImovel.adicionarParametro(new ParametroSimples(FiltroClienteImovel.IMOVEL_ID, matriculaImovel));

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
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setClienteUsuario(cliente.getNome());
			efetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroActionForm.setCpfCnpjCliente(documento);

		}else{
			throw new ActionServletException("atencao.naocadastrado", null, "Cliente");
		}
	}

	/**
	 * Monta os select�s obrigatorios
	 * 
	 * @author Rafael Corr�a
	 * @date 27/11/2006
	 */
	private void consultaSelectObrigatorio(HttpSession sessao){

		Fachada fachada = Fachada.getInstancia();

		// Filtro para o campo Tipo Debito
		Collection colecaoNaoCobranca = (Collection) sessao.getAttribute("colecaoNaoCobranca");
		if(colecaoNaoCobranca == null){
			FiltroServicoNaoCobrancaMotivo filtroServicoNaoCobrancaMotivo = new FiltroServicoNaoCobrancaMotivo();

			filtroServicoNaoCobrancaMotivo.setCampoOrderBy(FiltroDebitoTipo.DESCRICAO);

			colecaoNaoCobranca = fachada.pesquisar(filtroServicoNaoCobrancaMotivo, ServicoNaoCobrancaMotivo.class.getName());

			if(colecaoNaoCobranca != null && !colecaoNaoCobranca.isEmpty()){
				sessao.setAttribute("colecaoNaoCobranca", colecaoNaoCobranca);
			}else{
				throw new ActionServletException("atencao.naocadastrado", null, "Motivo da N�o Cobran�a");
			}
		}

		// Pesquisando local de instala��o
		FiltroHidrometroLocalInstalacao filtroHidrometroLocalInstalacao = new FiltroHidrometroLocalInstalacao();
		filtroHidrometroLocalInstalacao.setCampoOrderBy(FiltroHidrometroLocalInstalacao.DESCRICAO);
		filtroHidrometroLocalInstalacao.adicionarParametro(new ParametroSimples(FiltroHidrometroLocalInstalacao.INDICADOR_USO,
						ConstantesSistema.INDICADOR_USO_ATIVO));

		Collection colecaoHidrometroLocalInstalacao = Fachada.getInstancia().pesquisar(filtroHidrometroLocalInstalacao,
						HidrometroLocalInstalacao.class.getName());

		if(colecaoHidrometroLocalInstalacao == null || colecaoHidrometroLocalInstalacao.isEmpty()){
			throw new ActionServletException("atencao.entidade_sem_dados_para_selecao", null, "Hidr�metro local de instala��o");
		}

		sessao.setAttribute("colecaoHidrometroLocalInstalacao", colecaoHidrometroLocalInstalacao);

		// Pesquisando prote��o
		FiltroHidrometroProtecao filtroHidrometroProtecao = new FiltroHidrometroProtecao();
		filtroHidrometroProtecao.setCampoOrderBy(FiltroHidrometroProtecao.DESCRICAO);
		filtroHidrometroProtecao.adicionarParametro(new ParametroSimples(FiltroHidrometroProtecao.INDICADOR_USO,
						ConstantesSistema.INDICADOR_USO_ATIVO));
		Collection colecaoHidrometroProtecao = Fachada.getInstancia().pesquisar(filtroHidrometroProtecao,
						HidrometroProtecao.class.getName());

		if(colecaoHidrometroProtecao == null || colecaoHidrometroProtecao.isEmpty()){
			throw new ActionServletException("atencao.entidade_sem_dados_para_selecao", null, "Hidr�metro prote��o");
		}

		sessao.setAttribute("colecaoHidrometroProtecao", colecaoHidrometroProtecao);

	}

}
