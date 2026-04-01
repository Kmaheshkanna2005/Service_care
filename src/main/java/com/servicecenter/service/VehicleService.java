package com.servicecenter.service;

import com.servicecenter.entity.Customer;
import com.servicecenter.entity.Vehicle;
import com.servicecenter.exception.ResourceNotFoundException;
import com.servicecenter.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.servicecenter.repository.CustomerRepository;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {

        Vehicle existing = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with id: " + id));

        existing.setVehicleType(vehicle.getVehicleType());
        existing.setBrand(vehicle.getBrand());
        existing.setModel(vehicle.getModel());
        existing.setRegistrationNumber(vehicle.getRegistrationNumber());

        return vehicleRepository.save(existing);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {

        Long customerId = vehicle.getCustomer().getId();

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        vehicle.setCustomer(customer);

        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public List<Vehicle> getVehiclesByCustomerId(Long customerId) {
        return vehicleRepository.findByCustomerId(customerId);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}