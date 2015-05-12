/* ************************************************************** *
 *                                                                *
 * Copyright (c) 2005, Kota Mizushima, All rights reserved.       *
 *                                                                *
 *                                                                *
 * This software is distributed under the modified BSD License.   *
 * ************************************************************** */
package jp.gr.java_conf.mizu.es.ws;

public interface WSInstructionConstants {
  int PUSH            = 0;
  int DUP             = 1;
  int COPY            = 2;
  int SWAP            = 3;
  int DISCARD         = 4;
  int SLIDE           = 5;
  int ADD             = 6;
  int SUB             = 7;
  int MUL             = 8;
  int DIV             = 9;
  int MOD             = 10;
  int STORE           = 11;
  int RETR            = 12;
  int LABEL           = 13;
  int CALL            = 14;
  int JUMP            = 15;
  int JUMP_IF_ZERO    = 16;
  int JUMP_IF_NEG     = 17;
  int RETURN          = 18;
  int END             = 19;
  int PRINT_CHAR      = 20;
  int PRINT_NUM       = 21;
  int READ_CHAR       = 22;
  int READ_NUM        = 23;
}
