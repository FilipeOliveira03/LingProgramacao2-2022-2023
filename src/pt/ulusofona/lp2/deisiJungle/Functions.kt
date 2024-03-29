package pt.ulusofona.lp2.deisiJungle
import pt.ulusofona.lp2.deisiJungle.jogador.Player
import java.util.*
import kotlin.system.measureNanoTime

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
        "CONSUMED_FOODS" -> return getConsumedFoods(manager, args)
    }
    return null
}

fun comandoPost (manager: GameManager, args: List<String>) : String?{
    when(args[0]){
         "MOVE" -> return postMove(manager,args)
    }
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

fun getConsumedFoods(manager: GameManager, args: List<String>): String? {

    val comida : TreeSet<String> = TreeSet<String>()
    val comidaFinal = ArrayList<String>()

    manager.jogadores.forEach { comida.addAll(it.alimentosIngeridos) }

    comida.forEach{
        when(it) {
            "e" -> comidaFinal.add("Erva")
            "a" -> comidaFinal.add("Agua")
            "c" -> comidaFinal.add("Carne")
            "m" -> comidaFinal.add("Cogumelo Magico")
            "b" -> comidaFinal.add("Cacho de bananas")
        }
    }

    return comidaFinal
        .sortedWith {s1, s2 -> s1.compareTo(s2)}
        .joinToString(separator = "\n") { it }
}

fun postMove(manager: GameManager,args: List<String>):String?{

    val infojogador = manager.currentPlayerInfo
    val jogador : List<Player> = manager.jogadores.filter { it.nome.equals(infojogador[1]) }
    val posicaoAtual = jogador[0].posicaoAtual
    val posicaoPrevista = posicaoAtual + args[1].toInt()

    if(args[1].toInt() < 1 || args[1].toInt() > manager.meta ){
        manager.mudarTurno()
        return "Movimento invalido"
    }

    if(manager.tabuleiroAlimentos[posicaoPrevista].equals("b") && manager.bananas[posicaoPrevista]?.countBanCacho?.equals(0) == true){
        manager.mudarTurno()
        return "OK"
    }

    return when(manager.moveCurrentPlayer(args[1].toInt(),true)){
        MovementResult(MovementResultCode.CAUGHT_FOOD) -> "Apanhou comida"
        MovementResult(MovementResultCode.VALID_MOVEMENT) -> "OK"
        MovementResult(MovementResultCode.INVALID_MOVEMENT) -> "Movimento invalido"
        else -> "Sem energia"
    }
}
