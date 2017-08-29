/**
 * Created by blunt on 2017/8/24.
 */
public class LinkListDemo {
    public static void main(String[] args) {
        LinkList linkList =new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }


//        newLink.print(newLink.head);
        linkList.print(linkList.head);
        System.out.println(linkList.hasCycle(linkList.head));
        linkList.add(linkList.head);
//        linkList.print(linkList.head);
        System.out.println(linkList.hasCycle(linkList.head));
//        System.out.println(linkList.Find(9));

//        linkList.addFromNode(19,linkList.Find(3));
//        linkList.print(linkList.head);
//        linkList.print(linkList.head);
//        linkList.reversePrint(linkList.head);
    }
}
