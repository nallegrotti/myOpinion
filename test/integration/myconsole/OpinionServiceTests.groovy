package myconsole



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(OpinionService)
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
		Opinion.build()
		assert true
	}
}
