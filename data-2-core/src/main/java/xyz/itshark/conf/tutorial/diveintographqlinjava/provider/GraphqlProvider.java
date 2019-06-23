package xyz.itshark.conf.tutorial.diveintographqlinjava.provider;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;

import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import xyz.itshark.conf.tutorial.diveintographqlinjava.fetcher.AttendeeFetcher;
import xyz.itshark.conf.tutorial.diveintographqlinjava.fetcher.SpeakerFetcher;
import xyz.itshark.conf.tutorial.diveintographqlinjava.fetcher.TalkFetcher;


import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphqlProvider {

    @Autowired
    TalkFetcher talkFetcher;
    @Autowired
    SpeakerFetcher speakerFetcher;
    @Autowired
    AttendeeFetcher attendeeFetcher;

    private GraphQL graphQL;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("graphql/schema.graphqls");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query")
                        .dataFetcher("allTalks", talkFetcher.fetchAll())
                        .dataFetcher("allSpeakers", speakerFetcher.fetchAll())
                        .dataFetcher("allAttendees", attendeeFetcher.fetchAll()))
                .type(newTypeWiring("Talk")
                        .dataFetcher("speakers", speakerFetcher.fetchAllSpeakersForTalk()))
                .build();
    }

}
