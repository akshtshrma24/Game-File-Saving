import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class top5Sorting {
    String toSplit;
    ArrayList<String> split;
    ArrayList<entry> entryArrayList = new ArrayList<>();
    public top5Sorting(String toSplit)
    {
        this.toSplit = toSplit;
        split = new ArrayList<>();
    }

    public void splitIntoArrayListString()
    {
        String[] temp = this.toSplit.split("\\r?\\n");
        for(String t : temp)
        {
            split.add(t);
        }
    }

    public void splitIntoArrayListEntry() {
        String temp = "";
        String[] array;
        for(String t : split) {
            temp = t;
            array = temp.split(",");
            entry newEntry = new entry();
            for (int i = 0; i < array.length; i++) {
                String temp2 = array[i];
                temp2 = temp2.stripLeading();
                if (i % 2 == 0) {
                    newEntry.setName(temp2);
                } else {
                    newEntry.setScore(Integer.parseInt(temp2));
                }
            }
            entryArrayList.add(newEntry);
        }
        Collections.sort(entryArrayList);
        ArrayList<entry> temp3 = new ArrayList<>();
        if(entryArrayList.size() > 5)
        {
            for(int i = 0; i < 5; i++)
            {
                temp3.add(entryArrayList.get(i));
            }
            entryArrayList = temp3;
        }
    }

    public String getSplit()
    {
        return split.toString();
    }

    public String getEntrySplit()
    {
        System.out.println("Here are the top 5 Scores, Hopefully you made it :) \n");
        return entryArrayList.toString();
    }
}
