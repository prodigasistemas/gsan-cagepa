-- Isaac Silva
CREATE SEQUENCE GSAN_ADMIN.SQ_SETOR_COMERCIAL_VENCIMENTO 
INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1;

GRANT ALL PRIVILEGES ON GSAN_ADMIN.SQ_SETOR_COMERCIAL_VENCIMENTO TO GSAN_OPER;
CREATE OR REPLACE PUBLIC SYNONYM SQ_SETOR_COMERCIAL_VENCIMENTO FOR GSAN_ADMIN.SQ_SETOR_COMERCIAL_VENCIMENTO;