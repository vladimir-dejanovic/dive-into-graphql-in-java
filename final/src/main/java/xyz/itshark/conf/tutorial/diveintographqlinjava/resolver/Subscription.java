package xyz.itshark.conf.tutorial.diveintographqlinjava.resolver;

import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import io.reactivex.BackpressureStrategy;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.Observable;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Score;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class Subscription implements GraphQLSubscriptionResolver {

    public Publisher<Score> talkScores(final String title) {
        Observable<Score> observable = Observable.create(e -> {
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            executorService.scheduleAtFixedRate(() -> {
                Score s = Score.builder()
                               .title(title)
                               .score(Integer.valueOf((int) Math.floor(Math.random()*10)))
                               .build();
                e.onNext(s);
            }, 0, 2, TimeUnit.SECONDS);
        });

        ConnectableObservable connectableObservable = observable.share().publish();
        connectableObservable.connect();
        return connectableObservable.toFlowable(BackpressureStrategy.BUFFER);
    }

}
