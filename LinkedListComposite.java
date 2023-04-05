//A LinkedList using the composite pattern (https://en.wikipedia.org/wiki/Composite_pattern) using only one class and several subclasses

//Deadmau5 Master Class
public class LinkedListComposite {
    
    public static abstract class NodeComposite {
        public abstract NodeComposite append(Element e);
        public abstract NodeComposite remove(Element e);
        public abstract NodeComposite remove(int index);
        public abstract NodeComposite insert(int index, Element e);
        public abstract int length();
    }

    public static class Node extends NodeComposite{
        Element data;
        NodeComposite next;

        public Node() {
            super();
        }

    }


}
