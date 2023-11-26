package com.project.datasyncservice.dto;

import com.farmrise.orderintentservice.aspect.Translate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderListDTO {

    @Translate
    private List<OrderRecordDTO> orders;

}