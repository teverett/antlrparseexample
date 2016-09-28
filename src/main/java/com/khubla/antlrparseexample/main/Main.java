package com.khubla.antlrparseexample.main;

import java.io.InputStream;

import com.khubla.antlrparseexample.DocumentParser;

/**
 * @author tom
 */
public class Main {
   /**
    * main
    */
   static public void main(String args[]) throws Exception {
      InputStream inputStream = Main.class.getResourceAsStream("/Java8Parser.java");
      DocumentParser.parse(inputStream);
   }
}
