# RelativeLinkBuilder
This project is an example of using ByteBuddy to alter the behavior of Spring HATEOAS's ControllerLinkBuilder to always generate relative links.

## Sample Usage
Just create a Bean of type RelativeLinkBuilder
```java
@Bean
public RelativeLinkBuilder relativeLinkBuilder() {
    return new RelativeLinkBuilder();
}
```
