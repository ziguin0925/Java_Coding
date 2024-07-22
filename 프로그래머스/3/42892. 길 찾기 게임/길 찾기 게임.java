import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][];
        
                int[][] nodes = new int[nodeinfo.length][3];

        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i][0] = nodeinfo[i][0];
            nodes[i][1] = nodeinfo[i][1];
            nodes[i][2] = i+1;
        }

        Arrays.sort(nodes,Comparator.comparing(x->x[1]));


        Node first = new Node();
        first.idx = nodes[nodeinfo.length-1][2];
        first.val = nodes[nodeinfo.length-1][0];

        for(int i =nodeinfo.length-2; i>=0; i--) {
            first.numCom(nodes[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        Node.preOrder(first,list);



        ArrayList<Integer> list2 = new ArrayList<>();
        Node.postOrder(first,list2);

        answer[0] = list.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = list2.stream().mapToInt(Integer::intValue).toArray();


        return answer;
    }
}


class Node{

    Node Parent;

    Node Leftchild;
    int val;
    int idx;
    Node Rightchild;

    //자신이 왼쪽 자식노드이면 true
//    boolean type;


    public void numCom(int[] arr){
        if(arr[0]<this.val){
            if(this.Leftchild==null){
                this.Leftchild = new Node();
                this.Leftchild.Parent = this;
                this.Leftchild.val = arr[0];
                this.Leftchild.idx = arr[2];
            }else{
                this.Leftchild.numCom(arr);
            }

        }else{
            if(this.Rightchild==null){
                this.Rightchild = new Node();
                this.Rightchild.Parent = this;
                this.Rightchild.val = arr[0];
                this.Rightchild.idx = arr[2];
            }else {
                this.Rightchild.numCom(arr);
            }

        }
    }

    public static void preOrder(Node node,ArrayList<Integer> ans){
        ans.add(node.idx);

        if(node.Leftchild!=null){
            preOrder(node.Leftchild,ans);
        }
        if(node.Rightchild!=null){
            preOrder(node.Rightchild,ans);
        }

    }

    public static void postOrder(Node node,ArrayList<Integer> ans){


        if(node.Leftchild!=null){
            postOrder(node.Leftchild,ans);
        }
        if(node.Rightchild!=null){
            postOrder(node.Rightchild,ans);
        }

        ans.add(node.idx);

    }
}
