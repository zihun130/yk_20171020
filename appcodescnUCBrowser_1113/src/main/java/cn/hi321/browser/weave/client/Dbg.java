/*
 *  http://www.appcodes.cn APP精品源码下载站声明：
 * 1、本站源码为网上搜集或网友提供，如果涉及或侵害到您的版 权，请立即通知我们。 
 * 2、 本站提供免费代码只可供研究学习使用，切勿用于商业用途 由此引起一切后果与本站无关。
 * 3、 商业源码请在源码授权范围内进行使用。
 * 4、更多APP精品源码下载请访问:http://www.appcodes.cn。
 * 5、如有疑问请发信息至appcodes@qq.com。
 */
package cn.hi321.browser.weave.client;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * @author Patrick Woodworth
 */
class Dbg {

  private static final Level LEVEL_ANDROID_VERBOSE = Level.FINE; // should never ship using this
  private static final Level LEVEL_ANDROID_DEBUG = Level.CONFIG; // stripped at runtime (except on emulator?)
  @SuppressWarnings("unused")
private static final Level LEVEL_ANDROID_INFO = Level.INFO;
  private static final Level LEVEL_ANDROID_WARN = Level.WARNING;
  @SuppressWarnings("unused")
private static final Level LEVEL_ANDROID_ERROR = Level.SEVERE;

  @SuppressWarnings("unused")
private static final Level LEVEL_V = LEVEL_ANDROID_VERBOSE;
//  private static final Level LEVEL_D = LEVEL_ANDROID_INFO;
  private static final Level LEVEL_D = LEVEL_ANDROID_DEBUG;
  private static final Level LEVEL_W = LEVEL_ANDROID_WARN;

  private static final Logger sm_logger = Logger.getLogger(WeaveConstants.LOGGER_NAME_FULL);

  private Dbg() {
    // no instantiation
  }

  public static void v(String fmt, Object... args) {
//    logf(LEVEL_V, fmt, args);
  }

  public static void v(Throwable e, String fmt, Object... args) {
//    logf(LEVEL_V, e, fmt, args);
  }

  public static void v(Throwable e) {
//    log(LEVEL_V, e);
  }

  public static void d(String fmt, Object... args) {
    logf(LEVEL_D, fmt, args);
  }

  public static void d(Throwable e, String fmt, Object... args) {
    logf(LEVEL_D, e, fmt, args);
  }

  public static void d(Throwable e) {
    log(LEVEL_D, e);
  }

  public static void w(String fmt, Object... args) {
    logf(LEVEL_W, fmt, args);
  }

  public static void w(Throwable e, String fmt, Object... args) {
    logf(LEVEL_W, e, fmt, args);
  }

  public static void w(Throwable e) {
    log(LEVEL_W, e);
  }

  private static void log(Level level, Throwable e) {
    if (!sm_logger.isLoggable(level))
      return;
    LogRecord lr = new DebugLogRecord(level, "Something was thrown!");
    lr.setThrown(e);
    lr.setLoggerName(sm_logger.getName());
    sm_logger.log(lr);
  }

  private static void logf(Level level, Throwable e, String msg, Object... params) {
    if (!sm_logger.isLoggable(level))
      return;
    LogRecord lr = new DebugLogRecord(level, String.format(msg, params));
    lr.setThrown(e);
    lr.setLoggerName(sm_logger.getName());
    sm_logger.log(lr);
  }

  private static void logf(Level level, String msg, Object... params) {
    if (!sm_logger.isLoggable(level))
      return;
    LogRecord lr = new DebugLogRecord(level, String.format(msg, params));
    lr.setLoggerName(sm_logger.getName());
    sm_logger.log(lr);
  }

  @SuppressWarnings("serial")
public static class DebugLogRecord extends LogRecord {

    /**
     * @serial Class that issued logging call
     */
    private String sourceClassName;

    /**
     * @serial Method that issued logging call
     */
    private String sourceMethodName;

    private transient boolean needToInferCaller = true;

    DebugLogRecord(Level level, String msg) {
      super(level, msg);
    }

    /**
     * {@inheritDoc}
     */
    public String getSourceClassName() {
      if (sourceClassName == null) {
        inferCaller();
      }
      return sourceClassName;
    }

    /**
     * {@inheritDoc}
     */
    public void setSourceClassName(String sourceClassName) {
      this.sourceClassName = sourceClassName;
      needToInferCaller = false;
    }

    /**
     * {@inheritDoc}
     */
    public String getSourceMethodName() {
      if (needToInferCaller) {
        inferCaller();
      }
      return sourceMethodName;
    }

    /**
     * {@inheritDoc}
     */
    public void setSourceMethodName(String sourceMethodName) {
      this.sourceMethodName = sourceMethodName;
      needToInferCaller = false;
    }

    private void inferCaller() {
      // Get the stack trace.
      StackTraceElement stack[] = (new Throwable()).getStackTrace();
      // First, search back to a method in the Logger class.
      int ix = 0;
      while (ix < stack.length) {
        StackTraceElement frame = stack[ix];
        String cname = frame.getClassName();
        if (cname.equals(Dbg.class.getName())) {
          break;
        }
        ix++;
      }
      // Now search for the first frame before the "Logger" class.
      while (ix < stack.length) {
        StackTraceElement frame = stack[ix];
        String cname = frame.getClassName();
        if (!cname.equals(Dbg.class.getName())) {
          // We've found the relevant frame.
          setSourceClassName(cname);
          setSourceMethodName(frame.getMethodName());
          return;
        }
        ix++;
      }
      // We haven't found a suitable frame, so just punt.  This is
      // OK as we are only committed to making a "best effort" here.
    }
  }
}