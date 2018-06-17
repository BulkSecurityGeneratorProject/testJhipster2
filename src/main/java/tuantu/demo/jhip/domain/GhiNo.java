package tuantu.demo.jhip.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import tuantu.demo.jhip.domain.enumeration.NOTRA;

/**
 * A GhiNo.
 */
@Entity
@Table(name = "ghi_no")
public class GhiNo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ngayghino", nullable = false)
    private ZonedDateTime ngayghino;

    @NotNull
    @Column(name = "sotien", nullable = false)
    private Double sotien;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "trangthai", nullable = false)
    private NOTRA trangthai;

    @ManyToOne
    private HopDong hopDong;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getNgayghino() {
        return ngayghino;
    }

    public GhiNo ngayghino(ZonedDateTime ngayghino) {
        this.ngayghino = ngayghino;
        return this;
    }

    public void setNgayghino(ZonedDateTime ngayghino) {
        this.ngayghino = ngayghino;
    }

    public Double getSotien() {
        return sotien;
    }

    public GhiNo sotien(Double sotien) {
        this.sotien = sotien;
        return this;
    }

    public void setSotien(Double sotien) {
        this.sotien = sotien;
    }

    public NOTRA getTrangthai() {
        return trangthai;
    }

    public GhiNo trangthai(NOTRA trangthai) {
        this.trangthai = trangthai;
        return this;
    }

    public void setTrangthai(NOTRA trangthai) {
        this.trangthai = trangthai;
    }

    public HopDong getHopDong() {
        return hopDong;
    }

    public GhiNo hopDong(HopDong hopDong) {
        this.hopDong = hopDong;
        return this;
    }

    public void setHopDong(HopDong hopDong) {
        this.hopDong = hopDong;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GhiNo ghiNo = (GhiNo) o;
        if (ghiNo.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ghiNo.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GhiNo{" +
            "id=" + getId() +
            ", ngayghino='" + getNgayghino() + "'" +
            ", sotien=" + getSotien() +
            ", trangthai='" + getTrangthai() + "'" +
            "}";
    }
}
