<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="gcom.util.ConstantesSistema" isELIgnored="false"%>
<html:html>

<head>

<%@ include file="/jsp/util/titulo.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" href="<bean:message key="caminho.css"/>EstilosCompesa.css" type="text/css">

<script language="JavaScript" src="<bean:message key="caminho.js"/>validacao/regras_validator.js"></script>
<html:javascript staticJavascript="false" formName="FiltroEficienciaCobrancaRelatorioActionForm"  dynamicJavascript="true" />
<script language="JavaScript" src="<bean:message key="caminho.js"/>util.js"></script>
<script language="JavaScript" src="<bean:message key="caminho.js"/>Calendario.js"></script>

<script language="JavaScript">

	function validaForm(form){

		var campo = form.comando;
		var aux;
		for(var i = 0; i < campo.length; i++){
			if(campo[i].checked){
				aux = campo[i].value;
				}
			}
		
		if (aux == undefined){
			if (validarDatas()){
				submeterFormPadrao(form);
			}
			
		} else {
			if (aux == "3") {
				if (validarDatas()){
					submeterFormPadrao(form);
				}
				
			} else {
				submeterFormPadrao(form);
			}
		}
	}

	function validarDatas(){

		var form = document.forms[0];
		
		var periodoInicio = form.periodoInicio.value;
		var periodoFim = form.periodoFim.value;

		if (isBrancoOuNulo(periodoInicio) && isBrancoOuNulo(periodoFim)){
			alert("Informe:\no Per�odo");
			return false;
		} else if (isBrancoOuNulo(periodoInicio)){
			alert("Informe:\nPer�odo Inicial");
			return false;
		} else if (isBrancoOuNulo(periodoFim)){
			alert("Informe:\nPer�odo Final");
			return false;
		}

		return true;

	}

	function validarIntervalos(){

		var form = document.forms[0];
		
		var periodoInicio = form.periodoInicio.value;
		var periodoFim = form.periodoFim.value;

		// Verificamos se a data final informada � menor que a data inicial
	    if (comparaData(periodoFim, '<', periodoInicio)){
			  alert("A data final deve ser maior que a data inicial");
			  return false;
	    }
	    return true;
	}

	function limparForm(form) {
		redirecionarSubmit('exibirFiltrarEficienciaCobrancaRelatorioAction.do?menu=sim&limpar=true');
	}

	function limparTitulo(){
		var form = document.forms[0];
		form.idCobrancaAcaoAtividadeComando.value = '';
		form.tituloCobrancaAcaoAtividadeComando.value = '';
	}
	
	function recuperarDadosPopup(codigoRegistro, descricaoRegistro, tipoConsulta) {

	    var form = document.forms[0];
	    
	    if (tipoConsulta == 'cobrancaAcaoAtividadeComando') {
	      form.idCobrancaAcaoAtividadeComando.value = codigoRegistro;
	      form.tituloCobrancaAcaoAtividadeComando.value = descricaoRegistro;
	    }
	    if (tipoConsulta == 'cobrancaAcaoAtividadeCronograma'){
			form.idCobrancaAcaoAtividadeCronograma.value = codigoRegistro;
			form.descricaoGrupo.value = descricaoRegistro;
	    }
	}

	function recarregaForm(){
		redirecionarSubmit('exibirFiltrarEficienciaCobrancaRelatorioAction.do?menu=sim');
	}

	function verificaTipoComando(){

		var form = document.forms[0];
		var campo = form.comando;
		var aux;
		for(var i = 0; i < campo.length; i++){
			if(campo[i].checked){
				aux = campo[i].value;
				}
			}

		if (aux == undefined){
			habilitarCampos();
		} else {
			if (aux == "3") {
				habilitarCampos();
			} else {
				desabilitarCampos();
			}
		}
	}

	function desabilitarCampos(){

		var form = document.forms[0];
		
		form.acao.disabled = true;
		form.empresa.disabled = true;
		form.idGrupo.disabled = true;
		form.idSetor.disabled = true;
		form.periodoInicio.disabled = true;
		form.periodoFim.disabled = true;
		document.getElementById('linkPeriodoInicio').href = '#';
		document.getElementById('linkPeriodoFim').href = '#';
		
		//$("select[name='acao']").attr('disabled', true);
		//$("select[name='empresa']").attr('disabled', true);
		//$("select[name='idGrupo']").attr('disabled', true);
		//$("select[name='idSetor']").attr('disabled', true);
		//$("input[type=text][name=periodoInicio]").attr('disabled', true);
		//$("input[type=text][name=periodoFim]").attr('disabled', true);
		//$("#linkPeriodoInicio").attr('href', "#");
		//$("#linkPeriodoFim").attr('href', "#");
		//$("#linkTituloComando").attr('href', "");
		//$("#linkComnando").attr('href', "");
	}

	function habilitarCampos(){

		var form = document.forms[0];

		form.acao.disabled = false;
		form.empresa.disabled = false;
		form.idGrupo.disabled = false;
		form.idSetor.disabled = false;
		form.periodoInicio.disabled = false;
		form.periodoFim.disabled = false;
		document.getElementById('linkPeriodoInicio').href = 'javascript:abrirCalendario("FiltroEficienciaCobrancaRelatorioActionForm", "periodoInicio")';
		document.getElementById('linkPeriodoFim').href = 'javascript:abrirCalendario("FiltroEficienciaCobrancaRelatorioActionForm", "periodoFim")';
		
		//$("select[name='acao']").attr('disabled', false);
		//$("select[name='empresa']").attr('disabled', false);
		//$("select[name='idGrupo']").attr('disabled', false);
		//$("select[name='idSetor']").attr('disabled', false);
		//$("input[type=text][name=periodoInicio]").attr('disabled', false);
		//$("input[type=text][name=periodoFim]").attr('disabled', false);
		//$("#linkTituloComando").attr('href', "javascript:abrirPopup('exibirPesquisarComandoAcaoCobrancaAction.do', 400, 750);");
		//$("#linkComnando").attr('href', "javascript:abrirPopup('exibirPesquisarCronogramaAcaoCobrancaAction.do', 400, 750);");
		//$("#linkPeriodoInicio").attr("href", "javascript:abrirCalendario('FiltroEficienciaCobrancaRelatorioActionForm', 'periodoInicio')");
		//$("#linkPeriodoFim").attr("href", "javascript:abrirCalendario('FiltroEficienciaCobrancaRelatorioActionForm', 'periodoFim')");
	}

	
</script>


</head>

<body leftmargin="5" topmargin="5" onload="javascript:verificaTipoComando();">
<html:form action="/gerarRelatorioEficienciaCobrancaAction"
	name="FiltroEficienciaCobrancaRelatorioActionForm"
	type="gcom.gui.cobranca.FiltroEficienciaCobrancaRelatorioActionForm"
	method="post"
	onsubmit="return validateFiltrarClienteTipoActionForm(this);">

	<%@ include file="/jsp/util/cabecalho.jsp"%>
	<%@ include file="/jsp/util/menu.jsp"%>

	<table width="770" border="0" cellspacing="4" cellpadding="0">
		<tr>
			<td width="149" valign="top" class="leftcoltext">
				<div align="center">
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%@ include file="/jsp/util/informacoes_usuario.jsp"%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%@ include file="/jsp/util/mensagens.jsp"%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
					<%--<p align="left">&nbsp;</p>--%>
				</div>
			</td>
			
			<td width="615" valign="top" class="centercoltext">
				
				<table height="100%">
					<tr>
						<td></td>
					</tr>
				</table>

				<!--In�cio Tabela Reference a P�gina��o da Tela de Processo-->
				
				<table>
					<tr>
						<td></td>
					</tr>
				</table>
				
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td width="11"><img border="0" src="imagens/parahead_left.gif" /></td>
						<td class="parabg">Filtrar Relat&oacute;rio Efici&ecirc;ncia da Cobran&ccedil;a</td>
						<td width="11" valign="top"><img border="0" src="imagens/parahead_right.gif" /></td>
					</tr>
	
				</table>
				
				<!--Fim Tabela Reference a P�gina��o da Tela de Processo-->
				<p>&nbsp;</p>
				<table width="100%" border="0">
					<tr>
						<td width="100%" colspan=2>
							<table width="100%" border="0">
								<tr>
									<td>Para filtrar os dados do Relat&oacute;rio Efici&ecirc;ncia da Cobran&ccedil;a, informe os dados abaixo:</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td><strong>Tipo de Comando<font color="red">  </font>:</strong></td>
						<td>
							<span class="style2"> 					
								<html:radio property="comando" tabindex="2" value="1" onclick="recarregaForm();"/><strong>Cronograma</strong>
								<html:radio property="comando" tabindex="3" value="2" onclick="recarregaForm();"/><strong>Eventual</strong>
								<html:radio property="comando" tabindex="3" value="3" onclick="recarregaForm();"/><strong>Ambos</strong>
	 						</span>
	 					</td>
					</tr>
					<tr>
           					<logic:equal name="FiltroEficienciaCobrancaRelatorioActionForm" property="comando" value="2">
						<td HEIGHT="30"><strong>T�tulo do Comando<font color="red"></font>:</strong></td>
        				<td>
           					<html:hidden property="idCobrancaAcaoAtividadeComando"/>
        					<html:text property="tituloCobrancaAcaoAtividadeComando" size="52" maxlength="52" readonly="true"
								style="background-color:#EFEFEF; border:0; color: #000000"/>
							<a href="javascript:abrirPopup('exibirPesquisarComandoAcaoCobrancaAction.do?limparForm=OK', 400, 750);" title="Pesquisar" id="linkTituloComando" >
								<img src="<bean:message key='caminho.imagens'/>pesquisa.gif" width="23" height="21" border="0"></a>
							<a href="javascript:limparTitulo();">
								<img src="<bean:message key="caminho.imagens"/>limparcampo.gif"	border="0" title="Apagar" /></a>

					    </td>
					    </logic:equal>
					</tr>
					<tr><logic:equal name="FiltroEficienciaCobrancaRelatorioActionForm" property="comando" value="1">
						<td><Strong>Comando<font color="red"></font>:</Strong></td>
						<td>
							<html:hidden property="idCobrancaAcaoAtividadeCronograma"/>
							<html:text property="descricaoGrupo" size="20" readonly="true" style="background-color:#EFEFEF; border:0; color: #000000"/>&nbsp;
							<a href="javascript:abrirPopup('exibirPesquisarCronogramaAcaoCobrancaAction.do', 400, 750);" title="Pesquisar" id="linkComnando">
								<img src="<bean:message key='caminho.imagens'/>pesquisa.gif" width="23" height="21" border="0"></a>
							<a href="javascript:limparGrupo();">
								<img src="<bean:message key="caminho.imagens"/>limparcampo.gif"	border="0" title="Apagar" /></a>
						
						</td>
						</logic:equal>
					</tr>
					<tr>
						<td><strong>A��o:</strong></td>
						<td align="left">
							<html:select styleId="acao" property="acao">
								<html:option value="">&nbsp;</html:option>
								
								<logic:present name="colecaoCobrancaAcao" scope="request">
									<logic:notEmpty name="colecaoCobrancaAcao" scope="request">
										<html:options collection="colecaoCobrancaAcao" labelProperty="descricaoCobrancaAcao" property="id" />
									</logic:notEmpty>
								</logic:present>
							</html:select>
						</td>
					</tr>
					<tr>
						<td><strong>Empresa:<font color="red">*</font></strong></td>
						<td align="left">
							<html:select styleId="empresa" property="empresa">
								<html:option value="">&nbsp;</html:option>
								
								<logic:present name="colecaoEmpresa" scope="request">
									<logic:notEmpty name="colecaoEmpresa" scope="request">
										<html:options collection="colecaoEmpresa" labelProperty="descricao" property="id" />
									</logic:notEmpty>
								</logic:present>
							</html:select>
						</td>
					</tr>
					<tr>
						<td><strong>Per�odo Inicial:<font color="red">*</font></strong></td>
						<td>
							<strong> 
								<html:text maxlength="10" property="periodoInicio" size="10" tabindex="7" onkeypress="return isCampoNumerico(event);" onkeyup="javascript:mascaraData(this, event);replicarCampo(document.forms[0].periodoFim,this);" /> 
								 <a id="linkPeriodoInicio" href="javascript:abrirCalendario('FiltroEficienciaCobrancaRelatorioActionForm', 'periodoInicio')">
									<img border="0" src="<bean:message key='caminho.imagens'/>calendario.gif" width="20" border="0" align="middle" alt="Exibir Calend�rio" />
								  </a>
				   			&nbsp;(dd/mm/aaaa)
				   			</strong>
						</td>
					</tr>
					<tr>
						<td><strong>Per�odo Final:<font color="red">*</font></strong></td>
						<td>
							<strong> 
								<html:text maxlength="10" property="periodoFim" size="10" tabindex="8" onkeypress="return isCampoNumerico(event);" onkeyup="javascript:mascaraData(this, event);" /> 
								  <a id="linkPeriodoFim" href="javascript:abrirCalendario('FiltroEficienciaCobrancaRelatorioActionForm', 'periodoFim')">
									<img border="0" src="<bean:message key='caminho.imagens'/>calendario.gif" width="20" border="0" align="middle" alt="Exibir Calend�rio" />
								  </a>
				   			(dd/mm/aaaa)
				   			</strong>
						</td>
					</tr>
					<tr>
						<td><strong>Grupo :</strong></td>
						<td>
							<html:select styleId="idGrupo" property="idGrupo" name="FiltroEficienciaCobrancaRelatorioActionForm" style="width: 230px;" multiple="mutiple" size="6" onchange="recarregaForm();">
								<logic:present name="colecaoCobrancaGrupo" scope="request">
									<html:option value="" />
									<logic:notEmpty name="colecaoCobrancaGrupo" scope="request">
										<html:options collection="colecaoCobrancaGrupo" labelProperty="descricao" property="id" />
									</logic:notEmpty>
								</logic:present>
							</html:select>
						</td>
					</tr>
					<tr>
						<td><strong>Setor (Zona) :</strong></td>
						<td>
							<html:select styleId="idSetor" property="idSetor" name="FiltroEficienciaCobrancaRelatorioActionForm" style="width: 230px;" multiple="mutiple" size="6">
								<logic:present name="colecaoSetorComercial" scope="request">
									<logic:notEmpty name="colecaoSetorComercial" scope="request">
										<html:option value="" />
										<html:options collection="colecaoSetorComercial" labelProperty="descricao" property="id" />
									</logic:notEmpty>
								</logic:present>
							</html:select>
						</td>
					</tr>
                <tr>
                <tr>
					<td>
						<strong> 
							<font color="#FF0000"> 
								<input type="button" name="Submit22" class="bottonRightCol" value="Limpar" onClick="javascript:limparForm(document.forms[0]);">
							</font> 
						</strong>
					</td>
					<td align="right">
						<input type="button" name="Submit2" class="bottonRightCol" value="Gerar Relatorio" onclick="validaForm(document.forms[0]);">
					</td>
				</tr>
				</table>
				<p>&nbsp;</p>
			</tr>
			<!-- Rodap� -->
			<%@ include file="/jsp/util/rodape.jsp"%>
		</table>
		<p>&nbsp;</p>
	<tr>
	</tr>

</html:form>
</body>
</html:html>