package pt.ulusofona.lp2.deisiJungle;

public class InvalidInitialJungleException extends Exception{

    private String message = "";

    public InvalidInitialJungleException(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public boolean isInvalidPlayer(){

        switch (message){
            case "O id de um dos utilizadores não têm números",
                    "O id de um dos utilizadores têm números negativos",
                    "Existem dois jogadores com o mesmo id",
                    "Um dos utilizadores têm um nome inválido",
                    "Existe mais do que um tarzan",
                    "O número de jogadores em jogo é inválido",
                    "A espécie não existe"-> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public boolean isInvalidFood(){

        switch (message){
            case "A posição da comida não é um número",
                    "A posição da comida é inválida", "A comida não existe" -> {
                return true;
            }
            default -> {
                return false;
            }
        }


    }
}
