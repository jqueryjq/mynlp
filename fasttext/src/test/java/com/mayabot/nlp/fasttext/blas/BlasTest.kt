package com.mayabot.nlp.fasttext.blas

import org.junit.Test

class BlasTest {

    @Test
    fun test(){
       val m = FloatArrayMatrix(5,5)
        m.gaussRandom(1)
        println(m[1])
    }
}
