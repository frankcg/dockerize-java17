package com.bidea.factory.bookhouse.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTO {

    private String houseId;

    private String discountCode;

    private Long id;

    private String userId;

    private boolean status;

    private boolean passedRetry;
}
