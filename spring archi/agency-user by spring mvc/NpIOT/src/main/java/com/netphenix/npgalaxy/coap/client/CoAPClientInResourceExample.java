/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netphenix.npgalaxy.coap.client;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.ConcurrentCoapResource;

public class CoAPClientInResourceExample extends ConcurrentCoapResource {

    public CoAPClientInResourceExample(String name) {
        super(name, SINGLE_THREADED);
    }

    @Override
    public void handleGET(final CoapExchange exchange) {
        exchange.accept();

        CoapClient client = createClient("localhost:5683/target");
        client.get(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                exchange.respond(response.getCode(), response.getPayload());
            }

            @Override
            public void onError() {
                exchange.respond(ResponseCode.BAD_GATEWAY);
            }
        });

        // exchange has not been responded yet
    }

    @Override
    public void handlePOST(CoapExchange exchange) {
        exchange.accept();

        ResponseCode response;
        synchronized (this) {
            // critical section
            response = ResponseCode.CHANGED;
        }

        exchange.respond(response);
    }

    public static void main(String[] args) {
        CoapServer server = new CoapServer();
        server.add(new CoAPClientInResourceExample("example"));
        server.add(new CoapResource("target") {
            @Override
            public void handleGET(CoapExchange exchange) {
                exchange.respond("Target payload");
//				exchange.reject();
            }
        });
        server.start();
    }
}
