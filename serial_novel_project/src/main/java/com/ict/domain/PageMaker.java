package com.ict.domain;

import lombok.Data;

@Data
public class PageMaker {
	private int totalBoard;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	// ���� ������ �ϴ� ��ư������ ���������� �������� ���� ��� 
	// displayPageNum�� �����մϴ�.
	private int displayPageNum;
	// Criteria���� ���� ��ȸ�ϰ� �ִ� ������ ���� + ���� �������� �򸮴� �� ���� �޾ƿ;���.
	private SearchCriteria cri;
	// �ʿ��� ��� ������ ������ִ� �޼���.
	public void calcData() {
		this.displayPageNum =10;
		
		// ����������(cri.PageNum())�� �ٰŷ� ������ �׷��� ������ �������� ���� 
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 
				(double)displayPageNum) * displayPageNum);
		
		// ������ �������� ���� ������ �׷��� ������������ ���� .
		this.startPage = (endPage - displayPageNum) +1 ;
		
		// ���� endPage�� �������(�ܼ� �׷�������)������ �������̱� ������ �������� �� ������ ���� �����������.
		int tempEndPage = (int)(Math.ceil(totalBoard/(double)cri.getNumber()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		// next,prev��ư ���� ó��
		// prev�� startPage�� 1�� ��쿡�� ��Ȱ��ȭ �̹Ƿ� ���׿����ڷ� ������ ó��
		prev = startPage == 1 ? false : true; 
		
		//next�� ���±��� ����� �������� ���� �� �������� DB�� ��ü ���� �� ������쿡 Ȱ��ȭ
		next = endPage * cri.getNumber() >= totalBoard ? false : true;
	}
	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
		calcData(); // prev , next, endPage, startPage�� �� ���ع���.
	}
	
}
