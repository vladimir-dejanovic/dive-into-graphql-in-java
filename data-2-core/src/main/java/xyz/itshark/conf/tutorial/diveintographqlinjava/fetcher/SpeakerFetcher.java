package xyz.itshark.conf.tutorial.diveintographqlinjava.fetcher;

import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Talk;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.SpeakerService;

import javax.annotation.Resource;

@Component
public class SpeakerFetcher {

    @Resource
    SpeakerService speakerService;

    public DataFetcher fetchAllSpeakersForTalk() {
        return dataFetchingEnvironment -> {
            Talk talk = dataFetchingEnvironment.getSource();
            return speakerService.findAllSpeakersForTalk(talk);
        };
    }

    public DataFetcher fetchAll() {
        return dataFetchingEnvironment ->  speakerService.findAll();
    }
}
