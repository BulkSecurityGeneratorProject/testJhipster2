package tuantu.demo.jhip.repository;

import tuantu.demo.jhip.domain.AnhTaiSan;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AnhTaiSan entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AnhTaiSanRepository extends JpaRepository<AnhTaiSan, Long> {

}
