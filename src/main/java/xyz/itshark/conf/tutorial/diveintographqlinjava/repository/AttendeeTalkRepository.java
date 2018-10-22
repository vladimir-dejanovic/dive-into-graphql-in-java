package xyz.itshark.conf.tutorial.diveintographqlinjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.AttendeeTalk;

import java.util.List;

@Repository
public interface AttendeeTalkRepository extends JpaRepository<AttendeeTalk, Long> {
    List<AttendeeTalk> findAllByAttendeeId(Long id);

    List<AttendeeTalk> findAllByTalkId(Long id);
}
