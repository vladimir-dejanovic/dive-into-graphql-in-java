package xyz.itshark.conf.tutorial.diveintographqlinjava;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import xyz.itshark.conf.tutorial.diveintographqlinjava.resolver.Mutation;
import xyz.itshark.conf.tutorial.diveintographqlinjava.resolver.Query;
import xyz.itshark.conf.tutorial.diveintographqlinjava.resolver.SpeakerReslover;
import xyz.itshark.conf.tutorial.diveintographqlinjava.resolver.TalkReslover;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.AttendeeService;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.SpeakerService;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.TalkService;

public class GraphQLEntryPoint extends SimpleGraphQLServlet {

    public GraphQLEntryPoint(SpeakerService speakerService, AttendeeService attendeeService, TalkService talkService) {
        super(buildSchema(speakerService,attendeeService,talkService));
    }

    private static GraphQLSchema buildSchema(SpeakerService speakerService, AttendeeService attendeeService, TalkService talkService) {
        return SchemaParser
                .newParser()
                .file("schema.graphqls")
//                .dictionary()
                .resolvers( new Query(attendeeService,speakerService,talkService),
                        new TalkReslover(speakerService),
                new SpeakerReslover(talkService),
                new Mutation(speakerService))
                .build()
                .makeExecutableSchema();
    }
}
