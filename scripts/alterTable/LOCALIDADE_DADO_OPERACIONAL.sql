ALTER TABLE "GSAN_ADMIN"."LOCALIDADE_DADO_OPERACIONAL" ADD CONSTRAINT UK_L_D_OP_LOCA_ID_LDOP_AMREFE UNIQUE (LOCA_ID, LDOP_AMREFERENCIA);

-- Hebert Falc�o
ALTER TABLE "GSAN_ADMIN"."LOCALIDADE_DADO_OPERACIONAL" MODIFY "LDOP_QTCONSUMOENEERGIA" NUMBER(11,2);

ALTER TABLE "GSAN_ADMIN"."LOCALIDADE_DADO_OPERACIONAL" MODIFY "LDOP_QTHORASPARALIZADAS" NUMBER(11,2);
