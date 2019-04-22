package br.edu.ifsp.calculadoraimc;

public class Body {

    private Double weight;

    private Double height;

    public Body(Double weight, Double height) {
        this.weight = weight;
        this.height = height / 100;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height / 100;
    }
}
