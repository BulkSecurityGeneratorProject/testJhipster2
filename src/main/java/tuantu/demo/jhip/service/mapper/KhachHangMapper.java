package tuantu.demo.jhip.service.mapper;

import tuantu.demo.jhip.domain.*;
import tuantu.demo.jhip.service.dto.KhachHangDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity KhachHang and its DTO KhachHangDTO.
 */
@Mapper(componentModel = "spring", uses = {XaMapper.class, CuaHangMapper.class})
public interface KhachHangMapper extends EntityMapper<KhachHangDTO, KhachHang> {

    @Mapping(source = "xa.id", target = "xaId")
    @Mapping(source = "cuaHang.id", target = "cuaHangId")
    KhachHangDTO toDto(KhachHang khachHang);

    @Mapping(source = "xaId", target = "xa")
    @Mapping(target = "anhs", ignore = true)
    @Mapping(target = "hopdongs", ignore = true)
    @Mapping(source = "cuaHangId", target = "cuaHang")
    KhachHang toEntity(KhachHangDTO khachHangDTO);

    default KhachHang fromId(Long id) {
        if (id == null) {
            return null;
        }
        KhachHang khachHang = new KhachHang();
        khachHang.setId(id);
        return khachHang;
    }
}
