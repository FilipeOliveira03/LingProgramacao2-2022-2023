package pt.ulusofona.lp2.deisiJungle;

public record InitializationError(Boolean inicializou) {

    public String getMessage(){
        if(inicializou){
            return "Inicializou corretamente o terreno";
        }else{
            return "Não inicializou corretamente o terreno";
        }

    }
}
