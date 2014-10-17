CREATE TABLE GSAN_ADMIN.PRE_PARCELAMENTO
  (
    PREP_ID                        NUMBER PRIMARY KEY NOT NULL,
    CBDO_ID                        NUMBER,
    PREP_TMPREPARCELAMENTO         TIMESTAMP,
    PCST_ID                        NUMBER,    
    PREP_AMREFERENCIAFATURAMENTO   NUMBER,
    PREP_VLCONTA                   NUMBER(13,2),
    PREP_VLGUIAPAGAGAMENTO         NUMBER(13,2),
    PREP_VLSERVICOSACOBRAR         NUMBER(13,2),
    PREP_VLPREPARCELAMENTOSACOBRAR    NUMBER(13,2),
    PREP_VLCREDITOAREALIZAR        NUMBER(13,2),
    PREP_VLATUALIZACAOMONETARIA    NUMBER(13,2),
    PREP_VLJUROSMORA               NUMBER(13,2),
    PREP_VLMULTA                   NUMBER(13,2),
    PREP_VLDEBITOATUALIZADO        NUMBER(13,2),
    PREP_VLDESCONTOACRESCIMOS      NUMBER(13,2),
    PREP_VLDESCONTOANTIGUIDADE     NUMBER(13,2),
    PREP_VLDESCONTOINATIVIDADE     NUMBER(13,2),
    PREP_ICRESTABELECIMENTO        NUMBER,
    PREP_ICCONTASREVISAO           NUMBER,
    PREP_ICGUIASPAGAMENTO          NUMBER,
    PREP_ICACRESCIMOSIMPONTUALDADE NUMBER,
    PREP_ICDEBITOACOBRAR           NUMBER,
    PREP_ICCREDITOAREALIZAR        NUMBER,
    PREP_TMULTIMAALTERACAO         TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ENABLE,
    IMOV_ID                        NUMBER,
    IPER_ID                        NUMBER,
    RGAT_ID                        NUMBER,
    FUNC_ID                        NUMBER,
    LAST_ID                        NUMBER,
    LEST_ID                        NUMBER,
    LOCA_ID                        NUMBER,
    QDRA_ID                        NUMBER,
    PREP_CDSETORCOMERCIAL          NUMBER,
    PREP_NNQUADRA                  NUMBER,
    CBFM_ID                        NUMBER,
    PREP_ICCONFIRMACAO             NUMBER,
    CLIE_ID                        NUMBER,
    CONSTRAINT FK10_PREPARCELAMENTO FOREIGN KEY (CBDO_ID) REFERENCES COBRANCA_DOCUMENTO (CBDO_ID) ENABLE,
    CONSTRAINT FK11_PREPARCELAMENTO FOREIGN KEY (PCST_ID) REFERENCES PARCELAMENTO_SITUACAO (PCST_ID) ENABLE,
    CONSTRAINT FK12_PREPARCELAMENTO FOREIGN KEY (IMOV_ID) REFERENCES IMOVEL (IMOV_ID) ENABLE,
    CONSTRAINT FK13_PREPARCELAMENTO FOREIGN KEY (IPER_ID) REFERENCES IMOVEL_PERFIL (IPER_ID) ENABLE,
    CONSTRAINT FK2_PREPARCELAMENTO FOREIGN KEY (RGAT_ID) REFERENCES REGISTRO_ATENDIMENTO (RGAT_ID) ENABLE,
    CONSTRAINT FK3_PREPARCELAMENTO FOREIGN KEY (FUNC_ID) REFERENCES FUNCIONARIO (FUNC_ID) ENABLE,
    CONSTRAINT FK4_PREPARCELAMENTO FOREIGN KEY (LAST_ID) REFERENCES LIGACAO_AGUA_SITUACAO (LAST_ID) ENABLE,
    CONSTRAINT FK5_PREPARCELAMENTO FOREIGN KEY (LEST_ID) REFERENCES LIGACAO_ESGOTO_SITUACAO (LEST_ID) ENABLE,
    CONSTRAINT FK6_PREPARCELAMENTO FOREIGN KEY (LOCA_ID) REFERENCES LOCALIDADE (LOCA_ID) ENABLE,
    CONSTRAINT FK7_PREPARCELAMENTO FOREIGN KEY (QDRA_ID) REFERENCES QUADRA (QDRA_ID) ENABLE,
    CONSTRAINT FK17_PREPARCELAMENTO FOREIGN KEY (CBFM_ID) REFERENCES COBRANCA_FORMA (CBFM_ID) ENABLE,
    CONSTRAINT FK14_PREPARCELAMENTO FOREIGN KEY (CLIE_ID) REFERENCES GSAN_ADMIN.CLIENTE (CLIE_ID) ENABLE
  );
  
CREATE SEQUENCE GSAN_ADMIN.SQ_PRE_PARCELAMENTO MINVALUE 1 MAXVALUE 1.00000000000000E+27 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER NOCYCLE;
GRANT ALL PRIVILEGES ON GSAN_ADMIN.PRE_PARCELAMENTO to GSAN_OPER;
GRANT ALL PRIVILEGES ON GSAN_ADMIN.SQ_PRE_PARCELAMENTO to GSAN_OPER;
CREATE OR REPLACE PUBLIC SYNONYM SQ_PRE_PARCELAMENTO FOR GSAN_ADMIN.SQ_PRE_PARCELAMENTO;
CREATE OR REPLACE PUBLIC SYNONYM PRE_PARCELAMENTO FOR GSAN_ADMIN.PRE_PARCELAMENTO;

COMMIT;