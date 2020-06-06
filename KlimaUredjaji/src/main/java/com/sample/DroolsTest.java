package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;



public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

        	Klima k = new Klima();
           
        	k.setKvadratura(78);
        	k.setGrejanjeViseProstorija(true);
        	k.setZimiZaGrejanjeIspodMinus5(false);
        	k.setMogucnostUgradnjeUZid(true);
            kSession.insert(k);
            
            kSession.fireAllRules();
            
           System.out.println(k);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

   

}
