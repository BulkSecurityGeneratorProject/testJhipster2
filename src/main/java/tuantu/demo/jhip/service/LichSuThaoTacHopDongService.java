package tuantu.demo.jhip.service;

import tuantu.demo.jhip.service.dto.LichSuThaoTacHopDongDTO;
import java.util.List;

/**
 * Service Interface for managing LichSuThaoTacHopDong.
 */
public interface LichSuThaoTacHopDongService {

    /**
     * Save a lichSuThaoTacHopDong.
     *
     * @param lichSuThaoTacHopDongDTO the entity to save
     * @return the persisted entity
     */
    LichSuThaoTacHopDongDTO save(LichSuThaoTacHopDongDTO lichSuThaoTacHopDongDTO);

    /**
     * Get all the lichSuThaoTacHopDongs.
     *
     * @return the list of entities
     */
    List<LichSuThaoTacHopDongDTO> findAll();

    /**
     * Get the "id" lichSuThaoTacHopDong.
     *
     * @param id the id of the entity
     * @return the entity
     */
    LichSuThaoTacHopDongDTO findOne(Long id);

    /**
     * Delete the "id" lichSuThaoTacHopDong.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
