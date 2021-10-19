package com.itwillbs.controller;

import java.io.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) {
		
		log.info("list");
		model.addAttribute("list", service.getList());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(MemberVO member, RedirectAttributes rttr) {
		
		log.info("register: "+member);
		
		service.register(member);
		
		rttr.addFlashAttribute("result", member.getMno());
		
		return "redirect:/member/list";
		
	}


	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void get(@RequestParam("mno") Long mno, Model model) {
		
		log.info("/get");
		model.addAttribute("member",service.get(mno));
	}
//	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(MemberVO member, RedirectAttributes rttr) {
		log.info("modify: "+member);
		
		if(service.modify(member)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/member/list";
	}
	
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("mno") Long mno, RedirectAttributes rttr) {
		log.info("remove..." + mno);
		if(service.remove(mno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/member/list";
		
	} 

}
	

