package com.crud.simple.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class StudentRequest {
    @NotEmpty
    @NotNull
    String name;
}
