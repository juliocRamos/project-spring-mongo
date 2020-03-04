package com.learningspringmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLUtilities {

	public static String decodeUrlParam(String text) {
		try {
			return URLDecoder.decode(text,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
