/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netphenix.npgalaxy.coap.server;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;
import org.eclipse.californium.core.server.resources.ConcurrentCoapResource;

/**
 *
 * @author samraj
 */
public class NpCoapServer {

    public static void main(String[] args) {
        System.out.println("Starting Concurrent Example Server");

        CoapServer server = new CoapServer();
        server.add(new NoThreadResource("server-thread")
                .add(new NoThreadResource("server-thread")
                        .add(new NoThreadResource("server-thread"))));
        server.add(new ConcurrentResource("single-threaded", 1)
                .add(new ConcurrentResource("single-threaded", 1)));
        server.add(new ConcurrentResource("four-threaded", 4)
                .add(new NoThreadResource("same-as-parent")
                        .add(new NoThreadResource("same-as-parent"))));

        // Use an already created resource without executor as implementation
        // for a resource that has its own executor.
        server.add(ConcurrentCoapResource.createConcurrentCoapResource(2, new LegacyResource("legacy")));

        // start the server
        server.start();
    }

    /**
     * A resource that uses the executor of its parent/ancestor if defined or
     * the server's executor otherwise.
     */
    private static class NoThreadResource extends CoapResource {

        public NoThreadResource(String name) {
            super(name);
        }

        @Override
        public void handleGET(CoapExchange exchange) {
            exchange.respond(ResponseCode.CONTENT,
                    "You have been served by my parent's thread:" + Thread.currentThread().getName(),
                    MediaTypeRegistry.TEXT_PLAIN);
        }
    }

    /**
     * A resource with its own executor. Only threads of that executor will
     * handle GET requests.
     */
    private static class ConcurrentResource extends ConcurrentCoapResource {

        public ConcurrentResource(String name) {
            super(name);
        }

        public ConcurrentResource(String name, int threads) {
            super(name, threads);
        }

        @Override
        public void handleGET(CoapExchange exchange) {
            exchange.respond(ResponseCode.CONTENT, "You have been served by one of my " + getThreadCount() + " threads: " + Thread.currentThread().getName(), MediaTypeRegistry.TEXT_PLAIN);
        }

        /**
         * This method must only be executed by one thread at the time.
         * Therefore, we make it synchronized. This does not affect handleGET()
         * which can be executed concurrently.
         */
        @Override
        public void handlePOST(CoapExchange exchange) {
            exchange.accept();
            synchronized (this) {
                try {
                    Thread.sleep(5000); // waste some time
                } catch (Exception e) {
                    e.printStackTrace();
                }
                exchange.respond(ResponseCode.CONTENT, "Your POST request has been handled by one of my " + getThreadCount() + " threads: " + Thread.currentThread().getName());
            }
        }
    }

    /**
     * An already existing resource that we want to use as implementation of a
     * concurrent resource.
     */
    private static class LegacyResource extends CoapResource {

        public LegacyResource(String name) {
            super(name);
        }

        @Override
        public void handleGET(CoapExchange exchange) {
            exchange.respond("You have been served by " + Thread.currentThread());
        }
    }
}
