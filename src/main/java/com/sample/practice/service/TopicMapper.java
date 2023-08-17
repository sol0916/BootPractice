package com.sample.practice.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.sample.practice.command.TopicVO;

@Mapper
public interface TopicMapper {
	
	public int topicRegist(TopicVO vo);
	public ArrayList<TopicVO> getList(String topid_id);
	public TopicVO getDetail(int topic_num);
	public ArrayList<TopicVO> myList(String topic_id);
	public int topicModify(TopicVO vo);
	public void topicDelete(int topic_num);

}
