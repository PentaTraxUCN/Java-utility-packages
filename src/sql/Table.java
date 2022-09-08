package sql;

import java.util.ArrayList;

public class Table { // Used to make an easier overview of the query data
    private ArrayList<ArrayList<String>> table;

    public Table(){
        table = new ArrayList<>();
    }

    public void addRow(ArrayList<String> collumns){
        table.add(collumns);
    }

    public void removeRow(int index){
        table.remove(index);
    }

    public ArrayList<ArrayList<String>> getTableAsArray(){
        return table;
    }

    public ArrayList<String> getRow(int index){
        return table.get(index);
    }

    public String getData(int row, int collumn){
        String data = "N/A";
        if ((row < height() && row >= 0) && (collumn < width() && collumn >= 0)){
            data = table.get(row).get(collumn);
        }
        return data;
    }

    public int height(){
        return table.size();
    }

    public int width(){
        return table.get(0).size();
    }
}
