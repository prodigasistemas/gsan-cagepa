ALTER TABLE "GSAN_ADMIN"."COBRANCA_ACAO"
ADD ("RDIR_IDPRIMEIRAOPCAO" NUMBER(8) NULL,
"RDIR_IDSEGUNDAOPCAO" NUMBER(8) NULL,
"RDIR_IDTERCEIRAOPCAO" NUMBER(8) NULL);

COMMENT ON COLUMN "GSAN_ADMIN"."COBRANCA_ACAO".RDIR_IDPRIMEIRAOPCAO IS 'OP합ES PARCEL. PRIMEIRA RESOLU플O DA DIRETORIA';
COMMENT ON COLUMN "GSAN_ADMIN"."COBRANCA_ACAO".RDIR_IDSEGUNDAOPCAO IS 'OP합ES PARCEL. SEGUNDA RESOLU플O DA DIRETORIA';
COMMENT ON COLUMN "GSAN_ADMIN"."COBRANCA_ACAO".RDIR_IDTERCEIRAOPCAO IS 'OP합ES PARCEL. TERCEIRA RESOLU플O DA DIRETORIA';

ALTER TABLE "GSAN_ADMIN"."COBRANCA_ACAO"
ADD CONSTRAINT FK9_COBRANCA_ACAO FOREIGN KEY (RDIR_IDPRIMEIRAOPCAO)
REFERENCES "GSAN_ADMIN"."RESOLUCAO_DIRETORIA" (RDIR_ID) ENABLE;

ALTER TABLE "GSAN_ADMIN"."COBRANCA_ACAO"
ADD CONSTRAINT FK10_COBRANCA_ACAO FOREIGN KEY (RDIR_IDSEGUNDAOPCAO)
REFERENCES "GSAN_ADMIN"."RESOLUCAO_DIRETORIA" (RDIR_ID) ENABLE;

ALTER TABLE "GSAN_ADMIN"."COBRANCA_ACAO"
ADD CONSTRAINT FK11_COBRANCA_ACAO FOREIGN KEY (RDIR_IDTERCEIRAOPCAO)
REFERENCES "GSAN_ADMIN"."RESOLUCAO_DIRETORIA" (RDIR_ID) ENABLE;

delete FROM TABELA_COLUNA where TBCO_ID>=41068 and TBCO_ID<=41091;

update TABELA_COLUNA set TBCO_ICPRIMARYKEY = 1 where TBCO_ID=36290;
update TABELA_COLUNA set TBCO_DSCOLUNA='Acao Predecessora' where TBCO_ID=36291;
update TABELA_COLUNA set TBCO_DSCOLUNA='Descricao da Acao de Cobranca' where TBCO_ID=36292;
update TABELA_COLUNA set TBCO_DSCOLUNA='Acao Obrigatoria' where TBCO_ID=36293;
update TABELA_COLUNA set TBCO_DSCOLUNA='Pode ser Repetida no Ciclo' where TBCO_ID=36294;
update TABELA_COLUNA set TBCO_DSCOLUNA='Provoca Suspensao de Abastecimento' where TBCO_ID=36295;
update TABELA_COLUNA set TBCO_DSCOLUNA='Numero de Dias de Validade da Acao' where TBCO_ID=36296;
update TABELA_COLUNA set TBCO_DSCOLUNA='Numero de Dias entre a Acao e sua Predecessora' where TBCO_ID=36297;
update TABELA_COLUNA set TBCO_DSCOLUNA='Indicador de Uso' where TBCO_ID=36298;
update TABELA_COLUNA set TBCO_DSCOLUNA='Ultima Alteracao' where TBCO_ID=36299;
update TABELA_COLUNA set TBCO_DSCOLUNA='Tipo de Servico da Ordem de Servico a ser Gerada' where TBCO_ID=36300;
update TABELA_COLUNA set TBCO_DSCOLUNA='Tipo de Documento a ser Gerado' where TBCO_ID=36301;
update TABELA_COLUNA set TBCO_DSCOLUNA='Situacao da Ligacao de Agua dos Imoveis' where TBCO_ID=36302;
update TABELA_COLUNA set TBCO_DSCOLUNA='Situacao da Ligacao de Esgoto dos Imoveis' where TBCO_ID=36303;
update TABELA_COLUNA set TBCO_DSCOLUNA='Considera Debitos a Cobrar' where TBCO_ID=36304;
update TABELA_COLUNA set TBCO_DSCOLUNA='Gera Taxa' where TBCO_ID=36305;
update TABELA_COLUNA set TBCO_DSCOLUNA='Ordem no Cronograma' where TBCO_ID=36306;
update TABELA_COLUNA set TBCO_DSCOLUNA='Criterio de Cobranca' where TBCO_ID=36307;
update TABELA_COLUNA set TBCO_DSCOLUNA='Considera Acrescimos por Impontualidade' where TBCO_ID=36308;
update TABELA_COLUNA set TBCO_DSCOLUNA='Compoe o Cronograma' where TBCO_ID=36309;
update TABELA_COLUNA set TBCO_DSCOLUNA='Pode Emitir Boletins de Cadastro' where TBCO_ID=36310;
update TABELA_COLUNA set TBCO_DSCOLUNA='Pode ser Executada para Imoveis sem Debito' where TBCO_ID=36311;
update TABELA_COLUNA set TBCO_DSCOLUNA='Numero de Dias de Vencimento' where TBCO_ID=36312;
update TABELA_COLUNA set TBCO_DSCOLUNA='Efeito da Acao' where TBCO_ID=46028;
update TABELA_COLUNA set TBCO_DSCOLUNA='Numero da 1� R.D.' where TBCO_ID=46029;
update TABELA_COLUNA set TBCO_DSCOLUNA='N�mero da 2� R.D.' where TBCO_ID=46030;
update TABELA_COLUNA set TBCO_DSCOLUNA='N�mero da 3� R.D.' where TBCO_ID=46031;

update OPERACAO set TBCO_IDARGUMENTO=36290, TBCO_ID=36290 where OPER_ID=1010;

INSERT INTO OPERACAO_TABELA (OPER_ID,TABE_ID,OPTB_TMULTIMAALTERACAO) 
VALUES (1010,45,CURRENT_TIMESTAMP);

ALTER TABLE GSAN_ADMIN.COBRANCA_ACAO ADD (CBAC_ICCREDAREAL NUMBER(*,0) DEFAULT 2, CBAC_ICGUIAPAGAM NUMBER(*,0) DEFAULT 2);

COMMENT ON COLUMN "GSAN_ADMIN"."COBRANCA_ACAO".CBAC_ICCREDAREAL IS 'CONSIDERA CR�DITO A REALIZAR';
COMMENT ON COLUMN "GSAN_ADMIN"."COBRANCA_ACAO".CBAC_ICGUIAPAGAM IS 'CONSIDERA GUIA DE PAGAMENTO';

INSERT INTO TABELA_COLUNA (TBCO_ID,TABE_ID,TBCO_TMULTIMAALTERACAO,TBCO_NMCOLUNA,TBCO_DSCOLUNA,TBCO_ICPRIMARYKEY,TBCO_NMABREVIADO) 
	VALUES (SQ_TABELA_COLUNA.nextVal,45,current_timestamp,'cbac_iccredareal','Considera Cr�dito a Realizar ',2,NULL);
INSERT INTO TABELA_COLUNA (TBCO_ID,TABE_ID,TBCO_TMULTIMAALTERACAO,TBCO_NMCOLUNA,TBCO_DSCOLUNA,TBCO_ICPRIMARYKEY,TBCO_NMABREVIADO) 
	VALUES (SQ_TABELA_COLUNA.nextVal,45,current_timestamp,'cbac_icguiapagam','Considera Guia de Pagamento',2,NULL);
	
INSERT INTO OPERACAO_TABELA (OPER_ID,TABE_ID,OPTB_TMULTIMAALTERACAO) 
VALUES (1040,45,CURRENT_TIMESTAMP);

INSERT INTO OPERACAO_TABELA (OPER_ID,TABE_ID,OPTB_TMULTIMAALTERACAO) 
VALUES (1043,45,CURRENT_TIMESTAMP);

COMMIT;


