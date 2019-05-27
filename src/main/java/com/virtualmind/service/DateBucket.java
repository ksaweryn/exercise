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
import java.util.stream.IntStream;

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
				ZonedDateTime.of(LocalDate.of(1988, Month.MAY.getValue(), DayOfWeek.SUNDAY.getValue()),
						LocalTime.MIDNIGHT, ZoneId.systemDefault()),
				ZonedDateTime.now(), 2, ChronoUnit.DAYS);
		System.out.println(buckets.size());
		for (DateBucket bucket : buckets) {
			System.out.println("TO " + bucket.to);
			System.out.println("FROM " + bucket.from);
		}

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
		boolean reachedDate = false;
		for (int i = 0; !reachedDate; i++) {

		}
		IntStream.iterate(0, i -> i + 1).limit(toDate.isBefore(ZonedDateTime.now())).forEach(i -> {
			ZonedDateTime maxDate = fromDate.plus((i + 1) * bucketSize, bucketSizeUnit);
			buckets.add(new DateBucket(fromDate.plus(i * bucketSize, bucketSizeUnit).toInstant(), maxDate.toInstant()));
		})
		
		List<DateBucket> result = 

		return buckets;
	}
}
