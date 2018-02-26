package ro.wizadi.flightforum.container.configuration.localisation;

import org.springframework.context.i18n.LocaleContext;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class AcceptHeaderTzResolver implements LocaleContextResolver {

    private LocaleContextResolver localeContextResolver;
    private AcceptHeaderLocaleResolver acceptHeaderLocaleResolver;

    public AcceptHeaderTzResolver(LocaleContextResolver localeContextResolver) {
        this.localeContextResolver = localeContextResolver;
        acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(Locale.getDefault());
    }

    @Override
    public LocaleContext resolveLocaleContext(HttpServletRequest httpServletRequest) {
        return localeContextResolver.resolveLocaleContext(httpServletRequest);
    }

    @Override
    public void setLocaleContext(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, LocaleContext localeContext) {
        localeContextResolver.setLocaleContext(httpServletRequest, httpServletResponse, localeContext);
    }

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        return acceptHeaderLocaleResolver.resolveLocale(httpServletRequest);
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {
        acceptHeaderLocaleResolver.setLocale(httpServletRequest, httpServletResponse, locale);
    }
}
