includeTargets << grailsScript("_GrailsInit")

target(main: "Pone en producción en appFog la aplicación") {
	println "Deploying..."
    def proc = """cd target; af update; echo 'Termino!'""".execute()
	
	proc.waitFor()
	println proc.in.text
}

setDefaultTarget(main)
