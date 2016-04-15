package com.sibu.xinweishang.common.serialize;

import java.io.Closeable;

import org.apache.log4j.Logger;


/**
* @ClassName: SerializeTranscoder
* @Description: TODO
* @author zhy
* @date 2016年3月11日 上午10:37:40
* 版本：V2.0
*/ 
public abstract class SerializeTranscoder {

  protected static Logger logger = Logger.getLogger(SerializeTranscoder.class);
  
  public abstract byte[] serialize(Object value);
  
  public abstract Object deserialize(byte[] in);
  
  public void close(Closeable closeable) {
    if (closeable != null) {
      try {
        closeable.close();
      } catch (Exception e) {
         logger.info("Unable to close " + closeable, e); 
      }
    }
  }
}
