package com.sample.practice.service;

import java.util.ArrayList;

import com.sample.practice.command.TopicVO;

public interface TopicService {
	
	public int topicRegist(TopicVO vo);
	public ArrayList<TopicVO> getList(String topic_id);
	public TopicVO getDetail(int topic_num);
	public ArrayList<TopicVO> myList(String topic_id);
	public int topicModify(TopicVO vo);
	public void topicDelete(int topic_num);
	
}
