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

package gcom.gui.micromedicao;

import gcom.cadastro.empresa.Empresa;
import gcom.cadastro.localidade.FiltroSetorComercial;
import gcom.cadastro.localidade.SetorComercial;
import gcom.cadastro.sistemaparametro.FiltroSistemaParametro;
import gcom.cadastro.sistemaparametro.SistemaParametro;
import gcom.cobranca.CobrancaGrupo;
import gcom.fachada.Fachada;
import gcom.faturamento.FaturamentoGrupo;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.micromedicao.FiltroLeiturista;
import gcom.micromedicao.FiltroRota;
import gcom.micromedicao.Leiturista;
import gcom.micromedicao.Rota;
import gcom.micromedicao.leitura.LeituraTipo;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.util.ConstantesSistema;
import gcom.util.Util;
import gcom.util.filtro.ParametroSimples;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Realiza a inclus�o da rota de acordo com os par�metros informados
 * 
 * @author Vivianne Sousa
 * @created 21/03/2006
 * @author eduardo henrique
 * @date 25/08/2008
 *       Altera��o para obrigatoriedade do Leiturista/Agente Comercial no cadastro da Rota
 */
public class InserirRotaAction
				extends GcomAction {

	/**
	 * Este caso de uso permite a inclus�o de uma nova rota
	 * [UC0038] Inserir Rota
	 * 
	 * @author Vivianne Sousa
	 * @date 21/03/2006
	 * @param actionMapping
	 * @param actionForm
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		ActionForward retorno = actionMapping.findForward("telaSucesso");
		InserirRotaActionForm inserirRotaActionForm = (InserirRotaActionForm) actionForm;
		Fachada fachada = Fachada.getInstancia();
		HttpSession sessao = httpServletRequest.getSession(false);

		// ------------ REGISTRAR TRANSA��O ----------------
		/*
		 * RegistradorOperacao registradorOperacao = new RegistradorOperacao(
		 * Operacao.OPERACAO_ROTA_INSERIR,
		 * new UsuarioAcaoUsuarioHelper(getUsuarioLogado(httpServletRequest),
		 * UsuarioAcao.USUARIO_ACAO_EFETUOU_OPERACAO));
		 * Operacao operacao = new Operacao();
		 * operacao.setId(Operacao.OPERACAO_ROTA_INSERIR);
		 * OperacaoEfetuada operacaoEfetuada = new OperacaoEfetuada();
		 * operacaoEfetuada.setOperacao(operacao);
		 */
		// ------------ REGISTRAR TRANSA��O ----------------

		// obrigat�rios
		// String descFaturamentoGrupo = null;
		String idLocalidade = inserirRotaActionForm.getIdLocalidade();
		String codigoSetorComercial = inserirRotaActionForm.getCodigoSetorComercial();
		String codigoRota = inserirRotaActionForm.getCodigoRota();
		String idCobrancaGrupo = inserirRotaActionForm.getCobrancaGrupo();
		String idFaturamentoGrupo = inserirRotaActionForm.getFaturamentoGrupo();
		String idLeituraTipo = inserirRotaActionForm.getLeituraTipo();
		String idEmpresaLeituristica = inserirRotaActionForm.getEmpresaLeituristica();
		String indicadorFiscalizarCortado = inserirRotaActionForm.getIndicadorFiscalizarCortado();
		String indicadorFiscalizarSuprimido = inserirRotaActionForm.getIndicadorFiscalizarSuprimido();
		String indicadorGerarFalsaFaixa = inserirRotaActionForm.getIndicadorGerarFalsaFaixa();
		String indicadorGerarFiscalizacao = inserirRotaActionForm.getIndicadorGerarFiscalizacao();
		String idLeiturista = inserirRotaActionForm.getCodigoLeiturista();
		String indicadorAjusteConsumo = inserirRotaActionForm.getIndicadorAjusteConsumo();

		// n obrigat�rios
		/*
		 * Date dataAjusteLeitura = null;
		 * if (inserirRotaActionForm.getDataAjusteLeitura() != null ){
		 * dataAjusteLeitura =
		 * Util.converteStringParaDate(inserirRotaActionForm.getDataAjusteLeitura());
		 * }
		 */
		String percentualGeracaoFaixaFalsa = null;
		if(inserirRotaActionForm.getPercentualGeracaoFaixaFalsa() != null){
			percentualGeracaoFaixaFalsa = inserirRotaActionForm.getPercentualGeracaoFaixaFalsa().toString().replace(",", ".");
		}

		String percentualGeracaoFiscalizacao = null;
		if(inserirRotaActionForm.getPercentualGeracaoFiscalizacao() != null){
			percentualGeracaoFiscalizacao = inserirRotaActionForm.getPercentualGeracaoFiscalizacao().toString().replace(",", ".");
		}

		// Crit�rio de Cobran�a
		Collection collectionRotaAcaoCriterio = null;

		if(sessao.getAttribute("collectionRotaAcaoCriterio") != null){
			collectionRotaAcaoCriterio = (Collection) sessao.getAttribute("collectionRotaAcaoCriterio");
		}

		validacaoRota(idLocalidade, codigoSetorComercial, codigoRota, idCobrancaGrupo, idFaturamentoGrupo, idLeituraTipo,
						idEmpresaLeituristica, indicadorFiscalizarCortado, indicadorFiscalizarSuprimido, indicadorGerarFalsaFaixa,
						indicadorGerarFiscalizacao, percentualGeracaoFaixaFalsa, percentualGeracaoFiscalizacao, idLeiturista,
						collectionRotaAcaoCriterio, indicadorAjusteConsumo, fachada, httpServletRequest);

		Rota rotaNova = new Rota();

		rotaNova.setCodigo(new Short(codigoRota));

		// rotaNova.setDataAjusteLeitura(dataAjusteLeitura);

		rotaNova.setIndicadorFiscalizarCortado(new Integer(indicadorFiscalizarCortado).shortValue());

		rotaNova.setIndicadorFiscalizarSuprimido(new Integer(indicadorFiscalizarSuprimido).shortValue());

		rotaNova.setIndicadorGerarFalsaFaixa(new Integer(indicadorGerarFalsaFaixa).shortValue());

		rotaNova.setIndicadorAjusteConsumo(new Integer(indicadorAjusteConsumo).shortValue());

		if(percentualGeracaoFaixaFalsa != null && !percentualGeracaoFaixaFalsa.equals("")){
			rotaNova.setPercentualGeracaoFaixaFalsa(new BigDecimal(percentualGeracaoFaixaFalsa));
		}

		rotaNova.setIndicadorGerarFiscalizacao(new Integer(indicadorGerarFiscalizacao).shortValue());

		if(percentualGeracaoFiscalizacao != null && !percentualGeracaoFiscalizacao.equals("")){
			rotaNova.setPercentualGeracaoFiscalizacao(new BigDecimal(percentualGeracaoFiscalizacao));
		}

		SetorComercial setorComercial = null;
		if(codigoSetorComercial != null && !codigoSetorComercial.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){

			// Filtro para descobrir id do setor comercial
			FiltroSetorComercial filtroSetorComercial = new FiltroSetorComercial();

			filtroSetorComercial.adicionarParametro(new ParametroSimples(FiltroSetorComercial.ID_LOCALIDADE, new Integer(idLocalidade)));

			filtroSetorComercial.adicionarParametro(new ParametroSimples(FiltroSetorComercial.CODIGO_SETOR_COMERCIAL, new Integer(
							codigoSetorComercial)));

			Collection<SetorComercial> colectionSetorComerciais = fachada.pesquisar(filtroSetorComercial, SetorComercial.class.getName());

			Integer idSetorComercial = colectionSetorComerciais.iterator().next().getId();

			setorComercial = new SetorComercial();
			setorComercial.setId(new Integer(idSetorComercial));

			rotaNova.setSetorComercial(setorComercial);

		}

		CobrancaGrupo cobrancaGrupo = null;
		if(idCobrancaGrupo != null && !idCobrancaGrupo.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){
			cobrancaGrupo = new CobrancaGrupo();
			cobrancaGrupo.setId(new Integer(idCobrancaGrupo));
			rotaNova.setCobrancaGrupo(cobrancaGrupo);
		}

		FaturamentoGrupo faturamentoGrupo = null;
		if(idFaturamentoGrupo != null && !idFaturamentoGrupo.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){
			faturamentoGrupo = new FaturamentoGrupo();
			faturamentoGrupo.setId(new Integer(idFaturamentoGrupo));
			rotaNova.setFaturamentoGrupo(faturamentoGrupo);

			/*
			 * FiltroFaturamentoGrupo filtroFaturamentoGrupo = new FiltroFaturamentoGrupo();
			 * filtroFaturamentoGrupo.adicionarParametro(new ParametroSimples(
			 * FiltroFaturamentoGrupo.ID, new Integer(
			 * idFaturamentoGrupo)));
			 * Collection<FaturamentoGrupo> colectionFaturamentoGrupos = fachada.pesquisar(
			 * filtroFaturamentoGrupo, FaturamentoGrupo.class.getName());
			 * descFaturamentoGrupo = ((FaturamentoGrupo)
			 * Util.retonarObjetoDeColecao(colectionFaturamentoGrupos)).getDescricao();
			 */

		}

		LeituraTipo leituraTipo = null;
		if(idLeituraTipo != null && !idLeituraTipo.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){
			leituraTipo = new LeituraTipo();
			leituraTipo.setId(new Integer(idLeituraTipo));
			rotaNova.setLeituraTipo(leituraTipo);
		}

		Empresa empresaLeituristica = null;
		if(idEmpresaLeituristica != null && !idEmpresaLeituristica.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){
			empresaLeituristica = new Empresa();
			empresaLeituristica.setId(new Integer(idEmpresaLeituristica));
			rotaNova.setEmpresa(empresaLeituristica);
		}

		// adicionado a pedido de Eduardo 22/02/2007
		if(idEmpresaLeituristica != null && !idEmpresaLeituristica.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){
			rotaNova.setEmpresaCobranca(empresaLeituristica);
		}else{
			empresaLeituristica.setId(new Integer(1));
			rotaNova.setEmpresaCobranca(empresaLeituristica);
		}

		Leiturista leiturista = null;
		if(idLeiturista != null && !idLeiturista.equals(ConstantesSistema.NUMERO_NAO_INFORMADO)){
			leiturista = new Leiturista();
			leiturista.setId(new Integer(idLeiturista));

			rotaNova.setLeiturista(leiturista);
		}

		// Indicador de Uso
		rotaNova.setIndicadorUso(ConstantesSistema.INDICADOR_USO_ATIVO);

		// Ultima altera��o
		rotaNova.setUltimaAlteracao(new Date());

		Integer idRota = null;

		// ------------ REGISTRAR TRANSA��O ----------------
		/*
		 * rotaNova.setOperacaoEfetuada(operacaoEfetuada);
		 * rotaNova.adicionarUsuario(getUsuarioLogado(httpServletRequest),
		 * UsuarioAcao.USUARIO_ACAO_EFETUOU_OPERACAO);
		 * registradorOperacao.registrarOperacao(rotaNova);
		 */
		// ------------ REGISTRAR TRANSA��O ----------------

		Usuario usuarioLogado = (Usuario) sessao.getAttribute("usuarioLogado");

		idRota = fachada.inserirRota(rotaNova, idLocalidade, collectionRotaAcaoCriterio, usuarioLogado, true);

		sessao.removeAttribute("reloadPageURL");
		sessao.removeAttribute("reloadPage");
		sessao.removeAttribute("collectionRotaAcaoCriterio");

		montarPaginaSucesso(httpServletRequest, "Rota de c�digo  " + rotaNova.getCodigo() + " da localidade " + idLocalidade + " do setor "
						+ codigoSetorComercial + "  inserida com sucesso.", "Inserir outra Rota", "exibirInserirRotaAction.do?desfazer=S",
						"exibirAtualizarRotaAction.do?idRegistroInseridoAtualizar=" + idRota, "Atualizar Rota Inserida");

		return retorno;
	}

	private void validacaoRota(String idLocalidade, String codigoSetorComercial, String codigoRota, String idCobrancaGrupo,
					String idFaturamentoGrupo, String idLeituraTipo, String idEmpresaLeituristica, String indicadorFiscalizarCortado,
					String indicadorFiscalizarSuprimido, String indicadorGerarFalsaFaixa, String indicadorGerarFiscalizacao,
					String percentualGeracaoFaixaFalsa, String percentualGeracaoFiscalizacao, String codigoLeiturista,
					Collection collectionRotaAcaoCriterioNovos, String indicadorAjusteConsumo, Fachada fachada,
					HttpServletRequest httpServletRequest){

		// Localidade � obrigat�rio.
		if((idLocalidade == null) || (idLocalidade.equals(""))){
			httpServletRequest.setAttribute("nomeCampo", "idLocalidade");
			throw new ActionServletException("atencao.localidade_nao_informada");
		}else if(Util.validarValorNaoNumerico(idLocalidade)){
			// Localidade n�o num�rico.
			httpServletRequest.setAttribute("nomeCampo", "idLocalidade");
			throw new ActionServletException("atencao.nao.numerico", null, "Localidade");
		}

		// Setor Comercial � obrigat�rio.
		if((codigoSetorComercial == null) || (codigoSetorComercial.equals(""))){
			httpServletRequest.setAttribute("nomeCampo", "codigoSetorComercial");
			throw new ActionServletException("atencao.codigo_setor_comercial_nao_informado");
		}else if(Util.validarValorNaoNumerico(codigoSetorComercial)){
			// Setor Comercial n�o num�rico.
			httpServletRequest.setAttribute("nomeCampo", "codigoSetorComercial");
			throw new ActionServletException("atencao.nao.numerico", null, "Setor Comercial");
		}else{
			verificaExistenciaCodSetorComercial(idLocalidade, codigoSetorComercial, fachada, httpServletRequest);
		}

		// O c�digo da rota � obrigat�rio.
		if((codigoRota == null) || (codigoRota.equals(""))){
			httpServletRequest.setAttribute("nomeCampo", "codigoRota");
			throw new ActionServletException("atencao.rota_codigo_nao_informado");
		}else if(Util.validarValorNaoNumerico(codigoRota)){
			// Setor Comercial n�o num�rico.
			httpServletRequest.setAttribute("nomeCampo", "codigoRota");
			throw new ActionServletException("atencao.nao.numerico", null, "C�digo da Rota");
		}else{
			FiltroRota filtroRota = new FiltroRota();

			filtroRota.adicionarCaminhoParaCarregamentoEntidade("setorComercial");
			filtroRota.adicionarParametro(new ParametroSimples(FiltroRota.LOCALIDADE_ID, new Integer(idLocalidade)));

			filtroRota.adicionarParametro(new ParametroSimples(FiltroRota.SETOR_COMERCIAL_CODIGO, new Integer(codigoSetorComercial)));

			filtroRota.adicionarParametro(new ParametroSimples(FiltroRota.CODIGO_ROTA, new Integer(codigoRota).intValue()));

			// Retorna caso j� exista uma rota com o c�digo informado
			Collection colecaoPesquisa = null;

			colecaoPesquisa = fachada.pesquisar(filtroRota, Rota.class.getName());

			if(colecaoPesquisa.size() != 0 || !colecaoPesquisa.isEmpty()){
				// Rota de c�digo {0} da localidade {1} do setor comercial {2} j� existe no
				// cadastro.
				httpServletRequest.setAttribute("nomeCampo", "codigoRota");
				throw new ActionServletException("atencao.rota_ja_existente", codigoRota, idLocalidade, codigoSetorComercial);
			}
		}

		// O grupo de faturamento � obrigat�rio.
		if((idFaturamentoGrupo == null) || (idFaturamentoGrupo.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO))){
			httpServletRequest.setAttribute("nomeCampo", "faturamentoGrupo");
			throw new ActionServletException("atencao.faturamento_grupo_nao_informado");
		}

		// O grupo de cobran�a � obrigat�rio.
		if((idCobrancaGrupo == null) || (idCobrancaGrupo.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO))){
			httpServletRequest.setAttribute("nomeCampo", "cobrancaGrupo");
			throw new ActionServletException("atencao.cobranca_grupo_nao_informado");
		}

		// O tipo de leitura � obrigat�rio.
		if((idLeituraTipo == null) || (idLeituraTipo.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO))){
			httpServletRequest.setAttribute("nomeCampo", "leituraTipo");
			throw new ActionServletException("atencao.leitura_tipo_nao_informado");
		}

		// A empresa leituristica � obrigat�ria.
		if((idEmpresaLeituristica == null) || (idEmpresaLeituristica.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO))){
			httpServletRequest.setAttribute("nomeCampo", "empresaLeituristica");
			throw new ActionServletException("atencao.empresa_leituristica_nao_informado");
		}

		// Leiturista / Agente Comercial � obrigat�rio
		if((codigoLeiturista == null) || (codigoLeiturista.equals(""))){
			httpServletRequest.setAttribute("nomeCampo", "codigoLeiturista");
			throw new ActionServletException("atencao.leiturista_nao_informado");
		}else if(Util.validarValorNaoNumerico(codigoLeiturista)){
			// Leituristas n�o num�rico.
			httpServletRequest.setAttribute("nomeCampo", "codigoLeiturista");
			throw new ActionServletException("atencao.nao.numerico", null, "Agente Comercial");
		}else{
			verificarExistenciaCodLeiturista(idEmpresaLeituristica, codigoLeiturista, fachada, httpServletRequest);
		}

		// O identificador de fiscalizar cortado � obrigat�rio.
		if((indicadorFiscalizarCortado == null) || (indicadorFiscalizarCortado.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO))){
			httpServletRequest.setAttribute("nomeCampo", "indicadorFiscalizarCortado");
			throw new ActionServletException("atencao.fiscaliza_cortados_nao_informado");
		}

		// O identificador de fiscalizar suprido � obrigat�rio.
		if((indicadorFiscalizarSuprimido == null) || (indicadorFiscalizarSuprimido.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO))){
			httpServletRequest.setAttribute("nomeCampo", "indicadorFiscalizarSuprimido");
			throw new ActionServletException("atencao.fiscaliza_suprimidos_nao_informado");
		}

		// Sistema Parametro vai ser utilizado na valida��o de
		// Percentual de Faixa Falsa e
		// Percentual de Fiscaliza��o de Leitura
		FiltroSistemaParametro filtroSistemaParametro = new FiltroSistemaParametro();

		Collection<SistemaParametro> collectionSistemaParametro = fachada.pesquisar(filtroSistemaParametro, SistemaParametro.class
						.getName());
		SistemaParametro sistemaParametro = (SistemaParametro) collectionSistemaParametro.iterator().next();

		// O identificador de gerar faixa falsa � obrigat�rio.
		if((indicadorGerarFalsaFaixa == null) || (indicadorGerarFalsaFaixa.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO))){
			httpServletRequest.setAttribute("nomeCampo", "indicadorGerarFalsaFaixa");
			throw new ActionServletException("atencao.gera_faixa_nao_informado");
		}else if((percentualGeracaoFaixaFalsa == null || percentualGeracaoFaixaFalsa.equalsIgnoreCase(""))
						&& indicadorGerarFalsaFaixa.equals("" + ConstantesSistema.SIM)
						&& sistemaParametro.getIndicadorUsoFaixaFalsa().equals(SistemaParametro.INDICADOR_USO_FAIXA_FALSA_ROTA)){
			// Percentual de Faixa Falsa � obrigat�rio
			// caso o indicador de gera��o de fiscaliza��o de leitura seja SIM e
			// o indicador de uso do percentual para gera��o de fiscaliza��o de leitura
			// na tabela SISTEMA_PARAMETRO (PARM_ICUSOPERCENTUALFISCALIZACAOLEITURA)
			// corresponda ao valor 2=USA PERCENTUAL DA ROTA

			httpServletRequest.setAttribute("nomeCampo", "percentualGeracaoFaixaFalsa");
			throw new ActionServletException("atencao.percentual_faixa_falsa_nao_informado");
		}

		// O identificador de gerar fiscaliza��o � obrigat�rio.
		if((indicadorGerarFiscalizacao == null) || (indicadorGerarFiscalizacao.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO))){
			httpServletRequest.setAttribute("nomeCampo", "indicadorGerarFiscalizacao");
			throw new ActionServletException("atencao.gera_fiscalizacao_leitura_nao_informado");
		}else if((percentualGeracaoFiscalizacao == null || percentualGeracaoFiscalizacao.equalsIgnoreCase(""))
						&& indicadorGerarFiscalizacao.equals("" + ConstantesSistema.SIM)
						&& sistemaParametro.getIndicadorPercentualFiscalizacaoLeitura().equals(
										SistemaParametro.INDICADOR_PERCENTUAL_FISCALIZACAO_LEITURA_ROTA)){
			// Percentual de Fiscaliza��o de Leitura � obrigat�rio
			// caso o indicador de gera��o de faixa falsa seja SIM e
			// o indicador de uso do percentual para gera��o da faixa falsa
			// na tabela SISTEMA_PARAMETRO (PARM_ICUSOPERCENTUALFAIXAFALSA)
			// corresponda ao valor 2=USA PERCENTUAL DA ROTA
			httpServletRequest.setAttribute("nomeCampo", "percentualGeracaoFiscalizacao");
			throw new ActionServletException("atencao.percentual_fiscalizacao_leitura_nao_informado");
		}

		// O identificador de ajuste consumo � obrigat�rio.
		if((indicadorAjusteConsumo == null) || (indicadorAjusteConsumo.equals("" + ConstantesSistema.NUMERO_NAO_INFORMADO))){
			httpServletRequest.setAttribute("nomeCampo", "indicadorAjusteConsumo");
			throw new ActionServletException("atencao.ajuste_consumo_nao_informado");
		}

		/*
		 * if ((indicadorGerarFalsaFaixa == null)
		 * || (indicadorGerarFalsaFaixa.equals(""
		 * + ConstantesSistema.NUMERO_NAO_INFORMADO))) {
		 * httpServletRequest.setAttribute("nomeCampo","indicadorGerarFalsaFaixa");
		 * throw new ActionServletException("atencao.gera_faixa_nao_informado");
		 * } else if ((indicadorGerarFalsaFaixa.equals("" +
		 * SistemaParametro.INDICADOR_USO_FAIXA_FALSA_SISTEMA_PARAMETRO))
		 * && (percentualGeracaoFaixaFalsa.equalsIgnoreCase(""))) {
		 * // Indicador de Gera��o de Faixa Falsa == SIM
		 * FiltroSistemaParametro filtroSistemaParametro = new FiltroSistemaParametro();
		 * Collection<SistemaParametro> collectionSistemaParametro = fachada
		 * .pesquisar(filtroSistemaParametro,
		 * SistemaParametro.class.getName());
		 * SistemaParametro sistemaParametro = (SistemaParametro) collectionSistemaParametro
		 * .iterator().next();
		 * if(sistemaParametro.getIndicadorUsoFaixaFalsa().equals(SistemaParametro.
		 * INDICADOR_FAIXA_FALSA_NAO_USO)) {
		 * // Usa percentual da rota
		 * // Percentual de Faixa Falsa � obrigat�rio
		 * httpServletRequest.setAttribute("nomeCampo","percentualGeracaoFaixaFalsa");
		 * throw new ActionServletException(
		 * "atencao.percentual_faixa_falsa_nao_informado");
		 * }else
		 * if(Util.validarValorNaoNumericoComoBigDecimal(percentualGeracaoFaixaFalsa.replace(",",
		 * "."))){
		 * httpServletRequest.setAttribute("nomeCampo","percentualGeracaoFaixaFalsa");
		 * throw new ActionServletException(
		 * "atencao.nao.numerico",null,"Percentual de Faixa Falsa ");
		 * }
		 * }else if ((indicadorGerarFalsaFaixa.equals("" +
		 * SistemaParametro.INDICADOR_USO_FAIXA_FALSA_SISTEMA_PARAMETRO))
		 * && (!percentualGeracaoFaixaFalsa.equalsIgnoreCase(""))) {
		 * // Indicador de Gera��o de Faixa Falsa == SIM
		 * FiltroSistemaParametro filtroSistemaParametro = new FiltroSistemaParametro();
		 * Collection<SistemaParametro> collectionSistemaParametro = fachada
		 * .pesquisar(filtroSistemaParametro,
		 * SistemaParametro.class.getName());
		 * SistemaParametro sistemaParametro = (SistemaParametro) collectionSistemaParametro
		 * .iterator().next();
		 * if(!sistemaParametro.getIndicadorUsoFaixaFalsa().equals(SistemaParametro.
		 * INDICADOR_FAIXA_FALSA_NAO_USO)) {
		 * // N�o usa percentual da rota
		 * // Percentual de Faixa Falsa n�o deve ser informado
		 * httpServletRequest.setAttribute("nomeCampo","percentualGeracaoFaixaFalsa");
		 * throw new ActionServletException(
		 * "atencao.percentual_faixa_falsa_nao_deve_informar");
		 * }
		 * }
		 */

		/*
		 * // O identificador de gerar fiscaliza��o � obrigat�rio.
		 * if ((indicadorGerarFiscalizacao == null)
		 * || (indicadorGerarFiscalizacao.equals(""
		 * + ConstantesSistema.NUMERO_NAO_INFORMADO))) {
		 * httpServletRequest.setAttribute("nomeCampo","indicadorGerarFiscalizacao");
		 * throw new ActionServletException(
		 * "atencao.gera_fiscalizacao_leitura_nao_informado");
		 * }else if ((indicadorGerarFiscalizacao.equals("1"))
		 * && (percentualGeracaoFiscalizacao.equalsIgnoreCase(""))) {
		 * // Indicador de Gera��o de Fiscaliza��o == SIM
		 * FiltroSistemaParametro filtroSistemaParametro = new FiltroSistemaParametro();
		 * Collection<SistemaParametro> collectionSistemaParametro = fachada
		 * .pesquisar(filtroSistemaParametro,
		 * SistemaParametro.class.getName());
		 * SistemaParametro sistemaParametro = (SistemaParametro) collectionSistemaParametro
		 * .iterator().next();
		 * if (sistemaParametro
		 * .getIndicadorPercentualFiscalizacaoLeitura().equals(SistemaParametro.
		 * INDICADOR_USO_FISCALIZADOR_LEITURA_SISTEMA_PARAMETRO)) {
		 * // Usa percentual da rota
		 * // Percentual de Fiscaliza��o de Leitura � obrigat�rio
		 * httpServletRequest.setAttribute("nomeCampo","percentualGeracaoFiscalizacao");
		 * throw new ActionServletException(
		 * "atencao.percentual_fiscalizacao_leitura_nao_informado");
		 * }else
		 * if(Util.validarValorNaoNumericoComoBigDecimal(percentualGeracaoFiscalizacao.replace(",",
		 * "."))){
		 * httpServletRequest.setAttribute("nomeCampo","percentualGeracaoFiscalizacao");
		 * throw new ActionServletException(
		 * "atencao.nao.numerico",null,"Percentual de Fiscaliza��o de Leitura ");
		 * }
		 * }else if ((indicadorGerarFiscalizacao.equals("1"))
		 * && (!percentualGeracaoFiscalizacao.equalsIgnoreCase(""))) {
		 * // Indicador de Gera��o de Fiscaliza��o == SIM
		 * FiltroSistemaParametro filtroSistemaParametro = new FiltroSistemaParametro();
		 * Collection<SistemaParametro> collectionSistemaParametro = fachada
		 * .pesquisar(filtroSistemaParametro,
		 * SistemaParametro.class.getName());
		 * SistemaParametro sistemaParametro = (SistemaParametro) collectionSistemaParametro
		 * .iterator().next();
		 * if (!sistemaParametro
		 * .getIndicadorPercentualFiscalizacaoLeitura().equals(SistemaParametro.
		 * INDICADOR_USO_FISCALIZADOR_LEITURA_SISTEMA_PARAMETRO)) {
		 * // N�o usa percentual da rota
		 * // Percentual de Fiscaliza��o de Leitura n�o deve ser informado
		 * httpServletRequest.setAttribute("nomeCampo","percentualGeracaoFiscalizacao");
		 * throw new ActionServletException(
		 * "atencao.percentual_fiscalizacao_leitura_nao_deve_informar");
		 * }
		 * }
		 */

		/*
		 * Crit�rio de Cobran�a passa a ser opcional na rota.
		 * Analista Respons�vel: Luciene Bezerra
		 * Saulo Lima - 10/02/2009
		 */
		// [FS0010] Verificar inexist�ncia de alguma a��o de cobran�a
		// if (collectionRotaAcaoCriterioNovos == null || collectionRotaAcaoCriterioNovos.isEmpty())
		// {
		// //� necess�rio informar o crit�rio de cobran�a da rota para todas as a��es de cobran�a
		// throw new ActionServletException("atencao.criterio_cobranca_rota.informar");
		//			
		// } else {
		// FiltroCobrancaAcao filtroCobrancaAcao = new FiltroCobrancaAcao();
		// filtroCobrancaAcao.adicionarParametro(new
		// ParametroSimples(FiltroCobrancaCriterio.INDICADOR_USO, ConstantesSistema.SIM));
		// Collection<CobrancaGrupo> collectionCobrancaAcao = fachada.pesquisar(filtroCobrancaAcao,
		// CobrancaAcao.class.getName());
		//	        
		// if (collectionRotaAcaoCriterioNovos.size() != collectionCobrancaAcao.size()) {
		// //� necess�rio informar o crit�rio de cobran�a da rota para todas as a��es de cobran�a
		// throw new ActionServletException("atencao.criterio_cobranca_rota.informar");
		// }
		// }

	}

	private void verificaExistenciaCodSetorComercial(String idDigitadoEnterLocalidade, String codigoDigitadoEnterSetorComercial,
					Fachada fachada, HttpServletRequest httpServletRequest){

		// Verifica se o c�digo do Setor Comercial foi digitado
		if((codigoDigitadoEnterSetorComercial != null && !codigoDigitadoEnterSetorComercial.toString().trim().equalsIgnoreCase(""))
						&& (idDigitadoEnterLocalidade != null && !idDigitadoEnterLocalidade.toString().trim().equalsIgnoreCase(""))){

			FiltroSetorComercial filtroSetorComercial = new FiltroSetorComercial();
			if(idDigitadoEnterLocalidade != null && !idDigitadoEnterLocalidade.toString().trim().equalsIgnoreCase("")){

				filtroSetorComercial.adicionarParametro(new ParametroSimples(FiltroSetorComercial.ID_LOCALIDADE, new Integer(
								idDigitadoEnterLocalidade)));
			}

			filtroSetorComercial.adicionarParametro(new ParametroSimples(FiltroSetorComercial.CODIGO_SETOR_COMERCIAL, new Integer(
							codigoDigitadoEnterSetorComercial)));

			Collection<SetorComercial> setorComerciais = fachada.pesquisar(filtroSetorComercial, SetorComercial.class.getName());

			if(setorComerciais == null || setorComerciais.isEmpty()){
				// o setor comercial n�o foi encontrado
				// Setor Comercial n�o existe para esta localidade
				httpServletRequest.setAttribute("nomeCampo", "codigoSetorComercial");
				throw new ActionServletException("atencao.setor_comercial_nao_existe");

			}

		}

	}

	private void verificarExistenciaCodLeiturista(String idDigitadoEnterEmpresaLeitura, String idDigitadoEnterLeiturista, Fachada fachada,
					HttpServletRequest httpServletRequest){

		// Verifica se o c�digo do Leiturista que foi digitado
		if((idDigitadoEnterLeiturista != null && !idDigitadoEnterLeiturista.trim().equalsIgnoreCase(""))
						&& (idDigitadoEnterEmpresaLeitura != null && !idDigitadoEnterEmpresaLeitura.trim().equalsIgnoreCase(""))){

			FiltroLeiturista filtroLeiturista = new FiltroLeiturista();
			filtroLeiturista.adicionarCaminhoParaCarregamentoEntidade("funcionario");
			filtroLeiturista.adicionarCaminhoParaCarregamentoEntidade("cliente");
			if(idDigitadoEnterEmpresaLeitura != null && !idDigitadoEnterEmpresaLeitura.trim().equalsIgnoreCase("")){

				filtroLeiturista.adicionarParametro(new ParametroSimples(FiltroLeiturista.EMPRESA_ID, new Integer(
								idDigitadoEnterEmpresaLeitura)));
			}

			filtroLeiturista.adicionarParametro(new ParametroSimples(FiltroLeiturista.ID, new Integer(idDigitadoEnterLeiturista)));

			Collection<Leiturista> leituristas = fachada.pesquisar(filtroLeiturista, Leiturista.class.getName());

			if(leituristas == null || leituristas.isEmpty()){
				httpServletRequest.setAttribute("nomeCampo", "codigoLeiturista");
				throw new ActionServletException("atencao.leiturista_nao_encontrado");

			}

		}
	}

}