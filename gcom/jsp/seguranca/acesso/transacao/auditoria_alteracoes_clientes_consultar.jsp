<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/gcomLib.tld" prefix="gcom" %>
<%@ page import="gcom.util.ConstantesSistema"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link rel="stylesheet" href="<bean:message key="caminho.css"/>EstilosCompesa.css" type="text/css">

<script language="JavaScript" src="<bean:message key="caminho.js"/>util.js"></script>
<script language="JavaScript" src="<bean:message key="caminho.js"/>validacao/ManutencaoRegistro.js"></script>
<script language="JavaScript" src="<bean:message key="caminho.js"/>Calendario.js"></script>
	
<script language="JavaScript" src="<bean:message key="caminho.js"/>validacao/regras_validator.js"></script>	
<script language="JavaScript">

	function recuperarDadosPopup(codigoRegistro, descricaoRegistro, tipoConsulta) {
		var form = document.ConsultarAuditoriaAlteracoesClientesActionForm;
	 	if (tipoConsulta == 'funcionario') {       	
			form.idFuncionario.value = codigoRegistro;
			form.nomeFuncionario.value = descricaoRegistro;
			form.nomeFuncionario.style.color = "#000000";
		}
	}
	
	function dataEstahLimpa(){
		 	var dataInicial = document.forms[0].dataInicial.value;
		 	var dataFinal = document.forms[0].dataFinal.value;
		 	if (dataInicial == '' || dataFinal == ''){
		 	    document.forms[0].dataLimpa.value = '1';
		 	} else {
		    	document.forms[0].dataLimpa.value = '0';
		 	}
	}
	 	
	function validaForm(){	
		var form = document.ConsultarAuditoriaAlteracoesClientesActionForm;
		form.submit();
	}
	 
	function limparFuncionario() {		
		var form = document.ConsultarAuditoriaAlteracoesClientesActionForm;	
		form.idFuncionario.value = "";
		form.nomeFuncionario.value = "";
		desabilitarIdUsuario();
	}
	
	function limparUsuario() {		
		var form = document.ConsultarAuditoriaAlteracoesClientesActionForm;	
		form.idUsuario.value = "";
		desabilitarIdFuncionario();
	}
	
	function limparDataInicial() {		
		limparDataFinal();	
		var form = document.ConsultarAuditoriaAlteracoesClientesActionForm;
		form.dataInicial.value = "";
	}
	
	function limparDataFinal() {	
		var form = document.ConsultarAuditoriaAlteracoesClientesActionForm;
		form.dataFinal.value = "";
	}
	
	function desabilitarIdUsuario(){
		var form = document.ConsultarAuditoriaAlteracoesClientesActionForm;
		if(form.idFuncionario.value != "" ){
			form.idUsuario.disabled = true;
			limparUsuario();
		}else{
			form.idUsuario.disabled = false;				
		}
	}

	function desabilitarIdFuncionario(){
		var form = document.ConsultarAuditoriaAlteracoesClientesActionForm;
		if(form.idUsuario.value != "" ){
			form.idFuncionario.disabled = true;	
			limparFuncionario();
		}else{
			form.idFuncionario.disabled = false;					 
		}
	}
	 
</script>



</head>
<body leftmargin="5" topmargin="5" onload="desabilitarIdUsuario();desabilitarIdFuncionario();">
	<html:form action="/consultarAuditoriaAlteracoesClientesAction.do"
	   name="ConsultarAuditoriaAlteracoesClientesActionForm"
	   type="gcom.gui.seguranca.acesso.transacao.ConsultarAuditoriaAlteracoesClientesActionForm"
	   method="post" >
	  
		<table width="100%" border="0">
			<tr>
				<td colspan="3">Para Consultar as Altera��es de Clientes, informe os dados abaixo:</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
				
				<tr>
					<td><strong>Funcion�rio:</strong></td>
					<td colspan="2">
						<html:text maxlength="9" property="idFuncionario"
							tabindex="1" size="9"
							onkeypress="javascript:validaEnterComMensagem(event, 'exibirConsultarAuditoriaAlteracoesClientesAction.do?objetoConsulta=1', 'idFuncionario', 'Funcion�rio');" 
							onkeyup="desabilitarIdUsuario();"
							onblur="desabilitarIdUsuario();"/>
						<a
							href="javascript:abrirPopup('exibirPesquisarFuncionarioAction.do');">
						<img width="23" height="21" border="0"
							src="<bean:message key="caminho.imagens"/>pesquisa.gif"
							title="Pesquisar Funcion�rio" /></a> <logic:present
							name="idFuncionarioNaoEncontrado" scope="request">
							<html:text maxlength="30" property="nomeFuncionario"
								readonly="true"
								style="background-color:#EFEFEF; border:0; color: #ff0000"
								size="40" />
						</logic:present> <logic:notPresent
							name="idFuncionarioNaoEncontrado" scope="request">
							<html:text maxlength="30" property="nomeFuncionario"
								readonly="true"
								style="background-color:#EFEFEF; border:0; color: #000000"
								size="40" />
						</logic:notPresent> <a href="javascript:limparFuncionario();"> <img
							src="<bean:message key="caminho.imagens"/>limparcampo.gif"
							border="0" title="Apagar" /></a>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
                  <td>
	                  <strong>Usu�rio:</strong>
                  </td>
                  <td>
                  	<html:text property="idUsuario" size="10" tabindex="2" maxlength="8" 
                  		onkeypress="return isCampoNumerico(event);" 
                  		onkeyup="desabilitarIdFuncionario();" 
                  		onblur="desabilitarIdFuncionario();"/>
                  	<a href="javascript:limparUsuario();"> <img src="<bean:message key="caminho.imagens"/>limparcampo.gif" border="0" title="Apagar" /></a>	
                  </td>
                  <td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><strong>Data Inicial:</strong></td>
					<td>
					<input type="hidden" name="dataLimpa" value="0">
                  		<html:text name="ConsultarAuditoriaAlteracoesClientesActionForm" onkeyup="mascaraData(this, event);"
                  	 		onblur="javascript:dataEstahLimpa()"  property="dataInicial" size="10" maxlength="10" tabindex="3"/> 
						<a href="javascript:abrirCalendario('ConsultarAuditoriaAlteracoesClientesActionForm', 'dataInicial')">
						<img border="0" src="<bean:message key='caminho.imagens'/>calendario.gif" width="20" border="0" align="middle" alt="Exibir Calend�rio" />
						</a>&nbsp; dd/mm/aaaa
						<a href="javascript:limparDataInicial();"> <img src="<bean:message key="caminho.imagens"/>limparcampo.gif" border="0" title="Apagar" /></a>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td><strong>Data Final:</strong></td>	
					<td>			
					<html:text name="ConsultarAuditoriaAlteracoesClientesActionForm" onkeyup="mascaraData(this, event);" property="dataFinal" size="10" maxlength="10" tabindex="4"/> 
						<a href="javascript:abrirCalendario('ConsultarAuditoriaAlteracoesClientesActionForm', 'dataFinal')"><img border="0" src="<bean:message key='caminho.imagens'/>calendario.gif"
							width="20" border="0" align="middle" alt="Exibir Calend�rio" /></a> dd/mm/aaaa
						<a href="javascript:limparDataFinal();"> <img src="<bean:message key="caminho.imagens"/>limparcampo.gif" border="0" title="Apagar" /></a>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>
						<strong> 
							<font color="#ff0000"> 
								<input	name="Submit22" 
										class="bottonRightCol"
										value="Limpar"
										tabindex="5" 
										type="button"
										onclick="window.location.href='/gsan/exibirConsultarAuditoriaAlteracoesClientesAction.do?menu=sim';">
								<input type="button"
										name="ButtonCancelar" 
										class="bottonRightCol" 
										value="Cancelar"
										tabindex="6"
										onClick="javascript:window.location.href='/gsan/telaPrincipal.do'">
							</font>
						</strong>
					</td>
					<td align="right"></td>
					<td align="right">
						<gcom:controleAcessoBotao name="Button" value="Consultar" tabindex="7" onclick="javascript:validaForm();" url="consultarAuditoriaAlteracoesClientesAction.do"/>
					</td>
				</tr>
			</table>
	</html:form>
</body>
</html>