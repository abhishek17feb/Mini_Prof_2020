package com.abhi.app.auth;

public enum ApplicationUserPermission {

	STUDENT_READ("student:read"),
	STUDENT_WRITE("student:write"),
	COURSE_READ("course:read"),
	COURSE_WRITE("course:write"),
	ADMIN_READ("admin:read");
	
	private final String permission;

	ApplicationUserPermission(String permission){
		this.permission = permission;
	}
	
	public String getPermission() {
		return permission;
	}
	
	
}
