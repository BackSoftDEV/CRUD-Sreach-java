package com.example.demo.enity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "gio_hang")
public class Giohang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "id_khach_hang", referencedColumnName = "id")
    Khachhang khachhang;
    @NotBlank(message = "ko aaaa")
    @Column(name = "ma_gio_hang")
    String magiohang;
    @Column(name = "ngay_tao")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date ngaytao;
    @Column(name = "ten_nguoi_nhan")
    String tennguoinhan;
    @Column(name = "dia_chi")
    String diachi;
    @Column(name = "sdt")
    String sdt;


}
