/*
 * bTree.c
 *
 *  Created on: 2015-4-23
 *      Author: Van
 */

#include <stdlib.h>
#include "tree.h"

void init(int data[], int len, Node *root);
void insert(Node *root, int x);

Node empty() {
	Node root = { 0, NULL, NULL };
	return root;
}


void init(int data[], int len, Node *root) {
	if(len <= 0)
		return;

	int i;
	for(i = 1; i < len; i++) {
		insert(root, data[i]);
	}
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

