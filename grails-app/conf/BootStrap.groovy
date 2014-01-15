import be.strombeek.mindervaliden.Lid

class BootStrap {

	def init = { servletContext ->
		environments {
			development {
				new Lid(naam: 'Bogaerts', voornaam: 'Marc').save(failOnError: true)
			}
		}
	}
	def destroy = {
	}
}
