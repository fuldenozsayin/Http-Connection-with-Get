package com.example.search;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.flogger.Flogger;

@Getter
@Setter
@NoArgsConstructor

public class Categories {
    private int categoryId;
    private String categoryName;
    private String categoryDeneme;
}

