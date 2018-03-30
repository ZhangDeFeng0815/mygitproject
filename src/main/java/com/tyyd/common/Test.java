package com.tyyd.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Test {

	public static void main(String[] args) {
		// Set<Integer> ints = Set.of(1, 2, 3);
		// ints.add(4);
		// System.out.println(ints.size());
		//
		// List<String> filteredList = listOfOptionals.stream()
		// .flatMap(Optional::stream)
		// .collect(Collectors.toList());
		
		Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
		System.out.println(defaulable.notRequired());
		defaulable = DefaulableFactory.create(OverridableImpl::new);
		System.out.println(defaulable.notRequired());
		Value.<String>defaultValue();
		
		long[] arrayOfLong = new long[20000];
		Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
		Arrays.parallelSort(arrayOfLong);
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		System.out.println();
	}

}
