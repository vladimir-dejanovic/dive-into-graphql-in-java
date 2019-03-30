package xyz.itshark.conf.tutorial.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Speaker;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Talk;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.SpeakerService;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TalkReslover implements GraphQLResolver<Talk> {

    @Resource
    private SpeakerService speakerService;

    public List<Speaker> speakers(Talk talk) {
        return speakerService.findAllSpeakersForTalk(talk);
    }

}
