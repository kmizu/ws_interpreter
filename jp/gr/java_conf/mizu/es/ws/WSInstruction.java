/* ************************************************************** *
 *                                                                *
 * Copyright (c) 2005, Kota Mizushima, All rights reserved.       *
 *                                                                *
 *                                                                *
 * This software is distributed under the modified BSD License.   *
 * ************************************************************** */
package jp.gr.java_conf.mizu.es.ws;

import java.math.BigInteger;

public class WSInstruction implements WSInstructionConstants {
  private int type;
  private Object[] operands;
  private Location location;
  
  public WSInstruction(int type, Object[] operands, Location location) {
    this.type = type;
    this.operands = operands;
    this.location = location;
  }
  
  public int getType() {
    return type;
  }
  
  public Object[] getOperands() {
    return operands;
  }
  
  public Location getLocation() {
    return location;
  }
  
  public String toString() {
    switch (type) {
    case PUSH: 
      return "PUSH " + operands[0];
    case DUP:
      return "DUP";
    case COPY:
      return "COPY_" + operands[0];
    case SWAP:
      return "SWAP";
    case DISCARD:
      return "DISCARD";
    case SLIDE:
      return "SLIDE";
    case ADD:
      return "ADD";
    case SUB:
      return "SUB";
    case MUL:
      return "MUL";
    case DIV:
      return "DIV";
    case LABEL:
      return "" + operands[0] + ":";
    case MOD:
      return "MOD";
    case STORE:
      return "STORE";
    case RETR:
      return "RETR";
    case CALL:
      return "CALL " + operands[0];
    case JUMP:
      return "JUMP " + operands[0];
    case JUMP_IF_ZERO:
      return "JUMP_IF_ZERO " + operands[0];
    case JUMP_IF_NEG:
      return "JUMP_IF_ZEG " + operands[0];
    case RETURN:
      return "RETURN";
    case PRINT_CHAR:
      return "PRINT_CHAR";
    case PRINT_NUM:
      return "PRINT_NUM";
    case READ_CHAR:
      return "READ_CHAR";
    case READ_NUM:
      return "READ_NUM";
    case END:
      return "END";
    default:
      return "";
    }
  }
}