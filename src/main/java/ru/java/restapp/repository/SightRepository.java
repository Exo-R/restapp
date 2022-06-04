package ru.java.restapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.java.restapp.entity.Sight;
import ru.java.restapp.entity.TypeSight;
import java.util.List;

@Repository
public interface SightRepository extends JpaRepository<Sight, Long> {

    List<Sight> findAllByCity_Id(Long city_id);

    List<Sight> findAllByTypeSight(TypeSight typeSight);

}
