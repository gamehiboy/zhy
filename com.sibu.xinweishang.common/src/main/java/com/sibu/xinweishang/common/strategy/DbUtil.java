package com.sibu.xinweishang.common.strategy;

import java.util.Arrays;
import java.util.List;

public class DbUtil {

    public static final List<String> DATABASE_LASTCHAR = Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"});
    public static final List<String> TABLE_LASTCHAR = Arrays.asList(new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0a", "0b", "0c", "0d", "0e", "0f", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "1a", "1b", "1c", "1d", "1e", "1f", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2a", "2b", "2c", "2d", "2e", "2f", "30", "31", "32", "33", "34", "35", "36", "37",
            "38", "39", "3a", "3b", "3c", "3d", "3e", "3f", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4a", "4b", "4c", "4d", "4e", "4f", "50", "51", "52", "53", "54", "55", "56",
            "57", "58", "59", "5a", "5b", "5c", "5d", "5e", "5f", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6a", "6b", "6c", "6d", "6e", "6f", "70", "71", "72", "73", "74", "75",
            "76", "77", "78", "79", "7a", "7b", "7c", "7d", "7e", "7f", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8a", "8b", "8c", "8d", "8e", "8f", "90", "91", "92", "93", "94",
            "95", "96", "97", "98", "99", "9a", "9b", "9c", "9d", "9e", "9f", "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "aa", "ab", "ac", "ad", "ae", "af", "b0", "b1", "b2", "b3",
            "b4", "b5", "b6", "b7", "b8", "b9", "ba", "bb", "bc", "bd", "be", "bf", "c0", "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "ca", "cb", "cc", "cd", "ce", "cf", "d0", "d1", "d2",
            "d3", "d4", "d5", "d6", "d7", "d8", "d9", "da", "db", "dc", "dd", "de", "df", "e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "ea", "eb", "ec", "ed", "ee", "ef", "f0", "f1",
            "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "fa", "fb", "fc", "fd", "fe", "ff"});

    /*
     * 数据库规则：根据用户的最后两位字符，设置用户数据所在数据库
     * sibu_00   15
     */
    public static String GetDataBaseModValue(String userId) {
        int moduleValue = 4;
        String lastChar = userId.substring(userId.length() - 1, userId.length()).toLowerCase();
        Integer index = DATABASE_LASTCHAR.indexOf(lastChar) % moduleValue + 1;
        return index.toString(); // index.toString();
    }

    /*
     * 订单表规则：根据用户的最后一位字符，设置订单数据所在表
     * order_00  63
     */
    public static String GetTableNameModValue(String userId) {
        int moduleValue = 8;
        String lastChar = userId.substring(userId.length() - 2, userId.length()).toLowerCase();
        Integer index = TABLE_LASTCHAR.indexOf(lastChar) % moduleValue;
        return index < 10 ? "0" + index.toString() : index.toString();
    }

    /*
    * 订单号规则：时间戳+数据库所在+表所在
    * */
    public static String GetOrderCode(String userId) {
        String database = GetDataBaseModValue(userId);
        database = database.length() == 1 ? ("0" + database) : database;
        String table = GetTableNameModValue(userId);
        long now = System.currentTimeMillis();
        return database + table + now;
    }

    /**
     * 获取订单主表的名称
     *
     * @param memberId
     * @return
     */
    public static String getDoingOrderTableName(String memberId) {
        String module = DbUtil.GetTableNameModValue(memberId);
        return "doing_order_" + module;
    }

    /**
     * 获取订单子表的名称
     *
     * @param memberId
     * @return
     */
    public static String getDoingOrder1TableName(String memberId) {
        String module = DbUtil.GetTableNameModValue(memberId);
        return "doing_order1_" + module;
    }

    /**
     * 根据订单号获取所在的数据库
     *
     * @param orderCode
     * @return
     */
    public static String getOrderInWhichDataBase(String orderCode) {
        return orderCode.substring(0, 2);
    }


    /**
     * 根据订单号获取所在的数据库
     *
     * @param orderCode
     * @return
     */
    public static String getOrderInWhichTable(String orderCode) {
        return orderCode.substring(2, 4);
    }

    public static void main(String[] args) {
        System.out.println(GetDataBaseModValue("71eef20977b747d0b5dadcb6734255d0"));
        System.out.println(GetTableNameModValue("71eef20977b747d0b5dadcb6734255d0"));
    }
}
