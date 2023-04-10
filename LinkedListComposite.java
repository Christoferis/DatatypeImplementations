//A LinkedList using the composite pattern (https://en.wikipedia.org/wiki/Composite_pattern) using only one class and several subclasses

//Deadmau5 Master Class
public class LinkedListComposite {
    
    NodeComposite next;
    
    public LinkedListComposite() {
        next = new EndNode();
    }

    public static abstract class NodeComposite {
        public abstract NodeComposite append(Element e);
        public abstract NodeComposite remove(Element e);
        public abstract NodeComposite remove(int index);
        public abstract NodeComposite insert(int index, Element e);
        public abstract int length();
        public abstract Element getElement();
        public abstract NodeComposite getNode(int index);
    }

    public static class Node extends NodeComposite{
        Element data;
        NodeComposite next;

        public Node() {
            super();
        }

        public Node(Element e, NodeComposite next) {
            super();
        }

        @Override
        public LinkedListComposite.NodeComposite append(Element e) {
            next = next.append(e);
            return this;
        }

        @Override
        public LinkedListComposite.NodeComposite remove(Element e) {
            if(data == e){
                return next;
            }else{
                next = next.remove(e);
            }
            return this;
        }

        @Override
        public LinkedListComposite.NodeComposite remove(int index) {
            if(index == 0){
                return next;
            }else{
                next = next.remove(index--);
            }
            //return itself as list depends on returns -> change in list - other return
            return this;
        }

        @Override
        public LinkedListComposite.NodeComposite insert(int index, Element e) {
            if(index == 0){
                next = new Node(e, next);
            }else{
                next = next.insert(index--, e);
            }
            return this;
        }

        @Override
        public int length() {
            return next.length() + 1;
        }

        @Override
        public Element getElement() {
            return data;
        }

        @Override
        public LinkedListComposite.NodeComposite getNode(int index) {
            if(index == 0){
                return this;
            }else{
                return next.getNode(index--);
            }
        }
    }

    public static class EndNode extends NodeComposite{
        @Override
        public LinkedListComposite.NodeComposite append(Element e) {
            return new Node(e, this);
        }

        @Override
        public LinkedListComposite.NodeComposite insert(int index, Element e) {
            if(index == 0){
                return new Node(e, this);
            }else{
                System.err.println("IndexError: index does not exist, try append();");
            }

            return this;
        }

        @Override
        public LinkedListComposite.NodeComposite remove(Element e) {
            System.err.println("ItemNotFoundError: Item doesn't exist in list");
            return this;
        }

        @Override
        public LinkedListComposite.NodeComposite remove(int index) {
            System.err.println("IndexError: index does not exist");
            return this;
        }

        @Override
        public int length() {
            return 0;
        }

        @Override
        public Element getElement() {
            return null;
        }

        @Override
        public LinkedListComposite.NodeComposite getNode(int index) {
            if(index != 0){ System.err.println("Index is to large");}
            return this;
        }
    }

    public void append(Element e){
        next = next.append(e);
    }

    public void remove(Element e){
        next = next.remove(e);
    }

    public void remove(int index){
        next = next.remove(index);
    }

    public void insert(int index, Element e){
        next = next.insert(index, e);
    }

    public int length(){
        return next.length();
    }

    public NodeComposite getNode(int index){
        return next.getNode(index);
    }

}
