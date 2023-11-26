package com.project.datasyncservice.dto;

import com.farmrise.orderintentservice.aspect.Translate;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IntentMetaDataDTO {

    @NotNull
    private String cropName;

    @NotNull
    private String cropDiseaseName;

    @Translate
    @NotNull
    private List<String> productNames;
}
