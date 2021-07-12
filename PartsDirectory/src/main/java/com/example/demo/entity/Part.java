package com.example.demo.entity;

import javax.persistence.*;


@Entity
@Table(name = "part")

public class Part {
    // Define fields
    @Id //Will Map the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Will auto increment the primary key
    @Column(name = "id") // Maps the primary key to the id column in DB
    private int id;

    @Column(name = "part_name")
    private String partName;

    @Column(name = "color")
    private String color;

    @Column(name = "weight")
    private String weight;

    @Column(name = "sku")
    private String sku;

    // Default constructor
    public Part() {
    }

    // Parameter constructor
    public Part(String partName, String color, String weight, String sku) {
        this.partName = partName;
        this.color = color;
        this.weight = weight;
        this.sku = sku;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", color='" + color + '\'' +
                ", weight='" + weight + '\'' +
                ", sku='" + sku + '\'' +
                '}';
    }

}
