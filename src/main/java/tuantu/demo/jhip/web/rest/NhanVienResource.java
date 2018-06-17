package tuantu.demo.jhip.web.rest;

import com.codahale.metrics.annotation.Timed;
import tuantu.demo.jhip.service.NhanVienService;
import tuantu.demo.jhip.web.rest.errors.BadRequestAlertException;
import tuantu.demo.jhip.web.rest.util.HeaderUtil;
import tuantu.demo.jhip.web.rest.util.PaginationUtil;
import tuantu.demo.jhip.service.dto.NhanVienDTO;
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
 * REST controller for managing NhanVien.
 */
@RestController
@RequestMapping("/api")
public class NhanVienResource {

    private final Logger log = LoggerFactory.getLogger(NhanVienResource.class);

    private static final String ENTITY_NAME = "nhanVien";

    private final NhanVienService nhanVienService;

    public NhanVienResource(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    /**
     * POST  /nhan-viens : Create a new nhanVien.
     *
     * @param nhanVienDTO the nhanVienDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new nhanVienDTO, or with status 400 (Bad Request) if the nhanVien has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/nhan-viens")
    @Timed
    public ResponseEntity<NhanVienDTO> createNhanVien(@Valid @RequestBody NhanVienDTO nhanVienDTO) throws URISyntaxException {
        log.debug("REST request to save NhanVien : {}", nhanVienDTO);
        if (nhanVienDTO.getId() != null) {
            throw new BadRequestAlertException("A new nhanVien cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NhanVienDTO result = nhanVienService.save(nhanVienDTO);
        return ResponseEntity.created(new URI("/api/nhan-viens/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /nhan-viens : Updates an existing nhanVien.
     *
     * @param nhanVienDTO the nhanVienDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated nhanVienDTO,
     * or with status 400 (Bad Request) if the nhanVienDTO is not valid,
     * or with status 500 (Internal Server Error) if the nhanVienDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/nhan-viens")
    @Timed
    public ResponseEntity<NhanVienDTO> updateNhanVien(@Valid @RequestBody NhanVienDTO nhanVienDTO) throws URISyntaxException {
        log.debug("REST request to update NhanVien : {}", nhanVienDTO);
        if (nhanVienDTO.getId() == null) {
            return createNhanVien(nhanVienDTO);
        }
        NhanVienDTO result = nhanVienService.save(nhanVienDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, nhanVienDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /nhan-viens : get all the nhanViens.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of nhanViens in body
     */
    @GetMapping("/nhan-viens")
    @Timed
    public ResponseEntity<List<NhanVienDTO>> getAllNhanViens(Pageable pageable) {
        log.debug("REST request to get a page of NhanViens");
        Page<NhanVienDTO> page = nhanVienService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/nhan-viens");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /nhan-viens/:id : get the "id" nhanVien.
     *
     * @param id the id of the nhanVienDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the nhanVienDTO, or with status 404 (Not Found)
     */
    @GetMapping("/nhan-viens/{id}")
    @Timed
    public ResponseEntity<NhanVienDTO> getNhanVien(@PathVariable Long id) {
        log.debug("REST request to get NhanVien : {}", id);
        NhanVienDTO nhanVienDTO = nhanVienService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(nhanVienDTO));
    }

    /**
     * DELETE  /nhan-viens/:id : delete the "id" nhanVien.
     *
     * @param id the id of the nhanVienDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/nhan-viens/{id}")
    @Timed
    public ResponseEntity<Void> deleteNhanVien(@PathVariable Long id) {
        log.debug("REST request to delete NhanVien : {}", id);
        nhanVienService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
