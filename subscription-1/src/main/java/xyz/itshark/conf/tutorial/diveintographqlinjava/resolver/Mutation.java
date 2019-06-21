package xyz.itshark.conf.tutorial.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Speaker;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.SpeakerInput;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.SpeakerService;

import javax.annotation.Resource;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Resource
    private SpeakerService speakerService;

    public Speaker addSpeaker(SpeakerInput si ) {
        Speaker speaker  = new Speaker();
        speaker.setName(si.getName());
        speaker.setTwitter(si.getTwitter());

        return speakerService.save(speaker);
    }

}
