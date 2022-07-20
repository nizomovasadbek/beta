package uz.beta.permission;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static uz.beta.permission.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE)),
    ADMIN(Sets.newHashSet(STUDENT_WRITE, STUDENT_READ, TEACHER_READ, TEACHER_WRITE, ADMIN_READ, ADMIN_WRITE)),
    TEACHER(Sets.newHashSet(TEACHER_READ, TEACHER_WRITE));

    private Set<ApplicationUserPermission> permission;

    ApplicationUserRole(Set<ApplicationUserPermission> permission){
        this.permission = permission;
    }

    public Set<ApplicationUserPermission> getPermission(){
        return permission;
    }

    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthority(){
        Set<SimpleGrantedAuthority> authorities = getPermission().stream()
                .map(per -> new SimpleGrantedAuthority(per.getPermission()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
