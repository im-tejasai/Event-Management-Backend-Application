package com.cn.cnEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.service.EventScheduleDetailService;

@RestController
@RequestMapping("/eventScheduleDetail")
public class EventScheduleDetailController {

    @Autowired
    EventScheduleDetailService eventScheduleDetailService;

    @GetMapping("/{id}")
    public EventScheduleDetail getEventScheduleDetailById(@PathVariable Long id)
    {
        return eventScheduleDetailService.getEventScheduleDetailById(id);
    }

    @GetMapping("/all")
    public List<EventScheduleDetail> getAllEventScheduleDetails()
    {
        return eventScheduleDetailService.getAllEventScheduleDetails();
    }

    @PostMapping("/save")
    public  String saveEventScheduleDetail(@RequestBody EventScheduleDetail event)
    {
        return eventScheduleDetailService.saveEventScheduleDetail(event);
    }
}
