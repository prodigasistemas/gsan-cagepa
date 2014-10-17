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

package gcom.gui.atendimentopublico.ligacaoagua;

import gcom.atendimentopublico.ligacaoagua.CorteRegistroTipo;
import gcom.atendimentopublico.ligacaoagua.LigacaoAgua;
import gcom.atendimentopublico.ligacaoagua.LigacaoAguaDiametro;
import gcom.atendimentopublico.ligacaoagua.LigacaoAguaMaterial;
import gcom.atendimentopublico.ligacaoagua.LigacaoAguaPerfil;
import gcom.atendimentopublico.ligacaoagua.LigacaoAguaSituacao;
import gcom.atendimentopublico.ligacaoagua.RamalLocalInstalacao;
import gcom.cadastro.funcionario.Funcionario;
import gcom.cadastro.imovel.Imovel;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.gui.atendimentopublico.EfetuarLigacaoAguaComInstalacaoHidrometroSemRAActionForm;
import gcom.micromedicao.RateioTipo;
import gcom.micromedicao.hidrometro.Hidrometro;
import gcom.micromedicao.hidrometro.HidrometroInstalacaoHistorico;
import gcom.micromedicao.hidrometro.HidrometroLocalInstalacao;
import gcom.micromedicao.hidrometro.HidrometroProtecao;
import gcom.micromedicao.hidrometro.HidrometroSituacao;
import gcom.micromedicao.medicao.MedicaoTipo;
import gcom.seguranca.acesso.usuario.Usuario;
import gcom.util.ConstantesSistema;
import gcom.util.Util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Description of the Class
 * 
 * @author Leandro Cavalcanti
 * @created 20 de Junho de 2006
 */
public class EfetuarLigacaoAguaComInstalacaoHidrometroSemRAAction
				extends GcomAction {

	/**
	 * @author Saulo Lima
	 * @date 12/02/2009
	 * @param actionMapping
	 * @param actionForm
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// localiza o action no objeto actionmapping
		ActionForward retorno = actionMapping.findForward("telaSucesso");
		HttpSession sessao = httpServletRequest.getSession(false);

		EfetuarLigacaoAguaComInstalacaoHidrometroSemRAActionForm form = (EfetuarLigacaoAguaComInstalacaoHidrometroSemRAActionForm) actionForm;
		Fachada fachada = Fachada.getInstancia();

		// Usuario logado no sistema
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

		LigacaoAgua ligacaoAgua = this.setDadosLigacaoAgua(form);
		Imovel imovel = new Imovel();
		imovel.setId(Integer.valueOf(form.getMatriculaImovel()));
		imovel.setUltimaAlteracao(new Date());
		ligacaoAgua.setImovel(imovel);
		ligacaoAgua.setUltimaAlteracao(new Date());
		LigacaoAguaSituacao ligacaoAguaSituacao = new LigacaoAguaSituacao();
		ligacaoAguaSituacao.setId(LigacaoAguaSituacao.LIGADO);
		imovel.setLigacaoAguaSituacao(ligacaoAguaSituacao);
		ligacaoAguaSituacao.setId(imovel.getId());
		ligacaoAgua.setId(imovel.getId());
		CorteRegistroTipo corteRegistroTipo = new CorteRegistroTipo();
		corteRegistroTipo.setId(CorteRegistroTipo.LIQ_NORMAL);
		ligacaoAgua.setCorteRegistroTipo(corteRegistroTipo);

		HidrometroInstalacaoHistorico hidrometroInstalacaoHistorico = null;
		if(form.getNumeroHidrometro() != null && !form.getNumeroHidrometro().trim().equals("")){
			hidrometroInstalacaoHistorico = new HidrometroInstalacaoHistorico();
			hidrometroInstalacaoHistorico.setLigacaoAgua(ligacaoAgua);
			hidrometroInstalacaoHistorico = this.setDadosHidrometroInstalacaoHistorico(hidrometroInstalacaoHistorico, form);
		}

		fachada.efetuarLigacaoAguaComInstalacaoHidrometroSemRA(ligacaoAgua, hidrometroInstalacaoHistorico);

		if(retorno.getName().equalsIgnoreCase("telaSucesso")){
			// Monta a p�gina de sucesso
			montarPaginaSucesso(httpServletRequest, "Liga��o de �gua com Instala��o de Hidr�metro sem RA efetuada com Sucesso",
							"Efetuar outra Liga��o de �gua com Instala��o de Hidr�metro sem RA",
							"exibirEfetuarLigacaoAguaComInstalacaoHidrometroSemRAAction.do?menu=sim");
		}

		return retorno;
	}

	// [SB0001] - Gerar Liga��o de �gua
	//
	// M�todo respons�vel por setar os dados da liga��o de �gua
	// de acordo com os dados selecionados pelo usu�rio e pelas exig�ncias do
	// caso de uso
	public LigacaoAgua setDadosLigacaoAgua(
					EfetuarLigacaoAguaComInstalacaoHidrometroSemRAActionForm efetuarLigacaoAguaComInstalacaoHidrometroActionForm){

		String diametroLigacao = efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getDiametroLigacao();
		String materialLigacao = efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getMaterialLigacao();
		String perfilLigacao = efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getPerfilLigacao();
		String ramalLocalInstalacao = efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getRamalLocalInstalacao();
		String numeroLacre = efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getNumeroLacre();
		String idFuncionario = efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getIdFuncionario();

		LigacaoAgua ligacaoAgua = new LigacaoAgua();

		if(efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getDataLigacao() != null
						&& !efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getDataLigacao().equals("")){
			Date data = Util.converteStringParaDate(efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getDataLigacao());
			ligacaoAgua.setDataLigacao(data);
		}else{
			throw new ActionServletException("atencao.informe_campo", null, " Data da Liga��o");
		}

		if(diametroLigacao != null && !diametroLigacao.equals("")
						&& !diametroLigacao.trim().equalsIgnoreCase("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){
			LigacaoAguaDiametro ligacaoAguaDiametro = new LigacaoAguaDiametro();
			ligacaoAguaDiametro.setId(Integer.valueOf(diametroLigacao));
			ligacaoAgua.setLigacaoAguaDiametro(ligacaoAguaDiametro);
		}else{
			throw new ActionServletException("atencao.informe_campo_obrigatorio", null, "Diametro da Liga��o");
		}

		if(materialLigacao != null && !materialLigacao.equals("")
						&& !materialLigacao.trim().equalsIgnoreCase("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){
			LigacaoAguaMaterial ligacaoAguaMaterialMaterial = new LigacaoAguaMaterial();
			ligacaoAguaMaterialMaterial.setId(Integer.valueOf(materialLigacao));
			ligacaoAgua.setLigacaoAguaMaterial(ligacaoAguaMaterialMaterial);
		}else{
			throw new ActionServletException("atencao.informe_campo_obrigatorio", null, "Material da Liga��o");
		}

		if(perfilLigacao != null && !perfilLigacao.equals("")
						&& !perfilLigacao.trim().equalsIgnoreCase("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){
			LigacaoAguaPerfil ligacaoAguaPerfil = new LigacaoAguaPerfil();
			ligacaoAguaPerfil.setId(Integer.valueOf(perfilLigacao));
			ligacaoAgua.setLigacaoAguaPerfil(ligacaoAguaPerfil);
		}else{
			throw new ActionServletException("atencao.informe_campo_obrigatorio", null, "Perfil da Liga��o");
		}

		if(ramalLocalInstalacao != null && !ramalLocalInstalacao.equals("")
						&& !ramalLocalInstalacao.trim().equalsIgnoreCase("" + ConstantesSistema.NUMERO_NAO_INFORMADO)){

			RamalLocalInstalacao ramalLocal = new RamalLocalInstalacao();
			ramalLocal.setId(Integer.valueOf(ramalLocalInstalacao));
			ligacaoAgua.setRamalLocalInstalacao(ramalLocal);
		}

		if(numeroLacre != null && !numeroLacre.equals("")){
			ligacaoAgua.setNumeroLacre(numeroLacre);
		}

		if(idFuncionario != null && !idFuncionario.equals("")){
			Funcionario func = new Funcionario();
			func.setId(new Integer(idFuncionario));
			ligacaoAgua.setFuncionarioReligacaoAgua(func);
		}

		return ligacaoAgua;
	}

	// [SB0004] - Gerar Hist�rico de Instala��o do Hidr�metro
	//
	// M�todo respons�vel por setar os dados do hidr�metro instala��o hist�rico
	// de acordo com os dados selecionados pelo usu�rio e pelas exig�ncias do
	// caso de uso
	public HidrometroInstalacaoHistorico setDadosHidrometroInstalacaoHistorico(HidrometroInstalacaoHistorico hidrometroInstalacaoHistorico,
					EfetuarLigacaoAguaComInstalacaoHidrometroSemRAActionForm efetuarLigacaoAguaComInstalacaoHidrometroActionForm){

		Fachada fachada = Fachada.getInstancia();

		String numeroHidrometro = efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getNumeroHidrometro();

		if(numeroHidrometro != null){
			// Pesquisa o Hidr�metro
			Hidrometro hidrometro = fachada.pesquisarHidrometroPeloNumero(numeroHidrometro);

			if(hidrometro == null){
				throw new ActionServletException("atencao.hidrometro_inexistente");
			}else if(!hidrometro.getHidrometroSituacao().getId().equals(HidrometroSituacao.DISPONIVEL)){

				ActionServletException ex = new ActionServletException("atencao.hidrometro_situacao_indisponivel", null, hidrometro
								.getHidrometroSituacao().getDescricao());
				ex.setUrlBotaoVoltar("/gsan/exibirEfetuarRestabelecimentoLigacaoAguaComInstalacaoHidrometroAction.do");
				throw ex;
			}

			hidrometroInstalacaoHistorico.setHidrometro(hidrometro);
			hidrometroInstalacaoHistorico.setNumeroHidrometro(hidrometro.getNumero());

		}

		// Data instala��o
		if(efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getDataInstalacao() != null
						&& !efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getDataInstalacao().equals("")){
			Date dataInstalacao = Util.converteStringParaDate(efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getDataInstalacao());
			if(dataInstalacao.before(hidrometroInstalacaoHistorico.getLigacaoAgua().getDataLigacao())){

				throw new ActionServletException("atencao.data_instalacao_hidrometro_anterior_ligacao_agua");
			}else{
				hidrometroInstalacaoHistorico.setDataInstalacao(dataInstalacao);
			}
		}

		// Medi��o tipo
		MedicaoTipo medicaoTipo = new MedicaoTipo();
		medicaoTipo.setId(MedicaoTipo.LIGACAO_AGUA);
		hidrometroInstalacaoHistorico.setMedicaoTipo(medicaoTipo);

		// hidr�metro local instala��o
		HidrometroLocalInstalacao hidrometroLocalInstalacao = new HidrometroLocalInstalacao();
		hidrometroLocalInstalacao.setId(Integer.parseInt(efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getLocalInstalacao()));
		hidrometroInstalacaoHistorico.setHidrometroLocalInstalacao(hidrometroLocalInstalacao);

		// prote��o
		HidrometroProtecao hidrometroProtecao = new HidrometroProtecao();
		hidrometroProtecao.setId(Integer.parseInt(efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getProtecao()));
		hidrometroInstalacaoHistorico.setHidrometroProtecao(hidrometroProtecao);

		// leitura instala��o
		if(efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getLeituraInstalacao() != null
						&& !efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getLeituraInstalacao().trim().equals("")){
			hidrometroInstalacaoHistorico.setNumeroLeituraInstalacao(Integer.parseInt(efetuarLigacaoAguaComInstalacaoHidrometroActionForm
							.getLeituraInstalacao()));
		}else{
			hidrometroInstalacaoHistorico.setNumeroLeituraInstalacao(0);
		}

		// cavalete
		hidrometroInstalacaoHistorico.setIndicadorExistenciaCavalete(Short.parseShort(efetuarLigacaoAguaComInstalacaoHidrometroActionForm
						.getSituacaoCavalete()));

		/*
		 * Campos opcionais
		 */

		// data da retirada
		hidrometroInstalacaoHistorico.setDataRetirada(null);
		// leitura retirada
		hidrometroInstalacaoHistorico.setNumeroLeituraRetirada(null);
		// leitura corte
		hidrometroInstalacaoHistorico.setNumeroLeituraCorte(null);
		// leitura supress�o
		hidrometroInstalacaoHistorico.setNumeroLeituraSupressao(null);
		// numero selo
		if(efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getNumeroSelo() != null
						&& !efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getNumeroSelo().equals("")){
			hidrometroInstalacaoHistorico.setNumeroSelo(efetuarLigacaoAguaComInstalacaoHidrometroActionForm.getNumeroSelo());
		}else{
			hidrometroInstalacaoHistorico.setNumeroSelo(null);
		}
		// tipo de rateio
		hidrometroInstalacaoHistorico.setRateioTipo(new RateioTipo(RateioTipo.RATEIO_POR_IMOVEL));
		hidrometroInstalacaoHistorico.setDataImplantacaoSistema(new Date());

		// indicador instala��o substitui��o
		hidrometroInstalacaoHistorico.setIndicadorInstalcaoSubstituicao(ConstantesSistema.SIM);

		// data �ltima altera��o
		hidrometroInstalacaoHistorico.setUltimaAlteracao(new Date());

		return hidrometroInstalacaoHistorico;

	}
}
