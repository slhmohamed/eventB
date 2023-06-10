package tn.eesprit.gestionevenementback.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.eesprit.gestionevenementback.Entities.Event;
import tn.eesprit.gestionevenementback.Entities.Reservation;
import tn.eesprit.gestionevenementback.Entities.Reservation;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("select a from Reservation a where a.dateReservation <= :endD and a.dateReservation>= :start")
    List<Reservation> findAllByDateReservationBetweens(@Param("start")Date start,@Param("endD") Date endD);
    @Query( "SELECT d.event ,COUNT(d) AS counts FROM Reservation d    GROUP BY d.event    ORDER BY counts desc ")
    List<Object[]> statEvent( );
}
