package pt.ulusofona.lp2.deisiJungle;

import static pt.ulusofona.lp2.deisiJungle.MovementResultCode.VALID_MOVEMENT;
import static pt.ulusofona.lp2.deisiJungle.MovementResultCode.INVALID_MOVEMENT;
import static pt.ulusofona.lp2.deisiJungle.MovementResultCode.NO_ENERGY;
import static pt.ulusofona.lp2.deisiJungle.MovementResultCode.CAUGHT_FOOD;


public record MovementResult(MovementResultCode code) {

    public String message(){
        String mensagem = "";
        if(code == VALID_MOVEMENT){

            mensagem = "O movimento do jogador é válido";

        }else if(code == INVALID_MOVEMENT){

            mensagem = "O movimento do jogador é inválido";

        }else if(code == NO_ENERGY){

            mensagem = "O jogador não têm energia";

        }else if(code == CAUGHT_FOOD){

            mensagem = "O jogador comeu um alimento";

        }
        return mensagem;
    }
}
