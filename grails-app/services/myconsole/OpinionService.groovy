package myconsole
import static java.lang.Math.*


class OpinionService {
	def grailsApplication

    def getOpiniones(){
		Opinion.withCriteria {
			maxResults 500
			order 'puntos', 'desc'
			order 'lastUpdated', 'desc'
		}
	}

	def getRandomName(){
		def nombres = grailsApplication.config.general.names
		nombres[(random()*nombres.size()) as Integer]
	}
}
