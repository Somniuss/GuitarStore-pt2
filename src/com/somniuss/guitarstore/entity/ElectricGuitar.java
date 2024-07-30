package com.somniuss.guitarstore.entity;

import java.util.Objects;
import java.io.Serializable;

public class ElectricGuitar extends MusicalInstrument implements Serializable {

	private static final long serialVersionUID = 1L;

	private String bodyShape;
	private String tremoloSystem;

	public ElectricGuitar() {
	}

	public ElectricGuitar(int id, String type, String brand, String model, double price, String bodyShape,
			String tremoloSystem) {
		super(id, type, brand, model, price);
        this.bodyShape = bodyShape;
        this.tremoloSystem = tremoloSystem;
    }

    public ElectricGuitar(String type, String brand, String model, double price, String bodyShape, String tremoloSystem) {
        super(type, brand, model, price);
        this.bodyShape = bodyShape;
        this.tremoloSystem = tremoloSystem;
    }

    public String getBodyShape() {
        return bodyShape;
    }

    public void setBodyShape(String bodyShape) {
        this.bodyShape = bodyShape;
    }

    public String getTremoloSystem() {
        return tremoloSystem;
    }

    public void setTremoloSystem(String tremoloSystem) {
        this.tremoloSystem = tremoloSystem;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyShape, tremoloSystem);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        ElectricGuitar that = (ElectricGuitar) obj;
        return Objects.equals(bodyShape, that.bodyShape) && Objects.equals(tremoloSystem, that.tremoloSystem);
    }

    @Override
    public String toString() {
        return getClass().getName() + " [id=" + getId() + ", type=" + getType() + ", brand=" + getBrand() + ", model=" + getModel() + ", price=" + getPrice() + ", bodyShape=" + bodyShape + ", tremoloSystem=" + tremoloSystem + "]";
    }
}
