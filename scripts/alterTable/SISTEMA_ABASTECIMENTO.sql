-- SISTEMA_ABASTECIMENTO
-- P�RICLES TAVARES
ALTER TABLE "GSAN_ADMIN"."SISTEMA_ABASTECIMENTO"
ADD ("SABS_CDSISTEMAABASTECIMENTO" NUMBER(4) NULL);

ALTER TABLE GSAN_ADMIN.SISTEMA_ABASTECIMENTO ADD 
(GREG_ID NUMBER(*, 0) NOT NULL);

ALTER TABLE GSAN_ADMIN.SISTEMA_ABASTECIMENTO 
ADD CONSTRAINT FK1_SISTEMA_ABASTECIMENTO FOREIGN KEY (GREG_ID) 
REFERENCES GSAN_ADMIN.GERENCIA_REGIONAL (GREG_ID) ENABLE;

UPDATE SISTEMA_ABASTECIMENTO SET GREG_ID = 1

ALTER TABLE SISTEMA_ABASTECIMENTO MODIFY GREG_ID NOT NULL

-- Anderson Italo
COMMENT ON COLUMN SISTEMA_ABASTECIMENTO.SABS_ID IS 'ID DA ATABELA SISTEMA_ABASTECIMENTO.';
COMMENT ON COLUMN SISTEMA_ABASTECIMENTO.SABS_DSSISTEMAABASTECIMENTO IS 'DESCRI��O DO SISTEMA DE ABASTECIMENTO';
COMMENT ON COLUMN SISTEMA_ABASTECIMENTO.SABS_DSABREVIADO IS 'DESCRI��O ABREVIADA DO SISTEMA DE ABASTECIMENTO';
COMMENT ON COLUMN SISTEMA_ABASTECIMENTO.SABS_ICUSO IS 'INDICADOR DE ATIVO 1 - ATIVO 2 - INATIVO';
COMMENT ON COLUMN SISTEMA_ABASTECIMENTO.SABS_TMULTIMAALTERACAO IS 'DATA DA �LTIMA ALTERA��O';
COMMENT ON COLUMN SISTEMA_ABASTECIMENTO.SABS_CDSISTEMAABASTECIMENTO IS 'C�DIGO DO SISTEMA DE ABASTECIMENTO';
COMMENT ON COLUMN SISTEMA_ABASTECIMENTO.GREG_ID  IS 'C�DIGO DO GER�NCIA REGIONAL';

