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

import gcom.gui.ActionServletException;
import gcom.gui.cadastro.imovel.FiltrarAtualizacaoCadastralColetorDadosActionForm;
import gcom.relatorio.ExibidorProcessamentoTarefaRelatorio;
import gcom.relatorio.cadastro.imovel.RelatorioAtualizacaoCadastralColetorDados;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.tarefa.TarefaRelatorio;
import gcom.util.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * [UC3113] Atualizacao Cadastral Coletor de Dados
 * 
 * @author Victon Malcolm
 * @since 10/10/2013
 */
public class GerarRelatorioAtualizacaoCadastralColetorDadosAction
				extends ExibidorProcessamentoTarefaRelatorio {

	/**
	 * < <Descri��o do m�todo>>
	 * 
	 * @param actionMapping
	 *            Descri��o do par�metro
	 * @param actionForm
	 *            Descri��o do par�metro
	 * @param httpServletRequest
	 *            Descri��o do par�metro
	 * @param httpServletResponse
	 *            Descri��o do par�metro
	 * @return Descri��o do retorno
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Valida os par�metro passados como consulta
		ActionForward retorno = null;

		FiltrarAtualizacaoCadastralColetorDadosActionForm filtrarAtualizacaoCadastralColetorDadosActionForm = (FiltrarAtualizacaoCadastralColetorDadosActionForm) actionForm;
		// Recupera os par�metros do form
		Integer referenciaInicial = new Integer(Util.formatarMesAnoComBarraParaAnoMes(filtrarAtualizacaoCadastralColetorDadosActionForm
						.getReferenciaInicial()));
		Integer referenciaFinal = new Integer(Util.formatarMesAnoComBarraParaAnoMes(filtrarAtualizacaoCadastralColetorDadosActionForm
						.getReferenciaFinal()));
		Integer matricula = null;
		Integer localidade = null;
		Integer setorComercial = null;
		Integer rota = null;
		if(!filtrarAtualizacaoCadastralColetorDadosActionForm.getMatriculaImovel().equals("")){
			matricula = new Integer(filtrarAtualizacaoCadastralColetorDadosActionForm.getMatriculaImovel());
		}else{
			if(!filtrarAtualizacaoCadastralColetorDadosActionForm.getLocalidade().equals("")){
				localidade = new Integer(filtrarAtualizacaoCadastralColetorDadosActionForm.getLocalidade());
				if(!filtrarAtualizacaoCadastralColetorDadosActionForm.getSetorComercial().equals("")){
					setorComercial = new Integer(filtrarAtualizacaoCadastralColetorDadosActionForm.getSetorComercial());
				}
				if(!filtrarAtualizacaoCadastralColetorDadosActionForm.getRota().equals("")){
					rota = new Integer(filtrarAtualizacaoCadastralColetorDadosActionForm.getRota());
				}
			}else{
				throw new ActionServletException("atencao.naoinformado", "Matricula ou Localidade");
			}
		}

		// Fim da parte que vai mandar os parametros para o relat�rio

		String tipoRelatorio = httpServletRequest.getParameter("tipoRelatorio");

		RelatorioAtualizacaoCadastralColetorDados relatorioAtualizacaoCadastralColetorDados = new RelatorioAtualizacaoCadastralColetorDados(
							(Usuario) (httpServletRequest.getSession(false)).getAttribute("usuarioLogado"));
		relatorioAtualizacaoCadastralColetorDados.addParametro("referenciaInicial", referenciaInicial);
		relatorioAtualizacaoCadastralColetorDados.addParametro("referenciaFinal", referenciaFinal);
		relatorioAtualizacaoCadastralColetorDados.addParametro("matricula", matricula);
		relatorioAtualizacaoCadastralColetorDados.addParametro("localidade", localidade);
		relatorioAtualizacaoCadastralColetorDados.addParametro("setorComercial", setorComercial);
		relatorioAtualizacaoCadastralColetorDados.addParametro("rota", rota);
			if(tipoRelatorio == null){
				tipoRelatorio = TarefaRelatorio.TIPO_PDF + "";
			}

		relatorioAtualizacaoCadastralColetorDados.addParametro("tipoFormatoRelatorio", Integer.parseInt(tipoRelatorio));

		retorno = processarExibicaoRelatorio(relatorioAtualizacaoCadastralColetorDados, tipoRelatorio, httpServletRequest,
						httpServletResponse,
							actionMapping);

		// devolve o mapeamento contido na vari�vel retorno
		return retorno;
	}

}
