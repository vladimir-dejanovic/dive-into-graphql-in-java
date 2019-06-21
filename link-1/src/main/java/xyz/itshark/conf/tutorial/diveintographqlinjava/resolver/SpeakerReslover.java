package xyz.itshark.conf.tutorial.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Speaker;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Talk;
import xyz.itshark.conf.tutorial.diveintographqlinjava.repository.SpeakerTalkRepository;
import xyz.itshark.conf.tutorial.diveintographqlinjava.repository.TalkRepository;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.TalkService;

import java.util.List;

@RequiredArgsConstructor
public class SpeakerReslover implements GraphQLResolver<Speaker> {

    private final TalkService talkService;

    public List<Talk> talks(Speaker speaker) {
        return talkService.findAllTalksBySpeaker(speaker);
    }
}
