/*
 ============================================================================
 Name        : C_Helloworld.c
 Author      : yalong
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

void qSort(int num[], int start, int end) {
	if(start >= end) {
		return;
	}

	int left = start;
	int right = end;
	int val = num[start];

	while(left < right) {
		while(left < right && num[right] > val) {
			right--;
		}
		if(left < right) {
			num[left++] = num[right];
		}

		while(left < right && num[left] < val) {
			left++;
		}
		if(left < right) {
			num[right--] = num[left];
		}
	}

	num[left] = val;
	qSort(num, start, left - 1);
	qSort(num, left + 1, end);
}
