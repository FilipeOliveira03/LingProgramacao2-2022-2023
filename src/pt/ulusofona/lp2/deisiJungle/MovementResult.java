package pt.ulusofona.lp2.deisiJungle;

import static pt.ulusofona.lp2.deisiJungle.MovementResultCode.*;

public record MovementResult(MovementResultCode code) {

    private static String outPutalimento;

    public String message(){

        if(code == CAUGHT_FOOD){

            return "Apanhou " + outPutalimento;
        }

        return null;

    }

    public static String mudaOutPutAlimento(String alimento) {
        return outPutalimento = alimento;
    }
}
