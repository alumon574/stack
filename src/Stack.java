public class Stack<E extends Number> {
    public Stack() {
    }

    private Element<E> topElement = null;
    private Element<E> belowElement = null;

    public Boolean Empty() {
        return topElement == null;
    }

    public void peek() {
        System.out.println(topElement);
    }

    public E pop() {
        E oldTop;
        Element<E> newTop;
        oldTop = topElement.getObject();
        newTop = topElement.getUnder();
        topElement.delete();
        topElement = newTop;
        return oldTop;
    }

    public void push(E item) {
        Element<E> newElement = new Element<E>(item);
        newElement.setUnder(topElement);
        topElement = newElement;
    }

    public int search(E item) {
        int index=0;
        Element<E> currentItem = topElement;
        if (currentItem != null) {
            while (currentItem.getObject() != item){
                currentItem=currentItem.getUnder();
                index++;
            }
        }
        System.out.println("Indice: " + index);
        return index;
    }


    private class Element<E> {
        private E e;
        Element<E> under = null;
        Element<E> prev = null;

        public Element(E e) {
            this.e = e;
        }

        public void setUnder(Element<E> newNext) {
            this.under = newNext;
        }

        public void setPrev(Element<E> prev) {
            this.prev = prev;
        }

        public Element<E> getUnder() {
            return under;
        }

        public E getObject() {
            return e;
        }

        public void setObject(E newObject) {
            e = newObject;
        }

        public void delete() {
            e = null;
            under = null;
        }

        @Override
        public String toString() {
            return "Elemento: " + e;
        }
    }
}
