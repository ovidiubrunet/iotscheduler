package com.smartenergy.iotscheduler;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Scheduler {
	public static void main(String[] args) throws Exception {
		
		// a list of smart meters that have a s
		int dbTime = 1500;
		
		Scheduler s = new Scheduler();
		s.show(dbTime);
	}

	public void show(int duration) throws Exception{
		System.out.println("=== from Collection using map() ===");
		List<String> data = new ArrayList<String>(Arrays.asList("{A}", "{B}", "{C}"));
		Flux<String> intervalFlux1 = Flux.interval(Duration.ofMillis(duration)).map(tick -> {
			if (tick < data.size())
				return "item " + tick + ": " + data.get(tick.intValue());
			return "Done (tick == data.size())";
		});

		intervalFlux1.take(data.size() + 1).subscribe(System.out::println);
		Thread.sleep(10000000);

		/*System.out.println("=== from Collection using zipWithIterable() and map() ===");
		Flux<String> intervalFlux2 = Flux.interval(Duration.ofMillis(duration)).zipWithIterable(data)
				.map(source -> "item " + source.getT1() + ": " + source.getT2());

		intervalFlux2.subscribe(System.out::println);
		Thread.sleep(3000);

		System.out.println("=== from Flux using zipWith() ===");
		Flux<String> flux = Flux.just("{A}", "{B}", "{C}");
		Flux<String> intervalFlux3 = Flux.interval(Duration.ofMillis(duration)).zipWith(flux,
				(i, item) -> "item " + i + ": " + item);

		intervalFlux3.subscribe(System.out::println);
		Thread.sleep(3000);*/
	}
}
