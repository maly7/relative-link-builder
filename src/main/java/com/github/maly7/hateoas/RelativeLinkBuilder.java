package com.github.maly7.hateoas;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import static net.bytebuddy.matcher.ElementMatchers.named;

@Component
public class RelativeLinkBuilder {
    public RelativeLinkBuilder() {
        ByteBuddy byteBuddy = new ByteBuddy();
        ClassReloadingStrategy strategy = ClassReloadingStrategy.fromInstalledAgent();

        byteBuddy
                .redefine(ControllerLinkBuilder.class)
                .method(named("getBuilder"))
                .intercept(FixedValue.value(UriComponentsBuilder.fromPath("/")))
                .make()
                .load(contextClassLoader(), strategy);
    }

    private static ClassLoader contextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }
}
