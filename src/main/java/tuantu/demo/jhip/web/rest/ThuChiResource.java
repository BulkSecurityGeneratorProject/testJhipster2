package tuantu.demo.jhip.web.rest;

import com.codahale.metrics.annotation.Timed;
import tuantu.demo.jhip.service.ThuChiService;
import tuantu.demo.jhip.web.rest.errors.BadRequestAlertException;
import tuantu.demo.jhip.web.rest.util.HeaderUtil;
import tuantu.demo.jhip.service.dto.ThuChiDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing ThuChi.
 */
@RestController
@RequestMapping("/api")
public class ThuChiResource {

    private final Logger log = LoggerFactory.getLogger(ThuChiResource.class);

    private static final String ENTITY_NAME = "thuChi";

    private final ThuChiService thuChiService;

    public ThuChiResource(ThuChiService thuChiService) {
        this.thuChiService = thuChiService;
    }

    /**
     * POST  /thu-chis : Create a new thuChi.
     *
     * @param thuChiDTO the thuChiDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new thuChiDTO, or with status 400 (Bad Request) if the thuChi has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/thu-chis")
    @Timed
    public ResponseEntity<ThuChiDTO> createThuChi(@Valid @RequestBody ThuChiDTO thuChiDTO) throws URISyntaxException {
        log.debug("REST request to save ThuChi : {}", thuChiDTO);
        if (thuChiDTO.getId() != null) {
            throw new BadRequestAlertException("A new thuChi cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ThuChiDTO result = thuChiService.save(thuChiDTO);
        return ResponseEntity.created(new URI("/api/thu-chis/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /thu-chis : Updates an existing thuChi.
     *
     * @param thuChiDTO the thuChiDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated thuChiDTO,
     * or with status 400 (Bad Request) if the thuChiDTO is not valid,
     * or with status 500 (Internal Server Error) if the thuChiDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/thu-chis")
    @Timed
    public ResponseEntity<ThuChiDTO> updateThuChi(@Valid @RequestBody ThuChiDTO thuChiDTO) throws URISyntaxException {
        log.debug("REST request to update ThuChi : {}", thuChiDTO);
        if (thuChiDTO.getId() == null) {
            return createThuChi(thuChiDTO);
        }
        ThuChiDTO result = thuChiService.save(thuChiDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, thuChiDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /thu-chis : get all the thuChis.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of thuChis in body
     */
    @GetMapping("/thu-chis")
    @Timed
    public List<ThuChiDTO> getAllThuChis() {
        log.debug("REST request to get all ThuChis");
        return thuChiService.findAll();
        }

    /**
     * GET  /thu-chis/:id : get the "id" thuChi.
     *
     * @param id the id of the thuChiDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the thuChiDTO, or with status 404 (Not Found)
     */
    @GetMapping("/thu-chis/{id}")
    @Timed
    public ResponseEntity<ThuChiDTO> getThuChi(@PathVariable Long id) {
        log.debug("REST request to get ThuChi : {}", id);
        ThuChiDTO thuChiDTO = thuChiService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(thuChiDTO));
    }

    /**
     * DELETE  /thu-chis/:id : delete the "id" thuChi.
     *
     * @param id the id of the thuChiDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/thu-chis/{id}")
    @Timed
    public ResponseEntity<Void> deleteThuChi(@PathVariable Long id) {
        log.debug("REST request to delete ThuChi : {}", id);
        thuChiService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
