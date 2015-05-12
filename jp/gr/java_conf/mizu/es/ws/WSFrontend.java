/* ************************************************************** *
 *                                                                *
 * Copyright (c) 2005, Kota Mizushima, All rights reserved.       *
 *                                                                *
 *                                                                *
 * This software is distributed under the modified BSD License.   *
 * ************************************************************** */
package jp.gr.java_conf.mizu.es.ws;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import jp.gr.java_conf.mizu.es.ws.parser.ParseException;
import jp.gr.java_conf.mizu.es.ws.parser.WSParser;

public class WSFrontend {
  private WSInterpreter p;
  public WSFrontend(int heapSize) {
    p = new WSInterpreter(heapSize);
  }
  
  public WSFrontend(){
    this(1000000);
  }
  
  public void run(String program) throws ParseException {
    run(new StringReader(program));
  }
  
  public void run(Reader program) throws ParseException {
    Program ast = new WSParser(program).Program();
    System.out.println(ast);
    p.run(ast);
  }
  
  public static void main(String[] args) throws Exception {
    if(args.length == 0){
      System.err.println("Usage: java -jar ws.jar <file>");
    }else{
      new WSFrontend(1000000).run(new FileReader(args[0]));
    }
  }
}
