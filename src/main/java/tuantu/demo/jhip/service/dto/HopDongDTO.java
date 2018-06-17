package tuantu.demo.jhip.service.dto;


import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import tuantu.demo.jhip.domain.enumeration.LOAIHOPDONG;

/**
 * A DTO for the HopDong entity.
 */
public class HopDongDTO implements Serializable {

    private Long id;

    @Size(max = 200)
    private String ghichu;

    @NotNull
    private LOAIHOPDONG loaihopdong;

    @NotNull
    private ZonedDateTime ngaytao;

    private Long khachHangId;

    private Long cuaHangId;

    private Long nhanVienId;

    private Long hopdonggocId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public LOAIHOPDONG getLoaihopdong() {
        return loaihopdong;
    }

    public void setLoaihopdong(LOAIHOPDONG loaihopdong) {
        this.loaihopdong = loaihopdong;
    }

    public ZonedDateTime getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(ZonedDateTime ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Long getKhachHangId() {
        return khachHangId;
    }

    public void setKhachHangId(Long khachHangId) {
        this.khachHangId = khachHangId;
    }

    public Long getCuaHangId() {
        return cuaHangId;
    }

    public void setCuaHangId(Long cuaHangId) {
        this.cuaHangId = cuaHangId;
    }

    public Long getNhanVienId() {
        return nhanVienId;
    }

    public void setNhanVienId(Long nhanVienId) {
        this.nhanVienId = nhanVienId;
    }

    public Long getHopdonggocId() {
        return hopdonggocId;
    }

    public void setHopdonggocId(Long hopDongId) {
        this.hopdonggocId = hopDongId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HopDongDTO hopDongDTO = (HopDongDTO) o;
        if(hopDongDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), hopDongDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "HopDongDTO{" +
            "id=" + getId() +
            ", ghichu='" + getGhichu() + "'" +
            ", loaihopdong='" + getLoaihopdong() + "'" +
            ", ngaytao='" + getNgaytao() + "'" +
            "}";
    }
}
