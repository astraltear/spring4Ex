package com.astraltear.paging;


public class PagingTest {

	public static void main(String[] args) {
		
		int page=7;
		
		int PAGESIZE=5;
		int totalCount=89;
		
		Paging paging = new Paging();
		paging.setPageNo(page); // 페이지 번호
		paging.setPageSize(PAGESIZE); // 게시 글 수
		paging.setPageBlock(5); // 페이지 너비 
		
//		paging.setMoveMode("ONE");
		paging.setMoveMode("BLOCK");
		
		paging.setTotalCount(totalCount); // 게시 글 전체 수
		paging.makePaging();
		
		System.out.println(paging.toString());
		System.out.println("paging.firstPageNo:처음 페이지:"+paging.getFirstPageNo());
		System.out.println("paging.prevPageNo:이전 페이지:"+paging.getPrevPageNo());
		
		for (int i = paging.getStartPageNo(); i <= paging.getEndPageNo(); i++) {
			
			if (page == i) {
				System.out.println("current ==>"+i);
			} else {
				System.out.println("page==>"+i);
			}
		}
		
		System.out.println("paging.nextPageNo:다음 페이지:"+paging.getNextPageNo());
		System.out.println("paging.finalPageNo:마지막 페이지:"+paging.getFinalPageNo());
		
	

	}

}
