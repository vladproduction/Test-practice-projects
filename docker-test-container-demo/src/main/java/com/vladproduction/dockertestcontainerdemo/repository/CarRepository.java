package com.vladproduction.dockertestcontainerdemo.repository;

import com.vladproduction.dockertestcontainerdemo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vladproduction on 18-Apr-24
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
