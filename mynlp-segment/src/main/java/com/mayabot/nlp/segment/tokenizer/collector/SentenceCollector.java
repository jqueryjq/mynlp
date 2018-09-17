package com.mayabot.nlp.segment.tokenizer.collector;

import com.google.common.collect.Lists;
import com.mayabot.nlp.segment.WordTerm;
import com.mayabot.nlp.segment.WordTermCollector;
import com.mayabot.nlp.segment.wordnet.Vertex;
import com.mayabot.nlp.segment.wordnet.Wordnet;
import com.mayabot.nlp.segment.wordnet.Wordpath;
import com.mayabot.nlp.utils.StringUtils;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Nlp收集方式，不处理子词
 * 按照WordPath里面描述的唯一切分路径，构建WordTerm序列
 * @author jimichan
 */
public class SentenceCollector implements WordTermCollector {

    @Override
    public void collect(Wordnet wordnet, Wordpath wordPath, Consumer<WordTerm> consumer) {
        Iterator<Vertex> vertexIterator = wordPath.iteratorVertex();
        while (vertexIterator.hasNext()) {
            Vertex vertex = vertexIterator.next();

            WordTerm term = new WordTerm(vertex.realWord(), vertex.guessNature());
            term.setOffset(vertex.getRowNum());

            //默认把空白的字符去除掉
            if (StringUtils.isWhiteSpace(term.word)) {
                continue;
            }

            consumer.accept(term);
        }
    }

    public static void main(String[] args) {

        List<B> listB = Lists.newArrayList();
        List<? extends A> listA = listB;

        System.out.println(listA);

    }


    static class A {

    }

    static class B extends A {

    }
}