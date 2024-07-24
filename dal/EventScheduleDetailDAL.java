package com.cn.cnEvent.dal;

import java.util.List;

import com.cn.cnEvent.entity.EventScheduleDetail;

public interface EventScheduleDetailDAL {

	EventScheduleDetail getById(Long id);

	List<EventScheduleDetail> getAllEventScheduleDetails();

	String save(EventScheduleDetail item);
}
