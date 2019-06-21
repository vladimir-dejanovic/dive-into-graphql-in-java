package xyz.itshark.conf.tutorial.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Speaker;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Talk;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.TalkService;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SpeakerReslover implements GraphQLResolver<Speaker> {

    @Resource
    private TalkService talkService;

    public List<Talk> talks(Speaker speaker) {
        return talkService.findAllTalksBySpeaker(speaker);
    }
}
