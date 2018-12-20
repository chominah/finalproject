# finalproject
## 박주형
> 폴더 설정
<pre>
1. Mapper : FeedBackMapper.xml 추가
2. dao : AdminDao.java 추가
3. Controller
 1) FeedBackController.java 추가
 2) FeedBackRestController.java 추가
4. WebContent/resources/upload 폴더 생성(이력서&포트폴리오 파일을 올려서 저장해둘 폴더)
5. WeB-INF/spring/sub : sub-pjh.xml 추가
6. views
 1) Edu_Company_wirte.jsp
 2) Edu_Company.jsp
 3) Edu_Resume.jsp
 </pre>
 > 내용
 <pre>
 1. 학생관리_이력서&포트폴리오 피드백
  - 이력서&포트폴리오 피드백 요청이 들어온 학생들의 정보 View(학생이름, 이메일, 폰 번호, 강좌이름, 기수)
  - 학생의 정보를 누르게 되면 해당 학생에 대한 이력서&포트폴리오 리스트 View(이력서&포트폴리오 파일명, 입력일, 파일 다운로드, 파일 업로드)
 2. 학생관리_관심기업 피드백
  - 관심기업에 대한 피드백 요청이 들어온 학생들의 정보 View(피드백 요청 날짜, 기업이름, 강좌이름, 기수, 학생이름)
  - 학생의 정보를 누르게 되면 오른쪽 피드백 요청내용 화면에 요청사항에 대한 내용이 간략하게 보여진다.
  - 피드백 요청 내용에 대한 상세보기를 클릭하게 되면 요청사항에 대한 내용이 뜨게 되고 그 내용에 대해 
    글을 재 업로드 하는 형식으로 피드백을 할 수 있게 만듦
 </pre>
 > tiles 설정
<pre>
 1. WEB-INF/tiles : tiles-definitions.xml
 2. WEB-INF/template/default
  1) footer.jsp
  2) header.jsp
  3) menu.jsp
  4) template.jsp
  
</pre>
 * **menu.jsp** 부분에 링크 넣어주시면 됩니다~
 >> 예시
 ```html
 <ul>
  <li><a href="resume">이력서&포트폴리오 관리</a></li>
  <li><a href="company">관심기업 관리</a></li>
 </ul>
```
>> 결과화면
<pre><div><ul><li><a href="resume">이력서&포트폴리오 관리</a></li>
<li><a href="company">관심기업 관리</a></li></ul></div></pre>

## 김윤재
<pre>
1. Mappler : jobinfo.xml
2. dao : jobSearchDao.java
3. controller : DefaultController.java
                EmailController.java
                EmplymentController.java

4. src/myinfo.properties : 이메일 계정/비밀번호

5. views : list.jsp
           list2.jsp
           kTotalList.jsp
           cTotalList.jsp
           jobinfo.jsp
           email.jsp
           index.jsp

 내용)
1) index 초기화면엔 두 가지 주제로 기업을 조회할 수 있다. 첫번째로 나의 관심 키워드를
    항목에서 선택하여 기업리스트를 검색하여 볼 수 있고, 두번째로는 개설된 강좌를 선택하여
    관련 기업을 검색할 수 있다

2) 검색하여 나온 기업리스트는 처음엔 간략한 리스트로 나오게 되는데 "더보기" 버튼을 클릭하면
   전체 리스트를 볼 수 있다.

3) 전체리스트에서 기업마다 상세보기 버튼이 있고 버튼을 누르면 기업정보를 볼 수 있는 페이지로 이동

4) 기업정보페이지에서는 그 기업에 해당 링크를 걸어 홈페이지로 이동이 가능하고 대표자에게 이메일을
   전송할 수 있는 기능이 있고 파일을 첨부할 수 있는 기능도 추가할 예정이다
</pre>

# DB DDL
<pre>
2018.12.13
1차 모듈 완성 후 DB테이블 

/* 학생 정보 */
CREATE TABLE student (
   snum NUMBER(3) NOT NULL, /* 학생번호 */
   sname VARCHAR2(24), /* 이름 */
   sbirth DATE, /* 생년월일 */
   smail VARCHAR2(50), /* 이메일 */
   saddr VARCHAR2(128), /* 주소 */
   sphone VARCHAR2(50), /* 연락처 */
   smajor VARCHAR2(9), /* 전공/비전공 */
   sgender VARCHAR2(6), /* 성별 */
   cnum NUMBER(5), /* 강의번호 */
   scert NUMBER(3), /* 자격증번호 */
   keyword VARCHAR2(256), /* 키워드 */
  /* groupno NUMBER(3),  그룹 번호 */
   sid VARCHAR2(36), /* 아이디 */
   spwd VARCHAR2(36), /* 비밀번호 */
   rolnum NUMBER(3) /* 새 컬럼 */
);

create table stgroup(
snum number(3),
groupno number(3),
groupname varchar2(64),
constraint stgroup_fk_snum foreign key(snum)
references student(snum)
);

create table inclination(
innum number(8),
snum number(3),
infile varchar2(256),
ingrade varchar2(36)
);

CREATE UNIQUE INDEX pk_student
   ON student (
      snum ASC
   );

CREATE UNIQUE INDEX uk_student
   ON student (
      sid ASC
   );

ALTER TABLE student
   ADD
      CONSTRAINT pk_student
      PRIMARY KEY (
         snum
      );

ALTER TABLE student
   ADD
      CONSTRAINT UK_student
      UNIQUE (
         sid
      );

/* 이력서&포트폴리오 */
CREATE TABLE resume (
   rnum NUMBER(7) NOT NULL, /* 이력서번호 */
   snum NUMBER(3), /* 학생번호 */
   rfile VARCHAR2(256), /* 파일이름 */
   rdate DATE, /* 업로드날짜 */
   rcnum number(1) /*이력서, 포트폴리오 구분 넘버*/
);

CREATE UNIQUE INDEX PK_resume
   ON resume (
      rnum ASC
   );

ALTER TABLE resume
   ADD
      CONSTRAINT PK_resume
      PRIMARY KEY (
         rnum
      );

/* 채팅 */
CREATE TABLE chat (
   chnum NUMBER(8) NOT NULL, /* 채팅번호 */
   chfile VARCHAR2(256), /* 채팅파일 */
   chdate DATE, /* 날짜 */
   groupno NUMBER(3) /* 그룹번호 */
);


CREATE UNIQUE INDEX PK_chat
   ON chat (
      chnum ASC
   );

ALTER TABLE chat
   ADD
      CONSTRAINT PK_chat
      PRIMARY KEY (
         chnum
      );

/* 학생게시판 */
CREATE TABLE sboard (
   bnum NUMBER(5) NOT NULL, /* 게시판 번호 */
   snum NUMBER(3), /* 학생번호 */
   btitle VARCHAR2(64), /* 제목 */
   bdate DATE, /* 날짜 */
   bfile VARCHAR2(256), /* 파일 */
   bcontent CLOB, /* 내용 */
   groupno NUMBER(3) /* 그룹 번호 */
);

CREATE UNIQUE INDEX PK_sboard
   ON sboard (
      bnum ASC
   );

ALTER TABLE sboard
   ADD
      CONSTRAINT PK_sboard
      PRIMARY KEY (
         bnum
      );

/* 기업 리스트 */
CREATE TABLE cplist (
   cpnum VARCHAR2(36) NOT NULL, /* 기업번호 */
   cpname VARCHAR2(36), /* 기업이름 */
   cploc VARCHAR2(128), /* 기업위치 */
   keyword VARCHAR2(256), /* 키워드 */
   fmemo clob,
   cplink varchar2(256), /*기업 홈페이지*/
   ceomail varchar2(256) /*ceo 이메일*/
);

CREATE UNIQUE INDEX PK_cplist
   ON cplist (
      cpnum ASC
   );

ALTER TABLE cplist
   ADD
      CONSTRAINT PK_cplist
      PRIMARY KEY (
         cpnum
      );

/* 수료자 */
CREATE TABLE gstudent (
   gsnum NUMBER(5) NOT NULL, /* 수료자 번호 */
   gsordinal NUMBER(5), /* 기수 */
   gsmajor VARCHAR2(9), /* 전공여부 */
   crnum NUMBER(3) /* 자격증번호 */
);

CREATE UNIQUE INDEX PK_gstudent
   ON gstudent (
      gsnum ASC
   );

ALTER TABLE gstudent
   ADD
      CONSTRAINT PK_gstudent
      PRIMARY KEY (
         gsnum
      );

/* 강의 */
CREATE TABLE class (
   cnum NUMBER(5) NOT NULL, /* 강의번호 */
   cname VARCHAR2(50), /* 강의제목 */
   cordinal number(5), /* 기수 */
   croom NUMBER(3), /* 강의실 */
   cbegin DATE, /* 시작일 */
   cend DATE, /* 종료일 */
   tnum NUMBER(3), /* 강사번호 */
   totaldays number(5) /*총 수강일수*/
);

CREATE UNIQUE INDEX PK_class
   ON class (
      cnum ASC
   );

ALTER TABLE class
   ADD
      CONSTRAINT PK_class
      PRIMARY KEY (
         cnum
      );

/* 관심 기업 리스트 */
CREATE TABLE favlist (
   snum NUMBER(3), /* 학생번호 */
   cpnum VARCHAR2(36), /* 기업번호 */
   fmemo clob /*메모*/
);

/* 스케줄 */
CREATE TABLE schedule (
   shdate DATE, /* 날짜 */
   shname VARCHAR2(128), /* 이름 */
   shloc VARCHAR(256), /* 장소 */
   cnum NUMBER(5) /* 강의번호 */
);

/* 기업 피드백 */
CREATE TABLE cpfeed (
   cpfnum NUMBER(10) NOT NULL, /* 피드백번호 */
   snum NUMBER(3), /* 학생번호 */
   cpfcontent CLOB, /* 내용 */
   cpfdate DATE, /* 날짜 */
   cpnum VARCHAR2(36), /* 기업번호 */
   cpfmemo clob,
   cpffile varchar2(256)
);

CREATE UNIQUE INDEX PK_cpfeed
   ON cpfeed (
      cpfnum ASC
   );

ALTER TABLE cpfeed
   ADD
      CONSTRAINT PK_cpfeed
      PRIMARY KEY (
         cpfnum
      );

/* 자격증 */
CREATE TABLE cert (
   crnum NUMBER(3) NOT NULL, /* 자격증번호 */
   crname varchar2(36) /* 자격증이름 */
);

CREATE UNIQUE INDEX PK_cert
   ON cert (
      crnum ASC
   );

ALTER TABLE cert
   ADD
      CONSTRAINT PK_cert
      PRIMARY KEY (
         crnum
      );

/* 출석 */
CREATE TABLE attend (
   snum NUMBER(3), /* 학생번호 */
   attdate DATE /* 출석 */
);

/* 취업 키워드 */
CREATE TABLE jobkeyword (
   keynum NUMBER(2) NOT NULL, /* 키워드 번호 */
   keyword VARCHAR2(36) /* 키워드 */
);

CREATE UNIQUE INDEX PK_jobkeyword
   ON jobkeyword (
      keynum ASC
   );

ALTER TABLE jobkeyword
   ADD
      CONSTRAINT PK_jobkeyword
      PRIMARY KEY (
         keynum
      );

/* 관리자 */
CREATE TABLE admin (
   adnum NUMBER(3) NOT NULL, /* 관리자번호 */
   adname VARCHAR2(24), /* 이름 */
   adbirth DATE, /* 생년월일 */
   admail VARCHAR2(50), /* 이메일 */
   adaddr VARCHAR2(128), /* 주소 */
   adphone VARCHAR2(50), /* 연락처 */
   adgender VARCHAR2(6), /* 성별 */
   adid VARCHAR2(36), /* 아이디 */
   adpwd VARCHAR2(36), /* 비밀번호 */
   rolnum NUMBER(3) /* 새 컬럼 */
);

CREATE UNIQUE INDEX PK_admin
   ON admin (
      adnum ASC
   );

CREATE UNIQUE INDEX UIX_admin
   ON admin (
      adid ASC
   );

ALTER TABLE admin
   ADD
      CONSTRAINT PK_admin
      PRIMARY KEY (
         adnum
      );

ALTER TABLE admin
   ADD
      CONSTRAINT UK_admin
      UNIQUE (
         adid
      );

/* 학생로그 */
CREATE TABLE stu_logger (
   logno NUMBER(3) NOT NULL, /* 로그번호 */
   logdate DATE, /* 로그날짜 */
   rnum NUMBER(3), /* 정책번호 */
   snum NUMBER(3) /* 학생번호 */
);

CREATE UNIQUE INDEX PK_stu_logger
   ON stu_logger (
      logno ASC
   );

ALTER TABLE stu_logger
   ADD
      CONSTRAINT PK_stu_logger
      PRIMARY KEY (
         logno
      );

/* 관리자로그 */
CREATE TABLE admin_logger (
   logno NUMBER(3) NOT NULL, /* 로그번호 */
   logdate DATE, /* 로그날짜 */
   rnum NUMBER(3), /* 정책번호 */
   adnum NUMBER(3) /* 관리자번호 */
);

CREATE UNIQUE INDEX PK_admin_logger
   ON admin_logger (
      logno ASC
   );

ALTER TABLE admin_logger
   ADD
      CONSTRAINT PK_admin_logger
      PRIMARY KEY (
         logno
      );

/* 강사 */
CREATE TABLE teacher (
   tnum NUMBER(3) NOT NULL, /* 강사번호 */
   tname VARCHAR2(24), /* 이름 */
   tbirth DATE, /* 생년월일 */
   tmail VARCHAR2(50), /* 이메일 */
   taddr VARCHAR2(128), /* 주소 */
   tphone VARCHAR2(50), /* 연락처 */
   tgender VARCHAR2(6), /* 성별 */
   tid VARCHAR2(36), /* 아이디 */
   tpwd VARCHAR2(36), /* 비밀번호 */
   rolnum NUMBER(3) /* 새 컬럼 */
);

CREATE UNIQUE INDEX PK_teacher
   ON teacher (
      tnum ASC
   );

CREATE UNIQUE INDEX UIX_teacher
   ON teacher (
      tid ASC
   );

ALTER TABLE teacher
   ADD
      CONSTRAINT PK_teacher
      PRIMARY KEY (
         tnum
      );

ALTER TABLE teacher
   ADD
      CONSTRAINT UK_teacher
      UNIQUE (
         tid
      );

/* 강사로그 */
CREATE TABLE teacher_logger (
   logno NUMBER(3) NOT NULL, /* 로그번호 */
   logdate DATE, /* 로그날짜 */
   rnum NUMBER(3), /* 정책번호 */
   tnum NUMBER(3) /* 강사번호 */
);

CREATE UNIQUE INDEX PK_teacher_logger
   ON teacher_logger (
      logno ASC
   );

ALTER TABLE teacher_logger
   ADD
      CONSTRAINT PK_teacher_logger
      PRIMARY KEY (
         logno
      );

ALTER TABLE student
   ADD
      CONSTRAINT FK_class_TO_student
      FOREIGN KEY (
         cnum
      )
      REFERENCES class (
         cnum
      );

ALTER TABLE student
   ADD
      CONSTRAINT FK_cert_TO_student
      FOREIGN KEY (
         scert
      )
      REFERENCES cert (
         crnum
      );

ALTER TABLE resume
   ADD
      CONSTRAINT FK_student_TO_resume
      FOREIGN KEY (
         snum
      )
      REFERENCES student (
         snum
      );

ALTER TABLE sboard
   ADD
      CONSTRAINT FK_student_TO_sboard
      FOREIGN KEY (
         snum
      )
      REFERENCES student (
         snum
      );

ALTER TABLE gstudent
   ADD
      CONSTRAINT FK_cert_TO_gstudent
      FOREIGN KEY (
         crnum
      )
      REFERENCES cert (
         crnum
      );

ALTER TABLE class
   ADD
      CONSTRAINT FK_teacher_TO_class
      FOREIGN KEY (
         tnum
      )
      REFERENCES teacher (
         tnum
      );

ALTER TABLE favlist
   ADD
      CONSTRAINT FK_student_TO_favlist
      FOREIGN KEY (
         snum
      )
      REFERENCES student (
         snum
      );

ALTER TABLE favlist
   ADD
      CONSTRAINT FK_cplist_TO_favlist
      FOREIGN KEY (
         cpnum
      )
      REFERENCES cplist (
         cpnum
      );

ALTER TABLE schedule
   ADD
      CONSTRAINT FK_class_TO_schedule
      FOREIGN KEY (
         cnum
      )
      REFERENCES class (
         cnum
      );

ALTER TABLE cpfeed
   ADD
      CONSTRAINT FK_student_TO_cpfeed
      FOREIGN KEY (
         snum
      )
      REFERENCES student (
         snum
      );

ALTER TABLE attend
   ADD
      CONSTRAINT FK_student_TO_attend
      FOREIGN KEY (
         snum
      )
      REFERENCES student (
         snum
      );

ALTER TABLE stu_logger
   ADD
      CONSTRAINT FK_student_TO_stu_logger
      FOREIGN KEY (
         snum
      )
      REFERENCES student (
         snum
      );

ALTER TABLE admin_logger
   ADD
      CONSTRAINT FK_admin_TO_admin_logger
      FOREIGN KEY (
         adnum
      )
      REFERENCES admin (
         adnum
      );

ALTER TABLE teacher_logger
   ADD
      CONSTRAINT FK_teacher_TO_teacher_logger
      FOREIGN KEY (
         tnum
      )
      REFERENCES teacher (
         tnum
      );
        
              /* 메인게시판 */
CREATE TABLE tboard (
   tbnum number(5) NOT NULL, /* 메인게시판번호 */
   tnum NUMBER(3), /* 강사번호 */
   tbtitle VARCHAR2(64), /* 제목 */
   tbdate DATE, /* 날짜 */
   tbfile VARCHAR2(256), /* 파일 */
   tbcontent CLOB /* 내용 */
);

CREATE UNIQUE INDEX PK_tboard
   ON tboard (
      tbnum ASC
   );

ALTER TABLE tboard
   ADD
      CONSTRAINT PK_tboard
      PRIMARY KEY (
         tbnum
      );

ALTER TABLE tboard
   ADD
      CONSTRAINT FK_teacher_TO_tboard
      FOREIGN KEY (
         tnum
      )
      REFERENCES teacher (
         tnum
      );


----------------2018.12.19
--1. 학생테이블
alter table student add saddr2 varchar2(128);
alter table student add spost varchar2(128);
alter table student rename COLUMN saddr to saddr1;

--2. 학생 로거 테이블
alter table stu_logger add stat number(1);

--3. 관리자 로거 테이블
alter table admin_logger add stat number(1);

--4. 강사 로거 테이블
alter table teacher_logger add stat number(1);

--5. 시퀀스 생성
create sequence stu_logger_seq increment by 1 start with 1;
create sequence admin_logger_seq increment by 1 start with 1;
create sequence teacher_logger_seq increment by 1 start with 1;

alter table cplist add cpapl  varchar2(16);
alter table cplist add ratnum number(3);
alter table cplist add yearmoney number(12);
alter table cplist add cprel varchar2(34);
alter table cplist add cpmajor varchar2(128);
alter table cplist add cpceo varchar2(32);
alter table cplist add cpphone varchar2(50);
alter table cplist add cpagree varchar2(9);
alter table cplist add cparrears varchar2(9);

alter table cplist modify cpname varchar2(64);
alter table cplist modify cploc varchar2(200);

-----------------------------------------------

alter table teacher add taddr2 varchar2(128);
alter table teacher add tpost varchar2(128);
alter table teacher rename COLUMN taddr to taddr1;

alter table admin add adaddr2 varchar2(128);
alter table admin add adpost varchar2(128);
alter table admin rename COLUMN adaddr to adaddr1;


--------------------------2018.12.20
/* ROLE */
CREATE TABLE FINALPROJ.ROLE (
	id VARCHAR2(36), /* id */
	rolname VARCHAR2(36) /* rolname */
);

CREATE UNIQUE INDEX FINALPROJ.UIX_ROLE
	ON FINALPROJ.ROLE (
		id ASC
	);

ALTER TABLE FINALPROJ.ROLE
	ADD
		CONSTRAINT UK_ROLE
		UNIQUE (
			id
		);

/* suggestions */
CREATE TABLE FINALPROJ.suggestions (
	sugnum NUMBER(6) NOT NULL, /* 건의번호 */
	sugcontent VARCHAR2(256), /* 건의내용 */
	sugdate DATE, /* 건의날짜 */
	sugrecont VARCHAR2(256), /* 댓글 */
	sugtarget NUMBER(3), /* 건의대상 */
	SNUM NUMBER(3) /* SNUM */
);

CREATE UNIQUE INDEX FINALPROJ.PK_suggestions
	ON FINALPROJ.suggestions (
		sugnum ASC
	);

ALTER TABLE FINALPROJ.suggestions
	ADD
		CONSTRAINT PK_suggestions
		PRIMARY KEY (
			sugnum
		);

/* membertable */
CREATE TABLE FINALPROJ.membertable (
	id VARCHAR2(36) NOT NULL, /* id */
	pwd VARCHAR2(36), /* pwd */
	enable NUMBER(1) /* enable */
);

CREATE UNIQUE INDEX FINALPROJ.PK_membertable
	ON FINALPROJ.membertable (
		id ASC
	);

CREATE UNIQUE INDEX FINALPROJ.UIX_membertable
	ON FINALPROJ.membertable (
		id ASC
	);

ALTER TABLE FINALPROJ.membertable
	ADD
		CONSTRAINT PK_membertable
		PRIMARY KEY (
			id
		);

ALTER TABLE FINALPROJ.membertable
	ADD
		CONSTRAINT UK_membertable
		UNIQUE (
			id
		);

ALTER TABLE FINALPROJ.ROLE
	ADD
		CONSTRAINT FK_membertable_TO_ROLE
		FOREIGN KEY (
			id
		)
		REFERENCES FINALPROJ.membertable (
			id
		);

ALTER TABLE FINALPROJ.suggestions
	ADD
		CONSTRAINT FK_STUDENT_TO_suggestions
		FOREIGN KEY (
			SNUM
		)
		REFERENCES FINALPROJ.STUDENT (
			SNUM
		);
  
-----------------------------------------
</pre>

# DB 더미 데이터
<pre>
더미데이터 입력 순서와 insert문
/*teacher 테이블*/
create sequence tnum_seq increment by 1 start with 1;
insert into teacher values(tnum_seq.nextVal, '김수환', '1972.01.01', 'javabook@naver.com', '강남구 역삼동', '010-0001-0001', '남자', 'javabook', 'test00', 1);
insert into teacher values(tnum_seq.nextVal, '박선생', '1973.02.02', 'spring511@naver.com', '강남구 도곡동', '010-0002-0003', '남자', 'spring511', 'test00', 1);
insert into teacher values(tnum_seq.nextVal, '최스승', '1973.03.03', 'teacher@naver.com', '강남구 뉴욕', '010-0002-0004', '여자', 'teacher', 'test00', 1);
insert into teacher values(tnum_seq.nextVal, '강티쳐', '1974.04.04', 'javeeee@naver.com', '강남구 부르클린', '010-0002-0005', '남자', 'javeeee', 'test00', 1);
insert into teacher values(tnum_seq.nextVal, '주프로', '1975.05.05', 'kostaaa@naver.com', '강남구 벤쿠버', '010-0002-0006', '남자', 'kostaaa', 'test00', 1);

 

/* 관리자*/

create sequence admin_seq increment by 1 start with 1;

insert into admin values(admin_seq.nextVal, '김관리', '1991.12.01', 'aaa@naver.com', '경기도 우리집', '010-1111-1011', '남자', 'adminidenti1', 'test00', 2);
insert into admin values(admin_seq.nextVal, '박관리', '1991.12.01', 'bbb@naver.com', '경기도 우리집', '010-1111-1012', '남자', 'adminidenti2', 'test00', 2);
insert into admin values(admin_seq.nextVal, '최관리', '1991.12.01', 'ccc@naver.com', '경기도 우리집', '010-1111-1013', '여자', 'adminidenti3', 'test00', 2);
insert into admin values(admin_seq.nextVal, '주관리', '1991.12.01', 'ddd@naver.com', '경기도 우리집', '010-1111-1041', '남자', 'adminidenti4', 'test00', 2);
insert into admin values(admin_seq.nextVal, '고관리', '1991.12.01', 'eee@naver.com', '경기도 우리집', '010-1111-1051', '여자', 'adminidenti5', 'test00', 2);
insert into admin values(admin_seq.nextVal, '황관리', '1991.12.01', 'fff@naver.com', '경기도 우리집', '010-1111-1061', '남자', 'adminidenti6', 'test00', 2);
 
/*cplist*/
create sequence cplist_seq increment by 1 start with 1;

insert into cplist(cpnum, cpname, cploc, keyword, cplink, ceomail) values( cplist_seq.nextVal,'가나다솔루션','강남구 역삼동','SI, 솔루션, java, 자바, 금융','www.naver.com','toeicseoul@gmail.com');
insert into cplist(cpnum, cpname, cploc, keyword, cplink, ceomail) values( cplist_seq.nextVal, '귀요미정보통신aa', '금천구 가산동', '통신, 보안, oracle, spring, 스프링','www.naver.com','toeicseoul@gmail.com' );
insert into cplist(cpnum, cpname, cploc, keyword, cplink, ceomail) values( cplist_seq.nextVal, '귀요미정보통신bb', '금천구 가산동', '통신, 보안, oracle, 의료, solution' ,'www.naver.com','toeicseoul@gmail.com');
insert into cplist(cpnum, cpname, cploc, keyword, cplink, ceomail) values( cplist_seq.nextVal, '귀요미정보통신cc', '금천구 가산동', '통신, 보안, oracle, spring, java, 자바 ' ,'www.naver.com','toeicseoul@gmail.com');
insert into cplist(cpnum, cpname, cploc, keyword, cplink, ceomail) values( cplist_seq.nextVal, '귀요미정보통신dd', '금천구 가산동', '통신, 보안, oracle, spring, 안드로이드, android' ,'www.naver.com','toeicseoul@gmail.com');
insert into cplist(cpnum, cpname, cploc, keyword, cplink, ceomail) values( cplist_seq.nextVal, '귀요미정보통신ee', '금천구 가산동', '통신, 보안, oracle, spring, 중소기업' ,'www.naver.com','toeicseoul@gmail.com');
insert into cplist(cpnum, cpname, cploc, keyword, cplink, ceomail) values( cplist_seq.nextVal, '귀요미정보통신ff', '금천구 가산동', '통신, 보안, oracle, spring, 강소기업' ,'www.naver.com','toeicseoul@gmail.com');
insert into cplist(cpnum, cpname, cploc, keyword, cplink, ceomail) values( cplist_seq.nextVal, '귀요미정보통신gg', '금천구 가산동', '통신, 보안, oracle, spring, 1000대기업' ,'www.naver.com','toeicseoul@gmail.com');
insert into cplist(cpnum, cpname, cploc, keyword, cplink, ceomail) values( cplist_seq.nextVal, '귀요미정보통신hB', '금천구 가산동', '통신, 보안, oracle, spring, 정보처리기사' ,'www.naver.com','toeicseoul@gmail.com');
insert into cplist(cpnum, cpname, cploc, keyword, cplink, ceomail) values( cplist_seq.nextVal, '귀요미정보통신AD', '금천구 가산동', '통신, 보안, oracle, spring, 인공지능, AI' ,'www.naver.com','toeicseoul@gmail.com');
insert into cplist(cpnum, cpname, cploc, keyword, cplink, ceomail) values( cplist_seq.nextVal, '귀요미정보통신QQ', '금천구 가산동', '통신, 보안, oracle, spring, 정보처리기사, 빅데이터, BIGDATA, DBA' ,'www.naver.com','toeicseoul@gmail.com');
 
/*cert*/

CREATE SEQUENCE crnum_seq
increment by 1
start with 1;

insert into cert values(crnum_seq.nextVal, '정보처리기사');
insert into cert values(crnum_seq.nextVal, '정보보안기사');
insert into cert values(crnum_seq.nextVal, 'sqld');
insert into cert values(crnum_seq.nextVal, '컴퓨터활용능력 1급');
insert into cert values(crnum_seq.nextVal, '컴퓨터활용능력 2급');
insert into cert values(crnum_seq.nextVal, '워드프로세서');
insert into cert values(crnum_seq.nextVal, '리눅스 마스터');
insert into cert values(crnum_seq.nextVal, '정보처리산업기사');
insert into cert values(crnum_seq.nextVal, '정보처리기능사');
 
/*jobkeyword*/
create sequence jobkeyword_seq increment by 1 start with 1;

insert into jobkeyword values(jobkeyword_seq.nextVal, 'SI');
insert into jobkeyword values(jobkeyword_seq.nextVal, '솔루션');
insert into jobkeyword values(jobkeyword_seq.nextVal, 'java');
insert into jobkeyword values(jobkeyword_seq.nextVal, '금융');
insert into jobkeyword values(jobkeyword_seq.nextVal, '통신');
insert into jobkeyword values(jobkeyword_seq.nextVal, '보안');
insert into jobkeyword values(jobkeyword_seq.nextVal, '중소기업');
insert into jobkeyword values(jobkeyword_seq.nextVal, '강소기업');
insert into jobkeyword values(jobkeyword_seq.nextVal, '안드로이드');
insert into jobkeyword values(jobkeyword_seq.nextVal, 'android');
insert into jobkeyword values(jobkeyword_seq.nextVal, '빅데이터');
insert into jobkeyword values(jobkeyword_seq.nextVal, 'BIGDATA');
insert into jobkeyword values(jobkeyword_seq.nextVal, 'DBA');
insert into jobkeyword values(jobkeyword_seq.nextVal, '취업');
insert into jobkeyword values(jobkeyword_seq.nextVal, '신입사원');
insert into jobkeyword values(jobkeyword_seq.nextVal, '데이터베이스');
insert into jobkeyword values(jobkeyword_seq.nextVal, '인공지능');
insert into jobkeyword values(jobkeyword_seq.nextVal, 'AI');
 
/*class*/

/*강의번호 시퀀스 1부터 시작*/
create sequence cnum_seq
increment by 1
start with 4;

/*기수번호 시퀀스 188기부터 시작*/
create sequence cordinal_seq
increment by 1
start with 188;

/*강의번호 1~3은 종료된 강의이므로 시쿼스 적용 안함*/
insert into class values(1, '자바', 185, 8, '2018.10.10', '2018.10.20', 1, 10);
insert into class values(2, '스프링', 186, 1, '2018.11.01' ,'2018.11.10', 2, 10);
insert into class values(3, 'C', 187, 3, '2018.11.13', '2018.11.23', 3, 10);
insert into class values(cnum_seq.nextVal, 'C++', cordinal_seq.nextVal, 5, '2018.12.01', '2018.12.12', 4, 10);
insert into class values(cnum_seq.nextVal, '리눅스',  cordinal_seq.nextVal, 6, '2018.12.05', '2018.12.16', 5, 10);
 
/*student*/

CREATE SEQUENCE snum_seq
INCREMENT by 1
start with 4;

insert into student values(snum_seq.nextVal,'이규현','1991.05.11','andycandy@naver.com','경기도 시흥시 오타와','010-8908-3333','비전공'
,'남자',4,1,'금융','andycandy','test00',3);
insert into student values(snum_seq.nextVal,'최민수','1989.05.11','sinminsoo@naver.com','경기도 시흥시 철산동','010-8908-8685','전공'
,'남자',4,2,'인공지능','sinminsoo','test00',3);
insert into student values(snum_seq.nextVal,'김구라','1992.03.14','lierkim@naver.com','경기도 고양시 구라동','010-8908-4646','비전공'
,'남자',5,1,'spring','lierkim','test00',3);
insert into student values(snum_seq.nextVal,'김윤재','1993.11.04','dbsxjf2@naver.com','경기도 시흥시 목감동','010-8908-2476','전공'
,'남자',1,1,'java','dbsxjf2','test00',3);
insert into student values(snum_seq.nextVal,'강형욱','1993.12.31','kanghw@naver.com','경기도 시흥시 빅토리아','010-8908-2111','비전공'
,'남자',2,1,'SI','kanghw','test00',3);
insert into student values(snum_seq.nextVal,'최연하','1995.02.11','choikiller@naver.com','경기도 시흥시 빅토리아','010-8908-2155','비전공'
,'여자',3,3,'oracle','choikiller','test00',3);
 
/*수료자 테이블*/

/*현재까지 수료생은 시쿼스 적용 안하고 4부터 시작*/
create sequence gstudent_seq increment by 1 start with 4;

insert into gstudent values(1, 185, '비전공', 1);
insert into gstudent values(2, 186, '전공', 1);
insert into gstudent values(3, 187, '비전공', 3);
 
/*관심기업리스트 favlist*/

insert into favlist(snum, cpnum) values(4, 1);
insert into favlist(snum, cpnum) values(5, 2 );
insert into favlist(snum, cpnum) values(6, 3 );
insert into favlist(snum, cpnum) values(7, 4 );
insert into favlist(snum, cpnum) values(8, 5 );
insert into favlist(snum, cpnum) values(9, 6 );

</pre>
