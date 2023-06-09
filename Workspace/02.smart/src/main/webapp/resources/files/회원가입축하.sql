drop table member;
--회원관리
create table member(
name            varchar2(50) not null, /* 회원명 */
userid          varchar2(50) constraint member_userid_pk primary key, /* 아이디 */
userpw          varchar2(300) not null, /* 비밀번호 */
gender          varchar2(3) default '남' not null, /* 성별 */
email           varchar2(50) not null, /* 이메일 */
profile         varchar2(50), /* 프로필이미지 */
birth           date, /* 생년월일 */
phone           varchar2(13), /* 전화번호 */
post            varchar2(5), /* 우편번호 */
address         varchar2(300), /* 주소 */
admin           varchar2(1) default 'N' /* 관리자여부 : Y/N */
);

insert into member(name, userid, userpw, email) values ('abc', 'abc','123','@');
select * from member;
delete from member;
commit;


비밀번호 암호화 : 1234 -> 132123fdsa654fsad456asfd456afds465 : 양방향
         복호화 : afsd645fads456fdsa456fads465fasd645 -> 1234
비밀번호 암호화는 단방향