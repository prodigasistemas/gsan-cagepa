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

import gcom.cadastro.localidade.FiltroGerenciaRegional;
import gcom.cadastro.localidade.FiltroLocalidade;
import gcom.cadastro.localidade.GerenciaRegional;
import gcom.cadastro.localidade.Localidade;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.relatorio.ExibidorProcessamentoTarefaRelatorio;
import gcom.relatorio.cadastro.imovel.RelatorioGrandesConsumidores;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.tarefa.TarefaRelatorio;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * [UC0XXX] Gerar Relat�rio Grandes Consumidores
 * 
 * @author Anderson Italo
 * @date 16/02/2011
 */
public class GerarRelatorioGrandesConsumidoresAction
				extends ExibidorProcessamentoTarefaRelatorio {

	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// cria a vari�vel de retorno
		ActionForward retorno = null;
		GerarRelatorioGrandesConsumidoresActionForm formulario = (GerarRelatorioGrandesConsumidoresActionForm) actionForm;
		Fachada fachada = Fachada.getInstancia();

		if(formulario.getCodigoGerencia() != null && !formulario.getCodigoGerencia().equals("")){

			// [FS0001] � Verificar exist�ncia da localidade
			Localidade localidadeInicial = null;
			Localidade localidadeFinal = null;
			FiltroLocalidade filtroLocalidade = new FiltroLocalidade();

			filtroLocalidade.adicionarParametro(new ParametroSimples(FiltroLocalidade.ID, new Integer(formulario
							.getCodigoLocalidadeInicial())));
			filtroLocalidade.adicionarParametro(new ParametroSimples(FiltroLocalidade.ID_GERENCIA, new Integer(formulario
							.getCodigoGerencia())));

			Collection colecaoLocalidade = fachada.pesquisar(filtroLocalidade, Localidade.class.getName());

			if(colecaoLocalidade == null || colecaoLocalidade.isEmpty()){
				throw new ActionServletException("atencao.pesquisa_inexistente", null, "Localidade Inicial");
			}else{
				localidadeInicial = (Localidade) gcom.util.Util.retonarObjetoDeColecao(colecaoLocalidade);
			}

			filtroLocalidade = null;
			colecaoLocalidade = null;

			filtroLocalidade = new FiltroLocalidade();
			filtroLocalidade.adicionarParametro(new ParametroSimples(FiltroLocalidade.ID,
							new Integer(formulario.getCodigoLocalidadeFinal())));
			filtroLocalidade.adicionarParametro(new ParametroSimples(FiltroLocalidade.ID_GERENCIA, new Integer(formulario
							.getCodigoGerencia())));

			colecaoLocalidade = fachada.pesquisar(filtroLocalidade, Localidade.class.getName());

			if(colecaoLocalidade == null || colecaoLocalidade.isEmpty()){
				throw new ActionServletException("atencao.pesquisa_inexistente", null, "Localidade Final");
			}else{
				localidadeFinal = (Localidade) gcom.util.Util.retonarObjetoDeColecao(colecaoLocalidade);
			}

			// [FS0002] � Verificar Localidade final menor que Localidade Inicial
			if(localidadeInicial.getId().intValue() > localidadeFinal.getId().intValue()){
				throw new ActionServletException("atencao.localidafinal.menor.localidadeinicial", null, "");
			}

			FiltroGerenciaRegional filtroGerenciaRegional = new FiltroGerenciaRegional();
			filtroGerenciaRegional.adicionarParametro(new ParametroSimples(FiltroGerenciaRegional.ID, new Integer(formulario
							.getCodigoGerencia())));

			Collection colecaoGerenciaRegional = fachada.pesquisar(filtroGerenciaRegional, GerenciaRegional.class.getName());
			GerenciaRegional gerenciaRegional = (GerenciaRegional) Util.retonarObjetoDeColecao(colecaoGerenciaRegional);

			RelatorioGrandesConsumidores relatorio = new RelatorioGrandesConsumidores((Usuario) (httpServletRequest.getSession(false))
							.getAttribute("usuarioLogado"));

			relatorio.addParametro("idLocalidadeInicial", localidadeInicial.getId());
			relatorio.addParametro("idLocalidadeFinal", localidadeFinal.getId());
			relatorio.addParametro("nomeLocalidadeInicial", localidadeInicial.getDescricao());
			relatorio.addParametro("nomeLocalidadeFinal", localidadeFinal.getDescricao());
			relatorio.addParametro("idGerenciaRegional", gerenciaRegional.getId());
			relatorio.addParametro("nomeGerencia", gerenciaRegional.getNome());

			relatorio.addParametro("tipoFormatoRelatorio", TarefaRelatorio.TIPO_PDF);
			retorno = processarExibicaoRelatorio(relatorio, String.valueOf(TarefaRelatorio.TIPO_PDF), httpServletRequest,
							httpServletResponse, actionMapping);

		}else{

			throw new ActionServletException("atencao.informe_campo", null, "Gerencia Regional");
		}

		return retorno;
	}
}
