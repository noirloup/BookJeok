-- TB_USER SAMPLE DATA
-- �α��� �ȵǴ� ���� ���̵�
INSERT INTO TB_USER VALUES ('SAMPLE01', 'SAMPNICK01', 'SAMPPWD01', 'SAMPNAME01', 'M', 24, '010-1234-5678', 'SAMPLE01@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE02', 'SAMPNICK02', 'SAMPPWD02', 'SAMPNAME02', 'M', 28, '010-1111-2222', 'SAMPLE02@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE03', 'SAMPNICK03', 'SAMPPWD03', 'SAMPNAME03', 'M', 31, '010-2222-3333', 'SAMPLE03@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE04', 'SAMPNICK04', 'SAMPPWD04', 'SAMPNAME04', 'M', 50, '010-3333-4444', 'SAMPLE04@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE05', 'SAMPNICK05', 'SAMPPWD05', 'SAMPNAME05', 'M', 26, '010-4444-5555', 'SAMPLE05@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE06', 'SAMPNICK06', 'SAMPPWD06', 'SAMPNAME06', 'M', 35, '010-5555-6666', 'SAMPLE06@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE07', 'SAMPNICK07', 'SAMPPWD07', 'SAMPNAME07', 'M', 31, '010-6666-7777', 'SAMPLE07@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE08', 'SAMPNICK08', 'SAMPPWD08', 'SAMPNAME08', 'M', 61, '010-7777-8888', 'SAMPLE08@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE09', 'SAMPNICK09', 'SAMPPWD09', 'SAMPNAME09', 'M', 53, '010-8888-9999', 'SAMPLE09@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE10', 'SAMPNICK10', 'SAMPPWD10', 'SAMPNAME10', 'M', 51, '010-9999-8888', 'SAMPLE10@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE11', 'SAMPNICK11', 'SAMPPWD11', 'SAMPNAME11', 'M', 52, '010-8888-7777', 'SAMPLE11@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE12', 'SAMPNICK12', 'SAMPPWD12', 'SAMPNAME12', 'M', 43, '010-7777-6666', 'SAMPLE12@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE13', 'SAMPNICK13', 'SAMPPWD13', 'SAMPNAME13', 'M', 49, '010-6666-5555', 'SAMPLE13@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE14', 'SAMPNICK14', 'SAMPPWD14', 'SAMPNAME14', 'M', 46, '010-5555-4444', 'SAMPLE14@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('SAMPLE15', 'SAMPNICK15', 'SAMPPWD15', 'SAMPNAME15', 'M', 18, '010-4444-3333', 'SAMPLE15@TEST.COM', NULL, NULL, NULL, DEFAULT, NULL, NULL, DEFAULT, DEFAULT);
-- �α��� ���� ���� ���̵�
INSERT INTO TB_USER VALUES ('user01',	'nick01', 'cGFzczAx', 'ȫ�浿', 'M', 31, '01012345678', 'user01@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '����/�濵,����/�ܱ���,����/���,��Ÿ �帣', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user02',	'nick02', 'cGFzczAy', '������', 'F', 26, '01022223333', 'user02@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '�Ҽ�,����/�濵,��Ÿ �帣', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user03',	'nick03', 'cGFzczAz', '������', 'M', 39, '01022223333', 'user03@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '����/�濵,����/ǳ��/��ȭ,�ǰ�/����,��Ÿ �帣', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user04',	'nick04', 'cGFzczAx', '������', 'M', 28, '01044444444', 'user04@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '�Ҽ�,�ڱ���,��/������,��Ÿ �帣', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user05',	'nick05', 'cGFzczAx', '�̵���', 'M', 28, '01055555555', 'user05@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '�Ҽ�,�ڱ���,��/������,��Ÿ �帣', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user06',	'nick06', 'cGFzczAx', '������', 'M', 28, '01066666666', 'user06@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '�Ҽ�,�ڱ���,��/������,��Ÿ �帣', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user07',	'nick07', 'cGFzczAx', '������', 'M', 28, '01077777777', 'user07@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '�Ҽ�,�ڱ���,��/������,��Ÿ �帣', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('admin01',	'������01', 'cGFzczAx', '������', 'M', 28, '01098765432', 'admin01@test.com', NULL, NULL, NULL, DEFAULT, '������ ���̵�.', '����/�濵,��Ÿ �帣', DEFAULT, 'Y');


-- TB_PRODUCT_TYPE SAMPLE DATA
INSERT INTO TB_PRODUCT_TYPE VALUES (1, '�����ۺ�');
INSERT INTO TB_PRODUCT_TYPE VALUES (2, '����å');
INSERT INTO TB_PRODUCT_TYPE VALUES (3, '�������');


-- TB_PRODUCT_LOC SAMPLE DATA
INSERT INTO TB_PRODUCT_LOC VALUES (1, '��������');
INSERT INTO TB_PRODUCT_LOC VALUES (2, '���ܵ���');


-- TB_CATEGORY SAMPLE DATA
INSERT INTO TB_CATEGORY VALUES (1, '�Ҽ�');
INSERT INTO TB_CATEGORY VALUES (2, '����/�濵');
INSERT INTO TB_CATEGORY VALUES (3, '�ڱ���');
INSERT INTO TB_CATEGORY VALUES (4, '��/������');
INSERT INTO TB_CATEGORY VALUES (5, '�ι�');
INSERT INTO TB_CATEGORY VALUES (6, '����/�ܱ���');
INSERT INTO TB_CATEGORY VALUES (7, '����/ǳ��/��ȭ');
INSERT INTO TB_CATEGORY VALUES (8, '��ȸ/��ġ/��');
INSERT INTO TB_CATEGORY VALUES (9, '�帣�Ҽ�');
INSERT INTO TB_CATEGORY VALUES (10, '�ڹͽ�');
INSERT INTO TB_CATEGORY VALUES (11, '�Ƶ�');
INSERT INTO TB_CATEGORY VALUES (12, '����');
INSERT INTO TB_CATEGORY VALUES (13, '����/���߹�ȭ');
INSERT INTO TB_CATEGORY VALUES (14, '����/���輭');
INSERT INTO TB_CATEGORY VALUES (15, 'û�ҳ�/����');
INSERT INTO TB_CATEGORY VALUES (16, '�ڿ�����/����');
INSERT INTO TB_CATEGORY VALUES (17, '����/����');
INSERT INTO TB_CATEGORY VALUES (18, '�ǰ�/����');
INSERT INTO TB_CATEGORY VALUES (19, '�ϸ��');
INSERT INTO TB_CATEGORY VALUES (20, '����/���');
INSERT INTO TB_CATEGORY VALUES (21, '�Ű���');
INSERT INTO TB_CATEGORY VALUES (22, '����/��Ȱ/�丮');
INSERT INTO TB_CATEGORY VALUES (23, '��ǻ�� ���ͳ�');


-- TB_BOOK SAMPLE DATA
-- �����ۺ�
-- ����
INSERT INTO TB_BOOK VALUES(01, 1, 1, 1, '�������ູ.png', '�������ູ', 123456789, 1, '�ڱ���� �˿� ���� ���� �󸶳� ���·ο,�е��� ���� �� �����ϰ� ������ ����', '������',  '����Ҽ� ���� �λ��� ������ ķ������ ��1ȸ ����û�ҳ⹮�л���, ���� ������ ���󡷷� ��5ȸ ���蹮�л��� �����ߴ�.', 14220, 
7, '���೪��', '2021-06-08', '1�� / �׳��� ������ 2�� / �׳�� �����ϱ� 3�� / ������ �ູ ���ʷα� 508');
INSERT INTO TB_BOOK VALUES(02, 2, 1, 1, '�������й��ڵ�.png', '�������й��ڵ�', 123456789, 2, '������ �й��ڵ鿡�� ���� �λ��� �濵�� ����', '����ȭ',  '������б����� �濵���� ����', 16200, 
6, '�帧����', '2021-08-01', '1�� �������� �������� �ı��� ���Ű�');
INSERT INTO TB_BOOK VALUES(03, 3, 1, 1, '�̶�Ŭ���.png', '�̶�Ŭ���', 123465789, 3, '2030����, ������ ��ħ�� �����ϴ�', '������',  '������б��� ����', 10800, 
5, '�Ѻ�����', '2016-02-22', 'CHAPTER00 �Ѵ��� �д� ������ 6�� CHAPTER01 ��ħ�� �Ҿ���� �����');
INSERT INTO TB_BOOK VALUES(04, 4, 1, 1, '�������Ǿ�ħ.png', '�������Ǿ�ħ', 123465789, 4, '�׷��� �ʾҴ� �͵��� �����س��� ��ħ�� ����', '��ҿ�',  '�ø� ���� ��� �ִ�. Ȯ�ſ� �� ����� �ӿ� ���� ������ ���� �ʱ� ���� ����ϰ� �ִ�.', 10800, 
8, '���а�������', '2013-11-13', '1�� ���� ���� �Ǻθ� ����մϴ�');
INSERT INTO TB_BOOK VALUES(05, 5, 1, 1, '�������ں�������.png', '�������ں�������', 123465789, 5, '������ �ӵ��� ���߸� ��� �� ���ſ����� �� ��μ� ���� ������ ã�� ������', '������',  '������б� ������а��� ����', 14500, 
6, '�ٻ��ʴ�', '2021-06-14', '1�� ��ö�� �������� ���� ��');
INSERT INTO TB_BOOK VALUES(06, 6, 1, 1, '���ʺ�����.png', '���ʺ�����', 123456788, 6, '�Ϸ� 30�� �н����� ���� ��𼭳�', 'EBS',  'EBS�� �������� ��ȹ�� â������ ���α׷� ����', 13500, 
4, '�ѱ�������۰���', '2021-07-05', 'Day 001 �����Ϲ��� ����-���� 1483ȸ');
INSERT INTO TB_BOOK VALUES(07, 7, 1, 1, '���츮���� �ٴ�.png', '���츮���� �ٴ�', 123456788, 7, '��67ȭ ������ Ư�� ������ �⿬��', '�赿��',  '���п��� �Ź�����а��� �����ϰ� �Ź��� ���ڷ� ���Ѵ�.', 18000, 
9, '��������', '2021-07-29', '�ε��� �� �ѱ�������');
INSERT INTO TB_BOOK VALUES(08, 8, 1, 1, '���������¾��̵�.png', '���������¾��̵�', 123456788, 8, '���� �̵鿡�Լ� ����� �����ϴ� ���� �����.', '����',  '�깮, Į��, ���ͺ� �� ���ȼ��� ����, �۾��� ������ �����Ѵ�.', 13500, 
7, 'â��', '2021-06-18', '���ѷα� �� Ÿ���� ���̸� ����϶�');
INSERT INTO TB_BOOK VALUES(09, 9, 1, 1, '�츮�����Ǽӵ��ΰ������ٸ�.png', '�츮�����Ǽӵ��ΰ������ٸ�', 123456788, 9, '�츮 SF�� ����� �躸', '���ʿ�',  '�Ҽ���. 1993���.', 12600, 
8, '���', '2019-06-24', '�����ڵ��� �� ���ƿ��� �ʴ°� ��007');
INSERT INTO TB_BOOK VALUES(10, 10, 1, 1, '���ݿ츮�б���.png', '���ݿ츮�б���', 123456788, 10, '�ͺ����� �����ϴ� ������ �п� ��Ϲ�����!', '�ֵ���',  '1983�� 8�� 23�ϻ�', 13500, 
10, '���е���', '2021-07-31', '�Բ��ϴ� ģ������ �پ���� ����������.');
INSERT INTO TB_BOOK VALUES(11, 11, 1, 1, '���λ��巡���.png', '���λ��巡���', 123456788, 11, '�Ƹ��ٿ� ������ �޲۴�!', '�ڼ���',  '1971�� ���� �������� �¾���ϴ�.', 11700, 
3, 'â��', '2021-07-23', '�����̵� �� ��ġ�� ���');
INSERT INTO TB_BOOK VALUES(12, 12, 1, 1, 'ģ��������.png', 'ģ��������', 123456788, 12, '�Ϻ����� ������ �մ� �����ϰ� ġ������ ������ ã�ƿԴ�!', '������',  '�ѱ��� �������� �����ΰ� �׸��� �����߽��ϴ�', 12600, 
9, '�����ִϾ�', '2021-06-13', '������ �� �� ���� ������� ����!');
INSERT INTO TB_BOOK VALUES(13, 13, 1, 1, '���ǼӼ�.png', '���ǼӼ�', 123465789, 13, '�ֻ��� ���� ���ȣ ȸ���� ���� ������ ���� ������ ö��', '���ȣ',  '���� ��� ���� �۷ι� �ܽ� �׷��� SNOWFOX GROUP �� ȸ���̴�', 13500, 
6, '���������', '2020-06-15', '���� �ΰ�ü�� ���� ������ �� �Ǹ��� �濵�ڿ��� �����Ѵ�');
INSERT INTO TB_BOOK VALUES(14, 14, 1, 1, '���ڱ���.png', '���ڱ���', 123465789, 14, '���ڱ����� ���ϵ��� ��ȣ�ۿ��� �ٷ�� ������� ������������ ��ȣ�ۿ��� �ٷ�� �ڱ������� �����ȴ�.', '�赿��',  '������б� �������п��� ���ڰ��� �л�', 34200, 
7, '�Ѻ���ī����', '2020-12-17', '1��. ��ǥ��� ���� ����');
INSERT INTO TB_BOOK VALUES(15, 15, 1, 1, '���̰��������.png', '���̰��������', 123465789, 15, '�� ����� �ܷӰ� �Ҿ��� ������ �����ϰ� ��縸�� �ִ� ��ǰ', '�̲���',  '���Ṯ���� ��ȭ �޵λ��� �Ŀ��� ���', 11250, 
6, '�츮�б�', '2021-06-07', '������ ���ǰ� �μ��� ������ ���� �̾߱�');
INSERT INTO TB_BOOK VALUES(16, 16, 1, 1, '�̼��������غ�����.png', '�̼��������غ�����', 123465789, 16, '��ȭ�� ��� �غ��� �ڵ带 �ؼ��ϴ�!', '����ȣ', '�غ����� ������ ���� ������ �� �ֵ��� ����ϰ� �ִ�. ', 18000, 
7, '��ٿ����', '2021-07-05', '01. ���̶����ΰ� �׸� �ӿ� ���ܳ��� �� �غε��� ã�Ƽ�');
INSERT INTO TB_BOOK VALUES(17, 17, 1, 1, '����.png', '����', 123465789, 17, '�׸��������̶�� ������ ������ �ð��� �޴´�', '����ȯ', '�״� �̸��� �ҷ��ִ� ����̴� ', 13500, 
9, '����', '2021-07-19', '01. ��');
INSERT INTO TB_BOOK VALUES(18, 18, 1, 1, '���.png', '���', 123465789, 18, '100�� �λ��� �ǰ��ϰ� ������ ��� ���� �̵鿡�� �� ����� ���������� ����', '������', '����� �Ǵ� ��Ȱ���а� ������ ����', 17550, 
5, '��Ƽ��', '2019-11-11', '1�� �,�ְ��� ��� �׸��� ������');
INSERT INTO TB_BOOK VALUES(19, 19, 1, 1, '�޲ٴ¾����ǹ̶�Ŭ���.png', '�޲ٴ¾����ǹ̶�Ŭ���', 123465789, 19, '������ �Ϸ縦 �ٲٴ� ��ħ', '�迬��',  'CBS ����', 12600, 
9, '���������', '2021-05-31', '������ ��ǥ�� ������ �����');
INSERT INTO TB_BOOK VALUES(20, 20, 1, 1, '����������.png', '����������', 123465789, 20, '���� �� �������� �켱 �۰�����, �״������δ� ���� �����ڿ���.', '�迵��', '�������б� �濵�� �л�� ���縦 ���', 12150, 
7, '���е���', '2019-04-17', '��ó�� ���� ����� ���ǵ�κ��� �޾Ƴ���');
INSERT INTO TB_BOOK VALUES(21, 21, 1, 1, '��Ȩ.png', '��Ȩ', 123465789, 21, '���� ����� ���� �̾߱⸦ �ٷ� å', 'JOH���۴�', '���� ���� �귣�带 �� ȣ�� �ϳ��� �Ұ��ϴ� �귣�� ��ť���͸� �Ű���', 19000, 
7, 'JOH', '2020-09-25', '1. HOME OFFICE');
INSERT INTO TB_BOOK VALUES(22, 22, 1, 1, '����Ѹ�������.png', '����Ѹ�������', 123465789, 22, '���� �츮�� ������, ����Ѹ��� ��Ź', '������', '������ ���𰡸� ����� ���� �����ؼ� �丮�� �����ߴ�', 21600, 
8, '���̽�Ʈ�Ͻ�', '2020-06-30', '1. 71���� �޴�');
INSERT INTO TB_BOOK VALUES(23, 23, 1, 1, '�츮���̿����ذ��ִ�.png', '�츮���̿����ذ��ִ�', 123456788, 23, '��� �ȿ� ������ �������������ڴ� ���� �ٷ� �˰ڽ��ϴ�.', '������',  '1992�� ���￡�� �¾��. ���ϰ� �̽��ơ��� �����ϰ� ������ǻ縦 ��Ѵ�.', 13500, 
4, '���е���', '2021-07-10', '���ѷα� ������ ¡�׷��� ������ �����Բ�');

--����
INSERT INTO TB_BOOK VALUES(24, 1, 1, 2, '�󱼾��»�����.png', '�󱼾��»�����', 123456799, 24, '���ΰ��� �� ������ �γ� �ο��� ���۵ȴ�!', '������ ����',  '�������� ���� �α� �ְ� �߳����� ���� ������ �о� �۰�', 15120, 
9, '���ø��', '2021-06-30', '���� û�ҳ�� ����');
INSERT INTO TB_BOOK VALUES(25, 2, 1, 2, '�����ǽ�.png', '�����ǽ�', 123456799, 25, '�̱� ����縦 �����ϸ� �������� ����� ������ ����', '�ص�� ų��Ʈ��',  '1965�� ������ �ص� �� ���б��� ����', 25200, 
8, '����', '2021-08-30', '1�� ���� �����̶�� �ι�');
INSERT INTO TB_BOOK VALUES(26, 3, 1, 2, '��Ŀ��츣��.png', '��Ŀ��츣��', 123456799, 26, '����� �������� ���� ����õ���� DNA', '�ι�Ʈ ��罺',  '���ϴ��б����� ���� �ൿ���� �ڻ������� �޾Ұ�, �濵 ������Ʈ�� Ȱ��', 14850, 
6, '�˿�ġ�ڸ���', '2021-08-01', '1�� ����');
INSERT INTO TB_BOOK VALUES(27, 4, 1, 2, '�����̾߱⸦����ϰڽ��ϴ�.png', '�����̾߱⸦����ϰڽ��ϴ�', 123456799, 27, '����� ����� �ձ� ���� ������ ����ī�� ������ ������ ���', '������ ����ī��',  '��ȭ����. 1962�� ���쿡�� �¾��. ', 14400, 
7, '�ٴ����ǻ�', '2021-07-23', '������ �ʴ� �Ϳ� ���Ͽ� 13');
INSERT INTO TB_BOOK VALUES(28, 5, 1, 2, 'è�ǿ¸��ε�.png', 'è�ǿ¸��ε�', 123456799, 28, '�ڽŰ��� �ο򿡼� ������ �̱�� ��Ż Ʈ���̴�', 'Jim Afremow',  'Jim Afremow �̱��� ������ �ɸ����ڷ�, ������ ��Ż ��Ī ����� ��ϰ� �ִ�.', 16000, 
5, '������', '2020-07-05', '���ѷα�: �ٸ� ����� �������� �˾ƺ� �� �ִٸ�, ��ſ��Ե� ���� �� �������� ���� �ִ�');
INSERT INTO TB_BOOK VALUES(29, 6, 1, 2, 'Midnight.png', 'Midnight', 123456799, 29, '���� �̾߱⸦ Ǯ��� ����', 'Hai Matt',  '�̱��� �Ҽ����� ���л� ����.', 15500, 
6, '�λ굵��', '2020-02-28', '�� 12��, �ױ� �ٷ� ������ ������ ������ ����������');
INSERT INTO TB_BOOK VALUES(30, 7, 1, 2, 'Wonder.png', 'Wonder', 123456799, 30, '�̱����� �Ⱓ�� �� ���ݱ��� 22�� �������� �̱� ��ǥ�� �ϰ���', 'RJ Palacio',  '������ �Ҽ����� ���ι��л� ����.', 14000, 
7, ' Cannongate', '2014-06-01', '���� ��� ���� ���������� �ʾƿ�!');
INSERT INTO TB_BOOK VALUES(31, 8, 1, 2, 'ReBoot.png', 'ReBoot', 123456799, 31, '�ڷγ� ����� �Ѻ��ǿ���������Ʈ ��ǳ���� �ҷ�����Ų ȭ���� å', 'Kim MK',  '�̱��� �Ҽ����� �뺧���л� ����..', 16500, 
8, 'Lioncrest Publishing ', '2021-06-28', '��ȭ�� �帧�� ��վ� �� 130�� ��Ʃ�� ��̰��� �ڷγ� ���� ������');
INSERT INTO TB_BOOK VALUES(32, 9, 1, 2, 'ƿ.png', 'ƿ', 123456799, 32, '���� ����Ʈ���� ������ ����', '�ٴϿ� �̸�',  '975�� ���� ���� ���', 15200, 
6, '�ٻ�å��', '2021-07-09', '������ ����');
INSERT INTO TB_BOOK VALUES(33, 10, 1, 2, 'Ÿ�뽺����¡.png', 'Ÿ�뽺����¡', 123456799, 33, '���� ���Ϲ��� ��� �ְ�, �־��� ���� ���� Ÿ�뽺�� ź�� ��ȭ', '���̽� �Ʒ�',  '�̱� �˶�ٸ� ����� �۰�.', 9000, 
9, '�ð���', '2015-04-25', '�ٸ� ����ü�� ����ϰ� ������ ȣ��ɸ��� �����ϴ� ��');
INSERT INTO TB_BOOK VALUES(34, 11, 1, 2, '�׷��Ա׷���.png', '�׷��Ա׷���', 123456799, 34, '2017�� ���γ� ��ġ�� Ư���� ���� �۰� ���Ÿ�� �Ž��� ����!', '���Ÿ�� �Ž���',  '�׸�å �۰����� �Ϸ���Ʈ�����ʹ�.', 10620, 
7, '�ִϾ�迵��', '2021-07-08', '�׷��� ����;� �ȴ��̴���');
INSERT INTO TB_BOOK VALUES(35, 12, 1, 2, '�ϵ��Ǳ׸��б�.png', '�ϵ��Ǳ׸��б�', 123456799, 35, '�ϵθ� �ƽó���? �ϵ��� �׸� �б��� � ������!', '�ٺ�� Į��', '1972�⿡ ���������� �¾ ��Ż���ƿ��� ��� �ֽ��ϴ�.', 10800, 
6, '��������', '2021-07-20', '�������� ������!');
INSERT INTO TB_BOOK VALUES(36, 13, 1, 2, '�����Ǹ�����.png', '�����Ǹ�����', 123456799, 36, '�ô븦 �ٲ� �������� �Ǿ�� ����', '������õ ����',  '�̼� ���򰡷� Ȱ�� ��', 10800, 
9, '�ޱۺϽ�', '2021-06-21', '01. ���׿� �尡 - ������ �ʻ�ȭ');
INSERT INTO TB_BOOK VALUES(37, 14, 1, 2, '�����ȸ��.png', '�����ȸ��', 123456799, 37, '30�� �Ⱓ �ô� ��Ȳ�� ��ȭ�� �й��� ���忡 ���� ���ο� ������ ������ �Ұ�', '�ؼ��� ��罺', '�����ȸ�а��� ������ �������� ������ ��ǥ�� ��ȸ����', 11800, 
5, '������ȭ��', '2018-02-20', '1. ��ȸ���̶� �����ΰ�');
INSERT INTO TB_BOOK VALUES(38, 15, 1, 2, '���ݸ�.png', '���ݸ�', 123456799, 38, '���� ������ ������ ǥ������ ���尨 �ְ� ǥ���� �Ҽ�', '���� ��ν�', '970�⿡ �ĵ�Į�� ������ ���޷ο��� �¾ �ٴ尡���� ����', 13200, 
8, '�ӽ�Ʈ��', '2021-06-30', '���ݺ��� �ϰ� �� �̾߱��');
INSERT INTO TB_BOOK VALUES(39, 16, 1, 2, '�Ĺ��Ǽ���.png', '�Ĺ��Ǽ���', 123456799, 39, '�ΰ��� � ���� ū ������ �� �Ĺ� 80���� �̾߱�', '���ʼ� ��θ�', '���� ���� ������Ʈ�� ���Ӻ긮�� ���� ���� �̻�', 18000, 
4, '�ð���', '2021-06-16', '�������Ǯ Urtica dioica, ����');
INSERT INTO TB_BOOK VALUES(40, 17, 1, 2, '�ϻ��Ǽ�ȭ.png', '�ϻ��Ǽ�ȭ', 123456799, 40, '��ȭ�� Ʋ�� ���� ������ �ƴϴ�', '���̺�� ������', '�Ϲ��� ���б����� �ɸ���(B.A.), ����Ʈ�ν��� ���б����� ����(M.Div.)�� ����', 10350, 
6, '�������', '2021-05-31', '1��. �ϳ����� ����� ���� �츮�� �����Ŵ�');
INSERT INTO TB_BOOK VALUES(41, 18, 1, 2, 'ŵ����.png', 'ŵ����', 123456799, 41, '������ �ٲٸ� ���� ���� �ʴ´�!', '������ ��Ÿ', '���� �ڻ����� ���̻� ���� ������ CNN ���� ���� ����', 15300, 
8, '�ϵ��', '2021-06-22', 'Part 1. �� : �� �Ӹ����� ���ڽ�');
INSERT INTO TB_BOOK VALUES(42, 19, 1, 2, '������.png', '������', 123456799, 42, '����� �λ��� ������ �϶�!', 'Ŭ��������', '��Ʃ�� ä�� ��Ŭ�������̡� �,', 13500, 
7, '���̶̹�Ŭ���', '2021-07-07', '�����Ϳ��� ���� 16');
INSERT INTO TB_BOOK VALUES(43, 20, 1, 2, '�����ѳ��ǿ����Ľ���.png', '�����ѳ��ǿ����Ľ���', 123456799, 43, '��Ʃ�� ������ �������� ���Ͽ�� �ϼ�', '����', '��Ʃ�� ä�� Ŭ������ �,', 14400, 
6, '������Ͽ콺', '2021-06-30', '�����Ľ��ڷ� �׸� �׸��� �� �˾Ƶ� ��');
INSERT INTO TB_BOOK VALUES(44, 21, 1, 2, '���ǽ��Ű���.png', '���ǽ��Ű���', 123456799, 44, '��ȭ ���ǽ� �Ű��� 10ȣ', '���� ������ġ��', '�α⸸ȭ �����ǽ����� �۰�', 11700, 
9, '���', '2021-03-26', '����');
INSERT INTO TB_BOOK VALUES(45, 22, 1, 2, '�������ǿ��񵿿丮����.png', '�������ǿ��񵿿丮����', 123456799, 45, '�װ��� �����ϰ� �߰ſ� �丮������ �ִ�.', '��ī���� ������', '�Ϻ����� �¾ ����ġ �丮�� �ƹ��� �ؿ��� �ڶ� �׳�', 18000, 
8, '�̺�', '2021-08-04', '���ѷα� 13���� �ð��� ��� ������ ������ ����');
INSERT INTO TB_BOOK VALUES(46, 23, 1, 2, '�õ帶�̾�.png', '�õ帶�̾�', 123456799, 46, '�� ���� �츮�� ���� �� �ᴫ���� ���� ������� �ߴ����� ���ӡ��� ��� ź��������?', '�õ� ���̾�', '�̱��� ���� �����̳�', 17820, 
9, '��������', '2021-06-25', '10�� �ð�: ����');

--����å
--����
INSERT INTO TB_BOOK VALUES(47, 11, 2, 1, '���ǿ����ڵ�.png', '���ǿ����ڵ�', 123356789, 1, '�糭�� ����� �Ѻ��ǿ��� ���̴� ������ ����', '������',  '���� �������� 1980�� ���￡�� �¾ 2004�� �����й��л��� ������ ����ߴ�.', 13000, 
8, '������', '2013-10-11', '1 ���� 7 2 �縷�� ��ũȦ 37');
INSERT INTO TB_BOOK VALUES(48, 14, 2, 1, '�����ǽð�.png', '�����ǽð�', 123546789, 2, '������ ������ �������� ��´�.', '����',  '1965�� �λ꿡�� �¾ ������б� ���������� �����ߴ�.', 17000, 
7, '�ѱ��', '2021-05-31', '��1�� �÷��� ���ù�� ��2�� ���� �ѷ��� ��Ȥ��');
INSERT INTO TB_BOOK VALUES(49, 20, 2, 1, '�ϴ�ȣ���ζ�������.png', '�ϴ�ȣ���ζ�������', 123465789, 3, 'ȣ�������� �̾����� ����', '����ȯ',  '2017�� ���л� �����ϸ� ��ǰȰ���� �����ߴ�', 11500, 
6, '��ȭ��', '2021-05-27', '1 �÷��� �� 2 ����');
INSERT INTO TB_BOOK VALUES(50, 23, 2, 1, '���θӸ��¹��ط��̴�.png', '���θӸ��¹��ط��̴�', 123465789, 4, '���� ���ϴ� ���̵��� �ٽ� �ɷ�, ���ط��� Ű����', '������',  '������б� ���л�����', 13500, 
5, '����ü', '2021-07-01', '1�� �ʵ� ���θӸ��� �⸣�� ���ط�');
--����
INSERT INTO TB_BOOK VALUES(51, 1, 2, 2, '������.png', '������', 123465789, 5, '�� ���� �ð��� ���ξ����� �̾����� ����� ���� ���', 'Choi Eun',  '���� �������忡�� ���λ��� �����ϸ� ��ǰȰ���� �����ߴ�.', 14500, 
4, '���е���', '2021-07-27', '1�� _007 2�� _083');
INSERT INTO TB_BOOK VALUES(52, 11, 2, 2, '�׸����θ���ȭ.png', '�׸����θ���ȭ', 123546789, 6, '��ȭ�� �д� �ʵ� �ι���', 'Jain Lynn',  ' ������ �����ϸ� ��ǰȰ���� �����ߴ�', 22000, 
3, '�ƿ��', '2019-09-05', '1 �ŵ��� ������');
INSERT INTO TB_BOOK VALUES(53, 16, 2, 2, '���̳���.png', '���̳���', 123465789, 7, '�ո��� ������ �ƴ� ����� ������ ���� ��ȭ�ϴ� �ڿ��� ��Ģ', '�ٴϿ� ���̱�',  'ö�������� ��������, ��ȭ��������. �ĸ���ȸ���а��������� ������ ����', 13000, 
2, '�ٻ���̾�', '2021-06-27', '��1��  ��ȭ�� ������');
INSERT INTO TB_BOOK VALUES(54, 22, 2, 2, 'Ŀ�ǽ��͵�.png', 'Ŀ�ǽ��͵�', 123465789, 8, 'Ŀ�� �ڻ� ȣ����ġ �������� ���� ����', 'ȣ����ġ',  '���п��� �������������ҿ��� �濵�а� ������������ ����', 12500, 
1, 'Ȳ���ڸ�', '2021-07-07', 'Lesson 1 ������ ǰ���� ���ִ� ��̸� ����ٴ� �Ϳ� ����');

--�������
--����
INSERT INTO TB_BOOK VALUES(55, 1, 3, 1, 'Ÿ������.png', 'Ÿ������', 123356789, 1, 'ª�� ����ϰ� �����ϴ�!', '�տ���',  '�����б����� ��ȸ�а� ö���� ����', 11000, 
8, 'â��', '2020-06-11', '4���� �� ������');
INSERT INTO TB_BOOK VALUES(56, 8, 3, 1, '�����Ѱ���.png', '�����Ѱ���', 123546789, 2, '���� ��ġ�� ���� ���ؼ��� �̷�����', '���ؼ�',  '2003�� ������а���б� ����', 16500, 
7, '�������ڸ�', '2019-06-28', '�߰ſ� ����, ����');
INSERT INTO TB_BOOK VALUES(57, 13, 3, 1, '�����ѹ�ȭ����.png', '�����ѹ�ȭ����', 123465789, 3, '��̰� �����ϰ� �����ϴ� ��', '�����',  '��ȭ���� �̵�ŸƮ��', 13500, 
6, '���Ϻ�', '2021-07-14', '��ȭ�� ��� : ���̴� ���� ���ΰ� �ƴ� ����');
INSERT INTO TB_BOOK VALUES(58, 17, 3, 1, '�׻�����ϱ�����.png', '�׻�����ϱ�����', 123465789, 4, '������ ����� SNS ������', '������',  '�Ƶ鸸 ���� ��ȸ�� ������ ������ �¾ ��ȸ����', 12500, 
5, '����', '2021-07-05', '��ȸ���� ��� ����');
--����
INSERT INTO TB_BOOK VALUES(59, 10, 3, 2, 'Batman.png', 'Batman', 123546789, 6, '��ũ������� ź��', 'Jim Lee',  '2003�� �̱��Ϲ��� ����', 18500, 
2, '���е���', '2018-06-05', '1 ����');
INSERT INTO TB_BOOK VALUES(60, 18, 3, 2, '�ְ��ǽĹ���.png', '�ְ��ǽĹ���', 123465789, 7, '�Ĵ� ���� ���� �����ϰ� �ǰ����� �� �ִ� ������ ���', 'Will Bers',  ' �ǻ� ���㸦 ������ ��ȭ�⳻�� ������', 13500, 
3, 'û��������', '2021-07-14', '1�� �ǰ��� ��������');
INSERT INTO TB_BOOK VALUES(61, 23, 3, 2, '�����͸�.png', '�����͸�', 123465789, 8, '�����ڰ� ������ ���α׷� ��ġ', 'Martin Pauler',  '���� ������. ������������ ����Ʈ���� ����', 17500, 
4, '�Ѻ��̵��', '2020-04-01', 'CHAPTER 01 �����͸�');
INSERT INTO TB_BOOK VALUES(62, 4, 3, 2, 'Odyssey.png', 'Odyssey', 123356789, 5, '��� �뼭���', 'Homer Wilson',  '�̱��� ����', 13000, 
1, '�λ�', '2018-11-11', '1 The World of The Odyssey 94');


-- TB_OTHER_SITE SAMPLE DATA
INSERT INTO TB_OTHER_SITE VALUES(01, 01, '��������', 14220);
INSERT INTO TB_OTHER_SITE VALUES(02, 01, 'YES24', 14220);
INSERT INTO TB_OTHER_SITE VALUES(03, 01, '�˶��', 14220);
INSERT INTO TB_OTHER_SITE VALUES(04, 01, '��ǰ����', 14220);
INSERT INTO TB_OTHER_SITE VALUES(05, 01, '������ũ', 14220);

INSERT INTO TB_OTHER_SITE VALUES(06, 02, '��������', 14500);
INSERT INTO TB_OTHER_SITE VALUES(07, 02, 'YES24', 14500);
INSERT INTO TB_OTHER_SITE VALUES(08, 02, '�˶��', 14500);
INSERT INTO TB_OTHER_SITE VALUES(09, 02, '��ǰ����', 14500);
INSERT INTO TB_OTHER_SITE VALUES(10, 02, '������ũ', 14500);

INSERT INTO TB_OTHER_SITE VALUES(11, 03, '��������', 10800);
INSERT INTO TB_OTHER_SITE VALUES(12, 03, 'YES24', 10800);
INSERT INTO TB_OTHER_SITE VALUES(13, 03, '�˶��', 10800);
INSERT INTO TB_OTHER_SITE VALUES(14, 03, '��ǰ����', 10800);
INSERT INTO TB_OTHER_SITE VALUES(15, 03, '������ũ', 10800);

INSERT INTO TB_OTHER_SITE VALUES(26, 06, '��������', 14500);
INSERT INTO TB_OTHER_SITE VALUES(27, 06, 'YES24', 14500);
INSERT INTO TB_OTHER_SITE VALUES(28, 06, '�˶��', 14500);
INSERT INTO TB_OTHER_SITE VALUES(29, 06, '��ǰ����', 14500);
INSERT INTO TB_OTHER_SITE VALUES(30, 06, '������ũ', 14500);

INSERT INTO TB_OTHER_SITE VALUES(31, 07, '��������', 14500);
INSERT INTO TB_OTHER_SITE VALUES(32, 07, 'YES24', 14500);
INSERT INTO TB_OTHER_SITE VALUES(33, 07, '�˶��', 14500);
INSERT INTO TB_OTHER_SITE VALUES(34, 07, '��ǰ����', 14500);
INSERT INTO TB_OTHER_SITE VALUES(35, 07, '������ũ', 14500);

INSERT INTO TB_OTHER_SITE VALUES(36, 08, '��������', 13500);
INSERT INTO TB_OTHER_SITE VALUES(37, 08, 'YES24', 13500);
INSERT INTO TB_OTHER_SITE VALUES(38, 08, '�˶��', 13200);
INSERT INTO TB_OTHER_SITE VALUES(39, 08, '��ǰ����', 13500);
INSERT INTO TB_OTHER_SITE VALUES(40, 08, '������ũ', 13500);

INSERT INTO TB_OTHER_SITE VALUES(41, 09, '��������', 13000);
INSERT INTO TB_OTHER_SITE VALUES(42, 09, 'YES24', 13000);
INSERT INTO TB_OTHER_SITE VALUES(43, 09, '�˶��', 13000);
INSERT INTO TB_OTHER_SITE VALUES(44, 09, '��ǰ����', 13300);
INSERT INTO TB_OTHER_SITE VALUES(45, 09, '������ũ', 13000);

INSERT INTO TB_OTHER_SITE VALUES(46, 10, '��������', 12800);
INSERT INTO TB_OTHER_SITE VALUES(47, 10, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(48, 10, '�˶��', 12800);
INSERT INTO TB_OTHER_SITE VALUES(49, 10, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(50, 10, '������ũ', 12800);

INSERT INTO TB_OTHER_SITE VALUES(51, 11, '��������', 12900);
INSERT INTO TB_OTHER_SITE VALUES(52, 11, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(53, 11, '�˶��', 12900);
INSERT INTO TB_OTHER_SITE VALUES(54, 11, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(55, 11, '������ũ', 12800);

INSERT INTO TB_OTHER_SITE VALUES(56, 12, '��������', 13900);
INSERT INTO TB_OTHER_SITE VALUES(57, 12, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(58, 12, '�˶��', 13900);
INSERT INTO TB_OTHER_SITE VALUES(59, 12, '��ǰ����', 13800);
INSERT INTO TB_OTHER_SITE VALUES(60, 12, '������ũ', 13600);

INSERT INTO TB_OTHER_SITE VALUES(61, 13, '��������', 12600);
INSERT INTO TB_OTHER_SITE VALUES(62, 13, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(63, 13, '�˶��', 12900);
INSERT INTO TB_OTHER_SITE VALUES(64, 13, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(65, 13, '������ũ', 12600);

INSERT INTO TB_OTHER_SITE VALUES(66, 14, '��������', 12600);
INSERT INTO TB_OTHER_SITE VALUES(67, 14, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(68, 14, '�˶��', 12900);
INSERT INTO TB_OTHER_SITE VALUES(69, 14, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(70, 14, '������ũ', 12600);

INSERT INTO TB_OTHER_SITE VALUES(71, 15, '��������', 12600);
INSERT INTO TB_OTHER_SITE VALUES(72, 15, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(73, 15, '�˶��', 12900);
INSERT INTO TB_OTHER_SITE VALUES(74, 15, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(75, 15, '������ũ', 12600);

INSERT INTO TB_OTHER_SITE VALUES(76, 48, '��������', 12600);
INSERT INTO TB_OTHER_SITE VALUES(77, 48, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(78, 48, '�˶��', 12900);
INSERT INTO TB_OTHER_SITE VALUES(79, 48, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(80, 48, '������ũ', 12600);

INSERT INTO TB_OTHER_SITE VALUES(81, 49, '��������', 13900);
INSERT INTO TB_OTHER_SITE VALUES(82, 49, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(83, 49, '�˶��', 13900);
INSERT INTO TB_OTHER_SITE VALUES(84, 49, '��ǰ����', 13800);
INSERT INTO TB_OTHER_SITE VALUES(85, 49, '������ũ', 13600);

INSERT INTO TB_OTHER_SITE VALUES(86, 50, '��������', 13900);
INSERT INTO TB_OTHER_SITE VALUES(87, 50, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(88, 50, '�˶��', 13900);
INSERT INTO TB_OTHER_SITE VALUES(89, 50, '��ǰ����', 13800);
INSERT INTO TB_OTHER_SITE VALUES(90, 50, '������ũ', 13600);

INSERT INTO TB_OTHER_SITE VALUES(91, 51, '��������', 12900);
INSERT INTO TB_OTHER_SITE VALUES(92, 51, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(93, 51, '�˶��', 12900);
INSERT INTO TB_OTHER_SITE VALUES(94, 51, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(95, 51, '������ũ', 12800);

INSERT INTO TB_OTHER_SITE VALUES(96, 52, '��������', 12600);
INSERT INTO TB_OTHER_SITE VALUES(97, 52, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(98, 52, '�˶��', 12900);
INSERT INTO TB_OTHER_SITE VALUES(99, 52, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(100, 52, '������ũ', 12600);

INSERT INTO TB_OTHER_SITE VALUES(101, 53, '��������', 13900);
INSERT INTO TB_OTHER_SITE VALUES(102, 53, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(103, 53, '�˶��', 13900);
INSERT INTO TB_OTHER_SITE VALUES(104, 53, '��ǰ����', 13800);
INSERT INTO TB_OTHER_SITE VALUES(105, 53, '������ũ', 13600);

INSERT INTO TB_OTHER_SITE VALUES(106, 54, '��������', 13900);
INSERT INTO TB_OTHER_SITE VALUES(107, 54, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(108, 54, '�˶��', 13900);
INSERT INTO TB_OTHER_SITE VALUES(109, 54, '��ǰ����', 13800);
INSERT INTO TB_OTHER_SITE VALUES(110, 54, '������ũ', 13600);

INSERT INTO TB_OTHER_SITE VALUES(111, 55, '��������', 12900);
INSERT INTO TB_OTHER_SITE VALUES(112, 55, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(113, 55, '�˶��', 12900);
INSERT INTO TB_OTHER_SITE VALUES(114, 55, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(115, 55, '������ũ', 12800);

INSERT INTO TB_OTHER_SITE VALUES(116, 56, '��������', 13500);
INSERT INTO TB_OTHER_SITE VALUES(117, 56, 'YES24', 13500);
INSERT INTO TB_OTHER_SITE VALUES(118, 56, '�˶��', 13200);
INSERT INTO TB_OTHER_SITE VALUES(119, 56, '��ǰ����', 13500);
INSERT INTO TB_OTHER_SITE VALUES(120, 56, '������ũ', 13500);

INSERT INTO TB_OTHER_SITE VALUES(121, 57, '��������', 13000);
INSERT INTO TB_OTHER_SITE VALUES(122, 57, 'YES24', 13000);
INSERT INTO TB_OTHER_SITE VALUES(123, 57, '�˶��', 13000);
INSERT INTO TB_OTHER_SITE VALUES(124, 57, '��ǰ����', 13300);
INSERT INTO TB_OTHER_SITE VALUES(125, 57, '������ũ', 13000);

INSERT INTO TB_OTHER_SITE VALUES(126, 58, '��������', 12800);
INSERT INTO TB_OTHER_SITE VALUES(127, 58, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(128, 58, '�˶��', 12800);
INSERT INTO TB_OTHER_SITE VALUES(129, 58, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(130, 58, '������ũ', 12800);

INSERT INTO TB_OTHER_SITE VALUES(131, 59, '��������', 12900);
INSERT INTO TB_OTHER_SITE VALUES(132, 59, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(133, 59, '�˶��', 12900);
INSERT INTO TB_OTHER_SITE VALUES(134, 59, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(135, 59, '������ũ', 12800);

INSERT INTO TB_OTHER_SITE VALUES(136, 60, '��������', 13900);
INSERT INTO TB_OTHER_SITE VALUES(137, 60, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(138, 60, '�˶��', 13900);
INSERT INTO TB_OTHER_SITE VALUES(139, 60, '��ǰ����', 13800);
INSERT INTO TB_OTHER_SITE VALUES(140, 60, '������ũ', 13600);

INSERT INTO TB_OTHER_SITE VALUES(141, 61, '��������', 12600);
INSERT INTO TB_OTHER_SITE VALUES(142, 61, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(143, 61, '�˶��', 12900);
INSERT INTO TB_OTHER_SITE VALUES(144, 61, '��ǰ����', 12800);
INSERT INTO TB_OTHER_SITE VALUES(145, 61, '������ũ', 12600);


-- TB_REVIEW SAMPLE DATA
INSERT INTO TB_REVIEW VALUES(1, 'user01', 01, '��������1', sysdate, sysdate, null, null, '���䳻��1.', 10, '����');
INSERT INTO TB_REVIEW VALUES(2, 'user02', 02, '��������2', sysdate, sysdate, null, null, '���䳻��2', 5, 'Ű����');
INSERT INTO TB_REVIEW VALUES(3, 'user03', 03, '��������3', sysdate, sysdate, null, null, '���䳻��3', 4, 'Ű����');
INSERT INTO TB_REVIEW VALUES(4, 'user04', 04, '��������4', sysdate, sysdate, null, null, '���䳻��4', 2, 'Ű����');
INSERT INTO TB_REVIEW VALUES(5, 'user02', 05, '��������5', sysdate, sysdate, null, null, '���䳻��5', 3, 'Ű����');
INSERT INTO TB_REVIEW VALUES(6, 'user01', 06, '��������6', sysdate, sysdate, null, null, '���䳻��6', 7, 'Ű����');
INSERT INTO TB_REVIEW VALUES(7, 'user04', 07, '��������7', sysdate, sysdate, null, null, '���䳻��7', 8, 'Ű����');
INSERT INTO TB_REVIEW VALUES(8, 'user02', 08, '��������8', sysdate, sysdate, null, null, '���䳻��8', 5, 'Ű����');
INSERT INTO TB_REVIEW VALUES(9, 'user01', 09, '��������9', sysdate, sysdate, null, null, '���䳻��9', 4, 'Ű����');
INSERT INTO TB_REVIEW VALUES(10, 'user04', 10, '��������10', sysdate, sysdate, null, null, '���䳻��10', 6, 'Ű����');
INSERT INTO TB_REVIEW VALUES(11, 'user03', 11, '��������11', sysdate, sysdate, null, null, '���䳻��11', 3, 'Ű����');
INSERT INTO TB_REVIEW VALUES(12, 'user02', 12, '��������12', sysdate, sysdate, null, null, '���䳻��12', 9, 'Ű����');

INSERT INTO TB_REVIEW VALUES(13, 'user01', 12, '��������13', sysdate, sysdate, null, null, '���䳻��13.', 10, '����');
INSERT INTO TB_REVIEW VALUES(14, 'user02', 47, '��������14', sysdate, sysdate, null, null, '���䳻��14', 5, 'Ű����');
INSERT INTO TB_REVIEW VALUES(15, 'user03', 48, '��������15', sysdate, sysdate, null, null, '���䳻��15', 4, 'Ű����');
INSERT INTO TB_REVIEW VALUES(16, 'user04', 49, '��������16', sysdate, sysdate, null, null, '���䳻��16', 2, 'Ű����');
INSERT INTO TB_REVIEW VALUES(17, 'user04', 51, '��������17', sysdate, sysdate, null, null, '���䳻��17', 3, 'Ű����');
INSERT INTO TB_REVIEW VALUES(18, 'user03', 50, '��������18', sysdate, sysdate, null, null, '���䳻��18', 7, 'Ű����');
INSERT INTO TB_REVIEW VALUES(19, 'user02', 52, '��������19', sysdate, sysdate, null, null, '���䳻��19', 8, 'Ű����');
INSERT INTO TB_REVIEW VALUES(20, 'user01', 53, '��������20', sysdate, sysdate, null, null, '���䳻��20', 5, 'Ű����');
INSERT INTO TB_REVIEW VALUES(21, 'user01', 04, '��������21', sysdate, sysdate, null, null, '���䳻��21', 4, 'Ű����');
INSERT INTO TB_REVIEW VALUES(22, 'user02', 03, '��������22', sysdate, sysdate, null, null, '���䳻��22', 6, 'Ű����');
INSERT INTO TB_REVIEW VALUES(23, 'user01', 02, '��������23', sysdate, sysdate, null, null, '���䳻��23', 3, 'Ű����');
INSERT INTO TB_REVIEW VALUES(24, 'user02', 01, '��������24', sysdate, sysdate, null, null, '���䳻��24', 9, 'Ű����');

INSERT INTO TB_REVIEW VALUES(49, 'user01', 13, '��������25', sysdate, sysdate, null, null, '���䳻��25.', 10, '����');
INSERT INTO TB_REVIEW VALUES(50, 'user02', 14, '��������26', sysdate, sysdate, null, null, '���䳻��26', 5, 'Ű����');
INSERT INTO TB_REVIEW VALUES(51, 'user03', 15, '��������27', sysdate, sysdate, null, null, '���䳻��27', 4, 'Ű����');
INSERT INTO TB_REVIEW VALUES(52, 'user04', 16, '��������28', sysdate, sysdate, null, null, '���䳻��28', 2, 'Ű����');
INSERT INTO TB_REVIEW VALUES(53, 'user03', 17, '��������29', sysdate, sysdate, null, null, '���䳻��29', 3, 'Ű����');
INSERT INTO TB_REVIEW VALUES(54, 'user03', 18, '��������30', sysdate, sysdate, null, null, '���䳻��30', 7, 'Ű����');
INSERT INTO TB_REVIEW VALUES(55, 'user03', 19, '��������31', sysdate, sysdate, null, null, '���䳻��31', 8, 'Ű����');
INSERT INTO TB_REVIEW VALUES(56, 'user04', 20, '��������32', sysdate, sysdate, null, null, '���䳻��32', 5, 'Ű����');
INSERT INTO TB_REVIEW VALUES(57, 'user04', 21, '��������33', sysdate, sysdate, null, null, '���䳻��33', 4, 'Ű����');
INSERT INTO TB_REVIEW VALUES(58, 'user04', 22, '��������34', sysdate, sysdate, null, null, '���䳻��34', 6, 'Ű����');
INSERT INTO TB_REVIEW VALUES(59, 'user04', 23, '��������35', sysdate, sysdate, null, null, '���䳻��35', 3, 'Ű����');
INSERT INTO TB_REVIEW VALUES(60, 'user03', 24, '��������36', sysdate, sysdate, null, null, '���䳻��35', 9, 'Ű����');

INSERT INTO TB_REVIEW VALUES(61, 'user01', 24, '��������37', sysdate, sysdate, null, null, '���䳻��37.', 10, '����');
INSERT INTO TB_REVIEW VALUES(62, 'user02', 23, '��������38', sysdate, sysdate, null, null, '���䳻��38', 5, 'Ű����');
INSERT INTO TB_REVIEW VALUES(63, 'user03', 22, '��������39', sysdate, sysdate, null, null, '���䳻��39', 4, 'Ű����');
INSERT INTO TB_REVIEW VALUES(64, 'user04', 21, '��������40', sysdate, sysdate, null, null, '���䳻��40', 2, 'Ű����');
INSERT INTO TB_REVIEW VALUES(65, 'user01', 60, '��������41', sysdate, sysdate, null, null, '���䳻��41', 3, 'Ű����');
INSERT INTO TB_REVIEW VALUES(66, 'user01', 61, '��������42', sysdate, sysdate, null, null, '���䳻��42', 7, 'Ű����');
INSERT INTO TB_REVIEW VALUES(67, 'user02', 59, '��������43', sysdate, sysdate, null, null, '���䳻��43', 8, 'Ű����');
INSERT INTO TB_REVIEW VALUES(68, 'user02', 58, '��������44', sysdate, sysdate, null, null, '���䳻��44', 5, 'Ű����');
INSERT INTO TB_REVIEW VALUES(69, 'user03', 55, '��������45', sysdate, sysdate, null, null, '���䳻��45', 4, 'Ű����');
INSERT INTO TB_REVIEW VALUES(70, 'user01', 56, '��������46', sysdate, sysdate, null, null, '���䳻��46', 6, 'Ű����');
INSERT INTO TB_REVIEW VALUES(71, 'user03', 56, '��������47', sysdate, sysdate, null, null, '���䳻��47', 3, 'Ű����');
INSERT INTO TB_REVIEW VALUES(72, 'user04', 54, '��������48', sysdate, sysdate, null, null, '���䳻��48', 9, 'Ű����');


-- TB_SALETYPE SAMPLE DATA
INSERT INTO TB_SALETYPE VALUES (1, '���');
INSERT INTO TB_SALETYPE VALUES (2, '�Ϲ�');


-- TB_USED_AUCTION SAMPLE DATA
INSERT INTO TB_USED_AUCTION VALUES(1, 1, 'user01', 1, 5400, 12, 6200, 'user02', '21/07/21', '21/08/10', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(2, 1, 'user03', 2, 2100, 4, 2700, 'user01', '21/07/24', '21/08/10', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_AUCTION VALUES(3, 1, 'user02', 3, 3800, 7, 5200, 'user03', '21/07/25', '21/08/13', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_AUCTION VALUES(4, 1, 'user04', 4, 3500, 26, 6300, 'user04', SYSDATE, '21/08/13', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(5, 1, 'user01', 5, 5300, 6, 6100, 'user02', SYSDATE, '21/08/14', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_AUCTION VALUES(6, 1, 'user02', 6, 6700, 19, 9820, 'user03', SYSDATE, '21/08/18', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_AUCTION VALUES(7, 1, 'user03', 7, 5800, 31, 10830, 'user05', SYSDATE, '21/08/19', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_AUCTION VALUES(8, 1, 'user05', 8, 3100, 3, 4100, 'user06', SYSDATE, '21/08/20', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_AUCTION VALUES(9, 1, 'user06', 9, 4200, 4, 5100, 'user07', SYSDATE, '21/08/20', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(10, 1, 'user07', 10, 3500, 2, 4300, 'user02', SYSDATE, '21/08/21', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_AUCTION VALUES(11, 1, 'user06', 11, 3800, 8, 7100, 'user03', SYSDATE, '21/08/24', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_AUCTION VALUES(12, 1, 'user05', 12, 4300, 3, 5100, 'user01', SYSDATE, '21/08/24', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_AUCTION VALUES(13, 1, 'user07', 13, 2800, 2, 3200, 'user03', SYSDATE, '21/08/26', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(14, 1, 'user06', 14, 9100, 4, 10200, 'user04', SYSDATE, '21/08/26', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_AUCTION VALUES(15, 1, 'user05', 15, 2600, 5, 4300, 'user06', SYSDATE, '21/08/28', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_AUCTION VALUES(16, 1, 'user06', 16, 6500, 1, 6600, 'user04', SYSDATE, '21/08/28', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_AUCTION VALUES(17, 1, 'user05', 17, 6300, 6, 8800, 'user07', SYSDATE, '21/08/29', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(18, 1, 'user07', 18, 2700, 7, 6300, 'user05', SYSDATE, '21/08/29', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_AUCTION VALUES(19, 1, 'user07', 19, 2800, 0, 2800, 'user04', SYSDATE, '21/08/30', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_AUCTION VALUES(20, 1, 'user05', 20, 3400, 9, 8200, 'user06', SYSDATE, '21/08/30', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_AUCTION VALUES(21, 1, 'user07', 21, 3800, 8, 6100, 'user05', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(22, 1, 'user06', 22, 4200, 2, 4800, 'user07', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_AUCTION VALUES(23, 1, 'user03', 23, 4600, 3, 5100, 'user02', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'B');

INSERT INTO TB_USED_AUCTION VALUES(24, 1, 'user01', 24, 5400, 12, 6200, 'user02', '21/07/21', '21/08/10', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(25, 1, 'user03', 25, 2100, 4, 2700, 'user01', '21/07/24', '21/08/10', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_AUCTION VALUES(26, 1, 'user02', 26, 3800, 7, 5200, 'user03', '21/07/25', '21/08/13', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_AUCTION VALUES(27, 1, 'user04', 27, 3500, 26, 6300, 'user04', SYSDATE, '21/08/13', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(28, 1, 'user01', 28, 5300, 6, 6100, 'user02', SYSDATE, '21/08/14', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_AUCTION VALUES(29, 1, 'user02', 29, 6700, 19, 9820, 'user03', SYSDATE, '21/08/18', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(30, 1, 'user03', 30, 5800, 31, 10830, 'user05', SYSDATE, '21/08/19', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_AUCTION VALUES(31, 1, 'user05', 31, 3100, 3, 4100, 'user06', SYSDATE, '21/08/20', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_AUCTION VALUES(32, 1, 'user06', 32, 4200, 4, 5100, 'user07', SYSDATE, '21/08/20', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_AUCTION VALUES(33, 1, 'user07', 33, 3500, 2, 4300, 'user02', SYSDATE, '21/08/21', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ��', 'S');
INSERT INTO TB_USED_AUCTION VALUES(34, 1, 'user06', 34, 3800, 8, 7100, 'user03', SYSDATE, '21/08/24', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_AUCTION VALUES(35, 1, 'user05', 35, 4300, 3, 5100, 'user01', SYSDATE, '21/08/24', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_AUCTION VALUES(36, 1, 'user07', 36, 2800, 2, 3200, 'user03', SYSDATE, '21/08/26', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_AUCTION VALUES(37, 1, 'user06', 37, 9100, 4, 10200, 'user04', SYSDATE, '21/08/26', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(38, 1, 'user05', 38, 2600, 5, 4300, 'user06', SYSDATE, '21/08/28', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_AUCTION VALUES(39, 1, 'user06', 39, 6500, 1, 6600, 'user04', SYSDATE, '21/08/28', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_AUCTION VALUES(40, 1, 'user05', 40, 6300, 6, 8800, 'user07', SYSDATE, '21/08/29', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_AUCTION VALUES(41, 1, 'user07', 41, 2700, 7, 6300, 'user05', SYSDATE, '21/08/29', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(42, 1, 'user07', 42, 2800, 0, 2800, 'user04', SYSDATE, '21/08/30', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_AUCTION VALUES(43, 1, 'user05', 43, 3400, 9, 8200, 'user06', SYSDATE, '21/08/30', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_AUCTION VALUES(44, 1, 'user07', 44, 3800, 8, 6100, 'user05', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_AUCTION VALUES(45, 1, 'user06', 45, 4200, 2, 4800, 'user07', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_AUCTION VALUES(46, 1, 'user03', 46, 4600, 3, 5100, 'user02', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '���� ��� ���� �Ұ� �ؽ�Ʈ', 'A');


-- TB_USED_NORMAL SAMPLE DATA
INSERT INTO TB_USED_NORMAL VALUES(1, 2, 'user02', 1, 6000, '21/07/21', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_NORMAL VALUES(2, 2, 'user01', 2, 11000, '21/07/24', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_NORMAL VALUES(3, 2, 'user03', 3, 4300, '21/07/25', 3, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_NORMAL VALUES(4, 2, 'user04', 4, 2500, '21/07/26', 4, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(5, 2, 'user03', 5, 8600, '21/07/26', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(6, 2, 'user04', 6, 5000, '21/07/28', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_NORMAL VALUES(7, 2, 'user01', 7, 9200, '21/07/29', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_NORMAL VALUES(8, 2, 'user02', 8, 2400, '21/07/30', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(9, 2, 'user05', 9, 3500, '21/08/02', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_NORMAL VALUES(10, 2, 'user06', 10, 6200, '21/08/02', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_NORMAL VALUES(11, 2, 'user07', 11, 5300, '21/08/03', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_NORMAL VALUES(12, 2, 'user05', 12, 2500, '21/08/03', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_NORMAL VALUES(13, 2, 'user06', 13, 3400, '21/08/04', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(14, 2, 'user06', 14, 5700, '21/08/05', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(15, 2, 'user07', 15, 5300, '21/08/05', 3, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_NORMAL VALUES(16, 2, 'user05', 16, 4300, DEFAULT, 3, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_NORMAL VALUES(17, 2, 'user07', 17, 4700, DEFAULT, 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(18, 2, 'user06', 18, 4200, DEFAULT, 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_NORMAL VALUES(19, 2, 'user05', 19, 4500, DEFAULT, 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(20, 2, 'user04', 20, 5100, DEFAULT, 3, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_NORMAL VALUES(21, 2, 'user05', 21, 5300, DEFAULT, 3, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_NORMAL VALUES(22, 2, 'user06', 22, 3800, DEFAULT, 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(23, 2, 'user07', 23, 3200, DEFAULT, 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'C');

INSERT INTO TB_USED_NORMAL VALUES(24, 2, 'user02', 24, 6000, '21/07/21', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_NORMAL VALUES(25, 2, 'user01', 25, 11000, '21/07/24', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_NORMAL VALUES(26, 2, 'user03', 26, 4300, '21/07/25', 3, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_NORMAL VALUES(27, 2, 'user04', 27, 2500, '21/07/26', 4, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(28, 2, 'user03', 28, 8600, '21/07/26', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(29, 2, 'user04', 29, 5000, '21/07/28', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_NORMAL VALUES(30, 2, 'user01', 30, 9200, '21/07/29', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_NORMAL VALUES(31, 2, 'user02', 31, 2400, '21/07/30', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(32, 2, 'user05', 32, 3500, '21/08/02', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_NORMAL VALUES(33, 2, 'user06', 33, 6200, '21/08/02', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_NORMAL VALUES(34, 2, 'user07', 34, 5300, '21/08/03', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_NORMAL VALUES(35, 2, 'user05', 35, 2500, '21/08/03', 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_NORMAL VALUES(36, 2, 'user06', 36, 3400, '21/08/04', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(37, 2, 'user06', 37, 5700, '21/08/05', 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(38, 2, 'user07', 38, 5300, '21/08/05', 3, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_NORMAL VALUES(39, 2, 'user05', 39, 4300, DEFAULT, 3, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_NORMAL VALUES(40, 2, 'user07', 40, 4700, DEFAULT, 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(41, 2, 'user06', 41, 4200, DEFAULT, 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'C');
INSERT INTO TB_USED_NORMAL VALUES(42, 2, 'user05', 42, 4500, DEFAULT, 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(43, 2, 'user04', 43, 5100, DEFAULT, 3, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'A');
INSERT INTO TB_USED_NORMAL VALUES(44, 2, 'user05', 44, 5300, DEFAULT, 3, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'S');
INSERT INTO TB_USED_NORMAL VALUES(45, 2, 'user06', 45, 3800, DEFAULT, 2, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'B');
INSERT INTO TB_USED_NORMAL VALUES(46, 2, 'user07', 46, 3200, DEFAULT, 1, DEFAULT, '���� �Ϲ� ���� �Ұ� �ؽ�Ʈ', 'C');


-- TB_NOTICE SAMPLE DATA
INSERT INTO TB_NOTICE VALUES (1, 'admin01', '����1', NULL, NULL, '�ȳ��ϼ���1', '��ü����', DEFAULT, NULL, 53);
INSERT INTO TB_NOTICE VALUES (2, 'admin01', '����2', NULL, NULL, '�ȳ��ϼ���2', '��ü����', DEFAULT, NULL, 28);
INSERT INTO TB_NOTICE VALUES (3, 'admin01', '����3', NULL, NULL, '�ȳ��ϼ���3', '��ü����', DEFAULT, NULL, 67);
INSERT INTO TB_NOTICE VALUES (4, 'admin01', '����4', NULL, NULL, '�ȳ��ϼ���4', '��ü����', DEFAULT, NULL, 42);
INSERT INTO TB_NOTICE VALUES (5, 'admin01', '����5', NULL, NULL, '�ȳ��ϼ���5', '��ü����', DEFAULT, NULL, 150);
INSERT INTO TB_NOTICE VALUES (6, 'admin01', '����6', NULL, NULL, '�ȳ��ϼ���6', '��ü����', DEFAULT, NULL, 19);
INSERT INTO TB_NOTICE VALUES (7, 'admin01', '����7', NULL, NULL, '�ȳ��ϼ���7', '��ü����', DEFAULT, NULL, 80);
INSERT INTO TB_NOTICE VALUES (8, 'admin01', '����8', NULL, NULL, '�ȳ��ϼ���8', '��ü����', DEFAULT, NULL, 72);
INSERT INTO TB_NOTICE VALUES (9, 'admin01', '����9', NULL, NULL, '�ȳ��ϼ���9', '��ü����', DEFAULT, NULL, 15);
INSERT INTO TB_NOTICE VALUES (10, 'admin01', '����10', NULL, NULL, '�ȳ��ϼ���10', '��ü����', DEFAULT, NULL, 64);
INSERT INTO TB_NOTICE VALUES (11, 'admin01', '����11', NULL, NULL, '�ȳ��ϼ���11', '��ü����', DEFAULT, NULL, 15);


-- TB_ASK SAMPLE DATA
INSERT INTO TB_ASK VALUES (1, 'user01', '��ǰ����',  '�ȳ��ϼ���1', '�����Դϴ�1.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (2, 'user02', '��ǰ����',  '�ȳ��ϼ���2', '�����Դϴ�2.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (3, 'user03', '��ǰ����',  '�ȳ��ϼ���3', '�����Դϴ�3.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (4, 'user02', '��ǰ����',  '�ȳ��ϼ���4', '�����Դϴ�4.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (5, 'user01', '��ǰ����',  '�ȳ��ϼ���5', '�����Դϴ�5.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (6, 'user04', '��ǰ����',  '�ȳ��ϼ���6', '�����Դϴ�6.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (7, 'user03', '��ǰ����',  '�ȳ��ϼ���7', '�����Դϴ�7.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (8, 'user02', '��ǰ����',  '�ȳ��ϼ���8', '�����Դϴ�8.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (9, 'user04', '��ǰ����',  '�ȳ��ϼ���9', '�����Դϴ�9.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (10, 'user03', '��ǰ����',  '�ȳ��ϼ���10', '�����Դϴ�10.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (11, 'user01', '��ǰ����',  '�ȳ��ϼ���11', '�����Դϴ�11.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (12, 'user02', '��ǰ����',  '�ȳ��ϼ���12', '�����Դϴ�12.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);

commit;