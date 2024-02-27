package com.example.bootcampProject.core.utulities.paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {
    private String sortDirection;
    private  String sortBy;
    private int pageNumber;
    private int pageSize;
}
