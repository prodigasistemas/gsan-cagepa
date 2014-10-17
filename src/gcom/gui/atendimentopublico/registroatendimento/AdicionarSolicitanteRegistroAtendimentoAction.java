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

package gcom.gui.atendimentopublico.registroatendimento;

import gcom.atendimentopublico.registroatendimento.RegistroAtendimentoSolicitante;
import gcom.cadastro.cliente.Cliente;
import gcom.cadastro.funcionario.FiltroFuncionario;
import gcom.cadastro.funcionario.Funcionario;
import gcom.cadastro.unidade.FiltroUnidadeOrganizacional;
import gcom.cadastro.unidade.UnidadeOrganizacional;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Esta classe tem por finalidade inserir um solicitante em uma RA j� cadastrada
 * 
 * @author Raphael Rossiter
 * @date 25/08/2006
 */
public class AdicionarSolicitanteRegistroAtendimentoAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		ActionForward retorno = actionMapping.findForward("adicionarSolicitanteRegistroAtendimento");

		Fachada fachada = Fachada.getInstancia();

		HttpSession sessao = httpServletRequest.getSession(false);

		AdicionarSolicitanteRegistroAtendimentoActionForm form = (AdicionarSolicitanteRegistroAtendimentoActionForm) actionForm;

		sessao.setAttribute("AdicionarSolicitanteRegistroAtendimentoActionForm", form);

		form.setEspecificacao((String) sessao.getAttribute("idEspecificacao"));

		/*
		 * Pesquisas realizadas a partir do ENTER
		 * 
		 * ==========================================================================================
		 * =================
		 */
		String objetoColecao = (String) sessao.getAttribute("objetoColecao");

		String idRASolicitante = (String) sessao.getAttribute("idRASolicitante");

		if((form.getIdCliente() != null && !form.getIdCliente().equalsIgnoreCase(""))
						&& (form.getNomeCliente() == null || form.getNomeCliente().equals(""))){

			/*
			 * Obtendo o id do im�vel informado na aba de inser��o n� 02 (Caso
			 * n�o tenho sido informado ser� passado como par�metro NULL).
			 */
			String idImovel = null;
			// caso seja do processo de atualizar registro atendimento
			if(objetoColecao != null && !objetoColecao.equals("")){
				AtualizarRegistroAtendimentoActionForm atualizarRegistroAtendimentoActionForm = (AtualizarRegistroAtendimentoActionForm) sessao
								.getAttribute("AtualizarRegistroAtendimentoActionForm");
				idImovel = atualizarRegistroAtendimentoActionForm.getIdImovel();
			}else{
				// caso seja do processo de inserir registro atendimento
				InserirRegistroAtendimentoActionForm inserirRegistroAtendimentoActionForm = (InserirRegistroAtendimentoActionForm) sessao
								.getAttribute("InserirRegistroAtendimentoActionForm");
				idImovel = inserirRegistroAtendimentoActionForm.getIdImovel();
			}

			// [FS0027] � Verificar informa��o do im�vel
			Cliente cliente = fachada.verificarInformacaoImovel(Util.converterStringParaInteger(form.getIdCliente()), Util
							.converterStringParaInteger(idImovel), false);

			if(cliente == null){

				// Nenhuma cliente encontrado
				throw new ActionServletException("atencao.pesquisa_inexistente", null, "Cliente");

			}else{

				// caso seja do processo de atualizar registro atendimento
				if(objetoColecao == null || objetoColecao.equals("")){
					// [FS0012] � Verificar exist�ncia do cliente solicitante
					fachada.verificarExistenciaClienteSolicitante(Util.converterStringParaInteger(form.getIdRA()), cliente.getId());
				}else{
					if(idRASolicitante != null && !idRASolicitante.equals("")){
						// [FS0012] � Verificar exist�ncia do cliente solicitante
						fachada.verificarExistenciaClienteSolicitanteAtualizar(Util.converterStringParaInteger(form.getIdRA()), cliente
										.getId(), Util.converterStringParaInteger(idRASolicitante));
					}

				}

				form.setIdCliente(cliente.getId().toString());
				form.setNomeCliente(cliente.getNome());

				Collection colecaoEnderecos = fachada.pesquisarEnderecosClienteAbreviado(cliente.getId());

				if(colecaoEnderecos != null && !colecaoEnderecos.isEmpty()){

					sessao.setAttribute("colecaoEnderecosSolicitante", colecaoEnderecos);
				}

				Collection colecaoFones = fachada.pesquisarClienteFone(cliente.getId());

				sessao.setAttribute("colecaoFonesSolicitante", colecaoFones);
				this.limparUnidadeSolicitante(sessao);
				this.limparNomeSolicitante(sessao);

			}
		}

		if((form.getIdUnidadeSolicitanteInformar() != null && !form.getIdUnidadeSolicitanteInformar().equals(""))
						&& (form.getDescricaoUnidadeSolicitanteInformar() == null || form.getDescricaoUnidadeSolicitanteInformar().equals(
										""))){

			FiltroUnidadeOrganizacional filtroUnidadeOrganizacional = new FiltroUnidadeOrganizacional();

			filtroUnidadeOrganizacional.adicionarParametro(new ParametroSimples(FiltroUnidadeOrganizacional.ID, form
							.getIdUnidadeSolicitanteInformar()));

			filtroUnidadeOrganizacional.adicionarParametro(new ParametroSimples(FiltroUnidadeOrganizacional.INDICADOR_USO,
							ConstantesSistema.INDICADOR_USO_ATIVO));

			Collection colecaoUnidade = fachada.pesquisar(filtroUnidadeOrganizacional, UnidadeOrganizacional.class.getName());

			if(colecaoUnidade == null || colecaoUnidade.isEmpty()){

				// Nenhuma unidade encontrado
				throw new ActionServletException("atencao.pesquisa_inexistente", null, "Unidade Solicitante");

			}else{
				UnidadeOrganizacional unidade = (UnidadeOrganizacional) Util.retonarObjetoDeColecao(colecaoUnidade);

				form.setIdUnidadeSolicitanteInformar(unidade.getId().toString());
				form.setDescricaoUnidadeSolicitanteInformar(unidade.getDescricao());

				// caso seja do processo de atualizar registro atendimento
				if(objetoColecao == null || objetoColecao.equals("")){

					// [FS0026] � Verificar exist�ncia da unidade solicitante
					fachada.verificarExistenciaUnidadeSolicitante(Util.converterStringParaInteger(form.getIdRA()), Util
									.converterStringParaInteger(form.getIdUnidadeSolicitanteInformar()));
				}else{
					if(idRASolicitante != null && !idRASolicitante.equals("")){
						// [FS0026] � Verificar exist�ncia da unidade
						// solicitante
						fachada.verificarExistenciaUnidadeSolicitanteAtualizar(Util.converterStringParaInteger(form.getIdRA()), Util
										.converterStringParaInteger(form.getIdUnidadeSolicitanteInformar()), Util
										.converterStringParaInteger(idRASolicitante));
					}

				}

				// this.limparCliente(sessao);
				// this.limparNomeSolicitante(sessao);
			}
		}

		if((form.getIdFuncionarioResponsavel() != null && !form.getIdFuncionarioResponsavel().equalsIgnoreCase(""))
						&& (form.getDescricaoFuncionarioResponsavel() == null || form.getDescricaoFuncionarioResponsavel().equals(""))){

			FiltroFuncionario filtroFuncionario = new FiltroFuncionario();

			filtroFuncionario.adicionarParametro(new ParametroSimples(FiltroFuncionario.ID, form.getIdFuncionarioResponsavel()));

			filtroFuncionario.adicionarParametro(new ParametroSimples(FiltroFuncionario.UNIDADE_ORGANIZACIONAL_ID, form
							.getIdUnidadeSolicitanteInformar()));

			Collection colecaoFuncionario = fachada.pesquisar(filtroFuncionario, Funcionario.class.getName());

			if(colecaoFuncionario == null || colecaoFuncionario.isEmpty()){

				// Nenhum funcion�rio encontrado
				throw new ActionServletException("atencao.pesquisa_inexistente", null, "Funcion�rio");

			}else{
				Funcionario funcionario = (Funcionario) Util.retonarObjetoDeColecao(colecaoFuncionario);

				form.setIdFuncionarioResponsavel(funcionario.getId().toString());
				form.setDescricaoFuncionarioResponsavel(funcionario.getNome());

				httpServletRequest.setAttribute("nomeCampo", "botaoAdicionarSolicitante");
			}
		}

		/*
		 * Fim das pesquisas realizadas pelo ENTER
		 * 
		 * ==========================================================================================
		 * =================
		 * 
		 * ==========================================================================================
		 * =================
		 */

		String nomeSolicitante = null;
		if(form.getNomeSolicitanteInformar() != null && !form.getNomeSolicitanteInformar().equalsIgnoreCase("")){
			nomeSolicitante = form.getNomeSolicitanteInformar();
		}

		Collection colecaoEndereco = null;
		if(sessao.getAttribute("colecaoEnderecosSolicitante") != null){
			colecaoEndereco = (Collection) sessao.getAttribute("colecaoEnderecosSolicitante");
		}
		if(colecaoEndereco == null){
			throw new ActionServletException("atencao.endereco_solicitante_nao_informado");
		}

		Collection colecaoFone = null;
		if(sessao.getAttribute("colecaoFonesSolicitante") != null){
			colecaoFone = (Collection) sessao.getAttribute("colecaoFonesSolicitante");
		}
		// Em conversa com Luana e Alessandro, ficou definido que o telefone � opcional.
		// Assim como tamb�m n�o fala da obrigatoriedade do telefone no caso de uso.
		// if(colecaoFone == null){
		// throw new ActionServletException("atencao.telefone_solicitante_nao_informado");
		// }

		Short indicadorClienteEspecificacao = null;
		if(form.getIndicadorClienteEspecificacao() != null && !form.getIndicadorClienteEspecificacao().equalsIgnoreCase("")){
			indicadorClienteEspecificacao = Short.valueOf(form.getIndicadorClienteEspecificacao());
		}

		String pontoReferencia = null;
		if(form.getPontoReferenciaSolicitante() != null && !form.getPontoReferenciaSolicitante().equalsIgnoreCase("")){
			pontoReferencia = form.getPontoReferenciaSolicitante();
		}

		String clienteTipo = "-1";
		if(!Util.isVazioOuBranco(form.getClienteTipo()) && !form.getClienteTipo().equals("-1")){
			clienteTipo = form.getClienteTipo();
		}

		String idEspecificacao = "";
		if(!Util.isVazioOuBranco(form.getIdEspecificacao())){
			idEspecificacao = form.getIdEspecificacao();
		}

		String numeroCpf = "";
		if(!Util.isVazioOuBranco(form.getNumeroCpf())){
			numeroCpf = form.getNumeroCpf();
		}

		String numeroRG = "";
		if(!Util.isVazioOuBranco(form.getNumeroRG())){
			numeroRG = form.getNumeroRG();
		}

		String orgaoExpedidorRg = "-1";
		if(!Util.isVazioOuBranco(form.getOrgaoExpedidorRg())){
			orgaoExpedidorRg = form.getOrgaoExpedidorRg();
		}

		String unidadeFederacaoRG = "-1";
		if(!Util.isVazioOuBranco(form.getUnidadeFederacaoRG())){
			unidadeFederacaoRG = form.getUnidadeFederacaoRG();
		}

		String numeroCnpj = "";
		if(!Util.isVazioOuBranco(form.getNumeroCnpj())){
			numeroCnpj = form.getNumeroCnpj();
		}

		/*
		 * Obtendo o id do im�vel informado na aba de inser��o n� 02 (Caso n�o
		 * tenho sido informado ser� passado como par�metro NULL).
		 */
		String idImovel = null;

		// caso seja do processo de atualizar registro atendimento
		if(objetoColecao != null && !objetoColecao.equals("")){
			AtualizarRegistroAtendimentoActionForm atualizarRegistroAtendimentoActionForm = (AtualizarRegistroAtendimentoActionForm) sessao
							.getAttribute("AtualizarRegistroAtendimentoActionForm");
			idImovel = atualizarRegistroAtendimentoActionForm.getIdImovel();
			if(!objetoColecao.equals("SIM") && idRASolicitante != null && !idRASolicitante.equals("")){
				// Verifica os dados do solicitante com rela��o a rg, cpf e cnpj
				if(!fachada.isMeioSolicitacaoLiberaDocumentoIdentificacaoRA(Integer.valueOf(form.getIdMeioSolicitacao()))){
					fachada.verificarDadosSolicitanteRgCpfCnpj(clienteTipo, idEspecificacao, numeroCpf, numeroRG, orgaoExpedidorRg,
									unidadeFederacaoRG, numeroCnpj);
				}
				// [FS0030] � Verificar preenchimento dos dados de identifica��o
				// do
				// solicitante
				fachada.verificaDadosSolicitanteAtualizar(Util.converterStringParaInteger(form.getIdCliente()), Util
								.converterStringParaInteger(form.getIdUnidadeSolicitanteInformar()), Util.converterStringParaInteger(form
								.getIdFuncionarioResponsavel()), nomeSolicitante, colecaoEndereco, colecaoFone,
								indicadorClienteEspecificacao, Util.converterStringParaInteger(idImovel), Util
												.converterStringParaInteger(form.getIdRA()), Util
												.converterStringParaInteger(idRASolicitante));

			}else{
				// Verifica os dados do solicitante com rela��o a rg, cpf e cnpj
				if(!fachada.isMeioSolicitacaoLiberaDocumentoIdentificacaoRA(Integer.valueOf(form.getIdMeioSolicitacao()))){
					fachada.verificarDadosSolicitanteRgCpfCnpj(clienteTipo, idEspecificacao, numeroCpf, numeroRG, orgaoExpedidorRg,
									unidadeFederacaoRG, numeroCnpj);
				}
				// [FS0030] � Verificar preenchimento dos dados de identifica��o
				// do
				// solicitante
				fachada.verificaDadosSolicitante(Util.converterStringParaInteger(form.getIdCliente()), Util.converterStringParaInteger(form
								.getIdUnidadeSolicitanteInformar()), Util.converterStringParaInteger(form.getIdFuncionarioResponsavel()),
								nomeSolicitante, colecaoEndereco, colecaoFone, indicadorClienteEspecificacao, Util
												.converterStringParaInteger(idImovel), Util.converterStringParaInteger(form.getIdRA()),
								null);
			}

			Collection colecaoRASolicitante = (Collection) sessao.getAttribute("colecaoRASolicitante");

			RegistroAtendimentoSolicitante registroAtendimentoSolicitante = fachada.inserirDadosNoRegistroAtendimentoSolicitante(Util
							.converterStringParaInteger(form.getIdRA()), Util.converterStringParaInteger(form.getIdCliente()),
							colecaoEndereco, pontoReferencia, nomeSolicitante, Util.converterStringParaInteger(form
											.getIdUnidadeSolicitanteInformar()), Util.converterStringParaInteger(form
											.getIdFuncionarioResponsavel()), colecaoFone, form.getClienteFoneSelected(), clienteTipo, form
											.getNumeroCpf(), form.getNumeroRG(), form.getOrgaoExpedidorRg(), form.getUnidadeFederacaoRG(),
							form.getNumeroCnpj());

			if(objetoColecao != null && !objetoColecao.equals("SIM")){
				Iterator iteRASolicitante = colecaoRASolicitante.iterator();
				while(iteRASolicitante.hasNext()){
					RegistroAtendimentoSolicitante registroAtendimentoSolicitanteColecao = (RegistroAtendimentoSolicitante) iteRASolicitante
									.next();
					if(registroAtendimentoSolicitanteColecao.getUltimaAlteracao().getTime() == Util.converterStringParaLong(objetoColecao)
									.longValue()){
						if(registroAtendimentoSolicitanteColecao.getID() != null){
							registroAtendimentoSolicitante.setID(registroAtendimentoSolicitanteColecao.getID());

							registroAtendimentoSolicitante.setIndicadorSolicitantePrincipal(registroAtendimentoSolicitanteColecao
											.getIndicadorSolicitantePrincipal());

						}
						registroAtendimentoSolicitante.setUltimaAlteracao(registroAtendimentoSolicitanteColecao.getUltimaAlteracao());
						iteRASolicitante.remove();
						break;
					}
				}

			}else{
				// seta a ultima altera��o
				registroAtendimentoSolicitante.setUltimaAlteracao(new Date());
			}

			// recupera o nome do solicitante
			// se o cliente est� diferente de vazio ent�o
			if(form.getIdCliente() != null && !form.getIdCliente().equals("")){
				registroAtendimentoSolicitante.setSolicitante(form.getNomeCliente());
			}else{
				// se o id da unidade for diferente de nula
				if(form.getIdUnidadeSolicitanteInformar() != null && !form.getIdUnidadeSolicitanteInformar().equals("")){

					registroAtendimentoSolicitante.setSolicitante(form.getDescricaoUnidadeSolicitanteInformar());
				}else{
					// sen�o recupera do solicitante que foi
					// digitado
					registroAtendimentoSolicitante.setSolicitante(form.getNomeSolicitanteInformar());
				}
			}

			colecaoRASolicitante.add(registroAtendimentoSolicitante);

			// Iniciar Funcionalidade
			httpServletRequest
							.setAttribute("iniciarFuncionalidade",
											"/gsan/atualizarRegistroAtendimentoWizardAction.do?action=exibirAtualizarRegistroAtendimentoDadosSolicitanteAction");
		}else{
			// caso seja do processo de inserir registro atendimento
			InserirRegistroAtendimentoActionForm inserirRegistroAtendimentoActionForm = (InserirRegistroAtendimentoActionForm) sessao
							.getAttribute("InserirRegistroAtendimentoActionForm");
			idImovel = inserirRegistroAtendimentoActionForm.getIdImovel();

			// Verifica os dados do solicitante com rela��o a rg, cpf e cnpj
			fachada.verificarDadosSolicitanteRgCpfCnpj(clienteTipo, idEspecificacao, form.getNumeroCpf(), form.getNumeroRG(),
							form
							.getOrgaoExpedidorRg(), form.getUnidadeFederacaoRG(), form.getNumeroCnpj());
			// [FS0030] � Verificar preenchimento dos dados de identifica��o
			// do
			// solicitante
			fachada.verificaDadosSolicitante(Util.converterStringParaInteger(form.getIdCliente()), Util.converterStringParaInteger(form
							.getIdUnidadeSolicitanteInformar()), Util.converterStringParaInteger(form.getIdFuncionarioResponsavel()),
							nomeSolicitante, colecaoEndereco, colecaoFone, indicadorClienteEspecificacao, Util
											.converterStringParaInteger(idImovel), Util.converterStringParaInteger(form.getIdRA()), null);

			// [SB0027] � Inclui Solicitante do Registro de Atendimento
			fachada.inserirRegistroAtendimentoSolicitante(Util.converterStringParaInteger(form.getIdRA()), Util
							.converterStringParaInteger(form.getIdCliente()), colecaoEndereco, pontoReferencia, nomeSolicitante, true, Util
							.converterStringParaInteger(form.getIdUnidadeSolicitanteInformar()), Util.converterStringParaInteger(form
							.getIdFuncionarioResponsavel()), colecaoFone, clienteTipo, form.getNumeroCpf(), form.getNumeroRG(), form
							.getOrgaoExpedidorRg(), form.getUnidadeFederacaoRG(), form.getNumeroCnpj());

			// Iniciar Funcionalidade
			httpServletRequest.setAttribute("iniciarFuncionalidade", "/gsan/exibirInserirRegistroAtendimentoAction.do?idRaSolicitante="
							+ form.getIdRA());
		}

		sessao.removeAttribute("atualizacaoRA");
		sessao.removeAttribute("objetoColecao");

		sessao.removeAttribute("idRASolicitante");
		sessao.removeAttribute("enderecoOcorrenciaRA");
		limparCliente(sessao);
		limparUnidadeSolicitante(sessao);
		limparNomeSolicitante(sessao);

		return retorno;
	}

	private void limparCliente(HttpSession sessao){

		sessao.removeAttribute("colecaoEnderecosSolicitante");
		sessao.removeAttribute("colecaoFonesSolicitante");
		sessao.removeAttribute("desabilitarDadosSolicitanteUnidade");
		sessao.removeAttribute("desabilitarDadosSolicitanteFuncionario");
		sessao.removeAttribute("desabilitarDadosSolicitanteNome");
		sessao.removeAttribute("habilitarAlteracaoEnderecoSolicitante");

	}

	private void limparUnidadeSolicitante(HttpSession sessao){

		sessao.removeAttribute("desabilitarDadosSolicitanteCliente");
		sessao.removeAttribute("desabilitarDadosSolicitanteNome");
		sessao.removeAttribute("habilitarAlteracaoEnderecoSolicitante");

	}

	private void limparNomeSolicitante(HttpSession sessao){

		sessao.removeAttribute("desabilitarDadosSolicitanteCliente");
		sessao.removeAttribute("desabilitarDadosSolicitanteUnidade");
		sessao.removeAttribute("desabilitarDadosSolicitanteFuncionario");
		sessao.removeAttribute("habilitarAlteracaoEnderecoSolicitante");

	}
}
