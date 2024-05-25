package com.example.springserver.dto.response;

import lombok.*;

@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Setter
@Getter
@Data
public class CmtTruyen {
    private long id_truyen;
    private String cmt;
}
