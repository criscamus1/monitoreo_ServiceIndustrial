package com.example.monitoreo.service;

import com.example.monitoreo.dto.CreateDTO;
import com.example.monitoreo.dto.actuDTO;
import com.example.monitoreo.dto.actualiDTO;
import com.example.monitoreo.extencion.extencion;
import com.example.monitoreo.model.Monitoreo;
import com.example.monitoreo.repository.MonitoreoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MonitoreoService {
    private final MonitoreoRepository repository;

    public MonitoreoService(MonitoreoRepository repository) {
        this.repository = repository;
    }
    public List<Monitoreo> getMonitoreos() {
        return repository.findAll();
    }
    public Monitoreo buscarMonitoreo(Integer id) {
        return repository.findById(id).orElseThrow(() ->new RuntimeException("La medición no existe."));
    }
public String guardarMonitoreo(CreateDTO dto) {

    Monitoreo monitoreo = new Monitoreo();
    monitoreo.setJaulaId(dto.jaulaId());
    monitoreo.setTemperatura(dto.temperatura());
    monitoreo.setOxigeno(dto.oxigenoDisuelto());
    monitoreo.setPh(dto.ph());
    monitoreo.setSalinidad(dto.salinidad());
    monitoreo.setFechaRegistro(dto.fechaRegistro());

    repository.save(monitoreo);

    String alerta = "";
    if(dto.temperatura() > 18){
        alerta += "Temperatura sobre el límite permitido.\n";
    }
    if(dto.oxigenoDisuelto() < 5){
        alerta += "Oxígeno por debajo del nivel recomendado.\n";
    }
    if(dto.ph() < 6.5 || dto.ph() > 8.5){
        alerta += "pH fuera del rango permitido.\n";
    }
    if(dto.salinidad() < 28 || dto.salinidad() > 35){
        alerta += "Salinidad fuera del rango permitido.\n";
    }
    if(alerta.isBlank()){
        return "Medición registrada correctamente.";
    }
    return "Medición registrada.\n\nALERTA:\n" + alerta;
    }
    
    public Monitoreo actualizar(Integer id, actuDTO dto) {

        Monitoreo monitoreo = buscarMonitoreo(id);

        monitoreo.setTemperatura(dto.temperatura());
        monitoreo.setOxigeno(dto.oxigeno());
        monitoreo.setPh(dto.ph());
        monitoreo.setSalinidad(dto.salinidad());
        monitoreo.setFechaRegistro(dto.fechaRegistro());

        return repository.save(monitoreo);
    }

    public List<Monitoreo> buscarPorJaula(Integer jaulaId) {
        List<Monitoreo> lista = repository.findByJaulaId(jaulaId);
          if (lista.isEmpty()) {throw new RuntimeException("No existen mediciones para esta jaula."); }
            return lista;
    }

}