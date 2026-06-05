package com.example.monitoreo.dto;

import jakarta.validation.constraints.*;


public record CreateDTO (
    @NotNull(message = "El ID de la jaula es obligatorio")Integer jaulaId,

    @NotNull(message = "La temperatura es obligatoria")
    @DecimalMin(value = "0.0", message = "La temperatura no puede ser estar a menos 0°C")
    @DecimalMax(value = "25.0", message = "Temperatura demasiada alta para para el parametro establecido")
    Double temperatura,

    @NotNull(message = "El nivel de oxígeno disuelto es obligatorio")
    @DecimalMin(value = "0.0", message = "El oxígeno no puede ser un valor negativo")
    @DecimalMax(value = "25.0", message = "Nivel de oxígeno fuera de rango operativo")
    Double oxigenoDisuelto,

    @NotNull(message = "La medicion del ph es obligatoria")
    @DecimalMin(value = "0.0", message = "El ph no puede ser negativo")
    @DecimalMax(value = "10.0", message = "EL ph esta mas alto de lo establecido")
    Double ph,

    @NotNull(message = "Debe registrar la fecha de la medición")
    String fechaRegistro
) {}
