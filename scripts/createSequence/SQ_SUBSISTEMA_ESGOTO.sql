CREATE SEQUENCE GSAN_ADMIN.SQ_SUBSISTEMA_ESGOTO 
INCREMENT BY 1 MINVALUE 1 MAXVALUE 9223372036854775807 START WITH 1;

GRANT ALL PRIVILEGES ON GSAN_ADMIN.SQ_SUBSISTEMA_ESGOTO TO GSAN_OPER;
CREATE OR REPLACE PUBLIC SYNONYM SQ_SUBSISTEMA_ESGOTO FOR GSAN_ADMIN.SQ_SUBSISTEMA_ESGOTO;