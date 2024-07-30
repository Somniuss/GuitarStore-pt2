package com.somniuss.guitarstore.entity;

import java.util.Objects;
import java.io.Serializable;

public class BassGuitar extends MusicalInstrument implements Serializable {

	private static final long serialVersionUID = 1L;

	private String electronics;

	public BassGuitar() {
	}

	public BassGuitar(int id, String type, String brand, String model, double price, String electronics) {
		super(id, type, brand, model, price);
		this.electronics = electronics;
    }

    public BassGuitar(String type, String brand, String model, double price, String electronics) {
        super(type, brand, model, price);
        this.electronics = electronics;
    }

    public String getElectronics() {
        return electronics;
    }

    public void setElectronics(String electronics) {
        this.electronics = electronics;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), electronics);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        BassGuitar that = (BassGuitar) obj;
        return Objects.equals(electronics, that.electronics);
    }

    @Override
    public String toString() {
        return getClass().getName() + " [id=" + getId() + ", type=" + getType() + ", brand=" + getBrand() + ", model=" + getModel() + ", price=" + getPrice() + ", electronics=" + electronics + "]";
    }
}
