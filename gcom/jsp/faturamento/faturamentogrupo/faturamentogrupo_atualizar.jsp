<%@page import="gcom.util.ConstantesSistema"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-template.tld" prefix="template" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html:html>

<head>

 <%@ include file="/jsp/util/titulo.jsp"%>
 <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
 <link rel="stylesheet" href="<bean:message key="caminho.css"/>EstilosCompesa.css" type="text/css">

 <html:javascript staticJavascript="false"  formName="InserirFaturamentoGrupoActionForm" />

 <script language="JavaScript" src="<bean:message key="caminho.js"/>validacao/regras_validator.js"></script>
 <script language="JavaScript" src="<bean:message key="caminho.js"/>jquery-1.4.2.min.js"></script>
 <script language="JavaScript" src="<bean:message key="caminho.js"/>util.js" ></script>
 <script>

function validarForm(form){
	
	if(validateInserirFaturamentoGrupoActionForm(form)){
		
		if(form.diaVencimento.value != ""){
	  		if(form.diaVencimento.value < 1 || form.diaVencimento.value > 31){
	  			alert("O dia do vencimento deve ser entre 1 e 31");
	  			return;
	  		}
	  	}
		
		form.submit();
	}
}

 </script>
</head>

<body leftmargin="5" topmargin="5" onload="setarFoco('${requestScope.nomeCampo}');">
<div id="formDiv">
<html:form action="/atualizarFaturamentoGrupoAction.do" method="post"
	name="InserirFaturamentoGrupoActionForm"
	enctype="multipart/form-data"
	type="org.apache.struts.action.DynaActionForm"
	onsubmit="return validateAtualizarFaturamentoGrupoActionForm(this);">

	<%@ include file="/jsp/util/cabecalho.jsp"%>
	<%@ include file="/jsp/util/menu.jsp"%>
	
	<INPUT TYPE="hidden" ID="indicadorUsoAux" name="indicadorUsoAux" value="${requestScope.indicadorUsoAux}" />
	
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
			<td width="655" valign="top" class="centercoltext"><!--In�cio Tabela Reference a P�gina��o da Tela de Processo-->
			<table>
				<tr>
					<td></td>
				</tr>
			</table>
			<table width="100%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="11"><img border="0" src="<bean:message key='caminho.imagens'/>parahead_left.gif" /></td>
					<td class="parabg">Atualizar Grupo de Faturamento</td>
					<td width="11" valign="top"><img border="0" src="<bean:message key='caminho.imagens'/>parahead_right.gif" /></td>
				</tr>
			</table>
			<p>&nbsp;</p>
			 
			 <table width="100%" border="0">
			 	<tr> 
                	<td colspan="2">Para atualizar o grupo de faturamento, informe os dados abaixo:</td>
              	</tr>
              	
              	<tr>
					<td>
						<strong>C�digo:</strong>
					</td>
					<td>
						<html:hidden property="idFaturamentoGrupo" /> 
							<bean:write name="InserirFaturamentoGrupoActionForm" property="idFaturamentoGrupo" /></td>
					</td>
				</tr>
				
				<tr>
					<td width="162"><strong>Descri��o:<font color="#FF0000">*</font></strong></td>
					<td><strong> <html:text property="descricao" size="25" maxlength="25"></html:text> </strong></td>
				</tr>
			
				<tr>
					<td width="162"><strong>Descri��o Abreviada:<font color="#FF0000">*</font></strong></td>
					<td><strong> <html:text property="descricaoAbreviada" size="3" maxlength="3"></html:text> </strong></td>
				</tr>
				<tr>
         			 <td width="30%"><strong>M�s/Ano Refer�ncia:<font color="#FF0000">*</font></strong></td>
          			<td width="70%">
          				<html:text property="anoMesReferencia" size="7"  maxlength="7" 
          						   onkeypress="javascript: return isCampoNumerico(event);"
          						   onkeyup="javascript:mascaraAnoMes(this, event);" 
          						   onblur="javascript:return verificaAnoMes(this);"/>
         					&nbsp;mm/aaaa
         					<br/>
          			</td>
        		</tr>		
				<tr>
					<td width="162"><strong>Dia do Vencimento:<font color="#FF0000">*</font></strong></td>
					<td><strong> <html:text property="diaVencimento" size="1" maxlength="2" onkeypress="return isCampoNumerico(event);">
								</html:text> </strong></td>
				</tr>											
				<tr>
					<td><strong>O vencimento do grupo � igual ao ano/m�s do faturamento?<font color="#FF0000">*</font></strong></td>
					<td><strong> <html:radio property="indicadorVencimentoMesFatura" value="1" />
					<strong>Sim <html:radio property="indicadorVencimentoMesFatura" value="2" />
					N�o</strong> </strong></td>
				</tr>
             	<tr>
					<td><strong>Indicador de Uso:<font color="#FF0000">*</font></strong></td>
					<td>
						<html:radio property="indicadorUso" value="<%=ConstantesSistema.SIM.toString()%>" /><strong>Ativo</strong>
						<html:radio property="indicadorUso" value="<%=ConstantesSistema.NAO.toString()%>" /><strong> Inativo</strong>
					</td>
				</tr>
              	<tr> 
                	<td><strong> <font color="#FF0000"></font></strong></td>
                	<td align="right"> <div align="left"><strong><font color="#FF0000">*</font></strong>Campos obrigat&oacute;rios</div></td>
              	</tr>
              	
              	<table width="100%" border="0">
	              <tr>
					<td>
						<logic:present name="manter" scope="session">
							<input type="button" name="ButtonReset" class="bottonRightCol" value="Voltar"
								onClick="javascript:window.history.back();">
						</logic:present>

						<logic:notPresent name="manter" scope="session">
							<input type="button" name="ButtonReset"  class="bottonRightCol" value="Voltar"
								onClick="javascript:window.location.href='/gsan/exibirFiltrarFaturamentoGrupoAction.do?limpar=S'">
						</logic:notPresent> 
					<input name="desfazer"
							class="bottonRightCol" value="Desfazer" type="button"
							onclick="window.location.href='/gsan/exibirAtualizarFaturamentoGrupoAction.do?desfazer=S&idFaturamentoGrupo=<bean:write name="InserirFaturamentoGrupoActionForm" property="idFaturamentoGrupo" />';">
					
					<input name="Button" type="button" class="bottonRightCol"
							value="Cancelar" align="left"
							onClick="javascript:window.location.href='/gsan/telaPrincipal.do'"></td>
					<td align="right"><input name="Button" type="button"
						class="bottonRightCol" value="Atualizar" align="right"
						onClick="javascript:validarForm(document.forms[0]);"></td>
				</tr>
	              
             	</table>
              	
			 </table>
			
			<p>&nbsp;</p>
		</tr>
		<tr>
			<td colspan="3"></td>
		</tr>
	</table>
	<%@ include file="/jsp/util/rodape.jsp"%>
</html:form>
</div>
</body>

<%@ include file="/jsp/util/telaespera.jsp"%>

</html:html>