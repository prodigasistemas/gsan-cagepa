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

package gcom.gui.cadastro.imovel;

import gcom.cadastro.cliente.Cliente;
import gcom.cadastro.cliente.ClienteImovel;
import gcom.cadastro.cliente.FiltroCliente;
import gcom.cadastro.cliente.FiltroClienteImovel;
import gcom.cadastro.imovel.FiltroImovelCobrancaSituacao;
import gcom.cadastro.imovel.ImovelCobrancaSituacao;
import gcom.cobranca.CobrancaSituacao;
import gcom.cobranca.FiltroCobrancaSituacao;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.filtro.ParametroNulo;
import gcom.util.filtro.ParametroSimples;
import gcom.util.filtro.ParametroSimplesDiferenteDe;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * < <Descri��o da Classe>>
 * 
 * @author Administrador
 */
public class ExibirInserirImovelSituacaoCobrancaAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta o mapeamento de retorno
		ActionForward retorno = actionMapping.findForward("exibirInserirImovelSituacaoCobranca");

		Fachada fachada = Fachada.getInstancia();

		// Mudar isso quando tiver esquema de seguran�a
		// HttpSession sessao = httpServletRequest.getSession(false);

		InserirImovelSituacaoCobrancaActionForm form = (InserirImovelSituacaoCobrancaActionForm) actionForm;

		String idImovel = httpServletRequest.getParameter("idImovel");

		if(idImovel == null || idImovel.equalsIgnoreCase("")){
			idImovel = form.getCodigoImovel();
		}

		form.setCodigoImovel(idImovel);
		form.setDataImplantacao(Util.formatarData(new Date()));
		String matriculaImovel = fachada.pesquisarInscricaoImovel(new Integer(idImovel), true);

		if(matriculaImovel != null && !matriculaImovel.equalsIgnoreCase("")){
			form.setMatriculaImovel(matriculaImovel);
		}else{
			throw new ActionServletException("atencao.imovel.inexistente");
		}

		if(httpServletRequest.getParameter("objetoConsulta") != null){

			// VERIFICANDO ESCRITORIO (Kassia Albuquerque)
			if((form.getIdEscritorio() != null && !form.getIdEscritorio().equals(""))){

				FiltroCliente filtroCliente = new FiltroCliente();
				filtroCliente.adicionarParametro(new ParametroSimples(FiltroCliente.ID, form.getIdEscritorio()));
				Collection colecaoEscritorio = fachada.pesquisar(filtroCliente, Cliente.class.getName());

				if(colecaoEscritorio != null && !colecaoEscritorio.isEmpty()){

					Cliente escritorios = (Cliente) colecaoEscritorio.iterator().next();
					form.setNomeEscritorio(escritorios.getNome());

				}else{
					httpServletRequest.setAttribute("escritorioEncontrado", "exception");
					form.setIdEscritorio("");
					form.setNomeEscritorio("ESCRIT�RIO DE ADVOCACIA INEXISTENTE");
				}

			}

			// VERIFICANDO ADVOGADO (Kassia Albuquerque)
			if((form.getIdAdvogado() != null && !form.getIdAdvogado().equals(""))){

				FiltroCliente filtroCliente = new FiltroCliente();
				filtroCliente.adicionarParametro(new ParametroSimples(FiltroCliente.ID, form.getIdAdvogado()));
				Collection colecaoAdvogado = fachada.pesquisar(filtroCliente, Cliente.class.getName());

				if(colecaoAdvogado != null && !colecaoAdvogado.isEmpty()){

					Cliente advogados = (Cliente) colecaoAdvogado.iterator().next();
					form.setNomeAdvogado(advogados.getNome());

				}else{
					httpServletRequest.setAttribute("advogadoEncontrado", "exception");
					form.setIdAdvogado("");
					form.setNomeAdvogado("ADVOGADO INEXISTENTE");
				}

			}

			// VERIFICANDO CLIENTE ALVO
			if(form.getIdClienteAlvo() != null && !form.getIdClienteAlvo().equalsIgnoreCase("")){
				String idCliente = form.getIdClienteAlvo();

				Cliente cliente = fachada.pesquisarClienteDigitado(new Integer(idCliente));
				if(cliente != null){
					FiltroClienteImovel filtroClienteImovel = new FiltroClienteImovel();
					filtroClienteImovel.adicionarParametro(new ParametroSimples(FiltroClienteImovel.CLIENTE_ID, idCliente));
					filtroClienteImovel.adicionarParametro(new ParametroSimples(FiltroClienteImovel.IMOVEL_ID, idImovel));
					Collection colecaoClienteImovel = fachada.pesquisar(filtroClienteImovel, ClienteImovel.class.getName());

					if(colecaoClienteImovel != null && !colecaoClienteImovel.isEmpty()){
						form.setNomeClienteAlvo(cliente.getNome());
					}else{
						throw new ActionServletException("atencao.cliente_informado_nao_corresponde_imovel");
					}

				}else{
					throw new ActionServletException("atencao.cliente.inexistente");
				}
			}

			// SITUACAO COBRANCA
			if(form.getSituacaoCobranca() != null && !form.getSituacaoCobranca().equalsIgnoreCase("")){

				String idSituacaoCobranca = form.getSituacaoCobranca();
				FiltroCobrancaSituacao filtroCobrancaSituacao = new FiltroCobrancaSituacao();
				filtroCobrancaSituacao.adicionarParametro(new ParametroSimples(FiltroCobrancaSituacao.ID, idSituacaoCobranca));
				filtroCobrancaSituacao.adicionarCaminhoParaCarregamentoEntidade("contaMotivoRevisao");

				Collection colecaoCobrancaSituacao = fachada.pesquisar(filtroCobrancaSituacao, CobrancaSituacao.class.getName());
				CobrancaSituacao cobrancaSituacao = (CobrancaSituacao) colecaoCobrancaSituacao.iterator().next();

				if(cobrancaSituacao.getContaMotivoRevisao() == null){
					httpServletRequest.setAttribute("bloqueiaAnoMes", "sim");
					form.setAnoMesReferenciaInicio("");
					form.setAnoMesReferenciaFim("");
				}

				// HABILITANDO OS CAMPOS ESCRITORIO E ADVOGADO (Kassia Albuquerque)
				if(cobrancaSituacao.getIndicadorExigenciaAdvogado() != null
								&& cobrancaSituacao.getIndicadorExigenciaAdvogado().equals(ConstantesSistema.INDICADOR_USO_ATIVO)){
					httpServletRequest.setAttribute("ativo", "ativo");
				}else{
					form.setIdAdvogado("");
					form.setNomeAdvogado("");
					form.setIdEscritorio("");
					form.setNomeEscritorio("");
				}
			}
		}else{
			Cliente cliente = fachada.pesquisarClienteUsuarioImovel(new Integer(form.getCodigoImovel()));

			form.setIdClienteAlvo(cliente.getId().toString());
			form.setNomeClienteAlvo(cliente.getNome());
		}

		FiltroImovelCobrancaSituacao filtroImovelCobrancaSituacao = new FiltroImovelCobrancaSituacao();
		filtroImovelCobrancaSituacao
						.adicionarParametro(new ParametroSimples(FiltroImovelCobrancaSituacao.IMOVEL_ID, new Integer(idImovel)));
		filtroImovelCobrancaSituacao.adicionarParametro(new ParametroNulo(FiltroImovelCobrancaSituacao.DATA_RETIRADA_COBRANCA));

		filtroImovelCobrancaSituacao.adicionarCaminhoParaCarregamentoEntidade(FiltroImovelCobrancaSituacao.COBRANCA_SITUACAO);

		Collection colecaoImovelCobrancaSituacao = getFachada().pesquisar(filtroImovelCobrancaSituacao,
						ImovelCobrancaSituacao.class.getName());

		FiltroCobrancaSituacao filtroCobrancaSituacao = new FiltroCobrancaSituacao();

		filtroCobrancaSituacao.adicionarParametro(new ParametroSimples(FiltroCobrancaSituacao.INDICADOR_USO, ConstantesSistema.SIM));
		filtroCobrancaSituacao.adicionarParametro(new ParametroSimples(FiltroCobrancaSituacao.INDICADOR_BLOQUEIO_INCLUSAO,
						ConstantesSistema.NAO));

		Iterator it = colecaoImovelCobrancaSituacao.iterator();

		while(it.hasNext()){
			ImovelCobrancaSituacao imovelCobrancaSituacao = (ImovelCobrancaSituacao) it.next();
			filtroCobrancaSituacao.adicionarParametro(new ParametroSimplesDiferenteDe(FiltroCobrancaSituacao.ID, imovelCobrancaSituacao
							.getCobrancaSituacao().getId()));
		}

		filtroCobrancaSituacao.setCampoOrderBy(FiltroCobrancaSituacao.DESCRICAO);

		Collection colecaoSituacaoCobranca = fachada.pesquisar(filtroCobrancaSituacao, CobrancaSituacao.class.getName());

		if(colecaoSituacaoCobranca == null || colecaoSituacaoCobranca.isEmpty()){
			throw new ActionServletException("atencao.nao_possivel_informar_situacao_cobranca_imovel");
		}

		httpServletRequest.setAttribute("colecaoSituacaoCobranca", colecaoSituacaoCobranca);

		return retorno;

	}

}
