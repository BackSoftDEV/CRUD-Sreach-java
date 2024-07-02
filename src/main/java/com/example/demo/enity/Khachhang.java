package com.example.demo.enity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "khach_hang")
public class Khachhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "ten_khach_hang")
    String tenkhachhang;
    @Column(name = "ma_khach_hang")
    String makhachhang;
//    @OneToMany(mappedBy = "tenkh")
    //    List<Giohang> gh;
}
