package com.itwillbs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwillbs.domain.MemberVO;

@Mapper
public interface MemberMapper {
	
	// @select ("select * from itwill_board where bno > 0")
	public List<MemberVO> getList();
	
	public void insert(MemberVO member);
	
//	public void insertSelectKey(MemberVO member);
	
	public MemberVO read(Long mno);
	
	public int delete(Long mno);
	
	public int update(MemberVO member);
	
}
