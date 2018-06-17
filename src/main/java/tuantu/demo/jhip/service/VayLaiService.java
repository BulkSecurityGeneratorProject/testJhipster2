package tuantu.demo.jhip.service;

import tuantu.demo.jhip.service.dto.VayLaiDTO;
import java.util.List;

/**
 * Service Interface for managing VayLai.
 */
public interface VayLaiService {

    /**
     * Save a vayLai.
     *
     * @param vayLaiDTO the entity to save
     * @return the persisted entity
     */
    VayLaiDTO save(VayLaiDTO vayLaiDTO);

    /**
     * Get all the vayLais.
     *
     * @return the list of entities
     */
    List<VayLaiDTO> findAll();

    /**
     * Get the "id" vayLai.
     *
     * @param id the id of the entity
     * @return the entity
     */
    VayLaiDTO findOne(Long id);

    /**
     * Delete the "id" vayLai.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
