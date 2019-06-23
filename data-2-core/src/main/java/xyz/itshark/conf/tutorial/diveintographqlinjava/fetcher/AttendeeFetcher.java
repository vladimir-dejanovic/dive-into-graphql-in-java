package xyz.itshark.conf.tutorial.diveintographqlinjava.fetcher;

import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;
import xyz.itshark.conf.tutorial.diveintographqlinjava.service.AttendeeService;

import javax.annotation.Resource;

@Component
public class AttendeeFetcher {

    @Resource
    AttendeeService attendeeService;

    public DataFetcher fetchAll() {
        return  dataFetchingEnvironment -> attendeeService.findAll();
    }
}
