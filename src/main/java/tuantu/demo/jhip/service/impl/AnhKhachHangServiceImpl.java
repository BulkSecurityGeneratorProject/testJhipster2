package tuantu.demo.jhip.service.impl;

import tuantu.demo.jhip.service.AnhKhachHangService;
import tuantu.demo.jhip.domain.AnhKhachHang;
import tuantu.demo.jhip.repository.AnhKhachHangRepository;
import tuantu.demo.jhip.service.dto.AnhKhachHangDTO;
import tuantu.demo.jhip.service.mapper.AnhKhachHangMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing AnhKhachHang.
 */
@Service
@Transactional
public class AnhKhachHangServiceImpl implements AnhKhachHangService {

    private final Logger log = LoggerFactory.getLogger(AnhKhachHangServiceImpl.class);

    private final AnhKhachHangRepository anhKhachHangRepository;

    private final AnhKhachHangMapper anhKhachHangMapper;

    public AnhKhachHangServiceImpl(AnhKhachHangRepository anhKhachHangRepository, AnhKhachHangMapper anhKhachHangMapper) {
        this.anhKhachHangRepository = anhKhachHangRepository;
        this.anhKhachHangMapper = anhKhachHangMapper;
    }

    /**
     * Save a anhKhachHang.
     *
     * @param anhKhachHangDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AnhKhachHangDTO save(AnhKhachHangDTO anhKhachHangDTO) {
        log.debug("Request to save AnhKhachHang : {}", anhKhachHangDTO);
        AnhKhachHang anhKhachHang = anhKhachHangMapper.toEntity(anhKhachHangDTO);
        anhKhachHang = anhKhachHangRepository.save(anhKhachHang);
        return anhKhachHangMapper.toDto(anhKhachHang);
    }

    /**
     * Get all the anhKhachHangs.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<AnhKhachHangDTO> findAll() {
        log.debug("Request to get all AnhKhachHangs");
        return anhKhachHangRepository.findAll().stream()
            .map(anhKhachHangMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one anhKhachHang by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public AnhKhachHangDTO findOne(Long id) {
        log.debug("Request to get AnhKhachHang : {}", id);
        AnhKhachHang anhKhachHang = anhKhachHangRepository.findOne(id);
        return anhKhachHangMapper.toDto(anhKhachHang);
    }

    /**
     * Delete the anhKhachHang by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AnhKhachHang : {}", id);
        anhKhachHangRepository.delete(id);
    }
}
