package com.example.monitoreo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Monitoreo {
private int id;
private int idJaula;
private double temperatura;
private double oxigeno;
private double ph;
private String fecha;

}
