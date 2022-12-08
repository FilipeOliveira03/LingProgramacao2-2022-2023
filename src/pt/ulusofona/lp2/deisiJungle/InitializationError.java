package pt.ulusofona.lp2.deisiJungle;

import static pt.ulusofona.lp2.deisiJungle.InitializationErrorCode.*;

public record InitializationError(InitializationErrorCode code){

    public String getMessage(){

        String mensagem = "";

        if(code == INVALID_IDS){

            mensagem = "Os IDS são inválidos";

        }else if(code == INVALID_NAME){

            mensagem = "O nome é inválido";

        }else if(code == INVALID_SPECIE){

            mensagem = "A espécie é inválida";

        }else if(code == INVALID_FOOD){

            mensagem = "A comida é inválida";

        }else if(code == INVALID_POSITION_FOOD){

            mensagem = "A posição da comida é inválida";

        }else if(code == INVALID_NUM_PLAYERS){

            mensagem = "Numero de jogadores inválido";

        }else if(code == INVALID_MAP_CONFIGURATION){

            mensagem = "Não existem, pelo menos, duas posições por cada jogador";

        }

        return mensagem;
    }
}
