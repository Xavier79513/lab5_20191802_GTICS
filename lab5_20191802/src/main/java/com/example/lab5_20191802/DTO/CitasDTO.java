package com.example.lab5_20191802.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CitasDTO {
    private String sede;
    private String area;
    private String profesional;
    private Long totalCitas;
}
