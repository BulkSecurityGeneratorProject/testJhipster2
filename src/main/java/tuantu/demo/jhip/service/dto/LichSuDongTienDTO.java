package tuantu.demo.jhip.service.dto;


import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import tuantu.demo.jhip.domain.enumeration.DONGTIEN;

/**
 * A DTO for the LichSuDongTien entity.
 */
public class LichSuDongTienDTO implements Serializable {

    private Long id;

    @NotNull
    private ZonedDateTime ngaybatdau;

    @NotNull
    private ZonedDateTime ngayketthuc;

    @NotNull
    private Double sotien;

    @NotNull
    private DONGTIEN trangthai;

    private Long hopDongId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(ZonedDateTime ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public ZonedDateTime getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(ZonedDateTime ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public Double getSotien() {
        return sotien;
    }

    public void setSotien(Double sotien) {
        this.sotien = sotien;
    }

    public DONGTIEN getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(DONGTIEN trangthai) {
        this.trangthai = trangthai;
    }

    public Long getHopDongId() {
        return hopDongId;
    }

    public void setHopDongId(Long hopDongId) {
        this.hopDongId = hopDongId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LichSuDongTienDTO lichSuDongTienDTO = (LichSuDongTienDTO) o;
        if(lichSuDongTienDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), lichSuDongTienDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "LichSuDongTienDTO{" +
            "id=" + getId() +
            ", ngaybatdau='" + getNgaybatdau() + "'" +
            ", ngayketthuc='" + getNgayketthuc() + "'" +
            ", sotien=" + getSotien() +
            ", trangthai='" + getTrangthai() + "'" +
            "}";
    }
}
