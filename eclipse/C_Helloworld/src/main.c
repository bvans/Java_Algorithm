#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "tree.h"
#include "util.h"
#include "../mooc/mooc.h"

/*
 * main.c
 *
 *  Created on: Mar 16, 2015
 *      Author: Administrator
 */

void test(char str[]) {
	printf("%s\n", str);
	str[0] = '';
}



int main(void) {

	setbuf(stdout, NULL);

	char str[] = "123";
	test(str);
	printf("%s\n", str);

	struct Date {
		char a;
		int b;
		int64_t c;
		char d;
	};

	struct Date d;
	printf("%d\n", sizeof(d));

	float pi = PI;
	printf("%f\n", pi);

	char b[10] = "hello";
	printf("%s\n", b);

	maxSub3();
	return 0;

}

