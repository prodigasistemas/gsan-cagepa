-- VENCIMENTO_ALTERNATIVO
-- Isaac Silva
ALTER TABLE "GSAN_ADMIN"."VENCIMENTO_ALTERNATIVO"
ADD ("CLIE_ID" NUMBER);

ALTER TABLE "GSAN_ADMIN"."VENCIMENTO_ALTERNATIVO"
ADD CONSTRAINT FK2_VENCIMENTO_ALTERNATIVO FOREIGN KEY (CLIE_ID)
REFERENCES "GSAN_ADMIN"."CLIENTE" (CLIE_ID) ENABLE;