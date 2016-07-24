package com.nfl.mapper;

import java.util.List;

import com.nfl.pojo.NflPostsPanel;

public interface NflPostPanelMapper {
	List<NflPostsPanel> findPostUserAndTopic(Integer post_id);
}
