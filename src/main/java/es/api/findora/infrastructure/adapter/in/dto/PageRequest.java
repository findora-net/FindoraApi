package es.api.findora.infrastructure.adapter.in.dto;

import lombok.Data;

import java.util.Optional;

@Data
public class PageRequest {
    private Integer pageKey;
    private Integer pageSize;
}
