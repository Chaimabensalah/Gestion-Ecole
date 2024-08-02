package com.ecole.gestion.ecole.config;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;


 
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
 
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);
 
        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }
 
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
    
 
    /*
     * This method extracts the roles of currently logged-in user and returns
     * appropriate URL according to his/her role.
     */
    protected String determineTargetUrl(Authentication authentication) {
        String url = "";
 
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
 
        List<String> roles = new ArrayList<String>();
 
        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }
        
        if (isDba(roles)) {
            url = "/db";
        } else if (isAdmin(roles)) {
            url = "/";
//        } else if (isUser(roles)) {
//            url = "/test";
//            
//        } else if (isRh(roles)) {
//            url = "/candidatures";
//            
//        } else if (isRespo(roles)) {
//        url = "/respo";
        
    }else {
            url = "/accessDenied";
        }
 
        return url;
    }
 
//    private boolean isUser(List<String> roles) {
//    	 
//        if (roles.contains("USER")) {
//        	System.out.print("is user");
//            return true;
//        }
//        return false;
//    }
//    
//    private boolean isRespo(List<String> roles) {
//        if (roles.contains("RESPO")) {
//        	System.out.print("is RESPO");
//            return true;
//        }
//        return false;
//    }
 
    private boolean isAdmin(List<String> roles) {
        if (roles.contains("ADMIN")) {
            return true;
        }
        return false;
    }
 
    private boolean isDba(List<String> roles) {
        if (roles.contains("DBA")) {
            return true;
        }
        return false;
    }
    
//    private boolean isRh(List<String> roles) {
//        if (roles.contains("RH")) {
//            return true;
//        }
//        return false;
//    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
 
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
    
//    
//    @Autowired
//	private static UserService t;
    
//    public static int getIdUserloged() {
//		
//			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//             String name = auth.getName();
//    
//    return(t.findUserByEmail(name)).getUser_id();}
// 
}