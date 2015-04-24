#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include "tree.h"

#define PD(x) printf("%ld", (x))
#define PS(x) printf("%s", (x))
#define PN printf("\n")

/*
 * main.c
 *
 *  Created on: Mar 16, 2015
 *      Author: Administrator
 */

void change(int *arr, int length);

int main(void) {
	int a[10];
	int i = 0;
	while (i < 10)
		a[i++] = rand();

	Node *root = init(a, 1);
	long start = clock();
	long now;

	srand(clock());
	printf("%ld\n", rand() % 100);

	now = time(NULL);
	srand(now);
	printf("%ld\n", rand() % 100);

}

void change(int *arr, int length) {
	arr[0] = 12;
}
