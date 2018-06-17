package tuantu.demo.jhip.service.mapper;

import tuantu.demo.jhip.domain.*;
import tuantu.demo.jhip.service.dto.AnhKhachHangDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity AnhKhachHang and its DTO AnhKhachHangDTO.
 */
@Mapper(componentModel = "spring", uses = {KhachHangMapper.class})
public interface AnhKhachHangMapper extends EntityMapper<AnhKhachHangDTO, AnhKhachHang> {

    @Mapping(source = "khachHang.id", target = "khachHangId")
    AnhKhachHangDTO toDto(AnhKhachHang anhKhachHang);

    @Mapping(source = "khachHangId", target = "khachHang")
    AnhKhachHang toEntity(AnhKhachHangDTO anhKhachHangDTO);

    default AnhKhachHang fromId(Long id) {
        if (id == null) {
            return null;
        }
        AnhKhachHang anhKhachHang = new AnhKhachHang();
        anhKhachHang.setId(id);
        return anhKhachHang;
    }
}
