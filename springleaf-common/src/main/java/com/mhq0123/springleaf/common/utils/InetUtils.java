package com.mhq0123.springleaf.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;

/**
 * @author mhq0123
 * @project mhq0123-springleaf
 * @fileName InetUtils
 * @date 2016-07-06
 * @memo
 */
public class InetUtils {
    private InetUtils(){}

    private static String hostAddress = null;

    /** 截取ip最后一段，补足3位长度*/
    private static String lastSplitIp_3l = null;

    /** 截取ip最后两段，补足6位长度*/
    private static String lastSplitIp_6l = null;

    /**
     * 获取ip
     * @return
     */
    public static String getHostAddress() {
        try {
            if(StringUtils.isBlank(hostAddress)) {
                hostAddress = InetAddress.getLocalHost().getHostAddress();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hostAddress;
    }

    /**
     * 获取ip最后一段 3位长度
     * @return
     */
    public static String getLastSplitIp_3l() {
        if(StringUtils.isBlank(lastSplitIp_3l)) {
            String[] ips = InetUtils.getHostAddress().split("\\.");
            lastSplitIp_3l = StringUtils.leftPad(ips[ips.length-1], 3, '0');
        }
        return lastSplitIp_3l;
    }

    /**
     * 获取ip最后两段 6位长度
     * @return
     */
    public static String getLastSplitIp_6l() {
        if(StringUtils.isBlank(lastSplitIp_6l)) {
            String[] ips = InetUtils.getHostAddress().split("\\.");
            lastSplitIp_6l = StringUtils.leftPad(ips[ips.length-2], 3, '0') + StringUtils.leftPad(ips[ips.length-1], 3, '0');
        }
        return lastSplitIp_6l;
    }
}
