package com.sample.practice.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.practice.command.TopicVO;

@Service("topicService")
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicMapper topicMapper;
	
	@Override
	public int topicRegist(TopicVO vo) {
		return topicMapper.topicRegist(vo);
	}
	
	@Override
	public ArrayList<TopicVO> getList(String topid_id) {	
		return topicMapper.getList(topid_id);
	}
	
	@Override
	public TopicVO getDetail(int topic_num) {
		return topicMapper.getDetail(topic_num);
	}
	
	@Override
	public ArrayList<TopicVO> myList(String topic_id) {
		return topicMapper.myList(topic_id);
	}
	
	@Override
	public int topicModify(TopicVO vo) {
		return topicMapper.topicModify(vo);
	}
	
	@Override
	public void topicDelete(int topic_num) {
		topicMapper.topicDelete(topic_num);
	}
	
	
}
