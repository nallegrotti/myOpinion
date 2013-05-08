package myconsole
import static java.lang.Math.*


class OpinionService {
	def grailsApplication

	def antiguedadEnDias( fecha ){
		double antiguedad = System.currentTimeMillis() - fecha.time
		antiguedad / (1000D*60D*60D)
	}

    def getOpiniones(){
		def res = Opinion.list().sort {
			antiguedadEnDias(it.lastUpdated) - (it.puntos?:0)
		}
		res[0..min(499, res.size()-1)]
	}

	def getRandomName(){
		def nombres = grailsApplication.config.general.names
		nombres[(random()*nombres.size()) as Integer]
	}
}
