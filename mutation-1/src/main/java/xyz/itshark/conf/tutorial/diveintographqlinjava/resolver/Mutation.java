package xyz.itshark.conf.tutorial.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Speaker;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.SpeakerService;

@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final SpeakerService speakerService;

    public Speaker addSpeaker(String name ) {
        Speaker speaker  = new Speaker();
        speaker.setName(name);

        return speakerService.save(speaker);
    }

}
