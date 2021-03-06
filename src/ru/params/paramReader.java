package ru.params;

import ru.sort.common.Sorter;

import ru.sort.digits.DigitSorter;
import ru.sort.strings.StringSorter;


public class paramReader {

    private Sorter sorter = null;

    private boolean isOptionExist(String option){
        return true;
    }

    public Sorter getSorterType(){
        return sorter ;
    }
    private void initSorter(String[] args){

        if(args[0] == "-d"||args[0] == "-a"){
            boolean sortType;
            if(args[0] == "-d"){
                sortType = false;
            }
            else{
                sortType = true;
            }
            String[] inputFiles = new String[args.length-3];
            String outputFile = args[2];
            for(int i = 0;i<args.length-3;i++){
                inputFiles[i] = args[i+3];
            }
            if (args[1] == "-s") {
                sorter = new StringSorter(sortType,outputFile, inputFiles);
            } else {
                sorter = new DigitSorter(sortType,outputFile, inputFiles);
            }
        }
        else {
            String[] inputFiles = new String[args.length-2];
            String outputFile = args[1];
            for(int i = 0;i<args.length-2;i++){
                inputFiles[i] = args[i+2];
            }
            if (args[0] == "-s") {
                sorter = new StringSorter(true,outputFile, inputFiles);
            } else {
                sorter = new DigitSorter(true,outputFile, inputFiles);
            }
        }
    }
    public paramReader(String[] args) throws Exception {
        if(args.length == 0)
            throw new Exception();
        initSorter(args);
    }
}
