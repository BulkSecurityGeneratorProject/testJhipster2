package tuantu.demo.jhip.service.dto;


import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import tuantu.demo.jhip.domain.enumeration.TrangThaiCuaHang;

/**
 * A DTO for the CuaHang entity.
 */
public class CuaHangDTO implements Serializable {

    private Long id;

    @NotNull
    private String ten;

    @Size(max = 200)
    private String diachi;

    private String dienthoai;

    @Size(max = 11)
    private String cmnd;

    private TrangThaiCuaHang trangthai;

    private ZonedDateTime ngayTao;

    private Long xaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public TrangThaiCuaHang getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(TrangThaiCuaHang trangthai) {
        this.trangthai = trangthai;
    }

    public ZonedDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(ZonedDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Long getXaId() {
        return xaId;
    }

    public void setXaId(Long xaId) {
        this.xaId = xaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CuaHangDTO cuaHangDTO = (CuaHangDTO) o;
        if(cuaHangDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), cuaHangDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CuaHangDTO{" +
            "id=" + getId() +
            ", ten='" + getTen() + "'" +
            ", diachi='" + getDiachi() + "'" +
            ", dienthoai='" + getDienthoai() + "'" +
            ", cmnd='" + getCmnd() + "'" +
            ", trangthai='" + getTrangthai() + "'" +
            ", ngayTao='" + getNgayTao() + "'" +
            "}";
    }
}
