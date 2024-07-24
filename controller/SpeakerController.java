package com.cn.cnEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.service.SpeakerService;

@RestController
@RequestMapping("/speaker")
public class SpeakerController {

    @Autowired
    SpeakerService speakerService;

    @GetMapping("/{id}")
    public Speaker getSpeakerById(@PathVariable Long id){
        return speakerService.getSpeakerById(id);
    }

    @GetMapping("/all")
    public List<Speaker> getAllSpeakers(){
        return speakerService.getAllSpeakers();
    }

    @GetMapping("/eventCount/{eventCount}/experience/{experience}")
    public List<Speaker> getAllByExperience(@PathVariable Long eventCount, @PathVariable Long experience){
        return speakerService.getAllByExperience(eventCount, experience);
    }

    @PostMapping("/save")
    public String saveSpeaker(@RequestBody Speaker speaker){
        return speakerService.saveSpeaker(speaker);
    }

    @PostMapping("/id/{speakerId}/eventId/{eventId}")
    public void addSpeakerToEvent(@PathVariable("eventId") Long eventId, @PathVariable("speakerId") Long speakerId) {
        speakerService.addSpeakerToEvent(eventId, speakerId);
    }

}
