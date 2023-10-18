package br.com.flavio.curso.javaSpringProfessional;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.flavio.curso.javaSpringProfessional.entities.Order;
import br.com.flavio.curso.javaSpringProfessional.services.OrderService;
import br.com.flavio.curso.javaSpringProfessional.services.ShippingService;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {

	@Autowired
	private OrderService orderService;
	
	@Autowired ShippingService shippingService;
	
	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados do pedido:");
		
		System.out.print("Código: ");
		int codigo = sc.nextInt();
		
		System.out.print("Valor básico: R$ ");
		double valorBasico = sc.nextDouble();
		
		System.out.print("Percentual do desconto: ");
		double percentualDesconto = sc.nextDouble();
		
		Order pedido = new Order(codigo, valorBasico, percentualDesconto);
		
		sc.close();

		System.out.println();
		System.out.println("SAÍDA:");
		System.out.println("Pedido código " + pedido.getCode());
		System.out.println("Valor total: R$ " + String.format("%.2f", (orderService.total(pedido) + shippingService.shipment(pedido))));
		
	}

}