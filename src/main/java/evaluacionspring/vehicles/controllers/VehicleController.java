package evaluacionspring.vehicles.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import evaluacionspring.vehicles.dtos.CreateVehicleDto;
import evaluacionspring.vehicles.dtos.VehicleResponseDto;
import evaluacionspring.vehicles.services.VehicleService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

        @GetMapping
    public List<VehicleResponseDto> findAll() {
        return vehicleService.findAll();
    }

        @GetMapping("/{id}")
    public VehicleResponseDto findOne(@PathVariable("model") String model) {
        return vehicleService.findByModel(model);
    }

        @PostMapping
    public ResponseEntity<VehicleResponseDto> create(
            @Valid @RequestBody CreateVehicleDto vehiDto
    ) {
        VehicleResponseDto created = vehicleService.create(vehiDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }


        @DeleteMapping("/{String}")
    public ResponseEntity<Void> delete(@PathVariable("model") String model) {
        vehicleService.delete(model);
        return ResponseEntity.noContent().build();
    }
        
        

    
}
