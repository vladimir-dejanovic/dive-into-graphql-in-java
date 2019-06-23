package xyz.itshark.conf.tutorial.diveintographqlinjava.fetcher;

import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.TalkService;

import javax.annotation.Resource;

@Component
public class TalkFetcher {

    @Resource
    TalkService talkService;

    public DataFetcher fetchAll() {
        return dataFetcherEnv -> talkService.findAll();
    }
}
