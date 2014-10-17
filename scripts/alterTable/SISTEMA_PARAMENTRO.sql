ALTER TABLE GSAN_ADMIN.SISTEMA_PARAMETROS ADD
(PARM_QTDIASVENCIMENTOSETOR NUMBER(4,0) DEFAULT 0 NOT NULL);

-- SISTEMA_PARAMETROS
-- Hebert Falc�o
ALTER TABLE "GSAN_ADMIN"."SISTEMA_PARAMETROS"
ADD ("CSTF_IDDEFAULT" NUMBER NULL);

COMMENT ON COLUMN SISTEMA_PARAMETROS.CSTF_IDDEFAULT IS 'CODIGO DA TARIFA PADRAO';

ALTER TABLE "GSAN_ADMIN"."SISTEMA_PARAMETROS"
ADD CONSTRAINT FK8_SISTEMA_PARAMETROS FOREIGN KEY (CSTF_IDDEFAULT)
REFERENCES "GSAN_ADMIN"."CONSUMO_TARIFA" (CSTF_ID) ENABLE;
