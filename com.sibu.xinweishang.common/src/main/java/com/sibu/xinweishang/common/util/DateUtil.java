package com.sibu.xinweishang.common.util;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期工具类，提供有关日期操作方面的方法。
 *
 * @version 1.0
 */
public class DateUtil {

    /**
     * 时间格式
     */
    public final static String TIME_FORMAT = "HH:mm:ss:SS";

    /**
     * 缺省短日期格式
     */
    public final static String DEFAULT_SHORT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * yyyy-MM-dd HH:mm:ss格式数据。
     */
    public final static String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static DateFormat ddMMyyyySS = new SimpleDateFormat(
            "yyyyMMddHHmmss");
    private static DateFormat zstr = new SimpleDateFormat(
            DEFAULT_DATE_TIME_FORMAT);

    /**
     * yyyy-MM-dd格式数据。
     */
    public final static String DATE_ONLY_FORMAT = "yyyy-MM-dd";
    /**
     * 缺省短日期格式
     */
    public final static String DEFAULT_SHORT_DATE_FORMAT_ZH = "yyyy年M月d日";

    /**
     * 日期字符串（yyyyMMdd HHmmss）
     */
    public static final String YEAR_TO_SEC_UN_LINE = "yyyyMMdd HHmmss";

    /**
     * 缺省长日期格式
     */
    public final static String DEFAULT_LONG_DATE_FORMAT = DEFAULT_SHORT_DATE_FORMAT
            + " " + TIME_FORMAT;

    /**
     * Java能支持的最小日期字符串（yyyy-MM-dd）。
     */
    public final static String JAVA_MIN_SHORT_DATE_STR = "1970-01-01";

    /**
     * Java能支持的最小日期字符串（yyyy-MM-dd HH:mm:ss:SS）。
     */
    public final static String JAVA_MIN_LONG_DATE_STR = "1970-01-01 00:00:00:00";

    /**
     * Java能支持的最小的Timestamp。
     */
    public final static Timestamp JAVA_MIN_TIMESTAMP = convertStrToTimestamp(JAVA_MIN_LONG_DATE_STR);

    /**
     * 获取当前日期的上一周星期一的日期。注意只返回yyyy-MM-dd格式的数据。
     *
     * @return
     */
    public static String getMondayDateForLastWeek() {
        Calendar cal = Calendar.getInstance();
        // n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
        int n = -1;
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.add(Calendar.DATE, n * 7);
        // 想周几，这里就传几Calendar.MONDAY（TUESDAY...）
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * 获取当前日期的上一周星期日的日期。注意只返回yyyy-MM-dd格式的数据。
     *
     * @return
     */
    public static String getSundayDateForLastWeek() {
        Calendar cal = Calendar.getInstance();
        // n为推迟的周数，1本周，-1向前推迟一周，2下周，依次类推
        int n = -1;
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.add(Calendar.DATE, n * 7);
        // 想周几，这里就传几Calendar.MONDAY（TUESDAY...）
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    public static String formatDate(String dateStr, String formatStyle) {
        Date date = convertStrToDate(dateStr, formatStyle);
        dateStr = convertDateToStr(date, formatStyle);
        return dateStr;
    }

    /**
     * 取得指定日期所在周的第一天
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }

    /**
     * 取得指定日期所在周的最后一天
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return c.getTime();
    }

    /**
     * 获取指定日期在当年中的所在周数。
     *
     * @param dateStr 年月日 时分秒。
     */
    public static int getWeekOfYearByDate(String dateStr) {
        Calendar calendar = Calendar.getInstance();// new GregorianCalendar();
        Date date = DateUtil.convertStrToDate(dateStr,
                DateUtil.DEFAULT_DATE_TIME_FORMAT);
        calendar.setTime(date);
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 把字符串转换为Timestamp类型，对于短日期格式，自动把时间设为系统当前时间。
     *
     * @return Timestamp
     * @see #convertStrToTimestamp(String, boolean)
     */
    public static Timestamp convertStrToTimestamp(String dateStr) {
        return convertStrToTimestamp(dateStr, false);
    }

    /**
     * 把字符串转换为Timestamp类型，对于短日期格式，自动把时间设为0。
     *
     * @return Timestamp
     * @see #convertStrToTimestamp(String, boolean)
     */
    public static Timestamp convertStrToTimestampZero(String dateStr) {
        return convertStrToTimestamp(dateStr, true);
    }

    /**
     * 把字符串转换为Timestamp类型。
     *
     * @param dateStr     - 日期字符串，只支持"yyyy-MM-dd"和"yyyy-MM-dd HH:mm:ss:SS"两种格式。
     *                    如果为"yyyy-MM-dd"，系统会自动取得当前时间补上。
     * @param addZeroTime - 当日期字符串为"yyyy-MM-dd"这样的格式时，addZeroTime为true表示
     *                    用0来设置HH:mm:ss:SS，否则用当前Time来设置。
     * @return Timestamp
     */
    private static Timestamp convertStrToTimestamp(String dateStr,
                                                   boolean addZeroTime) {
        if (dateStr == null) {
            return null;
        }

        String dStr = dateStr.trim();
        if (dStr.indexOf(" ") == -1) {
            if (addZeroTime) {
                dStr = dStr + " 00:00:00:00";
            } else {
                dStr = dStr + " " + getCurrDateStr(DateUtil.TIME_FORMAT);
            }
        }

        Date utilDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                DEFAULT_LONG_DATE_FORMAT);

        try {
            utilDate = simpleDateFormat.parse(dStr);
        } catch (Exception ex) {
            throw new RuntimeException("DateUtil.convertStrToTimestamp(): "
                    + ex.getMessage());
        }

        return new Timestamp(utilDate.getTime());
    }

    /**
     * 得到系统当前时间的Timestamp对象
     *
     * @return 系统当前时间的Timestamp对象
     */
    public static Timestamp getCurrTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * <p>
     * 取得当前日期，并将其转换成格式为"dateFormat"的字符串 例子：假如当前日期是 2003-09-24 9:19:10，则：
     * <p>
     * <pre>
     * getCurrDateStr("yyyyMMdd")="20030924"
     * getCurrDateStr("yyyy-MM-dd")="2003-09-24"
     * getCurrDateStr("yyyy-MM-dd HH:mm:ss")="2003-09-24 09:19:10"
     * </pre>
     * <p>
     * </p>
     *
     * @param dateFormat String 日期格式字符串
     * @return String
     */
    public static String getCurrDateStr(String dateFormat) {
        return convertDateToStr(new Date(), dateFormat);
    }

    /**
     * @param date 2013-11-07 14:14:14
     * @return 20131107141414
     */
    public static String formateDate(Date date) {
        String str1 = "";
        try {
            str1 = ddMMyyyySS.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str1;
    }

    public static String formateDateStr(Date date) {
        String str1 = "";
        try {
            str1 = zstr.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str1;
    }

    /**
     * 将日期类型转换成指定格式的日期字符串
     *
     * @param date       待转换的日期
     * @param dateFormat 日期格式字符串
     * @return String
     */
    public static String convertDateToStr(Date date, String dateFormat) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * 将指定格式的字符串转换成日期类型
     *
     * @param date       待转换的日期字符串
     * @param dateFormat 日期格式字符串
     * @return Date
     */
    public static Date convertStrToDate(String dateStr, String dateFormat) {
        if (dateStr == null || dateStr.equals("")) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            return sdf.parse(dateStr);
        } catch (Exception e) {
            throw new RuntimeException("DateUtil.convertStrToDate():" + e.getMessage());
        }
    }

    /**
     * 计算两个日期之间的相隔的年、月、日。注意：只有计算相隔天数是准确的，相隔年和月都是 近似值，按一年365天，一月30天计算，忽略闰年和闰月的差别。
     *
     * @param datepart  两位的格式字符串，yy表示年，MM表示月，dd表示日
     * @param startdate 开始日期
     * @param enddate   结束日期
     * @return double 如果enddate>startdate，返回一个大于0的实数，否则返回一个小于等于0的实数
     */
    public static double dateDiff(String datepart, Date startdate, Date enddate) {
        if (datepart == null || datepart.equals("")) {
            throw new IllegalArgumentException("DateUtil.dateDiff()方法非法参数值："
                    + datepart);
        }

        double days = (double) (enddate.getTime() - startdate.getTime())
                / (60 * 60 * 24 * 1000);

        if (datepart.equals("yy")) {
            days = days / 365;
        } else if (datepart.equals("MM")) {
            days = days / 30;
        } else if (datepart.equals("dd")) {
            return days;
        } else {
            throw new IllegalArgumentException("DateUtil.dateDiff()方法非法参数值："
                    + datepart);
        }
        return days;
    }

    /**
     * 把日期对象加减年、月、日后得到新的日期对象
     *
     * @param depart 年、月、日
     * @param number 如果是 减就 -1
     *               加减因子
     * @param date   需要加减年、月、日的日期对象
     * @return Date 新的日期对象
     */
    public static Date addDate(String datepart, int number, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (datepart.equals("yy")) {
            cal.add(Calendar.YEAR, number);
        } else if (datepart.equals("MM")) {
            cal.add(Calendar.MONTH, number);
        } else if (datepart.equals("dd")) {
            cal.add(Calendar.DATE, number);
        } else if (datepart.equals("HH")) {
            cal.add(Calendar.HOUR, number);
        } else {
            throw new IllegalArgumentException("DateUtil.addDate()方法非法参数值：" + datepart);
        }

        return cal.getTime();
    }

    /**
     * 将普通时间 格式的字符串转化成unix时间戳
     *
     * @param dateStr
     * @param dateFormat
     * @return
     * @version 1.0
     */
    public static long convertDateStrToUnixTimeStamp(String dateStr, String dateFormat) {
        long timeStamp = DateUtil.convertStrToDate(dateStr, dateFormat).getTime() / 1000;
        return timeStamp;
    }

    /**
     * 将unix时间戳转化成普通时间 格式的字符串
     *
     * @param timeStamp
     * @param dateFormat
     * @return
     * @version 1.0
     */
    public static String convertUnixTimeStampToDateStr(long timeStamp, String dateFormat) {
        String dateStr = "";
        if (timeStamp != 0) {
            Long timestamp = Long.parseLong(timeStamp + "") * 1000;
            dateStr = DateUtil.convertDateToStr(new Date(timestamp), dateFormat);
        }
        return dateStr;
    }

    /**
     * 获取当前unix时间的秒数。
     *
     * @return
     * @version 1.0
     * @data 2013-8-9 上午9:50:43
     */
    public static long getCurrentUnixTimeSecond() {
        return getCurrTimestamp().getTime() / 1000;
    }

    /**
     * 获取当前unix时间的毫秒数。
     *
     * @return
     * @version 1.0
     * @data 2013-8-9 上午9:50:43
     */
    public static long getCurrentTimeMillis() {
        return getCurrTimestamp().getTime();
    }


    /**
     * @param str
     * @return void
     * @throws ParseException
     * @Title: formatString
     * @Description: TODO  20131010121212 这个格式转换成 yyyy-MM-dd HH:mm:ss
     * @author dao
     * @date 2013年10月31日 下午7:57:23
     */
    public static String formateStirng(String str) {
        String str1 = "";
        try {
            DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
            DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Date dDate = format.parse(str);
            str1 = format2.format(dDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str1;
    }

    /**
     * 如果该日期字符串是有效的返回true
     *
     * @param date
     * @return
     */
    public static boolean isLagelDateOfString(String date) {
        Pattern p = Pattern.compile("^\\d{4}-\\d{1,2}-\\d{1,2}$");
        Matcher match = p.matcher(date);
        return match.matches();
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String args[]) {
//		System.out.println(DateUtil.getMondayDateForLastWeek());
//		System.out.println(DateUtil.getSundayDateForLastWeek());
//		System.out.println(DateUtil.dateDiff("dd",
//				DateUtil.convertStrToTimestamp("2005-03-09 22:59:00:00"),
//				DateUtil.getCurrTimestamp()));
        boolean v = true;
        int i = 0;
        while (v) {
            System.out.println("" + i);
            if (i == -5) {
                v = false;
            }
            i--;
        }
        System.out.println(addDate("dd", 0, new Date()));
        System.out.println(getCurrentTimeMillis() % 16);
//		System.out.println("2014010112142512".length()+"===>"+"2014010112142512".substring(0,14)+"------"+"2014010112142512.test".substring(14,"2014010112142512.test".indexOf(".")));
//		String pathDate = formateDate(new Date());
//		String dates = pathDate.substring(0, 8);
//		String houts = pathDate.substring(8, 10);
////		System.out.println(dates+"/"+houts);
//		System.out.println(formateDateStr(new Date()));
    }

}