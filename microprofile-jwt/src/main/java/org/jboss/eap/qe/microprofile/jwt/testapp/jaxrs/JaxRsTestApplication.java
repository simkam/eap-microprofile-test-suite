package org.jboss.eap.qe.microprofile.jwt.testapp.jaxrs;

import org.eclipse.microprofile.auth.LoginConfig;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Application which activates JWT subsystem using {@code org.eclipse.microprofile.auth.LoginConfig} annotation
 */
@LoginConfig(authMethod = "MP-JWT",
        //"Virtual" security domain
        realmName = "MP-JWT")
@ApplicationPath("/")
public class JaxRsTestApplication extends Application {

}
