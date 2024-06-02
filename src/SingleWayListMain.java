public class SingleWayListMain {
    public static void main(String[] args){
        SingleWayList<Integer> singleWayList = new SingleWayList<>();
        singleWayList.add(1);
        singleWayList.add(2);
        singleWayList.add(5);
        singleWayList.addFirst(3);
        singleWayList.printList();
        singleWayList.removeLast();
        singleWayList.tailPrint();
    }
}
