package com.example.monitoreo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "monitoreo_agua")
public class Monitoreo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
 private Integer id;

@Column(name = "jaula_id", nullable = false)
 private Integer jaulaId;
@Column(name = "temperatura", nullable = false)
 private Double temperatura;

@Column(name = "oxigeno", nullable = false)
 private Double oxigeno;
@Column(name = "ph", nullable = false)
 private Double ph;

@Column(name = "fecha_registro", nullable = false, length = 20)
 private String fechaRegistro;
}
