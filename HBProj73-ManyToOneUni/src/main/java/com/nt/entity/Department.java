package com.nt.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Department implements Serializable {
    private Integer dno;
    @NonNull
    private String dname;
    @NonNull
    private  String location;
    @NonNull
    private  Integer capacity;
}
