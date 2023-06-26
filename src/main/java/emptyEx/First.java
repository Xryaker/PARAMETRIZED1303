package emptyEx;

import java.util.ResourceBundle;

public class First {
  static   ResourceBundle bundles;
    public static void main(String[] args) {
        ResourceBundle bundle= ResourceBundle.getBundle(Names.NIKOLAY.getName());
//        System.out.println(bundle.getString("name"));
//
//        // print all fields start
//        Iterator<String> iter=bundle.getKeys().asIterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }
        //end
        for (Names name : Names.values()) {
            bundles=ResourceBundle.getBundle(name.getName());
            System.out.println(bundles.getString("family"));
        }
    }
}
