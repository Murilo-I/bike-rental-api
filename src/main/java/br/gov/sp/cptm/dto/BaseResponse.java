package br.gov.sp.cptm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResponse {

    private boolean success;
    private String message;
}
