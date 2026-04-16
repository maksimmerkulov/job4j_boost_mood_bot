package ru.job4j.bmb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.bmb.model.Award;

import java.util.List;

/**
 * @author Maksim Merkulov
 * @version 1.0
 */
@Repository
public interface AwardRepository extends CrudRepository<Award, Long> {
    List<Award> findAll();
}
