package com.nfl.mapper;

import java.util.List;

import com.nfl.pojo.NflCommentsUsers;

public interface NflCommentsUsersMapper {
	List<NflCommentsUsers> findNflCommentsUsers(Integer postId);
}
