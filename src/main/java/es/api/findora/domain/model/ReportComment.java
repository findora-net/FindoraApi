package es.api.findora.domain.model;

import lombok.Data;

@Data
public class ReportComment extends Report{
    private Comment comment;
}
