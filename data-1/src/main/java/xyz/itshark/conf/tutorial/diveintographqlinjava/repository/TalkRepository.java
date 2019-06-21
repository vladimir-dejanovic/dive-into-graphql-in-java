package xyz.itshark.conf.tutorial.diveintographqlinjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Talk;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Long> {
}
