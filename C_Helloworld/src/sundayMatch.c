/*
 * sundayMatch.c
 *
 *  Created on: Mar 16, 2015
 *      Author: Administrator
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int sunday(const char* src, const char* des);

int sunday(const char* src, const char* des) {
	int i = 0;

	int hash[256] = { };

	int srcLen = strlen(src);
	int desLen = strlen(des);

	for (i = 0; i < 256; i++) {
		hash[i] = 0;
	}

	for (i = 0; i < desLen; i++) {
		//翻转子串中字符的位置(倒序)存储在hash数组中
		hash[des[i]] = desLen - i;
	}

	int pos = 0;
	while (pos < srcLen) {
		int k;
		for (k = 0; k < desLen && des[k] == src[pos + k]; k++)
			;

		if (k == desLen) {
			return pos;
		}

		char nextChar = src[pos + desLen];
		int step = hash[nextChar];
		if (!step) {
			//下一个字符没有在子串中出现,则直接移动 子串长度+1 个字符
			pos += desLen + 1;
		} else {
			//pos为子串头部对应于父串的位置
			//向后移动子串长度个位置,然后移几个位置(step)
			pos = pos + step;
			int a = 0;
		}
	}

	return -1;
}
