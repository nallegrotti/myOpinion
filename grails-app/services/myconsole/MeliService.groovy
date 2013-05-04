package myconsole

class MeliService {
	def rest = new grails.plugins.rest.client.RestBuilder()
	def domain = "https://api.mercadolibre.com"

    def apiGet = {resource, success, failure = { r -> println "Status: $r.status :: boby: $r.body" } ->
		def resp = rest.get "${domain}$resource"
		if (resp.status == 200){
			success(resp.json)
		}else{
			failure(resp)
		}
    }
}
