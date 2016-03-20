package org.jbpm.examples.util;

import org.kie.api.runtime.manager.RuntimeManager;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Collections;
import org.jbpm.services.api.DeploymentService;
import org.jbpm.services.api.model.DeployedUnit;
import org.jbpm.services.api.model.DeploymentUnit;


// plain CustomDeploymentService solves:
// Caused by: org.jboss.weld.exceptions.DeploymentException: WELD-001408 Unsatisfied dependencies for type [DeploymentService]
// with qualifiers [@Default] at injection point [[field] @Inject private org.jbpm.kie.services.impl.form.FormProviderServiceImpl.deploymentService]
@ApplicationScoped
public class CustomDeploymentService implements DeploymentService {

    @Override
    public void deploy(DeploymentUnit du) {
    }

    @Override
    public void undeploy(DeploymentUnit du) {
    }

    @Override
    public RuntimeManager getRuntimeManager(String string) {
        return null;
    }

    @Override
    public DeployedUnit getDeployedUnit(String string) {
        return null;
    }

    @Override
    public Collection<DeployedUnit> getDeployedUnits() {
        return Collections.emptyList();
    }

    @Override
    public void activate(String string) {
    }

    @Override
    public void deactivate(String string) {
    }

    @Override
    public boolean isDeployed(String string) {
        return true;
    }

 }
