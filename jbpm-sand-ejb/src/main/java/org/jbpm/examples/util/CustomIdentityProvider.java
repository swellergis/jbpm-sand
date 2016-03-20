package org.jbpm.examples.util;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.List;

import org.kie.internal.identity.IdentityProvider;

// dummy CustomIdentityProvider solves:
// org.jboss.weld.exceptions.DeploymentException: WELD-001408 Unsatisfied dependencies for type [IdentityProvider]
// with qualifiers [@Default] at injection point [[field] @Inject private org.jbpm.kie.services.impl.KModuleDeploymentService.identityProvider]
@ApplicationScoped
public class CustomIdentityProvider implements IdentityProvider {

    @Override
    public String getName() {
        return "dummy";
    }

    @Override
    public List<String> getRoles() {
        return Collections.emptyList();
    }

    @Override
    public boolean hasRole(String string) {
        return true;
    }

}
