package smart.common;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import smart.notice.NoticeVO;
@Getter @Setter
public class PageVO {
	private int totalList; //DB에서 조회해온 총 글 건수
	private int pageList = 10;	// 페이지당 보여질 목록 수
	private int blockPage = 10; // 블럭당 보여질 페이지의
	private int totalPage;	
	private int totalBlock;
	private int curPage = 1;	//현재 페이지번호
	private int endList, beginList;
	
	// 블록번호 : 페이지번호 / 블록당 보여질 페이지수
	private int curBlock;
	private int endPage, beginPage;
	private List<Object> list;// 현재페이지에서의 글 목록
	
	public void setTotalList(int totalList) {
		this.totalList = totalList;
		
		//총 페이지수 : 8페이지 = 212/10=21...2 -> 22p
		totalPage = totalList/pageList;
		if(totalList%pageList>0) ++totalPage;
		
		//총 블록수 : 3 블록 = 22/10=2...2
		totalBlock=totalPage/blockPage;
		if(totalPage%blockPage>0) ++totalBlock;
		
		endList = totalList-(curPage-1)*pageList;
		beginList = endList - (pageList-1);
		
		curBlock = curPage/blockPage;
		if(curPage%blockPage>0) ++curBlock;
		
		//3Block : 21, 22	
		endPage = curBlock*blockPage;		//30
		beginPage = endPage-(blockPage-1);	//21
		
		if(totalPage<endPage) endPage = totalPage;
		
	}
	
}
