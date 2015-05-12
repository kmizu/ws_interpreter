/* ************************************************************** *
 *                                                                *
 * Copyright (c) 2005, Kota Mizushima, All rights reserved.       *
 *                                                                *
 *                                                                *
 * This software is distributed under the modified BSD License.   *
 * ************************************************************** */
package jp.gr.java_conf.mizu.es.ws;

public class Program implements WSInstructionConstants {
  private WSInstruction[] instructions;

  public Program(WSInstruction[] instructions) {
    this.instructions = instructions;
  }

  public WSInstruction[] getInstructions() {
    return instructions;
  }
  
  public String toString() {
    StringBuffer buf = new StringBuffer();
    String lineSeparator = System.getProperty("line.separator");
    for(int i = 0; i < instructions.length; i++){
      buf.append(instructions[i].toString());
      buf.append(lineSeparator);
    }
    return new String(buf);
  }
}
