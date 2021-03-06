
package gcom.gui.atendimentopublico.ordemservico;

import gcom.atendimentopublico.ordemservico.OrdemServicoFotoOcorrencia;
import gcom.fachada.Fachada;
import gcom.gui.ActionServletException;
import gcom.gui.GcomAction;
import gcom.util.ConstantesAplicacao;
import gcom.util.ControladorException;
import gcom.util.validacao.ValidarCampos;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class AcompanharRoteiroProgramacaoOrdemServicoSalvarFotosAction
				extends GcomAction {

	/**
	 * Execute do Salvar Fotos OS PROGRAMADA
	 * 
	 * @param actionMapping
	 * @param actionForm
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return forward
	 */
	public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest httpServletRequest,
					HttpServletResponse httpServletResponse){

		// Seta o mapeamento de retorno
		ActionForward retorno = actionMapping.findForward("telaSucesso");
		Fachada fachada = Fachada.getInstancia();
		HttpSession sessao = httpServletRequest.getSession(false);

		AcompanharRoteiroProgramacaoOrdemServicoActionForm encerrarOrdemServicoprogramadaActionForm = (AcompanharRoteiroProgramacaoOrdemServicoActionForm) actionForm;

		FormFile[] fotos = new FormFile[3];
		FormFile foto1 = encerrarOrdemServicoprogramadaActionForm.getFotos1();
		FormFile foto2 = encerrarOrdemServicoprogramadaActionForm.getFotos2();
		FormFile foto3 = encerrarOrdemServicoprogramadaActionForm.getFotos3();
		fotos[0] = foto1;
		fotos[1] = foto2;
		fotos[2] = foto3;
		boolean adicionouFoto = false;
		Integer quantidadeFotosNaBase = fachada.pesquisarQuantidadeFotosOrdemServicoProgramacao(Integer
						.valueOf(encerrarOrdemServicoprogramadaActionForm.getIdOrdemServico()), Integer
						.valueOf(encerrarOrdemServicoprogramadaActionForm.getIdOrdemServicoProgramacao()));
		int i = quantidadeFotosNaBase + 1;
		if(quantidadeFotosNaBase.intValue() == Integer.valueOf(ConstantesAplicacao.get("QUANTIDADE_FOTOS_ORDEM_SERVICO")).intValue()){
			throw new ActionServletException("atencao.quantidade.fotos.excedida");
		}
		if(encerrarOrdemServicoprogramadaActionForm.getIdOrdemServicoProgramacao() == null
						|| encerrarOrdemServicoprogramadaActionForm.getIdOrdemServicoProgramacao() == ""){
			throw new ActionServletException("atencao.salvar.fotos.sem.osprogramacao");
		}
		for(FormFile formFoto : fotos){
			// Verifica o tipo e o tamanho da foto
			if(formFoto != null){
				if(ValidarCampos.validaFotoOrdemServico(formFoto)){
					OrdemServicoFotoOcorrencia osFoto = new OrdemServicoFotoOcorrencia();
					osFoto.setNumeroSequenciaFoto(i);
					osFoto.setIdOrdemServico(Integer.valueOf(encerrarOrdemServicoprogramadaActionForm.getIdOrdemServico()));
					osFoto.setIdOrdemServicoProgramacao(Integer.valueOf(encerrarOrdemServicoprogramadaActionForm
									.getIdOrdemServicoProgramacao()));
					try{
						osFoto.setFoto(formFoto.getFileData());
					}catch(FileNotFoundException e){
						throw new ActionServletException("erro.sistema", e);
					}catch(IOException e){
						throw new ActionServletException("erro.sistema", e);
					}

					try{
						fachada.salvarFotoOrdemServico(osFoto);
					}catch(ControladorException e){
						throw new ActionServletException("erro.sistema", e);
					}
					i++;
					adicionouFoto = true;
				}
			}
		}
		sessao.setAttribute("caminhoFuncionalidade", "acompanharRoteiroProgramacaoOrdemServicoSalvarFotosAction.do?menu=sim");
		if(!adicionouFoto){
			throw new ActionServletException("atencao.nao.selecionou.foto");
		}

		return retorno;
	}

}
