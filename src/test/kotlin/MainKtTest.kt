import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MainKtTest {

    @Test
    fun parseExpression() {
        assertEquals(5232, parseExpression("5232"))
        assertEquals(2901, parseExpression("(57)*(43-24+6)*2+51"))
        assertEquals(28995, parseExpression("912*32+(321-102*5)"))
        assertEquals(2950, parseExpression("2914+2*20-2*2"))
        assertEquals(17883, parseExpression("(((322*54-5)+43)-25+(432-1*2+52))"))
        assertEquals(346187520, parseExpression("3*2*5*(6*2)*53*(432*(42))"))
    }
}