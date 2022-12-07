package pt.ulusofona.lp2.deisiJungle;

import static pt.ulusofona.lp2.deisiJungle.InitializationErrorCode.*;

public class InitializationError{

    public String getMessage(Boolean inicializou){

        String mensagem = "";
        if(inicializou){
            mensagem = "yes";
        }else{
            mensagem = "no";
        }


        return mensagem;
    }
}
