package com.sin.buildingInsights.data.repository;

public class Assessment17 {

    public String validIPAddress(String IP) {
        if (IP == null || IP.length() <= 0) {
            return "Neither";
        }
        if (isIPV4(IP)) {
            return "IPv4";
        }
        if (isIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    /**
     * XXX.XXX.XXX.XXX
     * 4 numbers and 3 dots
     *
     * @param IP
     * @return
     */
    private boolean isIPV4(String IP) {
        // make sure 4 numbers and 3 dots
        String[] elements = IP.split("\\.");
        if (elements.length != 4) {
            return false;
        }

        for (String val : elements) {
            // Note: 192.0.0.1 this case. When substring length> 1, which is can not begin with 0.
            if ("".equals(val) || val.length() > 3 || (val.length() > 1 && val.charAt(0) == '0')) {
                return false;
            }
            for (int i = 0; i < val.length(); i++) {
                if (!(val.charAt(i) >= '0' && val.charAt(i) <= '9')) {
                    return false;
                }
            }
            if (Integer.parseInt(val) > 255) {
                return false;
            }
        }
        return true;
    }

    /**
     * XXXX:XXXX:XXXX:XXXX:XXXX:XXXX:XXXX:XXXX
     * 8 numbers and 7 ":"
     *
     * @param IP
     * @return
     */
    private boolean isIPV6(String IP) {
        // make sure 8 numbers and 7 ":"
        String[] elements = IP.toLowerCase().split("\\:");
        if (elements.length != 8) {
            return false;
        }
        for (String val : elements) {
            if (val.length() == 0 || val.length() > 4) {
                return false;
            }
            for (int i = 0; i < val.length(); i++) {
                char c = val.charAt(i);
                if (c < '0' || (c > '9' && c < 'a') || c > 'f') {
                    return false;
                }
            }
        }
        return true;
    }
}
