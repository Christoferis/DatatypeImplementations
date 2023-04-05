//Standard Implementation of a linked list, with recursion, in one class. The whole class acting either as a Node or the starting point
// CC0 for education purposes only -> github.com/Christoferis
public class LinkedListClassic{

    Element data;
    LinkedListClassic next;

    public LinkedListClassic(Element e) {
        data = e;
    }

    //append function -> Adds a new Element to the end of the list
    public void append(Element e){
        if(next != null){
            next.append(e);
        }else{
            next = new LinkedListClassic(e);
        }
    }

    //Index Implementation, throws IndexOutOfBounds if Index not in range
    public void remove(int index) throws IndexOutOfBoundsException{
        if(index == 1){
            next = next.getNext();
        }else if(next != null){
            next.remove(index--);
        }else{
            //if there is no Index of this caliber in here
            throw new IndexOutOfBoundsException();
        }
    }

    //Element Implementation -> throws exception if Element not found
    public void remove(Element e) throws Exception{
        if(next.getData() == e){
            next = next.getNext();
        }else if(next != null){
            next.remove(e);
        }else{
            throw new Exception();
        }
    }

    //inserts item [AFTER] desired index (zero indexed)
    public void insert(int index, Element e){
        if(index == 0 && next != null){
            LinkedListClassic temp = next;
            (next = new LinkedListClassic(e)).setNext(temp);
        }else if(next == null){
            next = new LinkedListClassic(e);
        }else{
            next.insert(index--, e);
        }
    }

    //returns current length of the list, starting at 1, as to include the first Node 
    public int length(){
        if(next != null){
            return next.length() + 1;
        }else{
            return 1;
        }
    }

    //getters and setters
    public Element getData(){
        return data;
    }

    public LinkedListClassic getNext(){
        return next;
    }

    public void setNext(LinkedListClassic next){
        this.next = next;
    }

}