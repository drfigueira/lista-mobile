package br.edu.ifsp.calculadoraimc;

public interface BodyService {

    static Double calculateIMC(Body body) {
        return body.getWeight() / (body.getHeight() * body.getHeight());
    }

    static String info(Double imc) {
        String text = "";
        if(imc < 18.5) {
            text = "Magreza!";
        }else if(imc >= 18.5 && imc <= 24.9) {
            text = "Normal!";
        }else if(imc > 24.9 && imc <= 30) {
            text = "Sobrepeso!";
        }else {
            text = "Obesidade!";
        }
        return text;
    }
}
