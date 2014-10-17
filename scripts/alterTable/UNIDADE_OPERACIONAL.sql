-- UNIDADE_OPERACIONAL
-- P�RICLES TAVARES
ALTER TABLE "GSAN_ADMIN"."UNIDADE_OPERACIONAL"
ADD CONSTRAINT FK1_UNIDADE_OPERACIONAL FOREIGN KEY (SABS_ID)
REFERENCES "GSAN_ADMIN"."SISTEMA_ABASTECIMENTO" (SABS_ID) ENABLE;

ALTER TABLE "GSAN_ADMIN"."UNIDADE_OPERACIONAL"
ADD CONSTRAINT FK2_UNIDADE_OPERACIONAL FOREIGN KEY (LOCA_ID)
REFERENCES "GSAN_ADMIN"."LOCALIDADE" (LOCA_ID) ENABLE;

ALTER TABLE "GSAN_ADMIN"."UNIDADE_OPERACIONAL"
ADD CONSTRAINT FK3_UNIDADE_OPERACIONAL FOREIGN KEY (LOGR_ID)
REFERENCES "GSAN_ADMIN"."LOGRADOURO" (LOGR_ID) ENABLE;

ALTER TABLE "GSAN_ADMIN"."UNIDADE_OPERACIONAL"
ADD CONSTRAINT FK4_UNIDADE_OPERACIONAL FOREIGN KEY (BAIR_ID)
REFERENCES "GSAN_ADMIN"."BAIRRO" (BAIR_ID) ENABLE;

ALTER TABLE "GSAN_ADMIN"."UNIDADE_OPERACIONAL"
ADD CONSTRAINT FK5_UNIDADE_OPERACIONAL FOREIGN KEY (EDRF_ID)
REFERENCES "GSAN_ADMIN"."ENDERECO_REFERENCIA" (EDRF_ID) ENABLE;

ALTER TABLE "GSAN_ADMIN"."UNIDADE_OPERACIONAL"
ADD CONSTRAINT FK6_UNIDADE_OPERACIONAL FOREIGN KEY (CEP_ID)
REFERENCES "GSAN_ADMIN"."CEP" (CEP_ID) ENABLE;