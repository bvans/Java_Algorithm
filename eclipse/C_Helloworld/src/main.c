#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "tree.h"
#include "util.h"

/*
 * main.c
 *
 *  Created on: Mar 16, 2015
 *      Author: Administrator
 */

int main(void) {
	setbuf(stdout, NULL);

	int i, j ,k, h;

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
				if(sum > max)
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

