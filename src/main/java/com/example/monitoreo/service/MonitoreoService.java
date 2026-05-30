package com.example.monitoreo.service;

import com.example.monitoreo.model.Monitoreo;
import com.example.monitoreo.repository.MonitoreoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MonitoreoService {
 @Autowired
 private MonitoreoRepository repository;

 public List<Monitoreo> obtenerMonitoreos(){
    return repository.obtenenerMonitoreos();
 }
 public Monitoreo buscarId(int id){
    return repository.buscarId(id);
 }
 public Monitoreo guardarMonitoreo(Monitoreo mon){
    return repository.guardar(mon);
 }
 public Monitoreo actualizarMonitoreo(Monitoreo mon){
    return repository.actualizar(mon);
 }
}
