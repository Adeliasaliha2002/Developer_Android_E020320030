package id.ac.poliban.e020320030.challenge23adelia;

import java.util.HashMap;

public class ButtonList {

    public HashMap<String, Integer> list = new HashMap<>();

    public void addItem (String item){

        if(list.containsKey(item)){

            list.put(item, list.get(item)+1);

        }else{
            list.put(item,1);

        }

    }

    public HashMap<String,Integer>getItems(){return list;}
}
