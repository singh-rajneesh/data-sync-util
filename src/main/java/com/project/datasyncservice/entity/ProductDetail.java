package com.project.datasyncservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product_detail")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class ProductDetail extends BaseEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private Long productId;

    private String productName;

    private String productImageUrl;

    private Double productSize;

    private String productSizeUnit;

}