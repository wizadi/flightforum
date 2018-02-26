package ro.wizadi.flightforum.modules.common.interceptors;

import org.springframework.context.i18n.SimpleTimeZoneAwareLocaleContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import static java.lang.String.format;

public class MyInterceptor extends HandlerInterceptorAdapter {

//    @Autowired
//    private MyRepository myRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Simple check to see if database object exists for requesting urls otherwise
        // throw runtime exception to be picked up by handler for error response

        /*Map pathVariables = getUrlPathVariables(request);
        String prop = (String) pathVariables.get("prop"); // e.g. /rest/path/${myParam}

        System.out.println(request.getParameter("prop"));

        if (myId != null && myRepository.findById(myId) == null) {
            throw new RuntimeException("My Object not found");
        }*/

        //todo, set locale

        String tz = request.getHeader("tz");
        if (tz != null) {
            TimeZone timeZone = TimeZone.getTimeZone(tz);
            LocaleContextResolver localeResolver = (LocaleContextResolver) RequestContextUtils.getLocaleResolver(request);
            Locale locale = localeResolver.resolveLocale(request);
            localeResolver.setLocaleContext(request, response, new SimpleTimeZoneAwareLocaleContext(locale, timeZone));
        }


        return true;
    }

    private Map getUrlPathVariables(HttpServletRequest request) {
        return (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    }

    private Map getUrlParamVariables(HttpServletRequest request) {
        return (Map) request.getAttribute(HandlerMapping.MATRIX_VARIABLES_ATTRIBUTE);
    }

}