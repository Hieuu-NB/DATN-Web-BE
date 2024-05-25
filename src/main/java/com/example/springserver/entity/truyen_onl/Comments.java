package com.example.springserver.entity.truyen_onl;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "comment")
@RequiredArgsConstructor
@Data
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String noi_dung;
    private String luotThich;
    private String thoi_gian_cmt;

    @ManyToOne
    @JoinColumn(name = "from_truyen" ,nullable = false,referencedColumnName = "id") // cột cart_id góống cột cartId bên cart
    @JsonBackReference
    private TruyenOnl truyenOnl;


//    @ManyToOne
//    @JoinColumn(name = "from_truyen" ,nullable = false,referencedColumnName = "from_truyen") // cột cart_id góống cột cartId bên cart
//    @JsonBackReference
//    private TrangTruyenOnl trangTruyenOnl;
}
