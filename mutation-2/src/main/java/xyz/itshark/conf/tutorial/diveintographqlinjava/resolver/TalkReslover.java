package xyz.itshark.conf.tutorial.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Speaker;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Talk;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.SpeakerService;

import java.util.List;

@RequiredArgsConstructor
public class TalkReslover implements GraphQLResolver<Talk> {

    private final SpeakerService speakerService;

    public List<Speaker> speakers(Talk talk) {
        return speakerService.findAllSpeakersForTalk(talk);
    }

}
