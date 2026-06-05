package com.example.monitoreo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class actualiDTO {
    
Integer id;
Integer jaulaId;
double temperatura;
double oxigeno;
double ph;
double salinidad;
String fechaRegistro;

}
