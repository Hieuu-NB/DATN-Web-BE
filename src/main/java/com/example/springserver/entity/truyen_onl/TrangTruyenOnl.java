package com.example.springserver.entity.truyen_onl;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "trang_truyen_onl")
@RequiredArgsConstructor
@Data
public class TrangTruyenOnl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String linkTrangTruyen;
//    private String from;
    @ManyToOne
    @JoinColumn(name = "from_truyen" ,nullable = false,referencedColumnName = "id") // cột cart_id góống cột cartId bên cart
    @JsonBackReference
    private TruyenOnl truyen;


//    @OneToMany(mappedBy = "trangTruyenOnl",cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private List<Comments> cmt;
}
