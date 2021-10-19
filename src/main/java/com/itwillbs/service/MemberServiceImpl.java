package com.itwillbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

//import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	
	@Override
	public void register(MemberVO member) {
		
		log.info("register......." + member);

	}

	@Override
	public MemberVO get(Long mno) {
		
		log.info("get......." + mno);
		
		return mapper.read(mno);
	}

	@Override
	public boolean modify(MemberVO member) {
		
		log.info("modify......." + member);
		
		return mapper.update(member) == 1;
	}

	@Override
	public boolean remove(Long mno) {

		log.info("remove......." + mno);
		
		return mapper.delete(mno)==1;
	}

	@Override
	public List<MemberVO> getList() {
		
		log.info("getList.......");
		
		return mapper.getList();
	}
}
