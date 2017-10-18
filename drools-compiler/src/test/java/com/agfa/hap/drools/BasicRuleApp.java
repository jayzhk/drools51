package com.agfa.hap.drools;

import com.agfa.hap.drools.service.AccountService;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;


public class BasicRuleApp {

    public static void main(String[] args){
        KnowledgeBase base = createKnowledgeBase();
        StatefulKnowledgeSession session = base.newStatefulKnowledgeSession();
        try {
            Account account1 = new Account();
            Account account2 = new Account();
            AccountService service = new AccountService();
            account1.setBalance(100);
            account2.setBalance(50);
            session.insert(account1);
            session.insert(account2);

            session.setGlobal("accountService", service);
            session.fireAllRules();
        }finally{
            session.dispose();
        }
    }

    private static KnowledgeBase createKnowledgeBase(){
        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        builder.add(ResourceFactory.newClassPathResource("account/basic.drl"), ResourceType.DRL);

        if(builder.hasErrors()){
            throw new RuntimeException(builder.getErrors().toString());
        }

        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());

        return knowledgeBase;

    }
}
