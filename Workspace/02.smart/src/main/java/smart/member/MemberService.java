package smart.member;

import java.util.List;

public interface MemberService {
	// CRUD
	int member_join(MemberVO vo); 		// 회원가입시 회원정보저장
	MemberVO member_info(String userid);// 내정보보기(내 프로필) : 회원정보 조회
	List<MemberVO> member_list();		// 전체 회원목록 조회 - 관리자만 가능
	int member_update(MemberVO vo);		// 마이페이지에서 회원정보 변경 저장
	int member_delete(String userid); 	// 회원탈퇴시 회원정보 삭제
	
	String member_userid_email(MemberVO vo); // 아이디와 이메일이 일치하는 회원정보(회원명) 조회
	int member_resetPassword(MemberVO vo); 	 // 비번 변경저장
	
}
