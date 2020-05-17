package com.abhi.app.auth;

import static com.abhi.app.auth.ApplicationUserPermission.COURSE_READ;
import static com.abhi.app.auth.ApplicationUserPermission.COURSE_WRITE;
import static com.abhi.app.auth.ApplicationUserPermission.STUDENT_READ;
import static com.abhi.app.auth.ApplicationUserPermission.STUDENT_WRITE;
import static com.abhi.app.auth.ApplicationUserPermission.ADMIN_READ;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum ApplicationUserRole {

	STUDENT(Sets.newHashSet(STUDENT_READ,STUDENT_WRITE,COURSE_READ,COURSE_WRITE)),
	ADMIN(Sets.newHashSet(ADMIN_READ)),
	TRAINEE(Sets.newHashSet(STUDENT_READ,COURSE_READ));
	
	private final Set<ApplicationUserPermission> permissions;

	ApplicationUserRole(Set<ApplicationUserPermission> permissions){
		this.permissions = permissions;
	}
	
	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}
	
	public Set<SimpleGrantedAuthority> getAuthority() {
		Set<SimpleGrantedAuthority> permissions =  getPermissions().stream().map(
				permission -> new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		return permissions;
			
	}
}
