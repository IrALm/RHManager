package com.backend.Gestion_Employee.repository;
import com.backend.Gestion_Employee.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
