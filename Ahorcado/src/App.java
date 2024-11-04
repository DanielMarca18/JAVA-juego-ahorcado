import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Declaramos scanner para que el usuario pueda leer
        Scanner scanner = new Scanner(System.in);

        // declaramos y asignamos 
        String palabraSecreta = "inteligencia";
        int intentosMax = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Arreglos:
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

            // Esctructura de control: (Bucle). Este nos colocara la cantidad de guiones que tiene la palabra secreta
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            // System.out.print(letrasAdivinadas[i]);
        }
        // este bucle nos verificara si las letras que introducimos son parte de la palabra secreta
        while (!palabraAdivinada && intentos < intentosMax) {
            // el"valueof" se usa cuando tenemos una palabra de chars
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " " + palabraSecreta.length() + " letras");

            System.out.println("Introduce una letra por favor: ");
            // usamos la clase scanner para pedir registrar la letra. el metodo charAt(0) nos permitira tommar solo la primera letra por si el jugador introduce varias, pero entes convierte en minisculas por si el jugador introduce letras  mayusculas
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;
            // con es te bucle vamos a recorrer la palbra secreta y vera si latre agregada por el jugador esta en ella
            for (int i = 0; i < palabraSecreta.length(); i++) {
                // si esta la letra la introducimos en la palabra secreta y letra correcta sera true
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            // aca agregams intentos encaso de que la letra sea incorrecta
            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! Te quedan " + (intentosMax - intentos) + " intentos.");
            }
            // aca verifivamos si la palabra fue adivinada utilizamos "equals" que es el metodo que compara si los string son iguales
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades, has adivinado la palabra secreta: " + palabraSecreta);
            }

        }

        // aca se imprime si es que no llego a adivinar la palabra
        if (!palabraAdivinada) {
            System.out.println("¡Qué pena te quedaste sin intentos!");
        }

        scanner.close();

    }
}
