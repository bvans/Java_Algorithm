/*
 * maxSub.c
 *
 *  Created on: Apr 26, 2015
 *      Author: fan
 */

int maxSub1(void) {
	int i, j, k, h;

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

	for (i = 0; i < k; i++) {
		for (j = i + 1; j < k; j++) {
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
	int k = 0;
	int i, j;
	int sum, max;

}
