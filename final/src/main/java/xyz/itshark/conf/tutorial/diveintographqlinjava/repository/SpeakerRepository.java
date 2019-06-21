package xyz.itshark.conf.tutorial.diveintographqlinjava.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Speaker;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
}
