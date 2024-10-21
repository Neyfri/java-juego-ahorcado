import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        // Scanner para leer lo que el usuario pasara por la consola
        Scanner sc = new Scanner(System.in);

        String palabraSecreta = "aptitud";
        int intentosMax = 10;
        int actualintento = 0;
        boolean palabraAdivinada = false;

        // Arreglo de char con la cantidad de letras de la palabra secreta
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // bucle que llena el arreglo de char con '_' 
        for (int index = 0; index < letrasAdivinadas.length; index++) {
            letrasAdivinadas[index] = '_';
        }

        while (!palabraAdivinada && actualintento < intentosMax) {
            System.out.println("Palabra para adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras.)");

            System.out.println("Introduce una letra, por favor");

            // Se usa scanner para pedir una letra
            char letra = Character.toLowerCase(sc.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                
                if(palabraSecreta.charAt(i) == letra){

                    letrasAdivinadas[i] = letra;

                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                actualintento++;
                System.out.println("!Incorrecto te quedan " + (intentosMax - actualintento) + " intentos.");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                
                palabraAdivinada = true;
                System.out.println("!Felicidades has adivinado la palabra secreta es " + palabraSecreta);
            }
        }

        if (!palabraAdivinada) {
            System.out.println("!Que pena parece que te has quedado sin intentos! Game Over");
        }

        sc.close();
    }
}
