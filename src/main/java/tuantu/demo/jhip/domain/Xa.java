package tuantu.demo.jhip.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * not an ignored comment
 */
@ApiModel(description = "not an ignored comment")
@Entity
@Table(name = "xa")
public class Xa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ten", nullable = false)
    private String ten;

    @ManyToOne
    private Huyen huyen;

    @OneToMany(mappedBy = "xa")
    @JsonIgnore
    private Set<KhachHang> khachangs = new HashSet<>();

    @OneToMany(mappedBy = "xa")
    @JsonIgnore
    private Set<NhanVien> nhanviens = new HashSet<>();

    @OneToMany(mappedBy = "xa")
    @JsonIgnore
    private Set<CuaHang> cuahangs = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public Xa ten(String ten) {
        this.ten = ten;
        return this;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Huyen getHuyen() {
        return huyen;
    }

    public Xa huyen(Huyen huyen) {
        this.huyen = huyen;
        return this;
    }

    public void setHuyen(Huyen huyen) {
        this.huyen = huyen;
    }

    public Set<KhachHang> getKhachangs() {
        return khachangs;
    }

    public Xa khachangs(Set<KhachHang> khachHangs) {
        this.khachangs = khachHangs;
        return this;
    }

    public Xa addKhachang(KhachHang khachHang) {
        this.khachangs.add(khachHang);
        khachHang.setXa(this);
        return this;
    }

    public Xa removeKhachang(KhachHang khachHang) {
        this.khachangs.remove(khachHang);
        khachHang.setXa(null);
        return this;
    }

    public void setKhachangs(Set<KhachHang> khachHangs) {
        this.khachangs = khachHangs;
    }

    public Set<NhanVien> getNhanviens() {
        return nhanviens;
    }

    public Xa nhanviens(Set<NhanVien> nhanViens) {
        this.nhanviens = nhanViens;
        return this;
    }

    public Xa addNhanvien(NhanVien nhanVien) {
        this.nhanviens.add(nhanVien);
        nhanVien.setXa(this);
        return this;
    }

    public Xa removeNhanvien(NhanVien nhanVien) {
        this.nhanviens.remove(nhanVien);
        nhanVien.setXa(null);
        return this;
    }

    public void setNhanviens(Set<NhanVien> nhanViens) {
        this.nhanviens = nhanViens;
    }

    public Set<CuaHang> getCuahangs() {
        return cuahangs;
    }

    public Xa cuahangs(Set<CuaHang> cuaHangs) {
        this.cuahangs = cuaHangs;
        return this;
    }

    public Xa addCuahang(CuaHang cuaHang) {
        this.cuahangs.add(cuaHang);
        cuaHang.setXa(this);
        return this;
    }

    public Xa removeCuahang(CuaHang cuaHang) {
        this.cuahangs.remove(cuaHang);
        cuaHang.setXa(null);
        return this;
    }

    public void setCuahangs(Set<CuaHang> cuaHangs) {
        this.cuahangs = cuaHangs;
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
        Xa xa = (Xa) o;
        if (xa.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), xa.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Xa{" +
            "id=" + getId() +
            ", ten='" + getTen() + "'" +
            "}";
    }
}
