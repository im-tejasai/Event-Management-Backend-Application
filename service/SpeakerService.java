package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.SpeakerDAL;
import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;

@Service
public class SpeakerService {

    @Autowired
    SpeakerDAL speakerDAL;

    @Transactional
    public Speaker getSpeakerById(Long id) {
        Speaker speaker = speakerDAL.getById(id);

        if(speaker == null){
            throw new NotFoundException("No Speaker found with id:  "+id);
        }

        return speaker;
    }
    @Transactional
    public List<Speaker> getAllSpeakers() {
       List<Speaker> speakers = speakerDAL.getAll();

       if(speakers == null){
            throw new NotFoundException("No Speakers found ");
       }

       return speakers;
    }
    @Transactional
    public List<Speaker> getAllByExperience(Long eventCount, Long experience) {
       List<Speaker> speakers = speakerDAL.getAllByExp(eventCount, experience);

       if(speakers == null){
        throw new NotFoundException("No Speakers found with this experience");
       }

       return speakers;
    }
    @Transactional
	public String saveSpeaker(Speaker newSpeaker) {
		List<Speaker> allSpeakers = getAllSpeakers();
		for(Speaker speaker : allSpeakers)
		{
			if(speaker.getId().equals(newSpeaker.getId()))
			{
				throw new ElementAlreadyExistException("This speaker already exist.");
			}
		}
		try {
			return speakerDAL.save(newSpeaker);
		}
		catch (Exception e)
		{
			throw new InvalidInputException("The input entity for speaker is invalid.");
		}
	}
    
    @Transactional
	public void addSpeakerToEvent(Long eventId, Long speakerId) {
		try{
			speakerDAL.addSpeakerToEvent(eventId,speakerId);
		}
		catch(Exception e){
			throw new ElementAlreadyExistException("Speaker and Event are either already linked, " +
					"or one of the entities doesn't exist");
		}

	}

}
