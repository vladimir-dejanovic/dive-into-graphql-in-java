package xyz.itshark.conf.tutorial.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Talk;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.AttendeeService;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.SpeakerService;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.TalkService;

import java.util.List;

@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final AttendeeService attendeeService;
    private final SpeakerService speakerService;
    private final TalkService talkService;

    public List<Talk> allTalks() {
        return talkService.findAll();
    }

}
