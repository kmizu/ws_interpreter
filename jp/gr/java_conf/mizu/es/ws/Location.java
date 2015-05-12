/* ************************************************************** *
 *                                                                *
 * Copyright (c) 2005, Kota Mizushima, All rights reserved.       *
 *                                                                *
 *                                                                *
 * This software is distributed under the modified BSD License.   *
 * ************************************************************** */
package jp.gr.java_conf.mizu.es.ws;

public class Location {
  private int row, col;
  public Location(int row, int col) {
    this.row = row;
    this.col = col;
  }
  
  public int getRow() {
    return row;
  }
  
  public int getCol() {
    return col;
  }
}
