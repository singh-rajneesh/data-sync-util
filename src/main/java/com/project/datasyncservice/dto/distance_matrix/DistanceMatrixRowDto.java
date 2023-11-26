package com.project.datasyncservice.dto.distance_matrix;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DistanceMatrixRowDto {

    List<DistanceMatrixElementDto> elements;
}
