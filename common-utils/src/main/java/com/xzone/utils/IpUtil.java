package com.xzone.utils;

import java.net.Inet4Address;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class IpUtil {

    private static List<String> ipV4 = new ArrayList<>();

    private static String ip;

    protected static final String LOCAL_DEFAULT_IP = "127.0.0.1";

    /**
     * 获取ipV4地址
     */
    public static List<String> getLocalIpV4() throws Exception {
        Enumeration<NetworkInterface> interfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        while (interfaceEnumeration.hasMoreElements()) {

            NetworkInterface networkInterface = interfaceEnumeration.nextElement();
            List<InterfaceAddress> interfaceAddresses = networkInterface.getInterfaceAddresses();
            interfaceAddresses.forEach(interfaceAddressesSingle -> {
                if (interfaceAddressesSingle.getAddress() instanceof Inet4Address) {
                    String address = interfaceAddressesSingle.getAddress().getHostAddress();
                    ipV4.add(address);
                }
            });
        }

        return ipV4;
    }

    public static String getLocalIpV4(String excludeIp) throws Exception {
        if (StringUtil.isBlank(excludeIp)) {
            excludeIp = LOCAL_DEFAULT_IP;
        }
        if (ipV4.size() > 0) {
            for (String ip : ipV4) {
                if (!ip.equals(excludeIp)) {
                    return ip;
                }
            }
        }
        getLocalIpV4();
        ip = getLocalIpV4(LOCAL_DEFAULT_IP);
        return ip;
    }

    public static String getIp() throws Exception{
        if (StringUtil.isNotBlank(ip)) {
            return ip;
        }
        return getLocalIpV4(LOCAL_DEFAULT_IP);
    }

}
