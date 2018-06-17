package tuantu.demo.jhip.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

import tuantu.demo.jhip.domain.enumeration.TrangThaiCuaHang;

/**
 * A CuaHang.
 */
@Entity
@Table(name = "cua_hang")
public class CuaHang implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "ten", nullable = false)
    private String ten;

    @Size(max = 200)
    @Column(name = "diachi", length = 200)
    private String diachi;

    @Column(name = "dienthoai")
    private String dienthoai;

    @Size(max = 11)
    @Column(name = "cmnd", length = 11)
    private String cmnd;

    @Enumerated(EnumType.STRING)
    @Column(name = "trangthai")
    private TrangThaiCuaHang trangthai;

    @Column(name = "ngay_tao")
    private ZonedDateTime ngayTao;

    @ManyToOne
    private Xa xa;

    @OneToMany(mappedBy = "cuaHang")
    @JsonIgnore
    private Set<ThuChi> thuchis = new HashSet<>();

    @OneToMany(mappedBy = "cuaHang")
    @JsonIgnore
    private Set<KhachHang> khachhangs = new HashSet<>();

    @OneToMany(mappedBy = "cuaHang")
    @JsonIgnore
    private Set<NhanVien> nhanviens = new HashSet<>();

    @OneToMany(mappedBy = "cuaHang")
    @JsonIgnore
    private Set<HopDong> hopdongs = new HashSet<>();

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

    public CuaHang ten(String ten) {
        this.ten = ten;
        return this;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public CuaHang diachi(String diachi) {
        this.diachi = diachi;
        return this;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public CuaHang dienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
        return this;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public String getCmnd() {
        return cmnd;
    }

    public CuaHang cmnd(String cmnd) {
        this.cmnd = cmnd;
        return this;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public TrangThaiCuaHang getTrangthai() {
        return trangthai;
    }

    public CuaHang trangthai(TrangThaiCuaHang trangthai) {
        this.trangthai = trangthai;
        return this;
    }

    public void setTrangthai(TrangThaiCuaHang trangthai) {
        this.trangthai = trangthai;
    }

    public ZonedDateTime getNgayTao() {
        return ngayTao;
    }

    public CuaHang ngayTao(ZonedDateTime ngayTao) {
        this.ngayTao = ngayTao;
        return this;
    }

    public void setNgayTao(ZonedDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Xa getXa() {
        return xa;
    }

    public CuaHang xa(Xa xa) {
        this.xa = xa;
        return this;
    }

    public void setXa(Xa xa) {
        this.xa = xa;
    }

    public Set<ThuChi> getThuchis() {
        return thuchis;
    }

    public CuaHang thuchis(Set<ThuChi> thuChis) {
        this.thuchis = thuChis;
        return this;
    }

    public CuaHang addThuchi(ThuChi thuChi) {
        this.thuchis.add(thuChi);
        thuChi.setCuaHang(this);
        return this;
    }

    public CuaHang removeThuchi(ThuChi thuChi) {
        this.thuchis.remove(thuChi);
        thuChi.setCuaHang(null);
        return this;
    }

    public void setThuchis(Set<ThuChi> thuChis) {
        this.thuchis = thuChis;
    }

    public Set<KhachHang> getKhachhangs() {
        return khachhangs;
    }

    public CuaHang khachhangs(Set<KhachHang> khachHangs) {
        this.khachhangs = khachHangs;
        return this;
    }

    public CuaHang addKhachhang(KhachHang khachHang) {
        this.khachhangs.add(khachHang);
        khachHang.setCuaHang(this);
        return this;
    }

    public CuaHang removeKhachhang(KhachHang khachHang) {
        this.khachhangs.remove(khachHang);
        khachHang.setCuaHang(null);
        return this;
    }

    public void setKhachhangs(Set<KhachHang> khachHangs) {
        this.khachhangs = khachHangs;
    }

    public Set<NhanVien> getNhanviens() {
        return nhanviens;
    }

    public CuaHang nhanviens(Set<NhanVien> nhanViens) {
        this.nhanviens = nhanViens;
        return this;
    }

    public CuaHang addNhanvien(NhanVien nhanVien) {
        this.nhanviens.add(nhanVien);
        nhanVien.setCuaHang(this);
        return this;
    }

    public CuaHang removeNhanvien(NhanVien nhanVien) {
        this.nhanviens.remove(nhanVien);
        nhanVien.setCuaHang(null);
        return this;
    }

    public void setNhanviens(Set<NhanVien> nhanViens) {
        this.nhanviens = nhanViens;
    }

    public Set<HopDong> getHopdongs() {
        return hopdongs;
    }

    public CuaHang hopdongs(Set<HopDong> hopDongs) {
        this.hopdongs = hopDongs;
        return this;
    }

    public CuaHang addHopdong(HopDong hopDong) {
        this.hopdongs.add(hopDong);
        hopDong.setCuaHang(this);
        return this;
    }

    public CuaHang removeHopdong(HopDong hopDong) {
        this.hopdongs.remove(hopDong);
        hopDong.setCuaHang(null);
        return this;
    }

    public void setHopdongs(Set<HopDong> hopDongs) {
        this.hopdongs = hopDongs;
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
        CuaHang cuaHang = (CuaHang) o;
        if (cuaHang.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), cuaHang.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CuaHang{" +
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
