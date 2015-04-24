/*
 * bTree.c
 *
 *  Created on: 2015-4-23
 *      Author: Van
 */

#include <stdlib.h>
#include "tree.h"

Node empty() {
	Node root = { 0, NULL, NULL };
	return root;
}

//Node init(int data[], int length){
//	if(len < 0) {
//		return empty();
//	}
//
//	Node root = {
//			data[0],
//			NULL,
//			NULL
//	};
//
//	int i;
//	for (i = 0; i <length; i++) {
//
//	}
//}

Node *init(int data[], int len) {
	if(len <= 0)
		return NULL;

	Node root = {data[0], NULL, NULL};

	int i;
	for(i = 1; i < len; i++) {
		insert(&root, data[i]);
	}
	return &root;
}

void insert(Node *root, int x) {
	if (root == NULL)
		return;

	if (root->data < x) {
		if (root->right != NULL) {
			insert(root->right, x);
		}
		Node node = { x, NULL, NULL };
		root->right = &node;
	} else {
		if (root->left != NULL) {
			insert(root->left, x);
		}
		Node node = { x, NULL, NULL };
		root->left = &node;
	}

	Node node = { x, NULL, NULL };
	return;
}

