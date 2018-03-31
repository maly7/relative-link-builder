package com.github.maly7.hateoas;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class RelativeLinkBuilder {
    public RelativeLinkBuilder() {
        ByteBuddyAgent.install();
        ByteBuddy byteBuddy = new ByteBuddy();
        ClassReloadingStrategy strategy = ClassReloadingStrategy.fromInstalledAgent();

        byteBuddy
                .redefine(ControllerLinkBuilder.class)
                .method(named("getBuilder"))
                .intercept(MethodDelegation.to(RelativeLinkBuilder.class))
                .make()
                .load(ControllerLinkBuilder.class.getClassLoader(), strategy);
    }

    public static UriComponentsBuilder getBuilder() {
        return UriComponentsBuilder.fromPath("/");
    }
}
