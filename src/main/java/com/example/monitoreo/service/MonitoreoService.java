package com.example.monitoreo.service;

import com.example.monitoreo.dto.CreateDTO;
import com.example.monitoreo.dto.actualiDTO;
import com.example.monitoreo.extencion.extencion;
import com.example.monitoreo.model.Monitoreo;
import com.example.monitoreo.repository.MonitoreoRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class MonitoreoService {
 @Autowired
    private MonitoreoRepository repository;

   public List<Monitoreo> obtenerMonitoreo() {
        return repository.findAll();
    }
 public Monitoreo buscarLecturaPorId(int id) {
        return repository.findById(id).orElseThrow(() -> new extencion("El id no fue encontrado"));
    }  
public Monitoreo registrarMedicion(CreateDTO dto) {
        Monitoreo mon = new Monitoreo();
        mon.setJaulaId(dto.jaulaId());
        mon.setTemperatura(dto.temperatura());
        mon.setOxigeno(dto.oxigenoDisuelto()); 
        mon.setPh(dto.ph());
        mon.setFechaRegistro(dto.fechaRegistro());
          if (dto.temperatura() > 15.0 && dto.oxigenoDisuelto() < 5.0) {
            System.out.println("[ALERTA]: Se ha detectado un crecimiento explosivo de algas.");
        }
        return repository.save(mon);

}
public Monitoreo actualizarMonitoreo(int id, actualiDTO dto){
   Monitoreo mon=buscarLecturaPorId(id);
   mon.setJaulaId(dto.getJaulaId());
   mon.setTemperatura(dto.getTemperatura());
   mon.setOxigeno(dto.getOxigeno());
   mon.setPh(dto.getPh());
   mon.setFechaRegistro(dto.getFechaRegistro());
   return repository.save(mon);


}