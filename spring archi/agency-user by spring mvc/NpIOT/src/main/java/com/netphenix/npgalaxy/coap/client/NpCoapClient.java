/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netphenix.npgalaxy.coap.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.californium.core.coap.CoAP;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.Request;

/**
 *
 * @author samraj
 */
public class NpCoapClient {

    public static void main(String[] args) {

        CoapClient client = new CoapClient("coap://localhost:5683/hello");

        System.out.println("SYNCHRONOUS");

        // synchronous
        String content1 = client.get().getResponseText();
        System.out.println("RESPONSE 1: " + content1);

        CoapResponse resp2 = client.post("payload", MediaTypeRegistry.TEXT_PLAIN);
        System.out.println("RESPONSE 2 CODE: " + resp2.getCode());

        // asynchronous
        System.out.println("ASYNCHRONOUS (press enter to continue)");

        client.get(new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                String content = response.getResponseText();
                System.out.println("RESPONSE 3: " + content);
            }

            @Override
            public void onError() {
                System.err.println("FAILED");
            }
        });

        // wait for user
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            br.readLine();
        } catch (IOException e) {
        }

        // observe
        System.out.println("OBSERVE (press enter to exit)");
        Request test;
        test = new Request(CoAP.Code.GET, CoAP.Type.CON);
        test.setObserve();
        CoapObserveRelation relation = client.observe(test, 
                new CoapHandler() {
            @Override
            public void onLoad(CoapResponse response) {
                String content = response.getResponseText();
                System.out.println("NOTIFICATION: " + content);
            }

            @Override
            public void onError() {
                System.err.println("OBSERVING FAILED (press enter to exit)");
            }
        });

        // wait for user
        try {
            br.readLine();
        } catch (IOException e) {
        }

        System.out.println("CANCELLATION");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(NpCoapClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        relation.proactiveCancel();
    }
}
