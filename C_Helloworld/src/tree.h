/*
 * headers.h
 *
 *
 *  Created on: Mar 16, 2015
 *      Author: Administrator
 */

#ifndef HEADERS_H_
#define HEADERS_H_


#endif /* HEADERS_H_ */

//二叉排序树的节点
typedef struct node {
	int data;
	struct node *left;
	struct node *right;
} Node;

Node *init(int data[], int len);
Node empty();
