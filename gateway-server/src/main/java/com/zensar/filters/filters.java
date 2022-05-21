package com.zensar.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public class filters implements GlobalFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		System.out.println("pre processing"+exchange.getRequest());
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			System.out.println("post processing"+exchange.getResponse());
		}));
	}
}
