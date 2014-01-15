package be.strombeek.mindervaliden

class Lid {
	
	String naam
	String voornaam
	Date geboortedatum
	String email
	

    static constraints = {
		naam blank: false, size: 1..50
		voornaam nullable: true, maxSize: 50
		email nullable: true, email: true
		geboortedatum nullable: true  
    }
}
