package ru.job4j.bmb.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.job4j.bmb.model.MoodLog;
import ru.job4j.bmb.model.User;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author Maksim Merkulov
 * @version 1.3
 */
@Repository
public interface MoodLogRepository extends CrudRepository<MoodLog, Long> {
    List<MoodLog> findAll();

    List<MoodLog> findByUserId(Long userId);

    Stream<MoodLog> findByUserIdOrderByCreatedAtDesc(Long userId);

    @Query("SELECT DISTINCT u FROM User u WHERE u.id NOT IN "
            + "(SELECT ml.user.id FROM MoodLog ml WHERE ml.createdAt BETWEEN :start AND :end)")
    List<User> findUsersWhoDidNotVoteToday(@Param("start") long start, @Param("end") long end);

    @Query("SELECT ml FROM MoodLog ml WHERE ml.user.id = :userId AND ml.createdAt >= :weekStart")
    List<MoodLog> findMoodLogsForWeek(@Param("userId") Long userId, @Param("weekStart") long weekStart);

    @Query("SELECT ml FROM MoodLog ml WHERE ml.user.id = :userId AND ml.createdAt >= :monthStart")
    List<MoodLog> findMoodLogsForMonth(@Param("userId") Long userId, @Param("monthStart") long monthStart);
}
