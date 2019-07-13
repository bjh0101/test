package utils;

import java.util.UUID;

public class UUIDUtils {
	public static String getUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}
	
	public static void main(String[] args) {
		System.out.println(getUUID());
	}
}
