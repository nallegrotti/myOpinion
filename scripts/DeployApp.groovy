includeTargets << grailsScript("_GrailsInit")

target(main: "Pone en producci�n en appFog la aplicaci�n") {
	println "Deploying..."
    def proc = """cd target; af update; echo 'Termino!'""".execute()
	
	proc.waitFor()
	println proc.in.text
}

setDefaultTarget(main)
