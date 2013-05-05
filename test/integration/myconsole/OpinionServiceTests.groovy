package myconsole

import grails.test.mixin.*
import org.junit.*

class OpinionServiceTests {
	def opinionService
	
	@Test
    void devuelve500Opiniones() {
        (0..505).each{
			Opinion.build()
        }
		assert opinionService.opiniones.size() == 500
    }
	
	@Test
	void primeroLosRecientes() {
		Opinion.build(opinion:"uno")
		Opinion.build(opinion:"dos")
		Opinion.build(opinion:"tres")
		Opinion.build(opinion:"cuatro")

		assert opinionService.opiniones*.opinion == ['cuatro', 'tres', 'dos', 'uno']
	}

	@Test
	void primeroLosMejores() {
		Opinion.build(opinion:"uno", puntos:10)
		Opinion.build(opinion:"dos", puntos:5)
		Opinion.build(opinion:"tres", puntos:1)

		assert opinionService.opiniones*.opinion == ['uno', 'dos', 'tres']
	}
}
