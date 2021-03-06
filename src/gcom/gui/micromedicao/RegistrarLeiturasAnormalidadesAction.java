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
 * GSANPCG
 * Eduardo Henrique
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

package gcom.gui.micromedicao;

import gcom.fachada.Fachada;
import gcom.faturamento.FaturamentoAtividade;
import gcom.faturamento.FaturamentoGrupo;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.micromedicao.FiltroRota;
import gcom.micromedicao.Rota;
import gcom.micromedicao.leitura.LeituraTipo;
import gcom.micromedicao.medicao.MedicaoHistorico;
import gcom.util.ControladorException;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;
import gcom.util.filtro.ParametroSimplesDiferenteDe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action respons�vel para dar um onLoad no arquivo e importar os ceps.
 * 
 * @author S�vio Luiz
 * @created 24 de Agosto de 2005
 * @author eduardo henrique
 * @date 12/09/2008
 *       Altera��o na chamada para execu��o de Registro por tipo Celular/Mobile
 */
public class RegistrarLeiturasAnormalidadesAction
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

		ActionForward retorno = actionMapping.findForward("telaSucesso");

		try{

			String idFaturamentoGrupo = null;

			DiskFileUpload upload = new DiskFileUpload();

			String anoMesLeitura = null;
			Integer anoMesReferenciaGrupo = null;

			// Parse the request
			List items = upload.parseRequest(httpServletRequest);

			Fachada fachada = Fachada.getInstancia();
			Collection<MedicaoHistorico> colecaoMedicaoHistorico = new ArrayList();
			Collection<Rota> colecaoRotaFaturamentoImediato = new ArrayList();

			FileItem item = null;

			// pega uma lista de itens do form
			Iterator iter = items.iterator();
			while(iter.hasNext()){

				item = (FileItem) iter.next();

				if(item.getFieldName().equals("idFaturamentoGrupo")){
					idFaturamentoGrupo = item.getString();
				}

				if(idFaturamentoGrupo != null){
					Map<ControladorException, Collection<Object[]>> mapaErrosMovimentoEmpresa = fachada
									.verificarLimiteAnormalidadesAceitavel(Integer.valueOf(idFaturamentoGrupo));
					if(!mapaErrosMovimentoEmpresa.isEmpty()){
						retorno = actionMapping.findForward("telaErroAnormalidadeAceitavel");
						ControladorException controladorException = (ControladorException) Util
										.retonarObjetoDeColecao(mapaErrosMovimentoEmpresa.keySet());
						String[] parametrosMensagem = new String[controladorException.getParametroMensagem().size()];
						parametrosMensagem = controladorException.getParametroMensagem().toArray(parametrosMensagem);
						ActionServletException exception = new ActionServletException(controladorException.getMessage(),
										controladorException, parametrosMensagem);
						httpServletRequest.getSession().setAttribute("exception", exception);
						httpServletRequest.getSession().setAttribute("movimentosRoteiroEmpresaAnormalidade",
										mapaErrosMovimentoEmpresa.get(controladorException));
						return retorno;
					}

					FiltroRota filtroRota = new FiltroRota();
					filtroRota.adicionarParametro(new ParametroSimples(FiltroRota.FATURAMENTO_GRUPO_ID, idFaturamentoGrupo));
					filtroRota
									.adicionarParametro(new ParametroSimples(FiltroRota.LEITURA_TIPO_ID,
													LeituraTipo.LEITURA_E_ENTRADA_SIMULTANEA));
					colecaoRotaFaturamentoImediato = fachada.pesquisar(filtroRota, Rota.class.getName());
					filtroRota.limparListaParametros();
					filtroRota.adicionarParametro(new ParametroSimples(FiltroRota.FATURAMENTO_GRUPO_ID, idFaturamentoGrupo));
					filtroRota.adicionarParametro(new ParametroSimplesDiferenteDe(FiltroRota.LEITURA_TIPO_ID,
									LeituraTipo.LEITURA_E_ENTRADA_SIMULTANEA));
					Collection<Rota> colecaoRota = fachada.pesquisar(filtroRota, Rota.class.getName());

					anoMesReferenciaGrupo = fachada.pesquisarAnoMesPorIdFaturamentoGrupo(Integer.valueOf(idFaturamentoGrupo));
					if(anoMesReferenciaGrupo == null){
						throw new ActionServletException("atencao.anomes.faturamento.invalido");
					}
					anoMesLeitura = anoMesReferenciaGrupo.toString();
					if(Util.isVazioOrNulo(colecaoRota) && Util.isVazioOrNulo(colecaoRotaFaturamentoImediato)){
						throw new ActionServletException("atencao.nao_ha_rotas_grupo_faturamento", idFaturamentoGrupo);
					}
					if(!Util.isVazioOrNulo(colecaoRota)){
						colecaoMedicaoHistorico = fachada.criarMedicoesHistoricoRegistrarLeituraAnormalidade(Integer
										.valueOf(idFaturamentoGrupo), anoMesReferenciaGrupo, colecaoRota);
					}

				}

			}
			if(!Util.isVazioOrNulo(colecaoMedicaoHistorico)){
				fachada.registrarLeituraAnormalidade(colecaoMedicaoHistorico, Integer.valueOf(idFaturamentoGrupo),
								anoMesLeitura == null ? null : Integer.valueOf(anoMesLeitura), getUsuarioLogado(httpServletRequest));
			}

			if(!Util.isVazioOrNulo(colecaoRotaFaturamentoImediato)){
				// Faturamento Imediato
				FaturamentoGrupo faturamentoGrupo = fachada.pesquisarFaturamentoGrupoPorID(Integer.valueOf(idFaturamentoGrupo));

				fachada.registrarFaturamentoImediatoGrupoFaturamento(colecaoRotaFaturamentoImediato, faturamentoGrupo,
								anoMesReferenciaGrupo, FaturamentoAtividade.REGISTRAR_FATURAMENTO_IMEDIATO);
			}

			/*
			 * byte[] relatorioRetorno = null;
			 * OutputStream out = null;
			 * try { // cria uma inst�ncia da classe do relat�rio
			 * RelatorioRegistrarLeiturasAnormalidades
			 * relatorioRegistrarLeiturasAnormalidades = new
			 * RelatorioRegistrarLeiturasAnormalidades( (Usuario)
			 * (httpServletRequest.getSession(false))
			 * .getAttribute("usuarioLogado"));
			 * relatorioRegistrarLeiturasAnormalidades.addParametro(
			 * "colecaoMedicaoHistoricoRelatorio", dadosParaRelatorio);
			 * relatorioRegistrarLeiturasAnormalidades.addParametro(
			 * "idFaturamentoGrupo", idFaturamentoGrupo);
			 * relatorioRegistrarLeiturasAnormalidades.addParametro(
			 * "anoMesLeitura", anoMesLeitura); String tipoRelatorio =
			 * httpServletRequest .getParameter("tipoRelatorio"); if
			 * (tipoRelatorio == null) { tipoRelatorio =
			 * TarefaRelatorio.TIPO_PDF + ""; }
			 * relatorioRegistrarLeiturasAnormalidades
			 * .addParametro("tipoFormatoRelatorio", Integer
			 * .parseInt(tipoRelatorio)); // chama o met�do de gerar relat�rio
			 * passando o c�digo da // analise // como par�metro
			 * relatorioRetorno = (byte[])
			 * relatorioRegistrarLeiturasAnormalidades .executar();
			 * if (retorno == null) { // prepara a resposta para o popup
			 * httpServletResponse.setContentType("application/pdf"); out =
			 * httpServletResponse.getOutputStream();
			 * out.write(relatorioRetorno); out.flush(); out.close(); } } catch
			 * (IOException ex) { // manda o erro para a p�gina no request atual
			 * ex.printStackTrace(); reportarErros(httpServletRequest,
			 * "erro.sistema"); // seta o mapeamento de retorno para a tela de
			 * erro de popup retorno =
			 * actionMapping.findForward("telaErroPopup"); } catch
			 * (SistemaException ex) { ex.printStackTrace(); // manda o erro
			 * para a p�gina no request atual reportarErros(httpServletRequest,
			 * "erro.sistema"); // seta o mapeamento de retorno para a tela de
			 * erro de popup retorno =
			 * actionMapping.findForward("telaErroPopup"); } catch
			 * (RelatorioVazioException ex1) { // manda o erro para a p�gina no
			 * request atual ex1.printStackTrace();
			 * reportarErros(httpServletRequest, "erro.relatorio.vazio"); //
			 * seta o mapeamento de retorno para a tela de aten��o de popup
			 * retorno = actionMapping.findForward("telaAtencaoPopup"); }
			 */
		}catch(FileUploadException e){
			e.printStackTrace();
			throw new ActionServletException("erro.sistema", e);
		}
		// montarPaginaSucesso(httpServletRequest,
		// "Leitura(s) e Anormalidade(s) importado(s) com sucesso",
		// "Importar outra(s) leitura(s) e anormalidade(s)",
		// "exibirRegistrarLeiturasAnormalidadesAction.do");

		// montando p�gina de sucesso
		montarPaginaSucesso(httpServletRequest, "Leituras e Anormalidades Enviado para Processamento", "Voltar",
						"/exibirRegistrarLeiturasAnormalidadesAction.do");
		return retorno;
	}

}
