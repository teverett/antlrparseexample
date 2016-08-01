package com.khubla.scalaparser;

import java.io.InputStream;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.scalaparser.grammar.ScalaLexer;
import com.scalaparser.grammar.ScalaParser;
import com.scalaparser.grammar.ScalaParser.CompilationUnitContext;

/**
 * @author tom
 */
public class ScalaDocumentParser {
   public static CompilationUnitContext parse(InputStream inputStream) throws Exception {
      try {
         final ScalaLexer scalaLexer = new ScalaLexer(new ANTLRInputStream(inputStream));
         final CommonTokenStream tokens = new CommonTokenStream(scalaLexer);
         final ScalaParser scalaParser = new ScalaParser(tokens);
         return scalaParser.compilationUnit();
      } catch (final Exception e) {
         throw new Exception("Exception in parse", e);
      }
   }
}
