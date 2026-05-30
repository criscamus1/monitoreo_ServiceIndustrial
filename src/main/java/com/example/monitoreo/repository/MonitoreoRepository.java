package com.example.monitoreo.repository;

import com.example.monitoreo.model.Monitoreo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class MonitoreoRepository {

 private List<Monitoreo> listaMonitoreo=new ArrayList<>(); 

 public List<Monitoreo> obtenenerMonitoreos (){
    return listaMonitoreo;
 }

 public Monitoreo buscarId(int id){
    for(Monitoreo mon:listaMonitoreo){
        if(mon.getId()== id){
            return mon;
        }
    }
    return  null;
 }

 public Monitoreo actualizar(Monitoreo mon){
    int id=0;
    int idPosicion=0;
    
    for(int i = 0 ; i<listaMonitoreo.size();i++ ){
        if(listaMonitoreo.get(i).getId()==mon.getId()){
            id=mon.getId();
            idPosicion=1;
        }
    }
    Monitoreo mon1=new Monitoreo();
    mon1.setId(id);
    mon1.setIdJaula(mon.getIdJaula());
    mon1.setTemperatura(mon.getTemperatura());
    mon1.setOxigeno(mon.getOxigeno());
    mon1.setPh(mon.getPh());
    mon1.setFecha(mon.getFecha());
    listaMonitoreo.set(idPosicion, mon1);
    return mon1;
 }
public Monitoreo guardar(Monitoreo mon){
    listaMonitoreo.add(mon);
    return mon;
}

 
}
