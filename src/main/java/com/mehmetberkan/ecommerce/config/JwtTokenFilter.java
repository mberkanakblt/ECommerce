package com.mehmetberkan.ecommerce.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class JwtTokenFilter extends OncePerRequestFilter {
    /**
     * Sunucuya gelen tüm istekelrin geçtiği nokta. Hiç bir istisnba olmadan burdan geçer.
     *
     *
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Autowired
    private JwtManager jwtManager;
    @Autowired
    private JwtUserDetails jwtUserDetails;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requestHeaderAuthorization = request.getHeader("Authorization");
        System.out.println("header : "+requestHeaderAuthorization);
        /**
         *
         */
        if(Objects.nonNull(requestHeaderAuthorization) && requestHeaderAuthorization.startsWith("Bearer ")){
            String token = requestHeaderAuthorization.substring(7);
            Optional<Long> userId =  jwtManager.validateToken(token);
            if(userId.isPresent()){ // token geçerli ve bir id var ise
                /**
                 * 1. İlgili kullanıcı id si ile kontrol yapılıp, bir kimlik artı oluşturuylur (UserDetails)
                 * 2. Spring in yönetebileceğin bir token oluşturulur. (AuthenticationToken)
                 * 3. Geçerli session içerisine bu token enjekte edilir. (holder içerisine ekleme)
                 */
                UserDetails userDetails = jwtUserDetails.loadUserById(userId.get());
                UsernamePasswordAuthenticationToken springToken = new
                        UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(springToken);
            }
        }
        filterChain.doFilter(request,response);

    }
}
