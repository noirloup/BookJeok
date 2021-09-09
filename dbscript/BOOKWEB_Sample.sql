-- TB_USER SAMPLE DATA
-- 로그인 안되는 샘플 아이디
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
-- 로그인 가능 샘플 아이디
INSERT INTO TB_USER VALUES ('user01',	'nick01', 'cGFzczAx', '홍길동', 'M', 31, '01012345678', 'user01@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '경제/경영,국어/외국어,여행/취미,기타 장르', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user02',	'nick02', 'cGFzczAy', '이춘향', 'F', 26, '01022223333', 'user02@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '소설,경제/경영,기타 장르', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user03',	'nick03', 'cGFzczAz', '강감찬', 'M', 39, '01022223333', 'user03@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '경제/경영,역사/풍속/신화,건강/의학,기타 장르', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user04',	'nick04', 'cGFzczAx', '정지혁', 'M', 28, '01044444444', 'user04@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '소설,자기계발,시/에세이,기타 장르', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user05',	'nick05', 'cGFzczAx', '이돈녕', 'M', 28, '01055555555', 'user05@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '소설,자기계발,시/에세이,기타 장르', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user06',	'nick06', 'cGFzczAx', '노형규', 'M', 28, '01066666666', 'user06@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '소설,자기계발,시/에세이,기타 장르', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('user07',	'nick07', 'cGFzczAx', '전보영', 'M', 28, '01077777777', 'user07@ict.org', NULL, NULL, NULL, DEFAULT, 'asdf', '소설,자기계발,시/에세이,기타 장르', DEFAULT, DEFAULT);
INSERT INTO TB_USER VALUES ('admin01',	'관리자01', 'cGFzczAx', '관리자', 'M', 28, '01098765432', 'admin01@test.com', NULL, NULL, NULL, DEFAULT, '관리자 아이디.', '경제/경영,기타 장르', DEFAULT, 'Y');


-- TB_PRODUCT_TYPE SAMPLE DATA
INSERT INTO TB_PRODUCT_TYPE VALUES (1, '페이퍼북');
INSERT INTO TB_PRODUCT_TYPE VALUES (2, '전자책');
INSERT INTO TB_PRODUCT_TYPE VALUES (3, '오디오북');


-- TB_PRODUCT_LOC SAMPLE DATA
INSERT INTO TB_PRODUCT_LOC VALUES (1, '국내도서');
INSERT INTO TB_PRODUCT_LOC VALUES (2, '국외도서');


-- TB_CATEGORY SAMPLE DATA
INSERT INTO TB_CATEGORY VALUES (1, '소설');
INSERT INTO TB_CATEGORY VALUES (2, '경제/경영');
INSERT INTO TB_CATEGORY VALUES (3, '자기계발');
INSERT INTO TB_CATEGORY VALUES (4, '시/에세이');
INSERT INTO TB_CATEGORY VALUES (5, '인문');
INSERT INTO TB_CATEGORY VALUES (6, '국어/외국어');
INSERT INTO TB_CATEGORY VALUES (7, '역사/풍속/신화');
INSERT INTO TB_CATEGORY VALUES (8, '사회/정치/법');
INSERT INTO TB_CATEGORY VALUES (9, '장르소설');
INSERT INTO TB_CATEGORY VALUES (10, '코믹스');
INSERT INTO TB_CATEGORY VALUES (11, '아동');
INSERT INTO TB_CATEGORY VALUES (12, '유아');
INSERT INTO TB_CATEGORY VALUES (13, '예술/대중문화');
INSERT INTO TB_CATEGORY VALUES (14, '교재/수험서');
INSERT INTO TB_CATEGORY VALUES (15, '청소년/교양');
INSERT INTO TB_CATEGORY VALUES (16, '자연과학/공학');
INSERT INTO TB_CATEGORY VALUES (17, '종교/역학');
INSERT INTO TB_CATEGORY VALUES (18, '건강/의학');
INSERT INTO TB_CATEGORY VALUES (19, '북모닝');
INSERT INTO TB_CATEGORY VALUES (20, '여행/취미');
INSERT INTO TB_CATEGORY VALUES (21, '매거진');
INSERT INTO TB_CATEGORY VALUES (22, '가정/생활/요리');
INSERT INTO TB_CATEGORY VALUES (23, '컴퓨터 인터넷');


-- TB_BOOK SAMPLE DATA
-- 페이퍼북
-- 국내
INSERT INTO TB_BOOK VALUES(01, 1, 1, 1, '완전한행복.png', '완전한행복', 123456789, 1, '자기애의 늪에 빠진 삶은 얼마나 위태로운가,압도적 서사 위 정교하고 서늘한 공포', '정유정',  '장편소설 《내 인생의 스프링 캠프》로 제1회 세계청소년문학상을, 《내 심장을 쏴라》로 제5회 세계문학상을 수상했다.', 14220, 
7, '은행나무', '2021-06-08', '1부 / 그녀의 오리들 2부 / 그녀는 누구일까 3부 / 완전한 행복 에필로그 508');
INSERT INTO TB_BOOK VALUES(02, 2, 1, 1, '위대한패배자들.png', '위대한패배자들', 123456789, 2, '위대한 패배자들에게 배우는 인생과 경영의 지혜', '유필화',  '서울대학교에서 경영학을 공부', 16200, 
6, '흐름출판', '2021-08-01', '1장 조국에서 버림받은 파괴적 혁신가');
INSERT INTO TB_BOOK VALUES(03, 3, 1, 1, '미라클모닝.png', '미라클모닝', 123465789, 3, '2030세대, 기적의 아침에 열광하다', '김현수',  '고려대학교를 졸업', 10800, 
5, '한빛비즈', '2016-02-22', 'CHAPTER00 한눈에 읽는 기적의 6분 CHAPTER01 아침을 잃어버린 사람들');
INSERT INTO TB_BOOK VALUES(04, 4, 1, 1, '수학자의아침.png', '수학자의아침', 123465789, 4, '그렇지 않았던 것들을 포착해내는 아침의 감각', '김소연',  '시를 쓰며 살고 있다. 확신에 찬 사람들 속에 나를 내버려 두지 않기 위해 노력하고 있다.', 10800, 
8, '문학과지성사', '2013-11-13', '1부 유서 없는 피부를 경멸합니다');
INSERT INTO TB_BOOK VALUES(05, 5, 1, 1, '숲속의자본주의자.png', '숲속의자본주의자', 123465789, 5, '세상의 속도에 맞추며 사는 게 버거워졌을 때 비로소 나의 월든을 찾아 떠났다', '박혜윤',  '서울대학교 영어영문학과를 졸업', 14500, 
6, '다산초당', '2021-06-14', '1장 제철에 블랙베리를 따는 삶');
INSERT INTO TB_BOOK VALUES(06, 6, 1, 1, '왕초보영어.png', '왕초보영어', 123456788, 6, '하루 30분 학습으로 언제 어디서나', 'EBS',  'EBS는 실험적인 기획과 창의적인 프로그램 제작', 13500, 
4, '한국교육방송공사', '2021-07-05', 'Day 001 위기일발의 남편-가정 1483회');
INSERT INTO TB_BOOK VALUES(07, 7, 1, 1, '뭉우리돌의 바다.png', '뭉우리돌의 바다', 123456788, 7, '제67화 광복절 특집 감동의 출연자', '김동우',  '대학에서 신문방송학과를 졸업하고 신문사 기자로 일한다.', 18000, 
9, '수오서재', '2021-07-29', '인도에 간 한국광복군');
INSERT INTO TB_BOOK VALUES(08, 8, 1, 1, '있지만없는아이들.png', '있지만없는아이들', 123456788, 8, '나는 이들에게서 운명을 마주하는 힘을 배웠다.', '은유',  '산문, 칼럼, 인터뷰 등 논픽션을 쓰고, 글쓰기 수업을 진행한다.', 13500, 
7, '창비', '2021-06-18', '프롤로그 먼 타인의 아이를 사랑하라');
INSERT INTO TB_BOOK VALUES(09, 9, 1, 1, '우리가빛의속도로갈수없다면.png', '우리가빛의속도로갈수없다면', 123456788, 9, '우리 SF의 우아한 계보', '김초엽',  '소설가. 1993년생.', 12600, 
8, '허블', '2019-06-24', '순례자들은 왜 돌아오지 않는가 ·007');
INSERT INTO TB_BOOK VALUES(10, 10, 1, 1, '지금우리학교는.png', '지금우리학교는', 123456788, 10, '핏빛으로 전율하는 공포의 학원 블록버스터!', '주동근',  '1983년 8월 23일생', 13500, 
10, '문학동네', '2021-07-31', '함께하는 친구들이 줄어갈수록 강해져갔다.');
INSERT INTO TB_BOOK VALUES(11, 11, 1, 1, '열두살장래희망.png', '열두살장래희망', 123456788, 11, '아름다운 내일을 꿈꾼다!', '박성우',  '1971년 전북 정읍에서 태어났습니다.', 11700, 
3, '창비', '2021-07-23', '무엇이든 잘 고치는 사람');
INSERT INTO TB_BOOK VALUES(12, 12, 1, 1, '친구의전설.png', '친구의전설', 123456788, 12, '팥빙수의 전설을 잇는 강력하고 치명적인 전설이 찾아왔다!', '이지은',  '한국과 영국에서 디자인과 그림을 공부했습니다', 12600, 
9, '웅진주니어', '2021-06-13', '떼려야 뗄 수 없는 운명적인 만남!');
INSERT INTO TB_BOOK VALUES(13, 13, 1, 1, '돈의속성.png', '돈의속성', 123465789, 13, '최상위 부자 김승호 회장이 직접 밝히는 돈에 통찰과 철학', '김승호',  '한인 기업 최초 글로벌 외식 그룹인 SNOWFOX GROUP 의 회장이다', 13500, 
6, '스노우폭스', '2020-06-15', '돈은 인격체다 나는 나보다 더 훌륭한 경영자에게 투자한다');
INSERT INTO TB_BOOK VALUES(14, 14, 1, 1, '전자기학.png', '전자기학', 123465789, 14, '전자기학은 전하들의 상호작용을 다루는 전기장과 전류도선들의 상호작용을 다루는 자기장으로 구성된다.', '김동명',  '서울대학교 공과대학에서 전자공학 학사', 34200, 
7, '한빛아카데미', '2020-12-17', '1장. 좌표계와 벡터 기초');
INSERT INTO TB_BOOK VALUES(15, 15, 1, 1, '죽이고싶은아이.png', '죽이고싶은아이', 123465789, 15, '십 대들의 외롭고 불안한 내면을 따뜻하게 어루만져 주는 작품', '이꽃잎',  '신춘문예에 동화 메두사의 후예로 등단', 11250, 
6, '우리학교', '2021-06-07', '조각난 진실과 부서진 믿음에 관한 이야기');
INSERT INTO TB_BOOK VALUES(16, 16, 1, 1, '미술관에간해부학자.png', '미술관에간해부학자', 123465789, 16, '명화에 담긴 해부학 코드를 해석하다!', '이재호', '해부학을 누구나 쉽게 이해할 수 있도록 노력하고 있다. ', 18000, 
7, '어바웃어북', '2021-07-05', '01. 미켈란젤로가 그림 속에 숨겨놓은 뇌 해부도를 찾아서');
INSERT INTO TB_BOOK VALUES(17, 17, 1, 1, '무명.png', '무명', 123465789, 17, '그리스도인이라면 누구나 무명의 시간을 겪는다', '김일환', '그는 이름을 불러주는 사람이다 ', 13500, 
9, '규장', '2021-07-19', '01. 꿈');
INSERT INTO TB_BOOK VALUES(18, 18, 1, 1, '백년운동.png', '백년운동', 123465789, 18, '100세 인생을 건강하고 멋지게 살고 싶은 이들에게 그 방법을 의학적으로 제시', '정성근', '서울대 의대 재활의학과 정선근 교수', 17550, 
5, '아티잔', '2019-11-11', '1부 운동,최고의 명약 그리고 딜레마');
INSERT INTO TB_BOOK VALUES(19, 19, 1, 1, '꿈꾸는엄마의미라클모닝.png', '꿈꾸는엄마의미라클모닝', 123465789, 19, '엄마의 하루를 바꾸는 아침', '김연지',  'CBS 기자', 12600, 
9, '유노라이프', '2021-05-31', '간절한 목표가 새벽을 깨운다');
INSERT INTO TB_BOOK VALUES(20, 20, 1, 1, '여행의이유.png', '여행의이유', 123465789, 20, '나는 그 무엇보다 우선 작가였고, 그다음으로는 역시 여행자였다.', '김영하', '연세대학교 경영학 학사와 석사를 취득', 12150, 
7, '문학동네', '2019-04-17', '상처를 몽땅 흡수한 물건들로부터 달아나기');
INSERT INTO TB_BOOK VALUES(21, 21, 1, 1, '더홈.png', '더홈', 123465789, 21, '집과 사람에 대한 이야기를 다룬 책', 'JOH컴퍼니', '균형 잡힌 브랜드를 한 호에 하나씩 소개하는 브랜드 다큐멘터리 매거진', 19000, 
7, 'JOH', '2020-09-25', '1. HOME OFFICE');
INSERT INTO TB_BOOK VALUES(22, 22, 1, 1, '집밥둘리가정식.png', '집밥둘리가정식', 123465789, 22, '요즘 우리의 가정식, 집밥둘리의 식탁', '박지연', '손으로 무언가를 만드는 것을 좋아해서 요리를 전공했다', 21600, 
8, '테이스트북스', '2020-06-30', '1. 71가지 메뉴');
INSERT INTO TB_BOOK VALUES(23, 23, 1, 1, '우리사이엔오해가있다.png', '우리사이엔오해가있다', 123456788, 23, '닷새 안에 답장이 없으면절교하자는 뜻인 줄로 알겠습니다.', '남궁인',  '1992년 서울에서 태어났다. 〈일간 이슬아〉를 발행하고 헤엄출판사를 운영한다.', 13500, 
4, '문학동네', '2021-07-10', '프롤로그 멋지고 징그러운 남궁인 선생님께');

--국외
INSERT INTO TB_BOOK VALUES(24, 1, 1, 2, '얼굴없는살인자.png', '얼굴없는살인자', 123456799, 24, '범인과의 피 말리는 두뇌 싸움이 시작된다!', '스테판 안헴',  '유럽에서 가장 인기 있고 잘나가는 범죄 스릴러 분야 작가', 15120, 
9, '마시멜로', '2021-06-30', '과거 청소년기 시절');
INSERT INTO TB_BOOK VALUES(25, 2, 1, 2, '투자의신.png', '투자의신', 123456799, 25, '미국 현대사를 관통하며 펼쳐지는 장대한 투자의 역사', '앤드루 킬패트릭',  '1965년 워싱턴 앤드 리 대학교를 졸업', 25200, 
8, '윌북', '2021-08-30', '1부 워런 버핏이라는 인물');
INSERT INTO TB_BOOK VALUES(26, 3, 1, 2, '워커사우르스.png', '워커사우르스', 123456799, 26, '비범한 리더들이 가진 위험천만한 DNA', '로버트 브루스',  '예일대학교에서 조직 행동으로 박사학위를 받았고, 경영 컨설턴트로 활동', 14850, 
6, '알에치코리아', '2021-08-01', '1장 올인');
INSERT INTO TB_BOOK VALUES(27, 4, 1, 2, '작은이야기를계속하겠습니다.png', '작은이야기를계속하겠습니다', 123456799, 27, '세상과 사람을 잇기 위한 고레에다 히로카즈 감독의 다짐과 노력', '고레에다 히로카즈',  '영화감독. 1962년 도쿄에서 태어났다. ', 14400, 
7, '바다출판사', '2021-07-23', '보이지 않는 것에 대하여 13');
INSERT INTO TB_BOOK VALUES(28, 5, 1, 2, '챔피온마인드.png', '챔피온마인드', 123456799, 28, '자신과의 싸움에서 무조건 이기는 멘탈 트레이닝', 'Jim Afremow',  'Jim Afremow 미국의 스포츠 심리학자로, 스포츠 멘탈 코칭 기업을 운영하고 있다.', 16000, 
5, '엘리온', '2020-07-05', '프롤로그: 다른 사람의 위대함을 알아볼 수 있다면, 당신에게도 역시 그 위대함이 숨어 있다');
INSERT INTO TB_BOOK VALUES(29, 6, 1, 2, 'Midnight.png', 'Midnight', 123456799, 29, '밤의 이야기를 풀어가는 도중', 'Hai Matt',  '미국의 소설가로 문학상 수상.', 15500, 
6, '두산도서', '2020-02-28', '밤 12시, 죽기 바로 전에만 열리는 마법의 도서관에서');
INSERT INTO TB_BOOK VALUES(30, 7, 1, 2, 'Wonder.png', 'Wonder', 123456799, 30, '미국에서 출간된 후 지금까지 22주 연속으로 미국 대표적 일간지', 'RJ Palacio',  '영국의 소설가로 신인문학상 수상.', 14000, 
7, ' Cannongate', '2014-06-01', '얼굴이 모든 것을 말해주지는 않아요!');
INSERT INTO TB_BOOK VALUES(31, 8, 1, 2, 'ReBoot.png', 'ReBoot', 123456799, 31, '코로나 재앙의 한복판에서‘리부트 열풍’을 불러일으킨 화제의 책', 'Kim MK',  '미국의 소설가로 노벨문학상 수상..', 16500, 
8, 'Lioncrest Publishing ', '2021-06-28', '변화의 흐름을 꿰뚫어 본 130만 유튜버 김미경의 코로나 이후 생존법');
INSERT INTO TB_BOOK VALUES(32, 9, 1, 2, '틸.png', '틸', 123456799, 32, '독일 베스트셀러 정상을 차지', '다니엘 켈만',  '975년 독일 뮌헨 출생', 15200, 
6, '다산책방', '2021-07-09', '공중의 제왕');
INSERT INTO TB_BOOK VALUES(33, 10, 1, 2, '타노스라이징.png', '타노스라이징', 123456799, 33, '마블 유니버스 사상 최강, 최악의 슈퍼 빌런 타노스의 탄생 비화', '제이슨 아론',  '미국 알라바마 출신의 작가.', 9000, 
9, '시공사', '2015-04-25', '다른 생명체를 사랑하고 순수한 호기심만이 가득하던 그');
INSERT INTO TB_BOOK VALUES(34, 11, 1, 2, '그렇게그렇게.png', '그렇게그렇게', 123456799, 34, '2017년 볼로냐 라가치상 특별상 수상 작가 요시타케 신스케 신작!', '요시타케 신스케',  '그림책 작가이자 일러스트레이터다.', 10620, 
7, '주니어김영사', '2021-07-08', '그렇게 갖고싶어 안달이더니');
INSERT INTO TB_BOOK VALUES(35, 12, 1, 2, '완두의그림학교.png', '완두의그림학교', 123456799, 35, '완두를 아시나요? 완두의 그림 학교에 놀러 오세요!', '다비드 칼리', '1972년에 스위스에서 태어나 이탈리아에서 살고 있습니다.', 10800, 
6, '진선아이', '2021-07-20', '서툴러도 괜찮아!');
INSERT INTO TB_BOOK VALUES(36, 13, 1, 2, '관계의마술사.png', '관계의마술사', 123456799, 36, '시대를 바꾼 예술가가 되어가는 과정', '세베스천 스미',  '미술 비평가로 활동 중', 10800, 
9, '앵글북스', '2021-06-21', '01. 마네와 드가 - 찢어진 초상화');
INSERT INTO TB_BOOK VALUES(37, 14, 1, 2, '현대사회학.png', '현대사회학', 123456799, 37, '30여 년간 시대 상황의 변화와 학문적 성장에 따라 새로운 내용을 꾸준히 소개', '앤서니 기든스', '현대사회학계의 세계적 석학으로 영국의 대표적 사회학자', 11800, 
5, '을유문화사', '2018-02-20', '1. 사회학이란 무엇인가');
INSERT INTO TB_BOOK VALUES(38, 15, 1, 2, '초콜릿.png', '초콜릿', 123456799, 38, '놀라운 반전과 섬세한 표현으로 긴장감 있게 표현한 소설', '소피 라로시', '970년에 파드칼레 지방의 위메로에서 태어나 바닷가에서 성장', 13200, 
8, '머스트비', '2021-06-30', '지금부터 하게 될 이야기는');
INSERT INTO TB_BOOK VALUES(39, 16, 1, 2, '식물의세계.png', '식물의세계', 123456799, 39, '인간의 삶에 가장 큰 영향을 준 식물 80종의 이야기', '조너선 드로리', '영국 에덴 프로젝트와 케임브리지 과학 센터 이사', 18000, 
4, '시공사', '2021-06-16', '서양쐐기풀 Urtica dioica, 영국');
INSERT INTO TB_BOOK VALUES(40, 17, 1, 2, '일상의성화.png', '일상의성화', 123456799, 40, '성화는 틀에 박힌 공식이 아니다', '데이비드 폴리슨', '하버드 대학교에서 심리학(B.A.), 웨스트민스터 신학교에서 신학(M.Div.)을 공부', 10350, 
6, '토기장이', '2021-05-31', '1장. 하나님은 약속을 통해 우리를 만나신다');
INSERT INTO TB_BOOK VALUES(41, 18, 1, 2, '킵샤프.png', '킵샤프', 123456799, 41, '습관을 바꾸면 뇌는 늙지 않는다!', '산제이 굽타', '의학 박사이자 에미상 수상에 빛나는 CNN 의학 전문 기자', 15300, 
8, '니들북', '2021-06-22', 'Part 1. 뇌 : 내 머릿속의 블랙박스');
INSERT INTO TB_BOOK VALUES(42, 19, 1, 2, '마스터.png', '마스터', 123456799, 42, '당신의 인생을 마스터 하라!', '클래스케이', '유튜브 채널 ‘클래스케이’ 운영,', 13500, 
7, '케이미라클모닝', '2021-07-07', '마스터와의 만남 16');
INSERT INTO TB_BOOK VALUES(43, 20, 1, 2, '다정한나의오일파스텔.png', '다정한나의오일파스텔', 123456799, 43, '유튜버 골드손의 감각적인 노하우로 완성', '골드손', '유튜브 채널 클래스케 운영,', 14400, 
6, '위즈덤하우스', '2021-06-30', '오일파스텔로 그림 그리기 전 알아둘 것');
INSERT INTO TB_BOOK VALUES(44, 21, 1, 2, '원피스매거진.png', '원피스매거진', 123456799, 44, '만화 원피스 매거진 10호', '오다 에이이치로', '인기만화 『원피스』의 작가', 11700, 
9, '대원', '2021-03-26', '시작');
INSERT INTO TB_BOOK VALUES(45, 22, 1, 2, '히데코의연희동요리교실.png', '히데코의연희동요리교실', 123456799, 45, '그곳에 은근하게 뜨거운 요리교실이 있다.', '나카가와 히데코', '일본에서 태어나 프렌치 요리사 아버지 밑에서 자란 그녀', 18000, 
8, '이봄', '2021-08-04', '프롤로그 13년의 시간을 담아 보내는 레시피 편지');
INSERT INTO TB_BOOK VALUES(46, 23, 1, 2, '시드마이어.png', '시드마이어', 123456799, 46, '그 시절 우리가 매일 밤 뜬눈으로 날을 지새우게 했던‘그 게임’은 어떻게 탄생했을까?', '시드 마이어', '미국의 게임 디자이너', 17820, 
9, '영진닷컴', '2021-06-25', '10억 시간: 서문');

--전자책
--국내
INSERT INTO TB_BOOK VALUES(47, 11, 2, 1, '밤의여행자들.png', '밤의여행자들', 123356789, 1, '재난과 재건의 한복판에서 벌이는 괴이한 모험', '윤고은',  '저자 윤고은은 1980년 서울에서 태어나 2004년 대산대학문학상을 받으며 등단했다.', 13000, 
8, '믿음사', '2013-10-11', '1 정글 7 2 사막의 싱크홀 37');
INSERT INTO TB_BOOK VALUES(48, 14, 2, 1, '조국의시간.png', '조국의시간', 123546789, 2, '조국의 생생한 육성으로 듣는다.', '조국',  '1965년 부산에서 태어나 서울대학교 법과대학을 졸업했다.', 17000, 
7, '한길사', '2021-05-31', '제1장 시련의 가시밭길 제2장 나를 둘러싼 의혹들');
INSERT INTO TB_BOOK VALUES(49, 20, 2, 1, '하늘호수로떠난여행.png', '하늘호수로떠난여행', 123465789, 3, '호수가에서 이어지는 정열', '류시환',  '2017년 문학상 수상하며 작품활동을 시작했다', 11500, 
6, '문화사', '2021-05-27', '1 시련의 길 2 구원');
INSERT INTO TB_BOOK VALUES(50, 23, 2, 1, '공부머리는문해력이다.png', '공부머리는문해력이다', 123465789, 4, '공부 잘하는 아이들의 핵심 능력, 문해력을 키워라', '진동섭',  '서울대학교 입학사정관', 13500, 
5, '포르체', '2021-07-01', '1장 초등 공부머리를 기르는 문해력');
--국외
INSERT INTO TB_BOOK VALUES(51, 1, 2, 2, '밝은밤.png', '밝은밤', 123465789, 5, '백 년의 시간을 감싸안으며 이어지는 사랑과 숨의 기록', 'Choi Eun',  '영국 옥스포드에서 신인상을 수상하며 작품활동을 시작했다.', 14500, 
4, '문학동네', '2021-07-27', '1부 _007 2부 _083');
INSERT INTO TB_BOOK VALUES(52, 11, 2, 2, '그리스로마신화.png', '그리스로마신화', 123546789, 6, '만화로 읽는 초등 인문학', 'Jain Lynn',  ' 문학을 수상하며 작품활동을 시작했다', 22000, 
3, '아울북', '2019-09-05', '1 신들의 대전쟁');
INSERT INTO TB_BOOK VALUES(53, 16, 2, 2, '굿이너프.png', '굿이너프', 123465789, 7, '합리와 서열이 아닌 낭비와 과잉을 통해 진화하는 자연의 법칙', '다니엘 헤이그',  '철학자이자 역사학자, 진화생물학자. 파리사회과학고등연구원에서 교수로 재직', 13000, 
2, '다산사이언스', '2021-06-27', '제1부  진화의 아이콘');
INSERT INTO TB_BOOK VALUES(54, 22, 2, 2, '커피스터디.png', '커피스터디', 123465789, 8, '커피 박사 호리구치 선생님의 현장 레슨', '호리구치',  '대학원과 국제교류연구소에서 경영학과 국제관계학을 전공', 12500, 
1, '황소자리', '2021-07-07', 'Lesson 1 생두의 품질이 맛있는 향미를 만든다는 것에 대해');

--오디오북
--국내
INSERT INTO TB_BOOK VALUES(55, 1, 3, 1, '타인의집.png', '타인의집', 123356789, 1, '짧고 대담하고 강렬하다!', '손원평',  '강대학교에서 사회학과 철학을 공부', 11000, 
8, '창비', '2020-06-11', '4월의 눈 괴물들');
INSERT INTO TB_BOOK VALUES(56, 8, 3, 1, '공정한경쟁.png', '공정한경쟁', 123546789, 2, '젊은 정치를 위한 이준석의 미래지도', '이준석',  '2003년 서울과학고등학교 졸업', 16500, 
7, '나무옆자리', '2019-06-28', '뜨거운 감자, 젠더');
INSERT INTO TB_BOOK VALUES(57, 13, 3, 1, '널위한문화예술.png', '널위한문화예술', 123465789, 3, '즐겁고 유쾌하게 감상하는 법', '오대우',  '문화예술 미디어스타트업', 13500, 
6, '웨일북', '2021-07-14', '명화의 비밀 : 보이는 것이 전부가 아닌 이유');
INSERT INTO TB_BOOK VALUES(58, 17, 3, 1, '그사랑전하기위해.png', '그사랑전하기위해', 123465789, 4, '마음을 뒤흔든 SNS 전도사', '최진현',  '아들만 넷인 목회자 가정의 막내로 태어나 교회에서', 12500, 
5, '규장', '2021-07-05', '교회에서 살던 아이');
--국외
INSERT INTO TB_BOOK VALUES(59, 10, 3, 2, 'Batman.png', 'Batman', 123546789, 6, '다크히어로의 탄생', 'Jim Lee',  '2003년 미국하버드 졸업', 18500, 
2, '문학동네', '2018-06-05', '1 서장');
INSERT INTO TB_BOOK VALUES(60, 18, 3, 2, '최강의식물식.png', '최강의식물식', 123465789, 7, '식단 제한 없이 날씬하고 건강해질 수 있는 유일한 대안', 'Will Bers',  ' 의사 면허를 소지한 소화기내과 전문의', 13500, 
3, '청림라이프', '2021-07-14', '1장 건강의 원동력은');
INSERT INTO TB_BOOK VALUES(61, 23, 3, 2, '리펙터링.png', '리펙터링', 123465789, 8, '개발자가 선택한 프로그램 가치', 'Martin Pauler',  '수석 과학자. 엔터프라이즈 소프트웨어 설계', 17500, 
4, '한빛미디어', '2020-04-01', 'CHAPTER 01 리팩터링');
INSERT INTO TB_BOOK VALUES(62, 4, 3, 2, 'Odyssey.png', 'Odyssey', 123356789, 5, '고대 대서사시', 'Homer Wilson',  '미국의 시인', 13000, 
1, '두산', '2018-11-11', '1 The World of The Odyssey 94');


-- TB_OTHER_SITE SAMPLE DATA
INSERT INTO TB_OTHER_SITE VALUES(01, 01, '교보문고', 14220);
INSERT INTO TB_OTHER_SITE VALUES(02, 01, 'YES24', 14220);
INSERT INTO TB_OTHER_SITE VALUES(03, 01, '알라딘', 14220);
INSERT INTO TB_OTHER_SITE VALUES(04, 01, '영품문고', 14220);
INSERT INTO TB_OTHER_SITE VALUES(05, 01, '인터파크', 14220);

INSERT INTO TB_OTHER_SITE VALUES(06, 02, '교보문고', 14500);
INSERT INTO TB_OTHER_SITE VALUES(07, 02, 'YES24', 14500);
INSERT INTO TB_OTHER_SITE VALUES(08, 02, '알라딘', 14500);
INSERT INTO TB_OTHER_SITE VALUES(09, 02, '영품문고', 14500);
INSERT INTO TB_OTHER_SITE VALUES(10, 02, '인터파크', 14500);

INSERT INTO TB_OTHER_SITE VALUES(11, 03, '교보문고', 10800);
INSERT INTO TB_OTHER_SITE VALUES(12, 03, 'YES24', 10800);
INSERT INTO TB_OTHER_SITE VALUES(13, 03, '알라딘', 10800);
INSERT INTO TB_OTHER_SITE VALUES(14, 03, '영품문고', 10800);
INSERT INTO TB_OTHER_SITE VALUES(15, 03, '인터파크', 10800);

INSERT INTO TB_OTHER_SITE VALUES(26, 06, '교보문고', 14500);
INSERT INTO TB_OTHER_SITE VALUES(27, 06, 'YES24', 14500);
INSERT INTO TB_OTHER_SITE VALUES(28, 06, '알라딘', 14500);
INSERT INTO TB_OTHER_SITE VALUES(29, 06, '영품문고', 14500);
INSERT INTO TB_OTHER_SITE VALUES(30, 06, '인터파크', 14500);

INSERT INTO TB_OTHER_SITE VALUES(31, 07, '교보문고', 14500);
INSERT INTO TB_OTHER_SITE VALUES(32, 07, 'YES24', 14500);
INSERT INTO TB_OTHER_SITE VALUES(33, 07, '알라딘', 14500);
INSERT INTO TB_OTHER_SITE VALUES(34, 07, '영품문고', 14500);
INSERT INTO TB_OTHER_SITE VALUES(35, 07, '인터파크', 14500);

INSERT INTO TB_OTHER_SITE VALUES(36, 08, '교보문고', 13500);
INSERT INTO TB_OTHER_SITE VALUES(37, 08, 'YES24', 13500);
INSERT INTO TB_OTHER_SITE VALUES(38, 08, '알라딘', 13200);
INSERT INTO TB_OTHER_SITE VALUES(39, 08, '영품문고', 13500);
INSERT INTO TB_OTHER_SITE VALUES(40, 08, '인터파크', 13500);

INSERT INTO TB_OTHER_SITE VALUES(41, 09, '교보문고', 13000);
INSERT INTO TB_OTHER_SITE VALUES(42, 09, 'YES24', 13000);
INSERT INTO TB_OTHER_SITE VALUES(43, 09, '알라딘', 13000);
INSERT INTO TB_OTHER_SITE VALUES(44, 09, '영품문고', 13300);
INSERT INTO TB_OTHER_SITE VALUES(45, 09, '인터파크', 13000);

INSERT INTO TB_OTHER_SITE VALUES(46, 10, '교보문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(47, 10, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(48, 10, '알라딘', 12800);
INSERT INTO TB_OTHER_SITE VALUES(49, 10, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(50, 10, '인터파크', 12800);

INSERT INTO TB_OTHER_SITE VALUES(51, 11, '교보문고', 12900);
INSERT INTO TB_OTHER_SITE VALUES(52, 11, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(53, 11, '알라딘', 12900);
INSERT INTO TB_OTHER_SITE VALUES(54, 11, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(55, 11, '인터파크', 12800);

INSERT INTO TB_OTHER_SITE VALUES(56, 12, '교보문고', 13900);
INSERT INTO TB_OTHER_SITE VALUES(57, 12, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(58, 12, '알라딘', 13900);
INSERT INTO TB_OTHER_SITE VALUES(59, 12, '영품문고', 13800);
INSERT INTO TB_OTHER_SITE VALUES(60, 12, '인터파크', 13600);

INSERT INTO TB_OTHER_SITE VALUES(61, 13, '교보문고', 12600);
INSERT INTO TB_OTHER_SITE VALUES(62, 13, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(63, 13, '알라딘', 12900);
INSERT INTO TB_OTHER_SITE VALUES(64, 13, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(65, 13, '인터파크', 12600);

INSERT INTO TB_OTHER_SITE VALUES(66, 14, '교보문고', 12600);
INSERT INTO TB_OTHER_SITE VALUES(67, 14, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(68, 14, '알라딘', 12900);
INSERT INTO TB_OTHER_SITE VALUES(69, 14, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(70, 14, '인터파크', 12600);

INSERT INTO TB_OTHER_SITE VALUES(71, 15, '교보문고', 12600);
INSERT INTO TB_OTHER_SITE VALUES(72, 15, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(73, 15, '알라딘', 12900);
INSERT INTO TB_OTHER_SITE VALUES(74, 15, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(75, 15, '인터파크', 12600);

INSERT INTO TB_OTHER_SITE VALUES(76, 48, '교보문고', 12600);
INSERT INTO TB_OTHER_SITE VALUES(77, 48, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(78, 48, '알라딘', 12900);
INSERT INTO TB_OTHER_SITE VALUES(79, 48, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(80, 48, '인터파크', 12600);

INSERT INTO TB_OTHER_SITE VALUES(81, 49, '교보문고', 13900);
INSERT INTO TB_OTHER_SITE VALUES(82, 49, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(83, 49, '알라딘', 13900);
INSERT INTO TB_OTHER_SITE VALUES(84, 49, '영품문고', 13800);
INSERT INTO TB_OTHER_SITE VALUES(85, 49, '인터파크', 13600);

INSERT INTO TB_OTHER_SITE VALUES(86, 50, '교보문고', 13900);
INSERT INTO TB_OTHER_SITE VALUES(87, 50, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(88, 50, '알라딘', 13900);
INSERT INTO TB_OTHER_SITE VALUES(89, 50, '영품문고', 13800);
INSERT INTO TB_OTHER_SITE VALUES(90, 50, '인터파크', 13600);

INSERT INTO TB_OTHER_SITE VALUES(91, 51, '교보문고', 12900);
INSERT INTO TB_OTHER_SITE VALUES(92, 51, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(93, 51, '알라딘', 12900);
INSERT INTO TB_OTHER_SITE VALUES(94, 51, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(95, 51, '인터파크', 12800);

INSERT INTO TB_OTHER_SITE VALUES(96, 52, '교보문고', 12600);
INSERT INTO TB_OTHER_SITE VALUES(97, 52, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(98, 52, '알라딘', 12900);
INSERT INTO TB_OTHER_SITE VALUES(99, 52, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(100, 52, '인터파크', 12600);

INSERT INTO TB_OTHER_SITE VALUES(101, 53, '교보문고', 13900);
INSERT INTO TB_OTHER_SITE VALUES(102, 53, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(103, 53, '알라딘', 13900);
INSERT INTO TB_OTHER_SITE VALUES(104, 53, '영품문고', 13800);
INSERT INTO TB_OTHER_SITE VALUES(105, 53, '인터파크', 13600);

INSERT INTO TB_OTHER_SITE VALUES(106, 54, '교보문고', 13900);
INSERT INTO TB_OTHER_SITE VALUES(107, 54, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(108, 54, '알라딘', 13900);
INSERT INTO TB_OTHER_SITE VALUES(109, 54, '영품문고', 13800);
INSERT INTO TB_OTHER_SITE VALUES(110, 54, '인터파크', 13600);

INSERT INTO TB_OTHER_SITE VALUES(111, 55, '교보문고', 12900);
INSERT INTO TB_OTHER_SITE VALUES(112, 55, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(113, 55, '알라딘', 12900);
INSERT INTO TB_OTHER_SITE VALUES(114, 55, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(115, 55, '인터파크', 12800);

INSERT INTO TB_OTHER_SITE VALUES(116, 56, '교보문고', 13500);
INSERT INTO TB_OTHER_SITE VALUES(117, 56, 'YES24', 13500);
INSERT INTO TB_OTHER_SITE VALUES(118, 56, '알라딘', 13200);
INSERT INTO TB_OTHER_SITE VALUES(119, 56, '영품문고', 13500);
INSERT INTO TB_OTHER_SITE VALUES(120, 56, '인터파크', 13500);

INSERT INTO TB_OTHER_SITE VALUES(121, 57, '교보문고', 13000);
INSERT INTO TB_OTHER_SITE VALUES(122, 57, 'YES24', 13000);
INSERT INTO TB_OTHER_SITE VALUES(123, 57, '알라딘', 13000);
INSERT INTO TB_OTHER_SITE VALUES(124, 57, '영품문고', 13300);
INSERT INTO TB_OTHER_SITE VALUES(125, 57, '인터파크', 13000);

INSERT INTO TB_OTHER_SITE VALUES(126, 58, '교보문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(127, 58, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(128, 58, '알라딘', 12800);
INSERT INTO TB_OTHER_SITE VALUES(129, 58, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(130, 58, '인터파크', 12800);

INSERT INTO TB_OTHER_SITE VALUES(131, 59, '교보문고', 12900);
INSERT INTO TB_OTHER_SITE VALUES(132, 59, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(133, 59, '알라딘', 12900);
INSERT INTO TB_OTHER_SITE VALUES(134, 59, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(135, 59, '인터파크', 12800);

INSERT INTO TB_OTHER_SITE VALUES(136, 60, '교보문고', 13900);
INSERT INTO TB_OTHER_SITE VALUES(137, 60, 'YES24', 13800);
INSERT INTO TB_OTHER_SITE VALUES(138, 60, '알라딘', 13900);
INSERT INTO TB_OTHER_SITE VALUES(139, 60, '영품문고', 13800);
INSERT INTO TB_OTHER_SITE VALUES(140, 60, '인터파크', 13600);

INSERT INTO TB_OTHER_SITE VALUES(141, 61, '교보문고', 12600);
INSERT INTO TB_OTHER_SITE VALUES(142, 61, 'YES24', 12800);
INSERT INTO TB_OTHER_SITE VALUES(143, 61, '알라딘', 12900);
INSERT INTO TB_OTHER_SITE VALUES(144, 61, '영품문고', 12800);
INSERT INTO TB_OTHER_SITE VALUES(145, 61, '인터파크', 12600);


-- TB_REVIEW SAMPLE DATA
INSERT INTO TB_REVIEW VALUES(1, 'user01', 01, '리뷰제목1', sysdate, sysdate, null, null, '리뷰내용1.', 10, '밝은');
INSERT INTO TB_REVIEW VALUES(2, 'user02', 02, '리뷰제목2', sysdate, sysdate, null, null, '리뷰내용2', 5, '키워드');
INSERT INTO TB_REVIEW VALUES(3, 'user03', 03, '리뷰제목3', sysdate, sysdate, null, null, '리뷰내용3', 4, '키워드');
INSERT INTO TB_REVIEW VALUES(4, 'user04', 04, '리뷰제목4', sysdate, sysdate, null, null, '리뷰내용4', 2, '키워드');
INSERT INTO TB_REVIEW VALUES(5, 'user02', 05, '리뷰제목5', sysdate, sysdate, null, null, '리뷰내용5', 3, '키워드');
INSERT INTO TB_REVIEW VALUES(6, 'user01', 06, '리뷰제목6', sysdate, sysdate, null, null, '리뷰내용6', 7, '키워드');
INSERT INTO TB_REVIEW VALUES(7, 'user04', 07, '리뷰제목7', sysdate, sysdate, null, null, '리뷰내용7', 8, '키워드');
INSERT INTO TB_REVIEW VALUES(8, 'user02', 08, '리뷰제목8', sysdate, sysdate, null, null, '리뷰내용8', 5, '키워드');
INSERT INTO TB_REVIEW VALUES(9, 'user01', 09, '리뷰제목9', sysdate, sysdate, null, null, '리뷰내용9', 4, '키워드');
INSERT INTO TB_REVIEW VALUES(10, 'user04', 10, '리뷰제목10', sysdate, sysdate, null, null, '리뷰내용10', 6, '키워드');
INSERT INTO TB_REVIEW VALUES(11, 'user03', 11, '리뷰제목11', sysdate, sysdate, null, null, '리뷰내용11', 3, '키워드');
INSERT INTO TB_REVIEW VALUES(12, 'user02', 12, '리뷰제목12', sysdate, sysdate, null, null, '리뷰내용12', 9, '키워드');

INSERT INTO TB_REVIEW VALUES(13, 'user01', 12, '리뷰제목13', sysdate, sysdate, null, null, '리뷰내용13.', 10, '밝은');
INSERT INTO TB_REVIEW VALUES(14, 'user02', 47, '리뷰제목14', sysdate, sysdate, null, null, '리뷰내용14', 5, '키워드');
INSERT INTO TB_REVIEW VALUES(15, 'user03', 48, '리뷰제목15', sysdate, sysdate, null, null, '리뷰내용15', 4, '키워드');
INSERT INTO TB_REVIEW VALUES(16, 'user04', 49, '리뷰제목16', sysdate, sysdate, null, null, '리뷰내용16', 2, '키워드');
INSERT INTO TB_REVIEW VALUES(17, 'user04', 51, '리뷰제목17', sysdate, sysdate, null, null, '리뷰내용17', 3, '키워드');
INSERT INTO TB_REVIEW VALUES(18, 'user03', 50, '리뷰제목18', sysdate, sysdate, null, null, '리뷰내용18', 7, '키워드');
INSERT INTO TB_REVIEW VALUES(19, 'user02', 52, '리뷰제목19', sysdate, sysdate, null, null, '리뷰내용19', 8, '키워드');
INSERT INTO TB_REVIEW VALUES(20, 'user01', 53, '리뷰제목20', sysdate, sysdate, null, null, '리뷰내용20', 5, '키워드');
INSERT INTO TB_REVIEW VALUES(21, 'user01', 04, '리뷰제목21', sysdate, sysdate, null, null, '리뷰내용21', 4, '키워드');
INSERT INTO TB_REVIEW VALUES(22, 'user02', 03, '리뷰제목22', sysdate, sysdate, null, null, '리뷰내용22', 6, '키워드');
INSERT INTO TB_REVIEW VALUES(23, 'user01', 02, '리뷰제목23', sysdate, sysdate, null, null, '리뷰내용23', 3, '키워드');
INSERT INTO TB_REVIEW VALUES(24, 'user02', 01, '리뷰제목24', sysdate, sysdate, null, null, '리뷰내용24', 9, '키워드');

INSERT INTO TB_REVIEW VALUES(49, 'user01', 13, '리뷰제목25', sysdate, sysdate, null, null, '리뷰내용25.', 10, '밝은');
INSERT INTO TB_REVIEW VALUES(50, 'user02', 14, '리뷰제목26', sysdate, sysdate, null, null, '리뷰내용26', 5, '키워드');
INSERT INTO TB_REVIEW VALUES(51, 'user03', 15, '리뷰제목27', sysdate, sysdate, null, null, '리뷰내용27', 4, '키워드');
INSERT INTO TB_REVIEW VALUES(52, 'user04', 16, '리뷰제목28', sysdate, sysdate, null, null, '리뷰내용28', 2, '키워드');
INSERT INTO TB_REVIEW VALUES(53, 'user03', 17, '리뷰제목29', sysdate, sysdate, null, null, '리뷰내용29', 3, '키워드');
INSERT INTO TB_REVIEW VALUES(54, 'user03', 18, '리뷰제목30', sysdate, sysdate, null, null, '리뷰내용30', 7, '키워드');
INSERT INTO TB_REVIEW VALUES(55, 'user03', 19, '리뷰제목31', sysdate, sysdate, null, null, '리뷰내용31', 8, '키워드');
INSERT INTO TB_REVIEW VALUES(56, 'user04', 20, '리뷰제목32', sysdate, sysdate, null, null, '리뷰내용32', 5, '키워드');
INSERT INTO TB_REVIEW VALUES(57, 'user04', 21, '리뷰제목33', sysdate, sysdate, null, null, '리뷰내용33', 4, '키워드');
INSERT INTO TB_REVIEW VALUES(58, 'user04', 22, '리뷰제목34', sysdate, sysdate, null, null, '리뷰내용34', 6, '키워드');
INSERT INTO TB_REVIEW VALUES(59, 'user04', 23, '리뷰제목35', sysdate, sysdate, null, null, '리뷰내용35', 3, '키워드');
INSERT INTO TB_REVIEW VALUES(60, 'user03', 24, '리뷰제목36', sysdate, sysdate, null, null, '리뷰내용35', 9, '키워드');

INSERT INTO TB_REVIEW VALUES(61, 'user01', 24, '리뷰제목37', sysdate, sysdate, null, null, '리뷰내용37.', 10, '밝은');
INSERT INTO TB_REVIEW VALUES(62, 'user02', 23, '리뷰제목38', sysdate, sysdate, null, null, '리뷰내용38', 5, '키워드');
INSERT INTO TB_REVIEW VALUES(63, 'user03', 22, '리뷰제목39', sysdate, sysdate, null, null, '리뷰내용39', 4, '키워드');
INSERT INTO TB_REVIEW VALUES(64, 'user04', 21, '리뷰제목40', sysdate, sysdate, null, null, '리뷰내용40', 2, '키워드');
INSERT INTO TB_REVIEW VALUES(65, 'user01', 60, '리뷰제목41', sysdate, sysdate, null, null, '리뷰내용41', 3, '키워드');
INSERT INTO TB_REVIEW VALUES(66, 'user01', 61, '리뷰제목42', sysdate, sysdate, null, null, '리뷰내용42', 7, '키워드');
INSERT INTO TB_REVIEW VALUES(67, 'user02', 59, '리뷰제목43', sysdate, sysdate, null, null, '리뷰내용43', 8, '키워드');
INSERT INTO TB_REVIEW VALUES(68, 'user02', 58, '리뷰제목44', sysdate, sysdate, null, null, '리뷰내용44', 5, '키워드');
INSERT INTO TB_REVIEW VALUES(69, 'user03', 55, '리뷰제목45', sysdate, sysdate, null, null, '리뷰내용45', 4, '키워드');
INSERT INTO TB_REVIEW VALUES(70, 'user01', 56, '리뷰제목46', sysdate, sysdate, null, null, '리뷰내용46', 6, '키워드');
INSERT INTO TB_REVIEW VALUES(71, 'user03', 56, '리뷰제목47', sysdate, sysdate, null, null, '리뷰내용47', 3, '키워드');
INSERT INTO TB_REVIEW VALUES(72, 'user04', 54, '리뷰제목48', sysdate, sysdate, null, null, '리뷰내용48', 9, '키워드');


-- TB_SALETYPE SAMPLE DATA
INSERT INTO TB_SALETYPE VALUES (1, '경매');
INSERT INTO TB_SALETYPE VALUES (2, '일반');


-- TB_USED_AUCTION SAMPLE DATA
INSERT INTO TB_USED_AUCTION VALUES(1, 1, 'user01', 1, 5400, 12, 6200, 'user02', '21/07/21', '21/08/10', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(2, 1, 'user03', 2, 2100, 4, 2700, 'user01', '21/07/24', '21/08/10', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_AUCTION VALUES(3, 1, 'user02', 3, 3800, 7, 5200, 'user03', '21/07/25', '21/08/13', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_AUCTION VALUES(4, 1, 'user04', 4, 3500, 26, 6300, 'user04', SYSDATE, '21/08/13', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(5, 1, 'user01', 5, 5300, 6, 6100, 'user02', SYSDATE, '21/08/14', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_AUCTION VALUES(6, 1, 'user02', 6, 6700, 19, 9820, 'user03', SYSDATE, '21/08/18', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_AUCTION VALUES(7, 1, 'user03', 7, 5800, 31, 10830, 'user05', SYSDATE, '21/08/19', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_AUCTION VALUES(8, 1, 'user05', 8, 3100, 3, 4100, 'user06', SYSDATE, '21/08/20', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_AUCTION VALUES(9, 1, 'user06', 9, 4200, 4, 5100, 'user07', SYSDATE, '21/08/20', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(10, 1, 'user07', 10, 3500, 2, 4300, 'user02', SYSDATE, '21/08/21', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_AUCTION VALUES(11, 1, 'user06', 11, 3800, 8, 7100, 'user03', SYSDATE, '21/08/24', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_AUCTION VALUES(12, 1, 'user05', 12, 4300, 3, 5100, 'user01', SYSDATE, '21/08/24', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_AUCTION VALUES(13, 1, 'user07', 13, 2800, 2, 3200, 'user03', SYSDATE, '21/08/26', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(14, 1, 'user06', 14, 9100, 4, 10200, 'user04', SYSDATE, '21/08/26', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_AUCTION VALUES(15, 1, 'user05', 15, 2600, 5, 4300, 'user06', SYSDATE, '21/08/28', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_AUCTION VALUES(16, 1, 'user06', 16, 6500, 1, 6600, 'user04', SYSDATE, '21/08/28', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_AUCTION VALUES(17, 1, 'user05', 17, 6300, 6, 8800, 'user07', SYSDATE, '21/08/29', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(18, 1, 'user07', 18, 2700, 7, 6300, 'user05', SYSDATE, '21/08/29', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_AUCTION VALUES(19, 1, 'user07', 19, 2800, 0, 2800, 'user04', SYSDATE, '21/08/30', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_AUCTION VALUES(20, 1, 'user05', 20, 3400, 9, 8200, 'user06', SYSDATE, '21/08/30', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_AUCTION VALUES(21, 1, 'user07', 21, 3800, 8, 6100, 'user05', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(22, 1, 'user06', 22, 4200, 2, 4800, 'user07', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_AUCTION VALUES(23, 1, 'user03', 23, 4600, 3, 5100, 'user02', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'B');

INSERT INTO TB_USED_AUCTION VALUES(24, 1, 'user01', 24, 5400, 12, 6200, 'user02', '21/07/21', '21/08/10', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(25, 1, 'user03', 25, 2100, 4, 2700, 'user01', '21/07/24', '21/08/10', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_AUCTION VALUES(26, 1, 'user02', 26, 3800, 7, 5200, 'user03', '21/07/25', '21/08/13', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_AUCTION VALUES(27, 1, 'user04', 27, 3500, 26, 6300, 'user04', SYSDATE, '21/08/13', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(28, 1, 'user01', 28, 5300, 6, 6100, 'user02', SYSDATE, '21/08/14', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_AUCTION VALUES(29, 1, 'user02', 29, 6700, 19, 9820, 'user03', SYSDATE, '21/08/18', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(30, 1, 'user03', 30, 5800, 31, 10830, 'user05', SYSDATE, '21/08/19', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_AUCTION VALUES(31, 1, 'user05', 31, 3100, 3, 4100, 'user06', SYSDATE, '21/08/20', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_AUCTION VALUES(32, 1, 'user06', 32, 4200, 4, 5100, 'user07', SYSDATE, '21/08/20', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_AUCTION VALUES(33, 1, 'user07', 33, 3500, 2, 4300, 'user02', SYSDATE, '21/08/21', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트기', 'S');
INSERT INTO TB_USED_AUCTION VALUES(34, 1, 'user06', 34, 3800, 8, 7100, 'user03', SYSDATE, '21/08/24', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_AUCTION VALUES(35, 1, 'user05', 35, 4300, 3, 5100, 'user01', SYSDATE, '21/08/24', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_AUCTION VALUES(36, 1, 'user07', 36, 2800, 2, 3200, 'user03', SYSDATE, '21/08/26', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_AUCTION VALUES(37, 1, 'user06', 37, 9100, 4, 10200, 'user04', SYSDATE, '21/08/26', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(38, 1, 'user05', 38, 2600, 5, 4300, 'user06', SYSDATE, '21/08/28', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_AUCTION VALUES(39, 1, 'user06', 39, 6500, 1, 6600, 'user04', SYSDATE, '21/08/28', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_AUCTION VALUES(40, 1, 'user05', 40, 6300, 6, 8800, 'user07', SYSDATE, '21/08/29', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_AUCTION VALUES(41, 1, 'user07', 41, 2700, 7, 6300, 'user05', SYSDATE, '21/08/29', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(42, 1, 'user07', 42, 2800, 0, 2800, 'user04', SYSDATE, '21/08/30', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_AUCTION VALUES(43, 1, 'user05', 43, 3400, 9, 8200, 'user06', SYSDATE, '21/08/30', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_AUCTION VALUES(44, 1, 'user07', 44, 3800, 8, 6100, 'user05', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_AUCTION VALUES(45, 1, 'user06', 45, 4200, 2, 4800, 'user07', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_AUCTION VALUES(46, 1, 'user03', 46, 4600, 3, 5100, 'user02', SYSDATE, '21/09/03', DEFAULT, DEFAULT, '샘플 경매 장터 소개 텍스트', 'A');


-- TB_USED_NORMAL SAMPLE DATA
INSERT INTO TB_USED_NORMAL VALUES(1, 2, 'user02', 1, 6000, '21/07/21', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_NORMAL VALUES(2, 2, 'user01', 2, 11000, '21/07/24', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_NORMAL VALUES(3, 2, 'user03', 3, 4300, '21/07/25', 3, DEFAULT, '샘플 일반 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_NORMAL VALUES(4, 2, 'user04', 4, 2500, '21/07/26', 4, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(5, 2, 'user03', 5, 8600, '21/07/26', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(6, 2, 'user04', 6, 5000, '21/07/28', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_NORMAL VALUES(7, 2, 'user01', 7, 9200, '21/07/29', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_NORMAL VALUES(8, 2, 'user02', 8, 2400, '21/07/30', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(9, 2, 'user05', 9, 3500, '21/08/02', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_NORMAL VALUES(10, 2, 'user06', 10, 6200, '21/08/02', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_NORMAL VALUES(11, 2, 'user07', 11, 5300, '21/08/03', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_NORMAL VALUES(12, 2, 'user05', 12, 2500, '21/08/03', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_NORMAL VALUES(13, 2, 'user06', 13, 3400, '21/08/04', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(14, 2, 'user06', 14, 5700, '21/08/05', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(15, 2, 'user07', 15, 5300, '21/08/05', 3, DEFAULT, '샘플 일반 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_NORMAL VALUES(16, 2, 'user05', 16, 4300, DEFAULT, 3, DEFAULT, '샘플 일반 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_NORMAL VALUES(17, 2, 'user07', 17, 4700, DEFAULT, 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(18, 2, 'user06', 18, 4200, DEFAULT, 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_NORMAL VALUES(19, 2, 'user05', 19, 4500, DEFAULT, 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(20, 2, 'user04', 20, 5100, DEFAULT, 3, DEFAULT, '샘플 일반 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_NORMAL VALUES(21, 2, 'user05', 21, 5300, DEFAULT, 3, DEFAULT, '샘플 일반 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_NORMAL VALUES(22, 2, 'user06', 22, 3800, DEFAULT, 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(23, 2, 'user07', 23, 3200, DEFAULT, 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'C');

INSERT INTO TB_USED_NORMAL VALUES(24, 2, 'user02', 24, 6000, '21/07/21', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_NORMAL VALUES(25, 2, 'user01', 25, 11000, '21/07/24', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_NORMAL VALUES(26, 2, 'user03', 26, 4300, '21/07/25', 3, DEFAULT, '샘플 일반 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_NORMAL VALUES(27, 2, 'user04', 27, 2500, '21/07/26', 4, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(28, 2, 'user03', 28, 8600, '21/07/26', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(29, 2, 'user04', 29, 5000, '21/07/28', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_NORMAL VALUES(30, 2, 'user01', 30, 9200, '21/07/29', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_NORMAL VALUES(31, 2, 'user02', 31, 2400, '21/07/30', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(32, 2, 'user05', 32, 3500, '21/08/02', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_NORMAL VALUES(33, 2, 'user06', 33, 6200, '21/08/02', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_NORMAL VALUES(34, 2, 'user07', 34, 5300, '21/08/03', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_NORMAL VALUES(35, 2, 'user05', 35, 2500, '21/08/03', 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_NORMAL VALUES(36, 2, 'user06', 36, 3400, '21/08/04', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(37, 2, 'user06', 37, 5700, '21/08/05', 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(38, 2, 'user07', 38, 5300, '21/08/05', 3, DEFAULT, '샘플 일반 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_NORMAL VALUES(39, 2, 'user05', 39, 4300, DEFAULT, 3, DEFAULT, '샘플 일반 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_NORMAL VALUES(40, 2, 'user07', 40, 4700, DEFAULT, 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(41, 2, 'user06', 41, 4200, DEFAULT, 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'C');
INSERT INTO TB_USED_NORMAL VALUES(42, 2, 'user05', 42, 4500, DEFAULT, 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(43, 2, 'user04', 43, 5100, DEFAULT, 3, DEFAULT, '샘플 일반 장터 소개 텍스트', 'A');
INSERT INTO TB_USED_NORMAL VALUES(44, 2, 'user05', 44, 5300, DEFAULT, 3, DEFAULT, '샘플 일반 장터 소개 텍스트', 'S');
INSERT INTO TB_USED_NORMAL VALUES(45, 2, 'user06', 45, 3800, DEFAULT, 2, DEFAULT, '샘플 일반 장터 소개 텍스트', 'B');
INSERT INTO TB_USED_NORMAL VALUES(46, 2, 'user07', 46, 3200, DEFAULT, 1, DEFAULT, '샘플 일반 장터 소개 텍스트', 'C');


-- TB_NOTICE SAMPLE DATA
INSERT INTO TB_NOTICE VALUES (1, 'admin01', '샘플1', NULL, NULL, '안녕하세요1', '전체공지', DEFAULT, NULL, 53);
INSERT INTO TB_NOTICE VALUES (2, 'admin01', '샘플2', NULL, NULL, '안녕하세요2', '전체공지', DEFAULT, NULL, 28);
INSERT INTO TB_NOTICE VALUES (3, 'admin01', '샘플3', NULL, NULL, '안녕하세요3', '전체공지', DEFAULT, NULL, 67);
INSERT INTO TB_NOTICE VALUES (4, 'admin01', '샘플4', NULL, NULL, '안녕하세요4', '전체공지', DEFAULT, NULL, 42);
INSERT INTO TB_NOTICE VALUES (5, 'admin01', '샘플5', NULL, NULL, '안녕하세요5', '전체공지', DEFAULT, NULL, 150);
INSERT INTO TB_NOTICE VALUES (6, 'admin01', '샘플6', NULL, NULL, '안녕하세요6', '전체공지', DEFAULT, NULL, 19);
INSERT INTO TB_NOTICE VALUES (7, 'admin01', '샘플7', NULL, NULL, '안녕하세요7', '전체공지', DEFAULT, NULL, 80);
INSERT INTO TB_NOTICE VALUES (8, 'admin01', '샘플8', NULL, NULL, '안녕하세요8', '전체공지', DEFAULT, NULL, 72);
INSERT INTO TB_NOTICE VALUES (9, 'admin01', '샘플9', NULL, NULL, '안녕하세요9', '전체공지', DEFAULT, NULL, 15);
INSERT INTO TB_NOTICE VALUES (10, 'admin01', '샘플10', NULL, NULL, '안녕하세요10', '전체공지', DEFAULT, NULL, 64);
INSERT INTO TB_NOTICE VALUES (11, 'admin01', '샘플11', NULL, NULL, '안녕하세요11', '전체공지', DEFAULT, NULL, 15);


-- TB_ASK SAMPLE DATA
INSERT INTO TB_ASK VALUES (1, 'user01', '상품문의',  '안녕하세요1', '샘플입니다1.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (2, 'user02', '상품문의',  '안녕하세요2', '샘플입니다2.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (3, 'user03', '상품문의',  '안녕하세요3', '샘플입니다3.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (4, 'user02', '상품문의',  '안녕하세요4', '샘플입니다4.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (5, 'user01', '상품문의',  '안녕하세요5', '샘플입니다5.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (6, 'user04', '상품문의',  '안녕하세요6', '샘플입니다6.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (7, 'user03', '상품문의',  '안녕하세요7', '샘플입니다7.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (8, 'user02', '상품문의',  '안녕하세요8', '샘플입니다8.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (9, 'user04', '상품문의',  '안녕하세요9', '샘플입니다9.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (10, 'user03', '상품문의',  '안녕하세요10', '샘플입니다10.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (11, 'user01', '상품문의',  '안녕하세요11', '샘플입니다11.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);
INSERT INTO TB_ASK VALUES (12, 'user02', '상품문의',  '안녕하세요12', '샘플입니다12.', 'N', NULL, NULL, NULL, NULL, SYSDATE, NULL);

commit;