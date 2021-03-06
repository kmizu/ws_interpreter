/* Generated By:JavaCC: Do not edit this line. WSParser.java */
package jp.gr.java_conf.mizu.es.ws.parser;
import java.math.*;
import java.util.*;
import jp.gr.java_conf.mizu.es.ws.*;

public class WSParser implements WSInstructionConstants, WSParserConstants {
  /* 何回も2を生成しないようにキャッシュしておく */
  private static final BigInteger TWO = new BigInteger("2");
  private static Location loc(Token t){
    return new Location(t.beginLine, t.beginColumn);
  }
  private static Object[] op() { return new Object[0]; }
  private static Object[] op(Object o) { return new Object[]{o}; }
  private static WSInstruction I(int type, Object[] operands, Location location) {
        return new WSInstruction(type, operands, location);
  }

  final public BigInteger number() throws ParseException {
                      boolean positive; List bits = new ArrayList();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case S:
      jj_consume_token(S);
         positive = true;
      break;
    case T:
      jj_consume_token(T);
                                    positive = false;
      break;
    default:
      jj_la1[0] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case T:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
        jj_consume_token(S);
         bits.add(new Integer(0));
        break;
      case T:
        jj_consume_token(T);
                                             bits.add(new Integer(1));
        break;
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(L);
        BigInteger result = new BigInteger("0");
        BigInteger n = new BigInteger("1");
        for(int i = bits.size() - 1; i >= 0; i--){
      int bit = ((Integer)bits.get(i)).intValue();
      if(bit == 1){
        result = result.add(n);
      }
      n = n.multiply(TWO);
        }
    {if (true) return positive ? result : result.negate();}
    throw new Error("Missing return statement in function");
  }

  final public String label() throws ParseException {
                 StringBuffer buf = new StringBuffer();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case T:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
        jj_consume_token(S);
         buf.append("0");
        break;
      case T:
        jj_consume_token(T);
                                    buf.append("1");
        break;
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    jj_consume_token(L);
    {if (true) return new String(buf);}
    throw new Error("Missing return statement in function");
  }

  final public WSInstruction Instruction() throws ParseException {
                              WSInstruction i;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case S:
      i = StackManipulation();
      break;
    default:
      jj_la1[5] = jj_gen;
      if (jj_2_1(2)) {
        i = Arithmetic();
      } else if (jj_2_2(2)) {
        i = HeapAccess();
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case L:
          i = FlowControl();
          break;
        default:
          jj_la1[6] = jj_gen;
          if (jj_2_3(2)) {
            i = IO();
          } else {
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
      }
    }
    {if (true) return i;}
    throw new Error("Missing return statement in function");
  }

  final public WSInstruction StackManipulation() throws ParseException {
                                    Token t; WSInstruction i; BigInteger n;
    t = jj_consume_token(S);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case S:
      jj_consume_token(S);
      n = number();
                       i = new WSInstruction(PUSH, op(n), loc(t));
      break;
    default:
      jj_la1[7] = jj_gen;
      if (jj_2_4(2)) {
        jj_consume_token(L);
        jj_consume_token(S);
                           i = new WSInstruction(DUP, op(), loc(t));
      } else if (jj_2_5(2)) {
        jj_consume_token(T);
        jj_consume_token(S);
        n = number();
                                        i = new WSInstruction(COPY, op(n), loc(t));
      } else if (jj_2_6(2)) {
        jj_consume_token(L);
        jj_consume_token(T);
                           i = new WSInstruction(SWAP, op(), loc(t));
      } else if (jj_2_7(2)) {
        jj_consume_token(L);
        jj_consume_token(L);
                           i = new WSInstruction(DISCARD, op(), loc(t));
      } else if (jj_2_8(2)) {
        jj_consume_token(T);
        jj_consume_token(L);
        n = number();
                                        i = new WSInstruction(SLIDE, op(n), loc(t));
      } else {
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
      {if (true) return i;}
    throw new Error("Missing return statement in function");
  }

  final public WSInstruction Arithmetic() throws ParseException {
                             Token t; WSInstruction i;
    t = jj_consume_token(T);
    jj_consume_token(S);
    if (jj_2_9(2)) {
      jj_consume_token(S);
      jj_consume_token(S);
                           i = new WSInstruction(ADD, op(), loc(t));
    } else if (jj_2_10(2)) {
      jj_consume_token(S);
      jj_consume_token(T);
                           i = new WSInstruction(SUB, op(), loc(t));
    } else if (jj_2_11(2)) {
      jj_consume_token(S);
      jj_consume_token(L);
                           i = new WSInstruction(MUL, op(), loc(t));
    } else if (jj_2_12(2)) {
      jj_consume_token(T);
      jj_consume_token(S);
                           i = new WSInstruction(DIV, op(), loc(t));
    } else if (jj_2_13(2)) {
      jj_consume_token(T);
      jj_consume_token(T);
                           i = new WSInstruction(MOD, op(), loc(t));
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
      {if (true) return i;}
    throw new Error("Missing return statement in function");
  }

  final public WSInstruction HeapAccess() throws ParseException {
                             Token t; WSInstruction i;
    t = jj_consume_token(T);
    jj_consume_token(T);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case S:
      jj_consume_token(S);
       i = I(STORE, op(), loc(t));
      break;
    case T:
      jj_consume_token(T);
       i = I(RETR, op(), loc(t));
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return i;}
    throw new Error("Missing return statement in function");
  }

  final public WSInstruction FlowControl() throws ParseException {
                              Token t; WSInstruction i; String s;
    t = jj_consume_token(L);
    if (jj_2_14(2)) {
      jj_consume_token(S);
      jj_consume_token(S);
      s = label();
                                    i = I(LABEL, op(s), loc(t));
    } else if (jj_2_15(2)) {
      jj_consume_token(S);
      jj_consume_token(T);
      s = label();
                                    i = I(CALL, op(s), loc(t));
    } else if (jj_2_16(2)) {
      jj_consume_token(S);
      jj_consume_token(L);
      s = label();
                                    i = I(JUMP, op(s), loc(t));
    } else if (jj_2_17(2)) {
      jj_consume_token(T);
      jj_consume_token(S);
      s = label();
                                    i = I(JUMP_IF_ZERO, op(s), loc(t));
    } else if (jj_2_18(2)) {
      jj_consume_token(T);
      jj_consume_token(T);
      s = label();
                                    i = I(JUMP_IF_NEG, op(s), loc(t));
    } else if (jj_2_19(2)) {
      jj_consume_token(T);
      jj_consume_token(L);
                                    i = I(RETURN, op(), loc(t));
    } else if (jj_2_20(2)) {
      jj_consume_token(L);
      jj_consume_token(L);
                                    i = I(END, op(), loc(t));
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return i;}
    throw new Error("Missing return statement in function");
  }

  final public WSInstruction IO() throws ParseException {
                     Token t; WSInstruction i;
    t = jj_consume_token(T);
    jj_consume_token(L);
    if (jj_2_21(2)) {
      jj_consume_token(S);
      jj_consume_token(S);
                        i = I(PRINT_CHAR, op(), loc(t));
    } else if (jj_2_22(2)) {
      jj_consume_token(S);
      jj_consume_token(T);
                        i = I(PRINT_NUM, op(), loc(t));
    } else if (jj_2_23(2)) {
      jj_consume_token(T);
      jj_consume_token(S);
                        i = I(READ_CHAR, op(), loc(t));
    } else if (jj_2_24(2)) {
      jj_consume_token(T);
      jj_consume_token(T);
                        i = I(READ_NUM, op(), loc(t));
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
   {if (true) return i;}
    throw new Error("Missing return statement in function");
  }

  final public Program Program() throws ParseException {
                    WSInstruction i; List is = new ArrayList();
    label_3:
    while (true) {
      i = Instruction();
                       is.add(i);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case S:
      case T:
      case L:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_3;
      }
    }
    jj_consume_token(0);
        {if (true) return new Program((WSInstruction[])is.toArray(new WSInstruction[0]));}
    throw new Error("Missing return statement in function");
  }

  final private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  final private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  final private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  final private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  final private boolean jj_2_5(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_5(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  final private boolean jj_2_6(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_6(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  final private boolean jj_2_7(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_7(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  final private boolean jj_2_8(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_8(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  final private boolean jj_2_9(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_9(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  final private boolean jj_2_10(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_10(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  final private boolean jj_2_11(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_11(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(10, xla); }
  }

  final private boolean jj_2_12(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_12(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(11, xla); }
  }

  final private boolean jj_2_13(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_13(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(12, xla); }
  }

  final private boolean jj_2_14(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_14(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(13, xla); }
  }

  final private boolean jj_2_15(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_15(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(14, xla); }
  }

  final private boolean jj_2_16(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_16(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(15, xla); }
  }

  final private boolean jj_2_17(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_17(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(16, xla); }
  }

  final private boolean jj_2_18(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_18(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(17, xla); }
  }

  final private boolean jj_2_19(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_19(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(18, xla); }
  }

  final private boolean jj_2_20(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_20(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(19, xla); }
  }

  final private boolean jj_2_21(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_21(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(20, xla); }
  }

  final private boolean jj_2_22(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_22(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(21, xla); }
  }

  final private boolean jj_2_23(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_23(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(22, xla); }
  }

  final private boolean jj_2_24(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_24(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(23, xla); }
  }

  final private boolean jj_3_5() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(S)) return true;
    return false;
  }

  final private boolean jj_3_4() {
    if (jj_scan_token(L)) return true;
    if (jj_scan_token(S)) return true;
    return false;
  }

  final private boolean jj_3_24() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(T)) return true;
    return false;
  }

  final private boolean jj_3_23() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(S)) return true;
    return false;
  }

  final private boolean jj_3_22() {
    if (jj_scan_token(S)) return true;
    if (jj_scan_token(T)) return true;
    return false;
  }

  final private boolean jj_3_3() {
    if (jj_3R_6()) return true;
    return false;
  }

  final private boolean jj_3_21() {
    if (jj_scan_token(S)) return true;
    if (jj_scan_token(S)) return true;
    return false;
  }

  final private boolean jj_3R_6() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(L)) return true;
    return false;
  }

  final private boolean jj_3_2() {
    if (jj_3R_5()) return true;
    return false;
  }

  final private boolean jj_3_1() {
    if (jj_3R_4()) return true;
    return false;
  }

  final private boolean jj_3_20() {
    if (jj_scan_token(L)) return true;
    if (jj_scan_token(L)) return true;
    return false;
  }

  final private boolean jj_3_19() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(L)) return true;
    return false;
  }

  final private boolean jj_3_18() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(T)) return true;
    return false;
  }

  final private boolean jj_3_17() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(S)) return true;
    return false;
  }

  final private boolean jj_3_16() {
    if (jj_scan_token(S)) return true;
    if (jj_scan_token(L)) return true;
    return false;
  }

  final private boolean jj_3_15() {
    if (jj_scan_token(S)) return true;
    if (jj_scan_token(T)) return true;
    return false;
  }

  final private boolean jj_3_14() {
    if (jj_scan_token(S)) return true;
    if (jj_scan_token(S)) return true;
    return false;
  }

  final private boolean jj_3R_5() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(T)) return true;
    return false;
  }

  final private boolean jj_3_13() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(T)) return true;
    return false;
  }

  final private boolean jj_3_12() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(S)) return true;
    return false;
  }

  final private boolean jj_3_11() {
    if (jj_scan_token(S)) return true;
    if (jj_scan_token(L)) return true;
    return false;
  }

  final private boolean jj_3_10() {
    if (jj_scan_token(S)) return true;
    if (jj_scan_token(T)) return true;
    return false;
  }

  final private boolean jj_3_9() {
    if (jj_scan_token(S)) return true;
    if (jj_scan_token(S)) return true;
    return false;
  }

  final private boolean jj_3R_4() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(S)) return true;
    return false;
  }

  final private boolean jj_3_8() {
    if (jj_scan_token(T)) return true;
    if (jj_scan_token(L)) return true;
    return false;
  }

  final private boolean jj_3_7() {
    if (jj_scan_token(L)) return true;
    if (jj_scan_token(L)) return true;
    return false;
  }

  final private boolean jj_3_6() {
    if (jj_scan_token(L)) return true;
    if (jj_scan_token(T)) return true;
    return false;
  }

  public WSParserTokenManager token_source;
  JavaCharStream jj_input_stream;
  public Token token, jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  public boolean lookingAhead = false;
  private boolean jj_semLA;
  private int jj_gen;
  final private int[] jj_la1 = new int[10];
  static private int[] jj_la1_0;
  static {
      jj_la1_0();
   }
   private static void jj_la1_0() {
      jj_la1_0 = new int[] {0xc,0xc,0xc,0xc,0xc,0x4,0x10,0x4,0xc,0x1c,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[24];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  public WSParser(java.io.InputStream stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new WSParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.InputStream stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public WSParser(java.io.Reader stream) {
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new WSParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public WSParser(WSParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  public void ReInit(WSParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 10; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  final private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  final private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }

  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

  final public Token getToken(int index) {
    Token t = lookingAhead ? jj_scanpos : token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  final private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.Vector jj_expentries = new java.util.Vector();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Enumeration e = jj_expentries.elements(); e.hasMoreElements();) {
        int[] oldentry = (int[])(e.nextElement());
        if (oldentry.length == jj_expentry.length) {
          exists = true;
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.addElement(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  public ParseException generateParseException() {
    jj_expentries.removeAllElements();
    boolean[] la1tokens = new boolean[5];
    for (int i = 0; i < 5; i++) {
      la1tokens[i] = false;
    }
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 10; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 5; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.addElement(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.elementAt(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  final public void enable_tracing() {
  }

  final public void disable_tracing() {
  }

  final private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 24; i++) {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
            case 4: jj_3_5(); break;
            case 5: jj_3_6(); break;
            case 6: jj_3_7(); break;
            case 7: jj_3_8(); break;
            case 8: jj_3_9(); break;
            case 9: jj_3_10(); break;
            case 10: jj_3_11(); break;
            case 11: jj_3_12(); break;
            case 12: jj_3_13(); break;
            case 13: jj_3_14(); break;
            case 14: jj_3_15(); break;
            case 15: jj_3_16(); break;
            case 16: jj_3_17(); break;
            case 17: jj_3_18(); break;
            case 18: jj_3_19(); break;
            case 19: jj_3_20(); break;
            case 20: jj_3_21(); break;
            case 21: jj_3_22(); break;
            case 22: jj_3_23(); break;
            case 23: jj_3_24(); break;
          }
        }
        p = p.next;
      } while (p != null);
    }
    jj_rescan = false;
  }

  final private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
