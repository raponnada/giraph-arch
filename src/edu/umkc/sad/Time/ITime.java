package edu.umkc.sad.Time;

import java.util.Date;

public interface ITime {

  /** Microseconds per millisecond */
  public long US_PER_MS = 1000;
  /** Nanoseconds per microsecond */
  public long NS_PER_US = 1000;
  /** Nanoseconds per millisecond */
  public long NS_PER_MS = US_PER_MS * NS_PER_US;
  /** Milliseconds per second */
  public long MS_PER_SECOND = 1000;
  /** Milliseconds per second (as float) */
  public float MS_PER_SECOND_AS_FLOAT = MS_PER_SECOND * 1f;
  /** Microseconds per second */
  public long US_PER_SECOND = US_PER_MS * MS_PER_SECOND;
  /** Microseconds per second (as float) */
  public float US_PER_SECOND_AS_FLOAT = US_PER_SECOND * 1f;
  /** Nanoseconds per second */
  public long NS_PER_SECOND = NS_PER_US * US_PER_SECOND;
  /** Nanoseconds per second (as float) */
  public float NS_PER_SECOND_AS_FLOAT = NS_PER_SECOND * 1f;
  /** Seconds per hour */
  public long SECONDS_PER_HOUR = 60 * 60;
  /** Seconds per day */
  public long SECONDS_PER_DAY = 24 * SECONDS_PER_HOUR;
  /** Milliseconds per hour */
  public long MS_PER_HOUR = SECONDS_PER_HOUR * MS_PER_SECOND;
  /** Milliseconds per day */
  public long MS_PER_DAY = SECONDS_PER_DAY * MS_PER_SECOND;

  /**
   * Get the current milliseconds
   *
   * @return The difference, measured in milliseconds, between
   *         the current time and midnight, January 1, 1970 UTC.
   */
  public long getMilliseconds();

  /**
   * Get the current microseconds
   *
   * @return The difference, measured in microseconds, between
   *         the current time and midnight, January 1, 1970 UTC.
   */
  public long getMicroseconds();

  /**
   * Get the current nanoseconds
   *
   * @return The difference, measured in nanoseconds, between
   *         the current time and midnight, January 1, 1970 UTC.
   */
  public long getNanoseconds();

  /**
   * Get the current seconds
   *
   * @return The difference, measured in seconds, between
   *         the current time and midnight, January 1, 1970 UTC.
   */
  public int getSeconds();

  /**
   * Get the current date
   *
   * @return Current date
   */
  public Date getCurrentDate();
  public ITimeImp get1();

  /**
   * Current thread should sleep for some number of milliseconds.
   *
   * @param milliseconds Milliseconds to sleep for
   * @throws InterruptedException
   */
  public void sleep(long milliseconds) throws InterruptedException;
}
