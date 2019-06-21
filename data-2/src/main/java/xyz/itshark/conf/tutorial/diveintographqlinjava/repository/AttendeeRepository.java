package xyz.itshark.conf.tutorial.diveintographqlinjava.repository;

import org.springframework.stereotype.Repository;
import xyz.itshark.conf.tutorial.diveintographqlinjava.pojo.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}
