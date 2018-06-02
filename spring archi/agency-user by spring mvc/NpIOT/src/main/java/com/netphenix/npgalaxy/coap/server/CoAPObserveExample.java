/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netphenix.npgalaxy.coap.server;

/**
 *
 * @author samraj
 */
import static org.eclipse.californium.core.coap.CoAP.ResponseCode.*;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.observe.ObserveRelation;
import org.eclipse.californium.core.observe.ObserveRelationFilter;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class CoAPObserveExample extends CoapResource {

    public CoAPObserveExample(String name) {
        super(name);
        setObservable(true); // enable observing
        setObserveType(Type.CON); // configure the notification type to CONs
        getAttributes().setObservable(); // mark observable in the Link-Format

        // schedule a periodic update task, otherwise let events call changed()
        Timer timer = new Timer();
        timer.schedule(new UpdateTask(), 0, 100);
    }

    private class UpdateTask extends TimerTask {

        @Override
        public void run() {
            ObserveRelationFilter filter = new ObserveRelationFilter() {
                @Override
                public boolean accept(ObserveRelation or) {
                    System.out.println("AAAAAAAAAAAAAAAAAAA " + or.getResource().getURI());
                    if(or.getResource().getURI().endsWith("aaa")) {
                        return true;
                    }
                    return false;
                }
            };
            // .. periodic update of the resource
            changed(); // notify all observers
        }
    }

    @Override
    public void handleGET(CoapExchange exchange) {
        exchange.setMaxAge(1); // the Max-Age value should match the update interval
        exchange.respond("update");
    }

    @Override
    public void handleDELETE(CoapExchange exchange) {
        delete(); // will also call clearAndNotifyObserveRelations(ResponseCode.NOT_FOUND)
        exchange.respond(DELETED);
    }

    @Override
    public void handlePUT(CoapExchange exchange) {
        // ...
        exchange.respond(CHANGED);
        changed(); // notify all observers
    }

    public static void main(String[] args) {
        CoapServer server = new CoapServer();
        server.add(new CoAPObserveExample("hello/#"));
        server.start();
    }

}
