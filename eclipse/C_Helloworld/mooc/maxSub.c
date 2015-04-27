/*
 * maxSub.c
 *
 *  Created on: Apr 26, 2015
 *      Author: fan
 */

#include <stdio.h>

int maxSub1(void) {
	int k, i;

	k = 0;
	scanf("%d", &k);
	if (k <= 0 || k > 100000) {
		return 0;
	}

	int num[k];
	for (i = 0; i < k; i++)
		scanf("%d", &num[i]);

	int max = 0;
	int sum;
	int j, h;

	for (i = 0; i < k; i++) {
		for (j = i; j < k; j++) {
			sum = 0;
			for (h = i; h <= j; h++) {
				sum += num[h];
				if (sum > max)
					max = sum;
			}
		}
	}

	if (max < 0) {
		printf("%d\n", 0);
	} else {
		printf("%d\n", max);
	}

	return max;
}

int maxSub2(void) {
	int k, i;

	k = 0;
	scanf("%d", &k);
	if (k <= 0 || k > 100000) {
		return 0;
	}

	int num[k];
	for (i = 0; i < k; i++)
		scanf("%d", &num[i]);

	int max = 0;
	int sum = 0;
	int j;

	for (i = 0; i < k; i++) {
		sum = 0;
		for (j = i; j < k; j++) {
			sum += num[j];
			if (max < sum) {
				max = sum;
			}
		}
	}

	if (max < 0) {
		printf("%d\n", 0);
	} else {
		printf("%d\n", max);
	}

	return max;
}
