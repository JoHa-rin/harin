package com.itwillbs.domain;

import java.sql.Date;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

@Data
public class MemberVO {
	
	


	private Long mno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
	
	
	
}
