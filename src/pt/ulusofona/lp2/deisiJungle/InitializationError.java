package pt.ulusofona.lp2.deisiJungle;

public record InitializationError(Boolean inicializou){

    public String getMessage(){

        if(inicializou ){
            return "O jogo foi inicializado";
        }else{
            return "O jogo não foi inicializado";
        }
    }
}
