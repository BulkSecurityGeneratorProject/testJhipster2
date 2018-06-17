package tuantu.demo.jhip.repository;

import tuantu.demo.jhip.domain.Tinh;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Tinh entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TinhRepository extends JpaRepository<Tinh, Long> {

}
