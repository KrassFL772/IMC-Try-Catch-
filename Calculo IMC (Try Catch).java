import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        try {
            String nombre = JOptionPane.showInputDialog("Ingresa tu nombre: ");
            String pesoStr = JOptionPane.showInputDialog("Ingresa tu peso en KG: ");
            String alturaStr = JOptionPane.showInputDialog("Ingresa tu estatura en MT (metros): ");

            // Validación de entrada
            float peso = Float.parseFloat(pesoStr);
            float altura = Float.parseFloat(alturaStr);

            // Crear objeto Paciente
            Paciente paciente = new Paciente(nombre, peso, altura);

            // Mostrar el resultado del IMC
            JOptionPane.showMessageDialog(null, paciente.calcularImc(), "Resultado del IMC", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingresa valores numéricos válidos.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error inesperado: " + e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}


public class Paciente {
    private String nombre;
    private float peso;
    private float altura;

    // Constructor
    public Paciente(String nombre, float peso, float altura) {
        this.nombre = nombre;
        setPeso(peso);
        setAltura(altura);
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        if (peso > 0) {
            this.peso = peso;
        } else {
            throw new IllegalArgumentException("El peso debe ser positivo.");
        }
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if (altura > 0) {
            this.altura = altura;
        } else {
            throw new IllegalArgumentException("La altura debe ser positiva.");
        }
    }

    // Método para calcular el IMC
    public String calcularImc() {
        float imc = peso / (altura * altura);
        String categoria;

        if (imc <= 18.5) {
            categoria = "BAJO PESO";
        } else if (imc <= 24.9) {
            categoria = "PESO NORMAL";
        } else if (imc <= 29.9) {
            categoria = "SOBREPESO";
        } else if (imc <= 34.9) {
            categoria = "OBESIDAD TIPO 1";
        } else if (imc <= 39.9) {
            categoria = "OBESIDAD TIPO 2";
        } else {
            categoria = "OBESIDAD TIPO 3";
        }

        return "El IMC de " + nombre + " es: " + String.format("%.2f", imc) + " (" + categoria + ")";
    }
}
