package com.virtualmind.service;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DateBucket {
	// Simplified for the example, should have getters at least for these fields
	final Instant from;
	final Instant to;

	DateBucket(Instant from, Instant to) {
		this.from = from;
		this.to = to;
	}

	public static void main(String... args) {

		List<DateBucket> buckets = bucketize(
				ZonedDateTime.of(LocalDate.of(2017, Month.MAY.getValue(), DayOfWeek.SUNDAY.getValue()),
						LocalTime.MIDNIGHT, ZoneId.systemDefault()),
				ZonedDateTime.now(), 150, ChronoUnit.SECONDS);

		List<DateBucket> buckets2 = bucketize8(
				ZonedDateTime.of(LocalDate.of(2017, Month.MAY.getValue(), DayOfWeek.SUNDAY.getValue()),
						LocalTime.MIDNIGHT, ZoneId.systemDefault()),
				ZonedDateTime.now(), 150, ChronoUnit.SECONDS);

		System.out.println(buckets.size());
		System.out.println(buckets2.size());
		for (int i = 0; i < buckets2.size(); i++) {
			if (!buckets.get(i).to.equals(buckets2.get(i).to) || !buckets.get(i).from.equals(buckets2.get(i).from)) {
				System.out.println("ERROR");
			}
			// System.out.println(buckets.get(i).to.equals(buckets2.get(i).to));
			// System.out.println(buckets.get(i).from.equals(buckets2.get(i).from));
		}
		System.out.println(buckets.size() == buckets2.size());

	}

	public static List<DateBucket> bucketize(ZonedDateTime fromDate, ZonedDateTime toDate, int bucketSize,
			ChronoUnit bucketSizeUnit) {
		List<DateBucket> buckets = new ArrayList<>();
		boolean reachedDate = false;
		for (int i = 0; !reachedDate; i++) {
			ZonedDateTime minDate = fromDate.plus(i * bucketSize, bucketSizeUnit);
			ZonedDateTime maxDate = fromDate.plus((i + 1) * bucketSize, bucketSizeUnit);
			reachedDate = toDate.isBefore(maxDate);
			buckets.add(new DateBucket(minDate.toInstant(), maxDate.toInstant()));
		}
		return buckets;
	}

	public static List<DateBucket> bucketize8(ZonedDateTime fromDate, ZonedDateTime toDate, int bucketSize,
			ChronoUnit bucketSizeUnit) {
		List<DateBucket> buckets = new ArrayList<>();
		Long diff = bucketSizeUnit.between(fromDate, toDate);
		Stream<Integer> integers = Stream.iterate(0, i -> i + 1).limit(diff / bucketSize + 1);
		integers.map(i -> new DateBucket(fromDate.plus(i * bucketSize, bucketSizeUnit).toInstant(),
				fromDate.plus((i + 1) * bucketSize, bucketSizeUnit).toInstant()))
				// .filter(b -> toDate.toInstant().isAfter(b.from))
				.collect(Collectors.toCollection(() -> buckets));

		return buckets;
	}
}
