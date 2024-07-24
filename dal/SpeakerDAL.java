package com.cn.cnEvent.dal;

import java.util.List;

import com.cn.cnEvent.entity.Speaker;

public interface SpeakerDAL {

    Speaker getById(Long id);

    List<Speaker> getAll();

    String save(Speaker speaker);

    List<Speaker> getAllByExp(Long eventCount, Long experience);

    void addSpeakerToEvent(Long eventId, Long speakerId);

	

}
