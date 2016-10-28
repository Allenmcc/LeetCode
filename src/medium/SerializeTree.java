package medium;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by danny on 2016/10/26.
 */
public class SerializeTree {
    public static void serialize(TreeNode root, PrintStream ps) {
        if (root == null)
            ps.print("# ");
        else {
            ps.print(root.val + " ");
            serialize(root.left, ps);
            serialize(root.right, ps);
        }
    }

    public static TreeNode deserialize(Scanner cin) {
        String token = cin.next();
        if (token.equals("#"))
            return null;
        int val = Integer.parseInt(token);
        TreeNode root = new TreeNode(val);
        root.left = deserialize(cin);
        root.right = deserialize(cin);

        return root;

    }

    public static void main(String[] args) throws FileNotFoundException {
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.right = new TreeNode(40);
        root.right.left = new TreeNode(35);
        root.right.right = new TreeNode(50);
        PrintStream ps = new PrintStream(new File("serialize.txt"));
        serialize(root, ps);

        Scanner cin = new Scanner(new File("serialize.txt"));
        TreeNode back = deserialize(cin);

        System.out.println(back.val);
        System.out.println(back.left.val);

    }
}
