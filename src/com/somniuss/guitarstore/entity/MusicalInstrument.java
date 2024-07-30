package com.somniuss.guitarstore.entity;

import java.util.Objects;
import java.io.Serializable;

import com.somniuss.guitarstore.util.GenerateId;

public class MusicalInstrument implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String type;
	private String brand;
	private String model;
	private double price;

	public MusicalInstrument() {
	}

	public MusicalInstrument(int id, String type, String brand, String model, double price) {
		this.id = id;
		this.type = type;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public MusicalInstrument(String type, String brand, String model, double price) {
        this.id = GenerateId.nextId();
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, brand, model, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MusicalInstrument that = (MusicalInstrument) obj;
        return id == that.id &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(type, that.type) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(model, that.model);
    }

    @Override
    public String toString() {
        return getClass().getName() + " [id=" + id + ", type=" + type + ", brand=" + brand + ", model=" + model + ", price=" + price + "]";
    }
}
