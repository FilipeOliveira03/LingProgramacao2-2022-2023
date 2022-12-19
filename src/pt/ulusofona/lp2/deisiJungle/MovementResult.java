package pt.ulusofona.lp2.deisiJungle;

import static pt.ulusofona.lp2.deisiJungle.MovementResultCode.*;

public record MovementResult(MovementResultCode code) {

    private static String outPutalimento;

    public String message(){

        String mensagem = "";

        if(code == VALID_MOVEMENT){

            mensagem = "O movimento do jogador é válido";

        }else if(code == INVALID_MOVEMENT){

            mensagem = "O movimento do jogador é inválido";

        }else if(code == NO_ENERGY){

            mensagem = "O jogador não têm energia";

        }else if(code == CAUGHT_FOOD){

            mensagem = "Apanhou " + outPutalimento;

        }

        return mensagem;
    }

    public static String mudaOutPutAlimento(String alimento) {
        return outPutalimento = alimento;
    }
}
