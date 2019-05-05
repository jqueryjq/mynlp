package com.mayabot.nlp.perceptron

import com.mayabot.nlp.collection.dat.DoubleArrayTrie

/**
 * DAT的特征集合构建器
 */
class DATFeatureSetBuilder(labelCount: Int) {

    private val keys = HashSet<String>()

    init {
        // Hanlp需要从 0=< <= labelCount 上站位 占用labelCount+1个位置
        //  BL= 要保证这个排在前面
        for (i in 0..labelCount) {
            keys.add("\u0000\u0001BL=$i")
        }
    }

    fun put(feature: String) {
        keys.add(feature)
    }

    fun build(): FeatureSet {
        val list = keys.sorted()
        return FeatureSet(DoubleArrayTrie(list), list)
    }

}
