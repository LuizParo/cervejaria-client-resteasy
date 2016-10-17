package br.com.geladaonline.client;

import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ProxyBuilder;

import br.com.geladaonline.model.rest.Cervejas;

public class Client {

    public static void main(String[] args) {
        ProxyBuilder<CervejaService> proxy = ProxyBuilder.builder(CervejaService.class, ClientBuilder.newClient().target(Constants.HOST));
        CervejaService service = proxy.build();
        
        Cervejas cervejas = service.listeTodasAsCervejas(0);
        cervejas.getLinks().forEach(System.out::println);
    }
}