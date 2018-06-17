package tuantu.demo.jhip.web.rest;

import com.codahale.metrics.annotation.Timed;
import tuantu.demo.jhip.service.HopDongService;
import tuantu.demo.jhip.web.rest.errors.BadRequestAlertException;
import tuantu.demo.jhip.web.rest.util.HeaderUtil;
import tuantu.demo.jhip.web.rest.util.PaginationUtil;
import tuantu.demo.jhip.service.dto.HopDongDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing HopDong.
 */
@RestController
@RequestMapping("/api")
public class HopDongResource {

    private final Logger log = LoggerFactory.getLogger(HopDongResource.class);

    private static final String ENTITY_NAME = "hopDong";

    private final HopDongService hopDongService;

    public HopDongResource(HopDongService hopDongService) {
        this.hopDongService = hopDongService;
    }

    /**
     * POST  /hop-dongs : Create a new hopDong.
     *
     * @param hopDongDTO the hopDongDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new hopDongDTO, or with status 400 (Bad Request) if the hopDong has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/hop-dongs")
    @Timed
    public ResponseEntity<HopDongDTO> createHopDong(@Valid @RequestBody HopDongDTO hopDongDTO) throws URISyntaxException {
        log.debug("REST request to save HopDong : {}", hopDongDTO);
        if (hopDongDTO.getId() != null) {
            throw new BadRequestAlertException("A new hopDong cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HopDongDTO result = hopDongService.save(hopDongDTO);
        return ResponseEntity.created(new URI("/api/hop-dongs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /hop-dongs : Updates an existing hopDong.
     *
     * @param hopDongDTO the hopDongDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated hopDongDTO,
     * or with status 400 (Bad Request) if the hopDongDTO is not valid,
     * or with status 500 (Internal Server Error) if the hopDongDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/hop-dongs")
    @Timed
    public ResponseEntity<HopDongDTO> updateHopDong(@Valid @RequestBody HopDongDTO hopDongDTO) throws URISyntaxException {
        log.debug("REST request to update HopDong : {}", hopDongDTO);
        if (hopDongDTO.getId() == null) {
            return createHopDong(hopDongDTO);
        }
        HopDongDTO result = hopDongService.save(hopDongDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, hopDongDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /hop-dongs : get all the hopDongs.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of hopDongs in body
     */
    @GetMapping("/hop-dongs")
    @Timed
    public ResponseEntity<List<HopDongDTO>> getAllHopDongs(Pageable pageable) {
        log.debug("REST request to get a page of HopDongs");
        Page<HopDongDTO> page = hopDongService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/hop-dongs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /hop-dongs/:id : get the "id" hopDong.
     *
     * @param id the id of the hopDongDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the hopDongDTO, or with status 404 (Not Found)
     */
    @GetMapping("/hop-dongs/{id}")
    @Timed
    public ResponseEntity<HopDongDTO> getHopDong(@PathVariable Long id) {
        log.debug("REST request to get HopDong : {}", id);
        HopDongDTO hopDongDTO = hopDongService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(hopDongDTO));
    }

    /**
     * DELETE  /hop-dongs/:id : delete the "id" hopDong.
     *
     * @param id the id of the hopDongDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/hop-dongs/{id}")
    @Timed
    public ResponseEntity<Void> deleteHopDong(@PathVariable Long id) {
        log.debug("REST request to delete HopDong : {}", id);
        hopDongService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
