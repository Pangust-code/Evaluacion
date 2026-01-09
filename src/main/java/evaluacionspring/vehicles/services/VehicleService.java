package evaluacionspring.vehicles.services;

import java.util.List;

import evaluacionspring.vehicles.dtos.CreateVehicleDto;
import evaluacionspring.vehicles.dtos.VehicleResponseDto;


public interface VehicleService {
    
    List<VehicleResponseDto> findAll();

    VehicleResponseDto findByModel(String model);

    VehicleResponseDto create(CreateVehicleDto createVehicleDto);

    void delete(String model);


}
