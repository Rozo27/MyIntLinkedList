public class Main {
    public static void printList(MyIntLinkedList lista){
        System.out.print("Lista contine elementele:[");
        for(int i=0;i<lista.getSize();i++){
            if(i==lista.getSize()-1)
                System.out.print(lista.get(i).value());
            else   System.out.print(lista.get(i).value()+",");
        }
        System.out.println("]");
    }
    public static void main(String[] args){
        MyIntLinkedList lista=new MyIntLinkedList();
        //creez lista
        lista.add(2);
        lista.add(3);
        lista.add(4);
        printList(lista);

        //adaug un element la un anumit index
        lista.add(2,5);
        printList(lista);

        //creez o lista prin transferul elementelor din lista initiala
        MyIntLinkedList listaCopie=new MyIntLinkedList(lista);
        printList(listaCopie);

        //verific daca o anumita valoare se gaseste in lista
        System.out.println("Lista contine valoarea 2?"+lista.contains(2));
        System.out.println("Lista contine valoarea 9?"+lista.contains(9));

        //caut un element in lista
        int rez=lista.indexOf(2);
        if(rez!=-1)
            System.out.println("Elementul 2 apare pe pozitia "+rez);
        else System.out.println("Elemetul 2 nu apare in lista");
        rez=lista.indexOf(10);
        if(rez!=-1)
            System.out.println("Elementul 10 apare pe pozitia "+rez);
        else System.out.println("Elemetul 10 nu apare in lista");
        rez=lista.indexOf(4);
        if(rez!=-1)
            System.out.println("Elementul 4 apare pe pozitia "+rez);
        else System.out.println("Elemetul 4 nu apare in lista");
        rez=lista.indexOf(5);
        if(rez!=-1)
            System.out.println("Elementul 5 apare pe pozitia "+rez);
        else System.out.println("Elemetul 5 nu apare in lista");
        System.out.println();
        //verific care este ultima aparitie
        lista.add(2,2);
        lista.add(0,5);
        printList(lista);
        System.out.println();
        rez=lista.lastIndexOf(2);
        if(rez!=-1)
            System.out.println("Elementul 2 apare ultima data pe pozitia "+rez);
        else System.out.println("Elemetul 2 nu apare in lista");
        rez=lista.lastIndexOf(5);
        if(rez!=-1)
            System.out.println("Elementul 5 apare ultima data pe pozitia "+rez);
        else System.out.println("Elemetul 5 nu apare in lista");
        rez=lista.lastIndexOf(10);
        if(rez!=-1)
            System.out.println("Elementul 10 apare ultima data pe pozitia "+rez);
        else System.out.println("Elemetul 10 nu apare in lista");
        rez=lista.lastIndexOf(4);
        if(rez!=-1)
            System.out.println("Elementul 4 apare ultima data pe pozitia "+rez);
        else System.out.println("Elemetul 4 nu apare in lista");
        System.out.println();
        //sterg prima aparitie a lui e din lista
        System.out.println("Lista dupa ce am sters elemente din ea folosind remove(int element)");
        lista.remove(2);
        lista.remove(4);
        lista.remove(5);
        printList(lista);

        System.out.println();
        //adaug elemente noi in lista si apoi sterg anumite elemente de la un index dat
        lista.add(6);
        lista.add(7);
        lista.add(10);
        lista.add(15);
        lista.add(19);
        printList(lista);
        System.out.println("Lista dupa ce am sters elemente din ea folosind removeElementAtIndex(int index)");
        lista.removeElementAtIndex(5);
        lista.removeElementAtIndex(19);
        lista.removeElementAtIndex(0);
        lista.removeElementAtIndex(lista.getSize()-1);
        printList(lista);
        System.out.println();

        //sterg toate elementele din lista
        lista.clear();
        System.out.println("Lista are "+lista.getSize()+" elemente");
        printList(lista);
        //setez un element la o pozitie data

        lista.add(6);
        lista.add(7);
        lista.add(10);
        lista.add(15);
        lista.add(19);
        printList(lista);
        System.out.println("Lista dupa ce am setat elementele la index");
        lista.set(5,17);
        lista.set(4,2);
        lista.set(0,26);
        lista.set(2,8);
        printList(lista);
        System.out.println("\n");

        //adaug un obiect MyIntLinkedList c la finalul listei
        System.out.println("Lista pe care o adaug");
        listaCopie=new MyIntLinkedList();
        listaCopie.add(3);
        listaCopie.add(9);
        listaCopie.add(7);
        listaCopie.add(10);
        printList(listaCopie);
        lista.addAll(listaCopie);
        printList(lista);
        System.out.println();

        //adaug o colectie MyIntArrayList la un index
        MyIntLinkedList listDeAdaugat=new MyIntLinkedList();
        listDeAdaugat.add(2);
        listDeAdaugat.add(3);
        listDeAdaugat.add(4);
        listDeAdaugat.add(5);
        printList(listDeAdaugat);
        lista.addAll(2,listDeAdaugat);
        printList(lista);
        System.out.println();
        //transform lista intr-un array
        int[] arr=lista.toArray();
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
