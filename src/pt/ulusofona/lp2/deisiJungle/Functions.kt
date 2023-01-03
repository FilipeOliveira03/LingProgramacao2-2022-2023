package pt.ulusofona.lp2.deisiJungle

import pt.ulusofona.lp2.deisiJungle.jogador.Player

fun router(): Function1<CommandType, Function2<GameManager,List<String>, String? >> {
    return :: criaFuncaoComando
}

fun criaFuncaoComando (commandType: CommandType) : Function2<GameManager,List<String>, String? >{
    return when (commandType){
        CommandType.GET -> :: comandoGet
        CommandType.POST -> :: comandoPost
    }

}

fun comandoGet (manager: GameManager, args: List<String>) : String?{
    when(args[0]){
        "PLAYER_INFO" -> return getPlayerInfo(manager, args)
    }
    return ""
}

fun comandoPost (manager: GameManager, args: List<String>) : String?{
    return ""
}

fun getPlayerInfo(manager: GameManager, args: List<String>): String? {

    val player : Player = manager.jogadores.filter { it.nome.equals(args[1]) }[0]

    if(player.equals(null)){
        return "Inexistent player"
    }

    val id : Int = player.id
    val nome : String = player.nome
    val nomeEspecie : String = player.especie.nomeSigla

    when (nomeEspecie){
        "E" -> nomeEspecie == "Elefante"
        "L" -> nomeEspecie == "Leão"
        "T" -> nomeEspecie == "Tartaruga"
        "P" -> nomeEspecie == "Passáro"
        "Z" -> nomeEspecie == "Tarzan"
    }

    val energia : Int = player.especie.energiaAtual
    val posicao : Int = player.posicaoAtual

    return " $id | $nome | $nomeEspecie | $energia | $posicao"
}

fun main() {
//    val routerFn = router()
//    val commandGetFn = routerFn.invoke(CommandType.GET)
//    val result = commandGetFn.invoke(manager, listOf("PLAYER_INFO", "Pedro"))

}
