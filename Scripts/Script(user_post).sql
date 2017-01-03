-- 우편번호
DROP TABLE IF EXISTS POST.post RESTRICT;

-- 우편변호
DROP SCHEMA IF EXISTS POST;

-- 우편변호
CREATE SCHEMA POST;

-- 우편번호
CREATE TABLE POST.post (
	zipcode   CHAR(5)     NULL, -- 우편번호
	sido      VARCHAR(20) NULL, -- 시도
	sigungu   VARCHAR(20) NULL, -- 시군구
	doro      VARCHAR(80) NULL, -- 도로
	building1 INT(5)      NULL, -- 건물번호1
	building2 INT(5)      NULL  -- 건물번호2
);

-- 우편번호 인덱스01
CREATE INDEX idx_post_sido
	ON POST.post( -- 우편번호
		sido ASC -- 시도
	);

-- 우편번호 인덱스02
CREATE INDEX idx_post_doro
	ON POST.post( -- 우편번호
		doro ASC -- 도로
	);
	
-- database 생성 -----------------------------------------------------------------

load data local infile 'C:/Users/sspc/Desktop/DataFiles/강원도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/경기도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/경상남도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/경상북도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/광주광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/대구광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/대전광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/부산광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/서울특별시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/세종특별자치시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/울산광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/인천광역시.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/전라남도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/전라북도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/제주특별자치도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/충청남도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

load data local infile 'C:/Users/sspc/Desktop/DataFiles/충청북도.txt' into table post
character set 'euckr' fields terminated by '|' ignore 1 lines
(@zipcode, @sido, @d, @sigungu, @d, @d,@d, @d,@doro, @d, @d, @building1, @building2, @d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d, @d,@d)
set zipcode=@zipcode, sido=@sido, sigungu=@sigungu, doro=@doro, building1=@building1, building2 = @building2;

select * from post;

select zipcode, sido, sigungu, doro, building1, building2 from post where sido="강원도" and doro like "언덕%";

select sido from post group by sido;

-- 인덱스는 자료 입력이 완료 된 후 만드는 게 더 유리할 듯

-- 우편번호 인덱스01
CREATE INDEX idx_post_sido
	ON POST.post( -- 우편번호
		sido ASC -- 시도
	);

-- 우편번호 인덱스02
CREATE INDEX idx_post_doro
	ON POST.post( -- 우편번호
		doro ASC -- 도로
	);
	
	select * from post where sido like '세종%';
	
	select distinct sido from post;