package com.khubla.antlrparseexample;

import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.khubla.antlrparseexample.grammar.Java8Lexer;
import com.khubla.antlrparseexample.grammar.Java8Parser;
import com.khubla.antlrparseexample.grammar.Java8Parser.CompilationUnitContext;

/**
 * @author tom
 */
public class DocumentParser {
   public static CompilationUnitContext parse(InputStream inputStream) throws Exception {
      try {
         final Java8Lexer lexer = new Java8Lexer(new ANTLRInputStream(inputStream));
         final CommonTokenStream tokens = new CommonTokenStream(lexer);
         final Java8Parser parser = new Java8Parser(tokens);
         return parser.compilationUnit();
      } catch (final Exception e) {
         throw new Exception("Exception in parse", e);
      }
   }
}
