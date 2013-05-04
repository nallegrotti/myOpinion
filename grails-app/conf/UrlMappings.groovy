class UrlMappings {

	static mappings = {
		"/opino/que" {
			controller = 'opino'
			action = ["GET":"que", "POST":"queSave"]
		}
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
