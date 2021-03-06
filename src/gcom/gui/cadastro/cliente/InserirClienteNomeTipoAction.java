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

package gcom.gui.cadastro.cliente;

import gcom.cadastro.cliente.*;
import gcom.cadastro.endereco.EnderecoTipo;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.gui.StatusWizard;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;

import java.util.Collection;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

/**
 * Description of the Class
 * 
 * @author Rodrigo
 * @author eduardo henrique
 * @date 27/06/2008
 *       Retirada da Valida��o de Unidade de Federa��o, para verificar se � um atributo de Pessoa
 *       F�sica
 *       e adi��o de verifica��o para Inscri��o Estaudal para Pessoa Jur�dica
 */
public class InserirClienteNomeTipoAction
				extends GcomAction {

	/**
	 * Description of the Method
	 * 
	 * @param actionMapping
	 *            Description of the Parameter
	 * @param actionForm
	 *            Description of the Parameter
	 * @param httpServletRequest
	 *            Description of the Parameter
	 * @param httpServletResponse
	 *            Description of the Parameter
	 * @return Description of the Return Value
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		ActionForward retorno = null;

		HttpSession session = httpServletRequest.getSession(false);

		DynaValidatorForm clienteActionForm = (DynaValidatorForm) actionForm;

		// Verifica se o usu�rio escolheu algum tipo de pessoa para que seja
		// mostrada a p�gina de pessoa f�sica ou de jur�dica, se nada estiver
		// especificado a p�gina selecionada ser� a de pessoa f�sica
		Short tipoPessoa = (Short) clienteActionForm.get("tipoPessoa");

		Fachada fachada = Fachada.getInstancia();

		FiltroClienteTipo filtroClienteTipo = new FiltroClienteTipo();

		// Verifica qual � o pr�ximo passo para a execu��o do processo
		String destinoPagina = httpServletRequest.getParameter("destino");

		String tipoPessoaForm = tipoPessoa.toString();

		filtroClienteTipo.adicionarParametro(new ParametroSimples(FiltroClienteTipo.ID, tipoPessoaForm));
		tipoPessoa = ((ClienteTipo) fachada.pesquisar(filtroClienteTipo, ClienteTipo.class.getName()).iterator().next())
						.getIndicadorPessoaFisicaJuridica();

		// Verifica o destino porque se o usu�rio tentar concluir o processo
		// nesta p�gina, n�o � necess�rio verificar a tela de confirma��o
		if(destinoPagina != null && !destinoPagina.trim().equals("")){

			// Coloca o statusWizard na sess�o, pois quando abre a tela de confirma��o dos dados
			// precisa desse objeto.
			// Estava dando null pointer na classe GComAction quando pegava o statusWizard.
			String nomeUnicoWizard = null;
			if(session.getAttribute("nomeUnicoWizard") != null){
				nomeUnicoWizard = (String) session.getAttribute("nomeUnicoWizard");
			}

			StatusWizard statusWizard = null;
			if(nomeUnicoWizard != null){
				statusWizard = (StatusWizard) session.getAttribute(nomeUnicoWizard);
				session.setAttribute("statusWizard", statusWizard);
			}

			if(tipoPessoa != null){
				if(tipoPessoa.equals(ClienteTipo.INDICADOR_PESSOA_JURIDICA)){

					clienteActionForm.set("indicadorPessoaFisicaJuridica", "" + ClienteTipo.INDICADOR_PESSOA_JURIDICA);

					// Vai para Pessoa Juridica mas tem dados existentes em pessoa fisica
					String cpf = (String) clienteActionForm.get("cpf");
					// Verifica Existencia de CPF j� cadastrado
					if(cpf != null && !cpf.equals("")){
						this.existeCpf(cpf, fachada);
					}
					String rg = (String) clienteActionForm.get("rg");
					String dataEmissao = (String) clienteActionForm.get("dataEmissao");
					Integer idOrgaoExpedidor = (Integer) clienteActionForm.get("idOrgaoExpedidor");
					String dataNascimento = (String) clienteActionForm.get("dataNascimento");
					Integer idProfissao = (Integer) clienteActionForm.get("idProfissao");
					Integer idPessoaSexo = (Integer) clienteActionForm.get("idPessoaSexo");
					clienteActionForm.set("idPessoaSexo", -1);

					if(session.getAttribute("colecaoEnderecos") != null){
						Collection enderecosCliente = (Collection) session.getAttribute("colecaoEnderecos");
						Iterator itEndereco = enderecosCliente.iterator();
						ClienteEndereco clienteEndereco = new ClienteEndereco();

						if(itEndereco.hasNext()){
							clienteEndereco = (ClienteEndereco) itEndereco.next();

							clienteEndereco.getEnderecoTipo().setId(new Integer(EnderecoTipo.ENDERECO_TIPO_COMERCIAL));
							clienteEndereco.getEnderecoTipo().setDescricao("COMERCIAL");
						}
					}else{
						session.setAttribute("tipoPessoa", tipoPessoa);
					}

					// Vai para Pessoa Juridica mas tem dados existentes em pessoa fisica
					if((idPessoaSexo != null && idPessoaSexo != ConstantesSistema.NUMERO_NAO_INFORMADO)
									|| (cpf != null && !cpf.trim().equalsIgnoreCase("")) || (rg != null && !rg.trim().equalsIgnoreCase(""))
									|| (dataEmissao != null && !dataEmissao.trim().equalsIgnoreCase(""))
									|| (dataNascimento != null && !dataNascimento.trim().equalsIgnoreCase(""))
									|| (idOrgaoExpedidor != null && idOrgaoExpedidor != ConstantesSistema.NUMERO_NAO_INFORMADO)
									|| (idProfissao != null && idProfissao != ConstantesSistema.NUMERO_NAO_INFORMADO)){
						return montarPaginaConfirmacaoWizard("confirmacao.processo.cliente.dependencia.pessoa_juridica",
										httpServletRequest, actionMapping);
					}

				}else if(tipoPessoa.equals(ClienteTipo.INDICADOR_PESSOA_FISICA)){
					// Vai para Pessoa Fisica mas tem dados existentes em pessoa juridica
					clienteActionForm.set("indicadorPessoaFisicaJuridica", "" + ClienteTipo.INDICADOR_PESSOA_FISICA);
					String cnpj = (String) clienteActionForm.get("cnpj");
					Integer idRamoAtividade = (Integer) clienteActionForm.get("idRamoAtividade");
					String codigoClienteResponsavel = (String) clienteActionForm.get("codigoClienteResponsavel");
					String inscricaoEstadual = (String) clienteActionForm.get("inscricaoEstadual");

					if(session.getAttribute("colecaoEnderecos") != null){
						Collection enderecosCliente = (Collection) session.getAttribute("colecaoEnderecos");
						Iterator itEndereco = enderecosCliente.iterator();
						ClienteEndereco clienteEndereco = new ClienteEndereco();

						if(itEndereco.hasNext()){
							clienteEndereco = (ClienteEndereco) itEndereco.next();

							clienteEndereco.getEnderecoTipo().setId(new Integer(EnderecoTipo.ENDERECO_TIPO_RESIDENCIAL));
							clienteEndereco.getEnderecoTipo().setDescricao("RESIDENCIAL");
						}
					}else{
						session.setAttribute("tipoPessoa", tipoPessoa);
					}

					if((cnpj != null && !cnpj.trim().equalsIgnoreCase(""))
									|| (inscricaoEstadual != null && !inscricaoEstadual.equalsIgnoreCase(""))
									|| (idRamoAtividade != null && idRamoAtividade != ConstantesSistema.NUMERO_NAO_INFORMADO)
									|| (codigoClienteResponsavel != null && !codigoClienteResponsavel.trim().equalsIgnoreCase(""))){
						return montarPaginaConfirmacaoWizard("confirmacao.processo.cliente.dependencia.pessoa_fisica", httpServletRequest,
										actionMapping);
					}
				}
			}
		}
		if(tipoPessoa != null){
			if(tipoPessoa.equals(ClienteTipo.INDICADOR_PESSOA_JURIDICA)){
				clienteActionForm.set("idPessoaSexo", -1);
			}else if(tipoPessoa.equals(ClienteTipo.INDICADOR_PESSOA_FISICA)){
				clienteActionForm.set("idPessoaSexo", null);
			}
		}
		return retorno;
	}

	private void existeCpf(String cpf, Fachada fachada){

		FiltroCliente filtroCpf = new FiltroCliente();
		filtroCpf.adicionarParametro(new ParametroSimples(FiltroCliente.CPF, cpf));

		Cliente clienteCpf = (Cliente) Util.retonarObjetoDeColecao(fachada.pesquisar(filtroCpf,

		Cliente.class.getName()));

		if(clienteCpf != null){
			throw new ActionServletException("atencao.cpf.cliente.ja_cadastrado", null,

			clienteCpf.getId().toString());
		}

	}
}