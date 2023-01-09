package pt.ulusofona.lp2.deisiJungle

import kotlin.test.assertEquals
import org.junit.Test

class TestFunctions(){

    @Test
    fun testGetPlayerInfo(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),
            arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

        val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers, arrayAlimentos)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(20,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("PLAYER_INFO", "Pedro"))
        val resultadoEsperado = "11 | Pedro | Elefante | 200 | 2"
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testGetPlayerInfo2(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),
            arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

        val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers, arrayAlimentos)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(20,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("PLAYER_INFO", "Alberto"))
        val resultadoEsperado = "Inexistent player"
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testGetPlayersBySpecie(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),
            arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

        val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers, arrayAlimentos)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(20,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("PLAYERS_BY_SPECIE", "T"))
        val resultadoEsperado = "Tomas,Lucas"
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testGetPlayersBySpecie2(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),
            arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

        val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers, arrayAlimentos)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(20,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("PLAYERS_BY_SPECIE", "F"))
        val resultadoEsperado = ""
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testGetMostTraveled(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),
            arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

        val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers, arrayAlimentos)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(20,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("MOST_TRAVELED", ""))
        val resultadoEsperado = "Tomas:T:20\n" +
                "Pedro:E:1\n" +
                "Lucas:T:1\n" +
                "Joao:E:0\n" +
                "Total:22"
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testGetTopEnergeticOmniveres(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),
            arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

        val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers, arrayAlimentos)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(20,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("TOP_ENERGETIC_OMNIVORES", "2"))
        val resultadoEsperado = "Lucas:189\n" +
                "Tomas:130"
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testGetConsumedFoods(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "Z"), arrayOf("22", "Tomas", "T"),
            arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

        val arrayAlimentos = arrayOf(arrayOf("c", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"), arrayOf("e", "6"))

        manager.createInitialJungle(30, arrayPlayers, arrayAlimentos)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)
        manager.moveCurrentPlayer(1,false)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        val resultadoReal = commandGetFn.invoke(manager, listOf("CONSUMED_FOODS", "2"))
        val resultadoEsperado = "Agua\n" +
                "Cacho de bananas\n" +
                "Carne\n" +
                "Cogumelo Magico\n" +
                "Erva"
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testPostMove1(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),
            arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

        val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers, arrayAlimentos)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(20,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("MOVE", "2"))
        val resultadoEsperado = "Apanhou comida"
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testPostMove2(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),
            arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

        val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers, arrayAlimentos)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(20,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("MOVE", "100"))
        val resultadoEsperado = "Movimento invalido"
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testPostMove3(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),
            arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

        val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers, arrayAlimentos)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("MOVE", "1"))
        val resultadoEsperado = "OK"
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testPostMove4(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),
            arrayOf("112", "Joao", "E"), arrayOf("12", "Lucas", "T"))

        //val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("MOVE", "1"))
        val resultadoEsperado = "OK"
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testPostMove5(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),)

        //val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        manager.moveCurrentPlayer(20,true)
        manager.moveCurrentPlayer(20,true)
        manager.moveCurrentPlayer(-20,true)
        manager.moveCurrentPlayer(-20,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("MOVE", "20"))
        val resultadoEsperado = "Sem energia"
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testGetNull(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),)

        //val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.GET)
        manager.moveCurrentPlayer(20,true)
        manager.moveCurrentPlayer(20,true)
        manager.moveCurrentPlayer(-20,true)
        manager.moveCurrentPlayer(-20,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("A", "20"))
        val resultadoEsperado = null
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testPostNull(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),)

        //val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        manager.moveCurrentPlayer(20,true)
        manager.moveCurrentPlayer(20,true)
        manager.moveCurrentPlayer(-20,true)
        manager.moveCurrentPlayer(-20,true)
        manager.moveCurrentPlayer(1,true)
        manager.moveCurrentPlayer(1,true)
        val resultadoReal = commandGetFn.invoke(manager, listOf("A", "20"))
        val resultadoEsperado = null
        assertEquals( resultadoEsperado, resultadoReal)
    }

    @Test
    fun testMove(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "E"), arrayOf("22", "Tomas", "T"),arrayOf("33", "Joao", "T"))

        //val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        commandGetFn.invoke(manager, listOf("MOVE", "8"))
        commandGetFn.invoke(manager, listOf("MOVE", "2"))
        commandGetFn.invoke(manager, listOf("MOVE", "-10"))
        manager.currentPlayerInfo

    }

    @Test
    fun testMove2(){

        val manager = GameManager()

        val arrayPlayers = arrayOf(arrayOf("11", "Pedro", "P"), arrayOf("22", "Tomas", "T"),arrayOf("33", "Joao", "T"))

        //val arrayAlimentos = arrayOf(arrayOf("b", "2"), arrayOf("b", "3"), arrayOf("m", "4"), arrayOf("a", "5"))

        manager.createInitialJungle(30, arrayPlayers)

        val routerFn = router()
        val commandGetFn = routerFn.invoke(CommandType.POST)
        val result = commandGetFn.invoke(manager, listOf("MOVE", "60"))
        println(result)
        manager.currentPlayerInfo

    }
}


