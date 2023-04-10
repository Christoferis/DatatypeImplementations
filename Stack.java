// A classic Stack example using the Adapter Software Pattern
public class Stack {

    LinkedListComposite list;

    public Stack() {
        list = new LinkedListComposite();
    }

    public void push(Element e){
        list.append(e);
    }

    public Element pop(){
        Element e = this.peek();
        list.remove(e);
        return e;
    }

    public Element peek(){
        return list.getNode(list.length() - 1).getElement();
    }

    public int length(){
        return list.length();
    }
}
