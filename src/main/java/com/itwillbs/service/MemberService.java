package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {

		public void register(MemberVO member);

		public MemberVO get(Long mno);
		
		public boolean modify(MemberVO member);
		
		public boolean remove(Long mno);
		
		public List<MemberVO> getList();
		
}
