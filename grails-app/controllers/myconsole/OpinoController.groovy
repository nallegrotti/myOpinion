package myconsole

import grails.converters.JSON;
import static java.lang.Math.*

class OpinoController {
	def opinionService

	def index() {
	}

	def que = { params ->
		def opiniones = Opinion.list().sort {(new Date().time - it.lastUpdated.time)/1000*60*60 + (it.puntos?:0)}
		render view: 'opinoQue' , model:[opiniones:opiniones]
	}

	def queSave = { params ->
		if (params.msg){
			new Opinion(opinion:params.msg, name:opinionService.randomName).save()
		}
		redirect action:'que'
	}

	def acuerdo = { params ->
		if (params.id){
			def opinion = Opinion.get(params.id)
			opinion?.puntos = (opinion?.puntos?:0) +1 
			opinion.save()
			render ([result:"OK", description: "up 1 point", points:opinion.puntos] as JSON)
		}else{
			render ([result:"error", description: "ID required"] as JSON)
		}
	}

	def desacuerdo = { params ->
		if (params.id){
			def opinion = Opinion.get(params.id)
			opinion?.puntos = (opinion?.puntos?:0) -1 
			opinion.save()
			render ([result:"OK", description: "down 1 point", points:opinion.puntos] as JSON)
		}else{
			render ([result:"error", description: "ID required"] as JSON)
		}
	}
}
