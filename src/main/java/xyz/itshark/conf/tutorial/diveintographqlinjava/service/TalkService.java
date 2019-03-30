package xyz.itshark.conf.tutorial.diveintographqlinjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.*;
import xyz.itshark.conf.tutorial.diveintographqlinjava.repository.AttendeeTalkRepository;
import xyz.itshark.conf.tutorial.diveintographqlinjava.repository.SpeakerTalkRepository;
import xyz.itshark.conf.tutorial.diveintographqlinjava.repository.TalkRepository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TalkService {

    @Resource
    private TalkRepository talkRepository;

    @Resource
    private SpeakerTalkRepository speakerTalkRepository;

    @Resource
    private AttendeeTalkRepository attendeeTalkRepository;

    public List<Talk> findAll() {
        return talkRepository.findAll();
    }

    public List<Talk> findAllTalksBySpeaker(Speaker speaker) {
        List<SpeakerTalk> st = speakerTalkRepository.findAllBySpeakerId(speaker.getId());

        return st.stream()
                .map(e -> talkRepository.findById(e.getTalkId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<Talk> findAllTAlksByAttendee(Attendee attendee) {
        List<AttendeeTalk> st = attendeeTalkRepository.findAllByAttendeeId(attendee.getId());

        return st.stream()
                .map(e -> talkRepository.findById(e.getTalkId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

    }
}
