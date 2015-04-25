/*
 * util.c
 *
 *  Created on: 2015-4-25
 *      Author: Van
 */

static unsigned long int next = 1; //种子
int rand1(void) {
	//产生随机数的魔术般的公式
	next = next * 1103515245 + 12345;
	return (unsigned) (next / 65536) % 32768;
}

void srand1(unsigned int seed) {
	next = seed;
}
