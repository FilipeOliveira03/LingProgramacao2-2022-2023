package pt.ulusofona.lp2.deisiJungle;

import static pt.ulusofona.lp2.deisiJungle.InitializationErrorCode.*;

public record InitializationError(InitializationErrorCode code){

    public String getMessage(){

        String mensagem = "";
        
        if(code == INVALID_ID_WITHOUT_NUMBERS){
            
            mensagem = "O jogador apresenta um ID com caracteres não núméricos";
            
        }else if(code == INVALID_ID_WITH_NEGATIVE_NUMBERS){

            mensagem = "O jogador apresenta um ID com valores negativos";

        }else if(code == INVALID_PLAYERS_WITH_SAME_ID){

            mensagem = "Existem pelo menos dois jogadores com ids iguais";

        }else if(code == INVALID_PLAYER_NAME){

            mensagem = "O jogador apresenta um nome vazio ou null";

        }else  if(code == INVALID_JUST_ONE_TARZAN){

            mensagem = "Não há só um Tarzan";

        }else if(code == INVALID_NUMBER_OF_PLAYERS){

            mensagem = "O número de jogadores é inválido";

        }else if(code == INVALID_SPECIE_INEXISTANTE){

            mensagem = "A espécie não existe";

        }else if(code == INVALID_FOOD_POSITION){

            mensagem = "A comida está fora dos limites do terreno ou na casa inicial/final";

        }else if(code == INVALID_FOOD_DOES_NOT_EXIST){
         
                     mensagem = "A comida não existe";
         
                 }

        return mensagem;
    }
}
