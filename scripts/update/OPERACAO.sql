-- Anderson Italo
update OPERACAO set OPER_DSCAMINHOURL = 'filtrarSistemaAbastecimentoAction.do' where OPER_ID=977;
update OPERACAO set OPER_DSCAMINHOURL = 'atualizarSistemaAbastecimentoAction.do' where OPER_ID=978;
update OPERACAO set OPER_DSCAMINHOURL = 'removerSistemaAbastecimentoAction.do' where OPER_ID=979;
UPDATE OPERACAO SET OPER_DSCAMINHOURL = 'inserirSistemaAbastecimentoAction.do' WHERE OPER_ID=976;
UPDATE OPERACAO SET TBCO_IDARGUMENTO=45851 WHERE OPER_ID=976;
UPDATE OPERACAO SET FNCD_ID=767 WHERE OPER_ID=979;
UPDATE OPERACAO SET TBCO_IDARGUMENTO=45851 WHERE OPER_ID=978;
UPDATE OPERACAO SET TBCO_IDARGUMENTO=45851 WHERE OPER_ID=979;

-- BRUNO FERREIRA DOS SANTOS

UPDATE OPERACAO SET TBCO_IDARGUMENTO = 45908 WHERE OPER_ID IN (1491, 1493, 3572);

--

UPDATE OPERACAO SET TBCO_IDARGUMENTO = 45914 WHERE OPER_ID IN (2535);

--

UPDATE OPERACAO SET TBCO_IDARGUMENTO = 46000 WHERE OPER_ID IN (726,731,735,739,740,741);

--

UPDATE OPERACAO SET TBCO_IDARGUMENTO = 46048 WHERE OPER_ID IN (1509, 1511, 16524);

-- Anderson Italo
UPDATE OPERACAO SET TBCO_IDARGUMENTO=45951, TBCO_ID = 45951 WHERE OPER_ID=23773;

-- Isaac Silva
UPDATE "GSAN_ADMIN"."OPERACAO" SET TBCO_IDARGUMENTO = '45955' WHERE OPER_ID = 1495;
UPDATE "GSAN_ADMIN"."OPERACAO" SET TBCO_IDARGUMENTO = '45955' WHERE OPER_ID = 1497;
UPDATE "GSAN_ADMIN"."OPERACAO" SET TBCO_IDARGUMENTO = '45955' WHERE OPER_ID = 3057;

-- Isaac Silva
UPDATE OPERACAO SET TBCO_IDARGUMENTO=46107 WHERE OPER_ID=1480;

-- Isaac Silva
UPDATE OPERACAO SET TBCO_IDARGUMENTO=40973 WHERE OPER_ID=28;

-- Bruno Ferreira dos Santos
UPDATE OPERACAO SET TBCO_IDARGUMENTO = 46179 WHERE OPER_ID IN (315, 308);

-- Isaac Silva - SETOR COMERCIAL VENCIMENTO
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 40284 where OPER_ID in (43457, 43975, 44493);

-- Isaac Silva - CLIENTE
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 40284 where OPER_ID in (19, 20, 23);

-- Isaac Silva - Vencimento Alternativo
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 46154 where OPER_ID in (54, 55);

-- Isaac Silva - SUBSISTEMA ESGOTO
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 45995 where OPER_ID in (1483, 1485, 1519);

-- Isaac Silva - SISTEMA ESGOTO
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 46057 where OPER_ID in (824, 841, 835);

-- Isaac Silva - Bacia
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 45991 where OPER_ID in (1487, 1489, 16521);

-- Isaac Silva - Localidade
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 43181 where OPER_ID in (10, 11, 12);

-- Isaac Silva - HIDROMETRO
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 42555 where OPER_ID = 21;
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 42545 where OPER_ID in (244, 245);

-- Isaac Silva - Imovel
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 45486 where OPER_ID in (6, 235, 7);
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 46237 where OPER_ID in (54853);
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 45587 where OPER_ID in (56407);
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 45486 where OPER_ID in (57961);
update "GSAN_ADMIN"."OPERACAO" set TBCO_IDARGUMENTO = 45486 where OPER_ID in (17, 9, 292);

-- Isaac Silva - Cliente
UPDATE "GSAN_ADMIN"."OPERACAO" SET TBCO_IDARGUMENTO = 36228 WHERE OPER_ID = 188;
UPDATE "GSAN_ADMIN"."OPERACAO" SET TBCO_IDARGUMENTO = 36242 WHERE OPER_ID = 189;
UPDATE "GSAN_ADMIN"."OPERACAO" SET TBCO_IDARGUMENTO = 40969 WHERE OPER_ID = 38;
UPDATE "GSAN_ADMIN"."OPERACAO" SET TBCO_IDARGUMENTO = 36241 WHERE OPER_ID = 345;