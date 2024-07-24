package com.cn.cnEvent.dal;

import java.util.List;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.entity.Ticket;

public interface EventDAL {

	Event getById(Long id);

	List<Event> getAllEvents();

	EventScheduleDetail getEventScheduleDetailByEventId(Long id);

	List<Event> getAllEventsByLocation(String location);

	String save(Event item);

	String delete(Long id);

	String deleteEventScheduleDetail(Long id);

	String update(Event updateEvent);

    List<Ticket> getAllTickets(Long id);

    List<Event> getAllByprice(Long price);
}
