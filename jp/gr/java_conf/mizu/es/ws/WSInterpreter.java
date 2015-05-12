/* ************************************************************** *
 *                                                                *
 * Copyright (c) 2005, Kota Mizushima, All rights reserved.       *
 *                                                                *
 *                                                                *
 * This software is distributed under the modified BSD License.   *
 * ************************************************************** */
package jp.gr.java_conf.mizu.es.ws;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class WSInterpreter implements WSInstructionConstants {
  private int      pc;
  private Stack    operands;
  private Stack    addrs;
  private Map      labels;
  private Object[] heap;
  
  public WSInterpreter(int heapSize) {
    pc       = 0;
    operands = new Stack();
    addrs    = new Stack();
    labels   = new HashMap(); 
    heap     = new Object[heapSize];
  }
  
  public void run(Program p){
    WSInstruction[] wis = p.getInstructions();
    reset();
    scanLabels(wis);
    for (int i = 0; i < wis.length; i++) {
      WSInstruction wi = wis[i];
      boolean hasNext = perform(wi);
      if(!hasNext) return;
      pc++;
    }
  }
  
  public void reset() {
    operands.clear();
    addrs.clear();
    labels.clear();
    pc = 0;
  }
  
  private boolean perform(WSInstruction wi) {
    switch (wi.getType()) {
    case PUSH: 
      operands.push(wi.getOperands()[0]); 
      break;
    case DUP:
      operands.push(operands.peek());     
      break;
    case COPY:
      int index = to_i(wi.getOperands()[0]).intValue();
      operands.push(operands.get(index));
      break;
    case SWAP:
      Object o1 = operands.pop(), o2 = operands.pop();
      operands.push(o1); operands.push(o2);
      break;
    case DISCARD:
      operands.pop();
      break;
    case SLIDE:
      break;
    case ADD:{
      BigInteger r = popi(), l = popi();
      pushi(l.add(r));
      break;
    }
    case SUB:{
      BigInteger r = popi(), l = popi();
      pushi(l.subtract(r));
      break;
    }
    case MUL:{
      BigInteger r = popi(), l = popi();
      pushi(l.multiply(r));      
      break;
    }
    case DIV:{
      BigInteger r = popi(), l = popi();
      pushi(l.divide(r));
      break;
    }
    case MOD:{
      BigInteger r = popi(), l = popi();
      pushi(l.mod(r));
      break;
    }
    case STORE:{
      BigInteger value = popi(), addr = popi();
      heap[addr.intValue()] = value;
      break;
    }
    case RETR:{
      BigInteger addr = popi();
      pushi((BigInteger)heap[addr.intValue()]);
      break;
    }
    case CALL:
      pushAddr(pc);
      jump(lookupLabel((String)wi.getOperands()[0]));
      break;
    case JUMP:
      jump(lookupLabel((String)wi.getOperands()[0]));
      break;
    case JUMP_IF_ZERO:
      if(popi().equals(BigInteger.ZERO)){
        jump(lookupLabel((String)wi.getOperands()[0]));
      }
      break;
    case JUMP_IF_NEG:
      if(popi().compareTo(BigInteger.ZERO) < 0){
        jump(lookupLabel((String)wi.getOperands()[0]));
      }
      break;
    case RETURN:
      jump(popAddr());
      break;
    case PRINT_CHAR:
      System.out.print((char)popi().intValue());
      break;
    case PRINT_NUM:
      System.out.print(popi());
      break;
    case READ_CHAR:
      break;
    case READ_NUM:
      break;
    case END:
      return false;
    default:
      break;
    }
    return true;
  }
  
  private BigInteger to_i(Object o){ 
    return (BigInteger)o; 
  }
  
  private void jump(int pc) {
    this.pc = pc;
  }
  
  private int popAddr() {
    return ((Integer)addrs.pop()).intValue();
  }
  
  private void pushAddr(int pc) {
    addrs.push(new Integer(pc));
  }
  
  private BigInteger popi(){ 
    return (BigInteger)operands.pop(); 
  }
  
  private void pushi(BigInteger val){
    operands.push(val); 
  }
  
  private void scanLabels(WSInstruction[] wis) {
    for(int i = 0; i < wis.length; i++){
      if(wis[i].getType() == LABEL){
        putLabel((String)wis[i].getOperands()[0], i);
      }
    }
  }
  
  private int lookupLabel(String label) {
    return ((Integer)labels.get(label)).intValue();
  }
  
  private void putLabel(String label, int pc) {
    labels.put(label, new Integer(pc));
  }
}
