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

	return 0;
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

	return 0;
}

int maxSub3(void) {
	int k, i;

	k = 0;
	scanf("%d", &k);
	if (k <= 0 || k > 100000) {
		return 0;
	}

	/*int num[k];
	for (i = 0; i < k; i++)
		scanf("%d", &num[i]);*/

	int sum = 0;
	int j;

	int num[3] = {8, -8, 9};
	int start = 0;
	int end = 2;
	int max = 0;
	maxSub33(num, &start, &end, &max);

	return 0;
}

int maxSub33(const int arr[], int *start, int *end, int *max) {
      	if (*start >= *end) {
		*max = arr[*start] > 0 ? arr[*start] : 0;
		return *max;
	}

	int mid = (*start + *end) >> 1;

	/*int *left1 = *start;
	int *right1 = mid - 1;
	int *left2 = &mid;
	int *right2 = *end;
	int *leftRes = 0;
	int *rightRes = 0;*/

	int left1 = *start;
	int right1 = mid - 1;
	int left2 = mid;
	int right2 = *end;

	int leftRes = 0;
	int rightRes = 0;

	maxSub33(arr, &left1, &right1, &leftRes);
	maxSub33(arr, &left2, &right2, &rightRes);

	if (leftRes <= 0 && rightRes <= 0) {
		return 0;
	} else if (leftRes <= 0) {
		*start = left1;
		*end = right1;
		*max = rightRes;
		return *max;
	} else if (rightRes <= 0) {
		*start = left2;
		*end = right2;
		*max = leftRes;
		return *max;
	}

	int i = left1;
	int j = right2;

	int tmp = 0;
	while (i <= j) {
		tmp += arr[i];
		i++;
	}

	if (tmp > leftRes && tmp > rightRes) {
		*start = i;
		*end = j;
		*max = tmp;
	} else if (leftRes > tmp && leftRes > rightRes ) {
		start = left1;
		*end = right1;
		*max = leftRes;
	} else {
		*start = left2;
		*end = right2;
		*max = rightRes;
	}

	return *max;
}

