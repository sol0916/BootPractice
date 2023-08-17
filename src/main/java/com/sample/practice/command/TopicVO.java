package com.sample.practice.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicVO {
	
	private Integer topic_num;
	private String topic_regdate;
	private String topic_id;
	private String topic_title;
	private String topic_content;

}
