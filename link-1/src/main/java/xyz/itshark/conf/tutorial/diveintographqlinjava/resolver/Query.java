package xyz.itshark.conf.tutorial.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Attendee;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Human;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Speaker;
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

    public List<Speaker> allSpeakers() {
        return speakerService.findAll();
    }

    public List<Attendee> allAttendees() {
        return attendeeService.findAll();
    }


    public List<Object> allPeople() {
        List<Attendee> attendees = attendeeService.findAll();
        List people = speakerService.findAll();

        people.addAll(attendees);
        return people;
    }

    public List<Human> allHumans() {
        List<Attendee> attendees = attendeeService.findAll();
        List people = speakerService.findAll();

        people.addAll(attendees);
        return people;
    }

}
