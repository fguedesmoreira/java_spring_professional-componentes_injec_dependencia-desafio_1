package br.com.flavio.curso.javaSpringProfessional.services;

import org.springframework.stereotype.Service;

import br.com.flavio.curso.javaSpringProfessional.entities.Order;

@Service
public class OrderService {

	public double total(Order order) {
		return order.getBasic() * (1 - order.getDiscount() / 100);
	}

}