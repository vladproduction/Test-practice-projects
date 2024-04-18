package com.vladproduction.dockertestcontainerdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by vladproduction on 18-Apr-24
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {

    @Id
    private Long id;

    private String name;

}
