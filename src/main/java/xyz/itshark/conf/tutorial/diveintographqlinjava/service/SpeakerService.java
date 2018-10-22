package xyz.itshark.conf.tutorial.diveintographqlinjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Attendee;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Speaker;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.SpeakerTalk;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Talk;
import xyz.itshark.conf.tutorial.diveintographqlinjava.repository.SpeakerRepository;
import xyz.itshark.conf.tutorial.diveintographqlinjava.repository.SpeakerTalkRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;

    @Autowired
    private SpeakerTalkRepository speakerTalkRepository;

    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }

    public List<Speaker> findAllSpeakersForTalk(Talk talk) {
        List<SpeakerTalk> st = speakerTalkRepository.findAllByTalkId(talk.getId());

        return st.stream()
                .map(e -> speakerRepository.findById(e.getSpeakerId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Speaker save(Speaker speaker) {
        return speakerRepository.save(speaker);
    }
}
