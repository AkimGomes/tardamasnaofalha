package br.com.mobile.tardamasnaofalha

object PaisService {

    fun getPaises(): List<Pais> {
        var paises = mutableListOf<Pais>()

        var pais1 = Pais()
        pais1.id = 1
        pais1.nome = "Brasil"
        pais1.capital = "Brasília"
        pais1.bandeira = "https://http2.mlstatic.com/D_NQ_NP_846593-MLB50471350726_062022-W.jpg"
        pais1.continente = "América do Sul"
        pais1.populacao = "214000000"
        pais1.latitude = "+05o 16'19"
        pais1.longitude = "-60o 12'45"
        paises.add(pais1)

        var pais2 = Pais()
        pais2.id = 2
        pais2.nome = "Itália"
        pais2.capital = "Roma"
        pais2.bandeira = "https://img.freepik.com/vetores-premium/bandeira-italiana-bandeira-da-italia_175392-29.jpg"
        pais2.continente = "Europa"
        pais2.populacao = "59000000"
        pais2.latitude = "12.4942 41° 53′ 26″"
        pais2.longitude = "12° 29′ 39″"
        paises.add(pais2)

        var pais3 = Pais()
        pais3.id = 3
        pais3.nome = "Japão"
        pais3.capital = "Tóquio"
        pais3.bandeira = "https://i.pinimg.com/736x/a5/d6/88/a5d688289cd6850016f14fe93b17da01.jpg"
        pais3.continente = "Ásia"
        pais3.populacao = "125000000"
        pais3.latitude = "139.692 35° 41′ 22″"
        pais3.longitude = "139° 41′ 31″"
        paises.add(pais3)

        return paises
    }
}