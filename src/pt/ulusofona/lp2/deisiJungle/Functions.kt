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
        "PLAYERS_BY_SPECIE" -> return getPlayersBySpecie(manager, args)
        "MOST_TRAVELED" -> return getMostTraveled(manager,args)
        "TOP_ENERGETIC_OMNIVORES" -> return getTopEnergeticOmniveres(manager,args)
    }
    return null
}

fun comandoPost (manager: GameManager, args: List<String>) : String?{
    return null
}

fun getPlayerInfo(manager: GameManager, args: List<String>): String? {

    val players : List<Player> = manager.jogadores.filter { it.nome.equals(args[1]) }

    if(players.isEmpty()){
        return "Inexistent player"
    }

    val player = players[0]

    val id : Int = player.id
    val nome : String = player.nome
    val nomeEspecie : String = player.especie.nomeEspecie
    val energia : Int = player.especie.energiaAtual
    val posicao : Int = player.posicaoAtual

    return "$id | $nome | $nomeEspecie | $energia | $posicao"
}

fun getPlayersBySpecie(manager: GameManager, args: List<String>): String? {

    val jogadores : List<Player> = manager.jogadores.filter { it.especie.nomeSigla.equals(args[1]) }

    return if(jogadores.isNotEmpty()) {
        jogadores
            .map { it.nome }
            .sortedWith {s1, s2 -> s1.compareTo(s2)}
            .reversed()
            .joinToString(",")
    }else{ "" }
}

fun getMostTraveled(manager: GameManager, args: List<String>): String? {
    val total = manager.jogadores.map { it.distanciaViajada }
        .sortedWith { s1, s2 -> s1.compareTo(s2) }.sum()

    manager.jogadores.sortByDescending { it.distanciaViajada }

    return manager.jogadores.joinToString(separator = "\n")
    { "${it.nome}:${it.especie.nomeSigla}:${it.distanciaViajada}" }.plus("\nTotal:$total")
}

fun getTopEnergeticOmniveres(manager: GameManager, args: List<String>): String? {

    manager.jogadores.sortByDescending { it.especie.energiaAtual }

    return manager.jogadores.filter { it.especie.tipoAlimentacao.equals("Omnívoro") }
        .take(args[1].toInt())
        .joinToString(separator = "\n") { "${it.nome}:${it.especie.energiaAtual}" }

}

fun main() {

    val manager = GameManager()

    val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "Z"), arrayOf("22", "Tomas", "T"),
        arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

    val arrayAlimentos = arrayOf(arrayOf("e", "2"), arrayOf("b", "3"))

    manager.createInitialJungle(30, arrayPlayers, arrayAlimentos)
    manager.moveCurrentPlayer(3,false)
    manager.moveCurrentPlayer(4,false)
    manager.moveCurrentPlayer(2,false)
    manager.moveCurrentPlayer(2,false)
    manager.moveCurrentPlayer(2,false)

    val routerFn = router()
    val commandGetFn = routerFn.invoke(CommandType.GET)
    val result = commandGetFn.invoke(manager, listOf("TOP_ENERGETIC_OMNIVORES", "2"))
    println(result)
}
