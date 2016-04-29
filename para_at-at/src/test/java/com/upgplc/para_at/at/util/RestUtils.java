package com.upgplc.para_at.at.util;

import java.net.URI;

public final class RestUtils {

	private RestUtils() {
	}
	
	public static long getIdFromLocation(URI location) {
		String[] parts = location.getPath().split("/");
		return Long.parseLong(parts[parts.length - 1]);
	}
}
