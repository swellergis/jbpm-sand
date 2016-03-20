package org.jbpm.examples.ejb;

import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.internal.runtime.manager.cdi.qualifier.Singleton;
import org.kie.internal.runtime.manager.context.EmptyContext;

@Startup
@javax.ejb.Singleton
public class ProcessBean    {

    @Inject
    @Singleton
    private RuntimeManager singletonManager;

    @PostConstruct
    public void configure() {
        // use toString to make sure CDI initializes the bean
        // this makes sure that RuntimeManager is started asap,
        // otherwise after server restart complete task won't move process forward 
        singletonManager.toString();
    }

    public long startProcess(String processName, Map<String, Object> params) throws Exception {
        RuntimeEngine runtime = singletonManager.getRuntimeEngine(EmptyContext.get());
        KieSession ksession = runtime.getKieSession();

        long processInstanceId = -1;
        try {
            ProcessInstance processInstance = ksession.startProcess(processName,params);
            processInstanceId = processInstance.getId();
            System.out.println("Process started ... : processInstanceId = "
                    + processInstanceId);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return processInstanceId;
    }

}
