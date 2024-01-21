import java.util.Scanner;
import java.io.*;
class PetSuggester {
    //a public scanner method for kbd input
    public static Scanner input = new Scanner(System.in);
    // a public method that returns true or false based on users input wether y or n.
    public static boolean askYesNo(){
        Boolean yes_no=false;

        String answer= input.nextLine();

        if (answer.equals("y") || answer.equals("Y")){
            yes_no=true;
        }
        return yes_no;
    }

    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("suggestions.txt");
        Writer output= new BufferedWriter( file);
        String preferred_pet;
        String new_question;
        // construction of original trww
        TreeNode new_root, old_leaf;
        TreeNode right2 = new TreeNode("a chihuahua");
        TreeNode left2 = new TreeNode("a golden retriever");
        TreeNode left1 = new TreeNode("Do you prefer big dogs?", left2, right2);

        TreeNode right1 = new TreeNode("an iguana");

        TreeNode Treeroot = new TreeNode("Do you like dogs?", left1, right1);
        TreeNode root= Treeroot;
        // while loop which uses recursiion to cycle through all nodes in the tree
        do {
            root.print();
            if (askYesNo()){
                root=root.getLeft();
            }
            else {
                root=root.getRight();
            }
            // asks wether leaf is satisfactory if not creates another node which replaces the current node
            if (root.isLeaf()){
                root.print();
                System.out.println("Was the animal satisfactory, [y/n]");
                if (askYesNo()){
                    System.out.println("Would you like to play again, [y/n]");
                    if (askYesNo()){
                        root= Treeroot;
                    }
                    else {
                        break;
                    }

                }
                // the new node takes a question which the new answer will always be right to.
                else {
                    System.out.println("What is the name of a preferred pet");
                    preferred_pet = input.nextLine();
                    System.out.println("Enter a question which is true for the preferred pet, and false for rejected suggestion");
                    new_question =input.nextLine();
                    TreeNode new_pet= new TreeNode(preferred_pet);
                    new_root = new TreeNode(new_question);
                    old_leaf= new TreeNode(root.value);
                    root.setnode(new_root.value, new_pet,old_leaf);
                    System.out.println("Would you like to play again? [y/n]");
                    // if you want to play again the recursive method is started again by making the argument the original node
                    if (askYesNo()){
                        root= Treeroot;}
                    else {
                        System.out.println("Do you want to save the current tree? [y/n]");
                        if (askYesNo()){
                            // to save the tree a bufferedwriter writes to suggestion.txt the new questions with 'question in front of them
                            // and a new suggestion with ' suggest' in front of them. it also has a try catch mehod to catch filenotfound error.
                            try {

                                String question= "question" + new_question;
                                String suggestion= "Suggest" + preferred_pet;
                                output.write(question+'\n');
                                output.write(suggestion + '\n');
                                output.close();
                                break;

                            }catch (Exception e) {

                                output.close();
                            }
                    }

                    
                    }

                }
            }



        } while (root.getLeft()!=null && root.getRight()!=null);

    }


}
