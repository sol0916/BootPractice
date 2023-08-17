package com.sample.practice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sample.practice.command.TopicVO;
import com.sample.practice.service.TopicService;

@Controller
@RequestMapping("/topic")
public class TopicController {

	@Autowired
	@Qualifier("topicService")
	private TopicService topicService;
	
	
	@GetMapping("/topicReg")
	public String topicReg() {
		return "topic/topicReg";
	}
	
	@GetMapping("/topicListAll")
	public String topicListAll(Model model) {
		
		String topic_id = "admin"; //현재 로그인 기능이 없으므로 admin으로 값 넣어줌
		
		ArrayList<TopicVO> list = topicService.getList(topic_id);
		model.addAttribute("list", list);
		
		return "topic/topicListAll";
	}
	
	@GetMapping("/topicListMe")
	public String topicListMe(Model model) {
		
		String topic_id = "admin";
		
		ArrayList<TopicVO> list = topicService.getList(topic_id);
		model.addAttribute("list", list);
		
		
		return "topic/topicListMe";
	}
	
	@GetMapping("/topicDetail")
	public String topicDetail(@RequestParam("topic_num") int topic_num,
							  Model model) {
		
		TopicVO vo = topicService.getDetail(topic_num);
		model.addAttribute("vo", vo);
		
		return "topic/topicDetail";
	}
	
	@GetMapping("/topicModify")
	public String topicModify(@RequestParam("topic_num") int topic_num,
							  Model model) {
		
		TopicVO vo = topicService.getDetail(topic_num);
		model.addAttribute("vo", vo);
				
		return "topic/topicModify";
	}
	
	
	//등록요청
	@PostMapping("registForm")
	public String regist(TopicVO vo, RedirectAttributes ra) {
		
		int result = topicService.topicRegist(vo);
		String msg = result == 1 ? "등록 되었습니다" : "등록 실패. 관리자에게 문의하세요";
		
		ra.addFlashAttribute("msg", msg);
		
		return "redirect:/topic/topicListMe";
	}
	
	//수정요청 
	@RequestMapping("modifyForm")
	public String modify(TopicVO vo, RedirectAttributes ra) {
		
		topicService.topicModify(vo);
		System.out.println(vo.toString());
//		String msg = result == 1 ? "수정되었습니다" : "수정 실패. 관리에게 문의하세요";
//		
//		ra.addFlashAttribute("msg", msg);
		
		
		return "redirect:/topic/topicListMe";
	}
	
	//삭제요청
	@RequestMapping("deleteForm")
	public String delete(@RequestParam("topic_num") int topic_num) {
		
		topicService.topicDelete(topic_num);
		
		return "redirect:/topic/topicListMe";
	}
	
}
