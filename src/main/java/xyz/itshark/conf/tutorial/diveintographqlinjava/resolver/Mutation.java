package xyz.itshark.conf.tutorial.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Attendee;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.AttendeeService;

@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final AttendeeService attendeeService;

    public Attendee addAttendee(String name ) {
        Attendee attendee = new Attendee();
        attendee.setName(name);

        return attendeeService.save(attendee);
    }

}
