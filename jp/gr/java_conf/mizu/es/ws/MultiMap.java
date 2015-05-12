/* ************************************************************** *
 *                                                                *
 * Copyright (c) 2005, Kota Mizushima, All rights reserved.       *
 *                                                                *
 *                                                                *
 * This software is distributed under the modified BSD License.   *
 * ************************************************************** */
package jp.gr.java_conf.mizu.es.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiMap {
  private Map map;
  public MultiMap() {
    map = new HashMap();
  }
  
  public void add(Object key, Object value) {
    List values = (List) map.get(key);
    if(values == null){
      values = new ArrayList();
      map.put(key, values);
    }
    values.add(value);
  }
  
  public List get(Object key) {
    return (List)map.get(key);
  }
  
  public boolean remove(Object key, Object value) {
    List values = (List) map.get(key);
    if(values == null) return false;
    return values.remove(value);
  }
  
  public Iterator keys() {
    return map.keySet().iterator();
  }
}
