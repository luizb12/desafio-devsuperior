package com.teste.demo;

import com.teste.demo.Service.OrderService;
import com.teste.demo.Service.ShippingService;
import com.teste.demo.entities.Order;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class TesteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TesteApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o codigo do produto:");
		Integer cod = sc.nextInt();
		System.out.print("Digite o valor basico:");
		double basic = sc.nextDouble();
		System.out.print("Digite a porcentagem de desconto:");
		double disc = sc.nextDouble();


		ShippingService shippingService = new ShippingService();
		OrderService orderService = new OrderService(shippingService);

		Order order = new Order(cod, basic,disc);

		double total = orderService.total(order);

		System.out.println();
		System.out.println("codigo do pedido:" + order.getCode());
		System.out.printf("valor total: R$ %.2f%n" , total);
		// ajuste forçado para atualizaçao do codigo

	}


}
