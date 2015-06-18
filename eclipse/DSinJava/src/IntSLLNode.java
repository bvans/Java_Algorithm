//***********************  IntSLLNode.java  *********************

class IntSLLNode {
    public int info;
    public IntSLLNode next = null;
    public IntSLLNode() {
    }
    public IntSLLNode(int el) {
        info = el;
    }
    public IntSLLNode(int el, IntSLLNode ref) {
        info = el; next = ref; 
    }
}
