package tuantu.demo.jhip.service.dto;


import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import tuantu.demo.jhip.domain.enumeration.HINHTHUCLAI;
import tuantu.demo.jhip.domain.enumeration.TINHLAI;

/**
 * A DTO for the VayLai entity.
 */
public class VayLaiDTO implements Serializable {

    private Long id;

    @NotNull
    private Double tienvay;

    @NotNull
    private HINHTHUCLAI hinhthuclai;

    @NotNull
    private Integer thoigianvay;

    @NotNull
    private Integer chukylai;

    @NotNull
    private Float lai;

    @NotNull
    private TINHLAI cachtinhlai;

    private Long hopdongvlId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTienvay() {
        return tienvay;
    }

    public void setTienvay(Double tienvay) {
        this.tienvay = tienvay;
    }

    public HINHTHUCLAI getHinhthuclai() {
        return hinhthuclai;
    }

    public void setHinhthuclai(HINHTHUCLAI hinhthuclai) {
        this.hinhthuclai = hinhthuclai;
    }

    public Integer getThoigianvay() {
        return thoigianvay;
    }

    public void setThoigianvay(Integer thoigianvay) {
        this.thoigianvay = thoigianvay;
    }

    public Integer getChukylai() {
        return chukylai;
    }

    public void setChukylai(Integer chukylai) {
        this.chukylai = chukylai;
    }

    public Float getLai() {
        return lai;
    }

    public void setLai(Float lai) {
        this.lai = lai;
    }

    public TINHLAI getCachtinhlai() {
        return cachtinhlai;
    }

    public void setCachtinhlai(TINHLAI cachtinhlai) {
        this.cachtinhlai = cachtinhlai;
    }

    public Long getHopdongvlId() {
        return hopdongvlId;
    }

    public void setHopdongvlId(Long hopDongId) {
        this.hopdongvlId = hopDongId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VayLaiDTO vayLaiDTO = (VayLaiDTO) o;
        if(vayLaiDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), vayLaiDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "VayLaiDTO{" +
            "id=" + getId() +
            ", tienvay=" + getTienvay() +
            ", hinhthuclai='" + getHinhthuclai() + "'" +
            ", thoigianvay=" + getThoigianvay() +
            ", chukylai=" + getChukylai() +
            ", lai=" + getLai() +
            ", cachtinhlai='" + getCachtinhlai() + "'" +
            "}";
    }
}
