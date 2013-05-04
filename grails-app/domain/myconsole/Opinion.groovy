package myconsole

class Opinion {
	
	String opinion
	Date dateCreated
	Date lastUpdated
	Long puntos
	String name

    static constraints = {
		puntos nullable:true
		name nullable:true
    }
}
