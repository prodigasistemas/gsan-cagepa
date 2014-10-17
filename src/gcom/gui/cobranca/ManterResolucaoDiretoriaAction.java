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

package gcom.gui.cobranca;

import gcom.cobranca.FiltroResolucaoDiretoriaGrupo;
import gcom.cobranca.ResolucaoDiretoria;
import gcom.cobranca.ResolucaoDiretoriaGrupo;
import gcom.cobranca.parcelamento.FiltroParcelamentoSituacaoEspecial;
import gcom.cobranca.parcelamento.ParcelamentoSituacaoEspecial;
import gcom.fachada.Fachada;
import gcom.gui.GcomAction;
import gcom.gui.ManutencaoRegistroActionForm;
import gcom.seguranca.acesso.Operacao;
import gcom.seguranca.acesso.OperacaoEfetuada;
import gcom.seguranca.acesso.usuario.UsuarioAcao;
import gcom.seguranca.acesso.usuario.UsuarioAcaoUsuarioHelper;
import gcom.util.ControladorException;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ManterResolucaoDiretoriaAction
				extends GcomAction {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta o retorno
		ActionForward retorno = actionMapping.findForward("telaSucesso");

		// Obt�m a inst�ncia da fachada
		Fachada fachada = Fachada.getInstancia();

		ManutencaoRegistroActionForm manutencaoRegistroActionForm = (ManutencaoRegistroActionForm) actionForm;

		// ------------ REGISTRAR TRANSA��O ----------------
		Operacao operacao = new Operacao();
		operacao.setId(Operacao.OPERACAO_RESOLUCAO_DIRETORIA_REMOVER);

		OperacaoEfetuada operacaoEfetuada = new OperacaoEfetuada();
		operacaoEfetuada.setOperacao(operacao);
		// ------------ REGISTRAR TRANSA��O ----------------

		// Pega os ids selecionados pelo o usu�rio para remo��o.
		String[] idsRegistrosRemocaoResolucaoDiretoria = manutencaoRegistroActionForm.getIdRegistrosRemocao();

		// Para cada RD -exlcuir os grupos e restirecoes de debitos associados
		for(String idResolucaoDiretoria : idsRegistrosRemocaoResolucaoDiretoria){
			FiltroResolucaoDiretoriaGrupo filtroResolucaoDiretoriaGrupo = new FiltroResolucaoDiretoriaGrupo();
			filtroResolucaoDiretoriaGrupo.adicionarParametro(new ParametroSimples(FiltroResolucaoDiretoriaGrupo.RESOLUCAO_DIRETORIA_ID,
							Integer.valueOf(idResolucaoDiretoria)));
			Collection colecaoGrupos = fachada.pesquisar(filtroResolucaoDiretoriaGrupo, ResolucaoDiretoriaGrupo.class.getName());

			if(!Util.isVazioOrNulo(colecaoGrupos)){
				try{
					fachada.removerColecaoObjetos(colecaoGrupos);
				}catch(ControladorException e){
					e.printStackTrace();
				}
			}

			FiltroParcelamentoSituacaoEspecial filtroParcelamentoSituacaoEspecial = new FiltroParcelamentoSituacaoEspecial();
			filtroParcelamentoSituacaoEspecial.adicionarParametro(new ParametroSimples(
							FiltroParcelamentoSituacaoEspecial.RESOLUCAO_DIRETORIA_ID, Integer.valueOf(idResolucaoDiretoria)));
			Collection colecaoRestricoes = fachada.pesquisar(filtroParcelamentoSituacaoEspecial, ParcelamentoSituacaoEspecial.class
							.getName());

			if(!Util.isVazioOrNulo(colecaoRestricoes)){
				try{
					fachada.removerColecaoObjetos(colecaoRestricoes);
				}catch(ControladorException e){
					e.printStackTrace();
				}
			}
		}

		// ------------ REGISTRAR TRANSA��O ----------------
		UsuarioAcaoUsuarioHelper usuarioAcaoUsuarioHelper = new UsuarioAcaoUsuarioHelper(getUsuarioLogado(httpServletRequest),
						UsuarioAcao.USUARIO_ACAO_EFETUOU_OPERACAO);
		Collection<UsuarioAcaoUsuarioHelper> colecaoUsuarios = new ArrayList();
		colecaoUsuarios.add(usuarioAcaoUsuarioHelper);

		// ------------ REGISTRAR TRANSA��O ----------------

		// Remove os objetos selecionados do banco, verificando se ele possui
		// algum v�nculo no sistema.
		fachada.remover(idsRegistrosRemocaoResolucaoDiretoria, ResolucaoDiretoria.class.getName(), operacaoEfetuada, colecaoUsuarios);

		// Monta a p�gina de sucesso de acordo com o padr�o do sistema.
		montarPaginaSucesso(httpServletRequest, idsRegistrosRemocaoResolucaoDiretoria.length
						+ " Resolu��o(�es) de Diretoria removidas(s) com sucesso.", "Realizar outra Manuten��o de Resolu��o de Diretoria",
						"exibirFiltrarResolucaoDiretoriaAction.do?menu=sim");

		return retorno;

	}
}
