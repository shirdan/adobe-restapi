package com.adobe.crudrev.common.util;

import com.adobe.crudrev.exception.AddressValidatorException;

public class AddressScrubber {

    String scrubbedAddr; 

    public String getScrubbedAddr() {
		return scrubbedAddr;
	}

	public void setScrubbedAddr(String scrubbedAddr) {
		this.scrubbedAddr = scrubbedAddr;
	}

	public AddressScrubber( String addr ) throws AddressValidatorException {
        this.scrubbedAddr = addr;
    }

    public static String cleanZip (String zip) {
    	//clean for special characters
        String splCharStr = "-~`\"'%^$#!*()={}[]|\\<>?/. ";
        zip = removeSplChars(zip, splCharStr);
        return zip;
    }

    public static String cleanAddress (String addr) {
    	//clean for special characters
        String splCharStr = "~`\"'%^$#!*()={}[]|\\<>?/";
        addr = removeSplChars(addr, splCharStr);
        return addr.toString();
    }
	
    public static String removeSplChars (String str, String splCharStr) {
    	if (str == null) {
    		return null;
    	}
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (splCharStr.indexOf(str.charAt(i)) == -1) {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
   
}

